package com.example.nutricao.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numero;
    private String nome;
    @Enumerated(EnumType.STRING)
    private CategoriaReceita categoria;
    private String equipamentos;
    private String modoDePreparo;
    private String tempoDePreparo;
    private float pesoDaPorcao;
    private String rendimento;
    private int numeroDePorcoes;
    private float fcc;
    private String medidaCaseira;

    @OneToMany(mappedBy = "receita")
    private List<Receita_Ingrediente> ingredientesAssociados = new ArrayList<>();
}
