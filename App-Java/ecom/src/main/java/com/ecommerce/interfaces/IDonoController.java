package com.ecommerce.interfaces;

import com.ecommerce.models.Dono;

public interface IDonoController{
    public Dono buscarDono();

    public Dono create();

    public boolean login();
}