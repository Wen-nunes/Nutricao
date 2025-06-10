package com.example.nutricao.model;
import java.io.Serializable;
import java.util.Objects;

public class Receita_Ingrediente_Id implements Serializable {
    private int receitaNumero;
    private int ingredienteId;

    public Receita_Ingrediente_Id() {}

    public Receita_Ingrediente_Id(int receitaNumero, int ingredienteId) {
        this.receitaNumero = receitaNumero;
        this.ingredienteId = ingredienteId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receita_Ingrediente_Id that = (Receita_Ingrediente_Id) o;
        return receitaNumero == that.receitaNumero &&
                ingredienteId == that.ingredienteId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(receitaNumero, ingredienteId);
    }
}
