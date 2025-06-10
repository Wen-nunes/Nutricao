package com.example.nutricao.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@IdClass(Receita_Ingrediente_Id.class)
@Data
public class Receita_Ingrediente {

    @Id
    @Column(name = "receita_numero")
    private int receitaNumero;

    @Id
    @Column(name = "ingrediente_id")
    private int ingredienteId;

    @ManyToOne
    @JoinColumn(name = "receita_numero", insertable = false, updatable = false)
    private Receita receita;

    @ManyToOne
    @JoinColumn(name = "ingrediente_id", insertable = false, updatable = false)
    private Ingredientes ingrediente;

    private String medidaCaseira;
    private float pesoBruto;
    private float pesoLiquido;
    private float fatorDeCorrecao;
    private float custoCompra;
    private float custoUtilizado;
    private float custoTotal;
    private float custoPercapito;
}
