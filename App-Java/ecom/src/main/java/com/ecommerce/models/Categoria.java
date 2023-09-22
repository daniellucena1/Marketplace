package com.ecommerce.models;

public class Categoria {
    private static int idCounter = 0;
    private final int id;
    private String nome;

    public Categoria(String nome) {
        this.id = idCounter++;
        this.nome = nome;
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
