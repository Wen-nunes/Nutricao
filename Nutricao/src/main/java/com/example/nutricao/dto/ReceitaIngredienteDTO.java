package com.example.nutricao.dto;

import lombok.Data;

@Data
public class ReceitaIngredienteDTO {
    private int receitaNumero;
    private int ingredienteId;
    private String medidaCaseira;
    private float pesoBruto;
    private float pesoLiquido;
    private float fatorDeCorrecao;
    private float custoCompra;
    private float custoUtilizado;
    private float custoTotal;
    private float custoPercapito;
} 