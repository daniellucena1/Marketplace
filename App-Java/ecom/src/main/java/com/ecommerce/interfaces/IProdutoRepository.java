package com.ecommerce.interfaces;

import java.util.List;

import com.ecommerce.models.Categoria;
import com.ecommerce.models.Produto;

public interface IProdutoRepository {
  public List<Produto> getByCategoria(Categoria categoria);

  public Produto findById(int idProduto);

  public List<Produto> getAll();

  public String create(Produto produto);

  public String delete(int idProduto);

  public String update(int idProduto, Produto produtoAtualizado);
}
