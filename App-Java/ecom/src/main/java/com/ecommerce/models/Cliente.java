package com.ecommerce.models;

public class Cliente extends User {
  private String endereco;
  private String cep;

  public Cliente(String cpf, String senha, String nome, boolean permissao, String endereco, String cep) {
    super(cpf, senha, nome, permissao);
    this.endereco = endereco;
    this.cep = cep;
  }

  public String getEndereco() {
    return endereco;
  }

  public String getCep() {
    return cep;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }
}
