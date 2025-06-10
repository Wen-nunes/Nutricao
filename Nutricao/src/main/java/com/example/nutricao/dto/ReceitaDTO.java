package com.example.nutricao.dto;

import com.example.nutricao.model.CategoriaReceita;
import lombok.Data;
import java.util.List;

@Data
public class ReceitaDTO {
    private int numero;
    private String nome;
    private CategoriaReceita categoria;
    private String equipamentos;
    private String modoDePreparo;
    private String tempoDePreparo;
    private float pesoDaPorcao;
    private String rendimento;
    private int numeroDePorcoes;
    private float fcc;
    private String medidaCaseira;
    private List<ReceitaIngredienteDTO> ingredientes;
} 