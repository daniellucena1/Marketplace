package com.ecommerce.models;

public class Produto {
    private static int idCounter = 0;
    private int ID;
    private String nome;
    private String descricao;
    private double preco;
    private int categoriaID;
    private int quantidade;

    public Produto(String nome, String descricao, double preco, int categoriaID, int quantidade) {
        this.ID = idCounter++;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoriaID = categoriaID;
        this.quantidade = quantidade;
    }

    public int getID() {
        return ID;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getCategoriaId() {
        return categoriaID;
    }

    public void setCategoriaId(int categoriaID) {
        this.categoriaID = categoriaID;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "\n ID: " + ID + "\n Nome: " + nome + "\n Descricao: " + descricao + "\n Preco: " + preco
                + "\n Quantidade: " + quantidade +
                "\n------------------------------------";
    }
}
