package com.example.nutricao.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Ingredientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private float proteina;
    private float carboidrato;
    private float lipidio;
    private float sodio;
    private float gorduraSaturada;

    private boolean ingredienteSistema; // true= do sistema, false= de nutricionista
    private int nutricionistaId; // null para ingredientes do sistema

    @OneToMany(mappedBy = "ingrediente")
    private List<Receita_Ingrediente> receitasAssociadas = new ArrayList<>();
}
