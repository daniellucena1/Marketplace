package com.ecommerce.models;

public class User {
    protected final String CPF;
    protected final String senha;
    protected String nome;
    protected boolean permissao;

    public User(String cpf, String senha, String nome, boolean permissao) {
        this.CPF = cpf;
        this.senha = senha;
        this.nome = nome;
        this.permissao = permissao;
    }

    public String getSenha() {
        return this.senha;
    }

    public String getCPF() {
        return CPF;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

    public boolean isPermissao() {
        return permissao;
    }

    public void setPermissao(boolean permissao) {
        this.permissao = permissao;
    }

    @Override
    public String toString() {
        return "User [CPF=" + CPF + ", nome=" + nome + "";
    }
}