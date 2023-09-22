package com.ecommerce.interfaces;

import com.ecommerce.models.Categoria;
import com.ecommerce.models.Produto;

public interface IProdutoController {
  public void getByCategoria(Categoria categoria);

  public Produto findById();

  public void getAll();

  public String create(Categoria categoria);

  public void remove();

  public void update();
}
