package com.ecommerce.interfaces;

import com.ecommerce.models.Cliente;

public interface IClienteRepository {
    public Cliente findClienteById(String id);

    public String remove(String CPF);

    public String create(Cliente cliente);

    public String update(Cliente clienteAtualizado);

    public boolean login(String cpf, String senha);
}