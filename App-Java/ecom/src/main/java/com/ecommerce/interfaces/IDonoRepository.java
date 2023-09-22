package com.ecommerce.interfaces;

import com.ecommerce.models.Dono;

public interface IDonoRepository {
    public Dono buscarDono(String cpf);

    public String create(Dono dono);

    public boolean login(String cpf, String senha);
}