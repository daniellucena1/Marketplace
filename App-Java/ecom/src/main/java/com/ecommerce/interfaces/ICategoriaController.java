package com.ecommerce.interfaces;

import com.ecommerce.models.Categoria;

public interface ICategoriaController {
  public Categoria create();

  public void getAll();

  public int getPos();

  public Categoria getCategoria(int pos);
}
