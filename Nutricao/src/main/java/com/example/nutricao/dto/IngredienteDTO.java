package com.example.nutricao.dto;

import lombok.Data;

@Data
public class IngredienteDTO {
    private int id;
    private String nome;
    private float proteina;
    private float carboidrato;
    private float lipidio;
    private float sodio;
    private float gorduraSaturada;
    private boolean ingredienteSistema;
    private int nutricionistaId;
} 