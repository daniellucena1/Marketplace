package com.ecommerce.interfaces;

import com.ecommerce.models.Cliente;

public interface IClienteController {
    public Cliente create();

    public void remove();

    public Cliente findClienteById();

    public void update(Cliente cliente);

    public boolean login(boolean end);
}