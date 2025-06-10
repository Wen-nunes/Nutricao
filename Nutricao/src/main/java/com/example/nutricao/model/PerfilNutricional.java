package com.example.nutricao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class PerfilNutricional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private float percapita;
    private float totalGramas;
    private float totalKcal;
    private float porcentagem;
    private float vtc;

}
