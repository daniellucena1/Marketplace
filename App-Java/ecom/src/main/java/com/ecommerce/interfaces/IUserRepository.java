package com.ecommerce.interfaces;

import com.ecommerce.models.Cliente;

public interface IUserRepository {
  public int buscarPosicaoUser(String idCliente);

  public String remove(String idCliente);

  public String findClientById(String idCliente);

  public String create(Cliente cliente);

  public String update(Cliente clienteAtualizado);

  public boolean login(String cpf, String senha);
}
