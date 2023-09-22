package com.ecommerce.interfaces;

import com.ecommerce.models.Pedido;

public interface IPedidoController {
  public void getPedidos();

  public void getPedidoByUserId(String idCliente);

  public void create(Pedido pedido);

  public String getById(int idPedido);

  public void getAll();
}
