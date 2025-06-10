package com.example.nutricao.model;

public enum CategoriaReceita {
    PRATO_PRINCIPAL("Prato Principal (Proteína)"),
    COMPLEMENTO("Complemento (Guarnição)"),
    SALADA("Salada"),
    SOBREMESA("Sobremesa"),
    BEBIDA("Bebida");

    private final String descricao;

    CategoriaReceita(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}