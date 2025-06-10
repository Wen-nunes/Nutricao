package com.example.nutricao.service;

import com.example.nutricao.dto.ReceitaDTO;
import com.example.nutricao.dto.ReceitaIngredienteDTO;
import com.example.nutricao.model.Receita;
import com.example.nutricao.model.Receita_Ingrediente;
import com.example.nutricao.repository.ReceitaRepository;
import com.example.nutricao.repository.ReceitaIngredienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;

    @Autowired
    private ReceitaIngredienteRepository receitaIngredienteRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<ReceitaDTO> findAll() {
        return receitaRepository.findAll().stream()
                .map(receita -> modelMapper.map(receita, ReceitaDTO.class))
                .collect(Collectors.toList());
    }

    public ReceitaDTO findById(Integer id) {
        return receitaRepository.findById(id)
                .map(receita -> modelMapper.map(receita, ReceitaDTO.class))
                .orElse(null);
    }

    @Transactional
    public ReceitaDTO save(ReceitaDTO dto) {
        Receita receita = modelMapper.map(dto, Receita.class);
        
        // Salva a receita primeiro para obter o ID
        receita = receitaRepository.save(receita);
        
        // Processa os ingredientes
        if (dto.getIngredientes() != null) {
            float pesoLiquidoTotal = 0;
            float custoTotal = 0;
            
            for (ReceitaIngredienteDTO ingredienteDTO : dto.getIngredientes()) {
                Receita_Ingrediente receitaIngrediente = modelMapper.map(ingredienteDTO, Receita_Ingrediente.class);
                receitaIngrediente.setReceita(receita);
                
                // Calcula fator de correção
                receitaIngrediente.setFatorDeCorrecao(
                    receitaIngrediente.getPesoBruto() / receitaIngrediente.getPesoLiquido()
                );
                
                // Calcula custo utilizado
                receitaIngrediente.setCustoUtilizado(
                    receitaIngrediente.getCustoCompra() * (receitaIngrediente.getPesoLiquido() / 1000)
                );
                
                custoTotal += receitaIngrediente.getCustoUtilizado();
                pesoLiquidoTotal += receitaIngrediente.getPesoLiquido();
                
                receitaIngredienteRepository.save(receitaIngrediente);
            }
            
            // Atualiza o custo total e per capita para cada ingrediente
            for (Receita_Ingrediente receitaIngrediente : receitaIngredienteRepository.findByReceitaNumero(receita.getNumero())) {
                receitaIngrediente.setCustoTotal(custoTotal);
                receitaIngrediente.setCustoPercapito(custoTotal / receita.getNumeroDePorcoes());
                receitaIngredienteRepository.save(receitaIngrediente);
            }
            
            // Atualiza o FCC da receita
            receita.setFcc(Float.parseFloat(receita.getRendimento()) / pesoLiquidoTotal);
            
            receita = receitaRepository.save(receita);
        }
        
        return modelMapper.map(receita, ReceitaDTO.class);
    }

    public void delete(Integer id) {
        receitaRepository.deleteById(id);
    }
} 