package com.example.nutricao.repository;

import com.example.nutricao.model.Receita_Ingrediente;
import com.example.nutricao.model.Receita_Ingrediente_Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReceitaIngredienteRepository extends JpaRepository<Receita_Ingrediente, Receita_Ingrediente_Id> {
    List<Receita_Ingrediente> findByReceitaNumero(int receitaNumero);
} 