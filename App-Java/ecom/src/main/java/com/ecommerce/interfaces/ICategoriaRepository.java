package com.ecommerce.interfaces;

import java.util.List;

import com.ecommerce.models.*;

public interface ICategoriaRepository {
  public List<Categoria> getCategorias();

  public void create(Categoria categoria);

  public Categoria getCategoriaById(int id);
}
