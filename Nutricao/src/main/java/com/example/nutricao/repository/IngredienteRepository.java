package com.example.nutricao.repository;

import com.example.nutricao.model.Ingredientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingredientes, Integer> {
} 