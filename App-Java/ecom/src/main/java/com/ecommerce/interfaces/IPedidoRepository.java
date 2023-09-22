package com.ecommerce.interfaces;

import java.util.List;

import com.ecommerce.models.*;

public interface IPedidoRepository {
  public void create(Pedido pedido);

  public Pedido getPedidoByUserId(String cpf);

  public String getById(int idPedido);

  public List<Pedido> getAll();
}
