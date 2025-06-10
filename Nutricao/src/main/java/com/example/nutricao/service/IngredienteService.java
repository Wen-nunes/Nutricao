package com.example.nutricao.service;

import com.example.nutricao.dto.IngredienteDTO;
import com.example.nutricao.model.Ingredientes;
import com.example.nutricao.repository.IngredienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredienteService {

    @Autowired
    private IngredienteRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public List<IngredienteDTO> findAll() {
        return repository.findAll().stream()
                .map(ingrediente -> modelMapper.map(ingrediente, IngredienteDTO.class))
                .collect(Collectors.toList());
    }

    public IngredienteDTO findById(Integer id) {
        return repository.findById(id)
                .map(ingrediente -> modelMapper.map(ingrediente, IngredienteDTO.class))
                .orElse(null);
    }

    public IngredienteDTO save(IngredienteDTO dto) {
        Ingredientes ingrediente = modelMapper.map(dto, Ingredientes.class);
        ingrediente = repository.save(ingrediente);
        return modelMapper.map(ingrediente, IngredienteDTO.class);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
} 