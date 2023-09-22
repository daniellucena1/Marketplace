package com.ecommerce.controllers;

import java.util.List;

import com.ecommerce.interfaces.*;
import com.ecommerce.models.*;
import com.ecommerce.repositories.*;

public class PedidoController implements IPedidoController {
  private IPedidoRepository repository;

  public PedidoController(PedidoRepository repository) {
    this.repository = repository;
  }

  public void getPedidos() {
    this.repository.getAll();
  }

  public void getPedidoByUserId(String idCliente) {
    System.out.println(this.repository.getPedidoByUserId(idCliente));
  }

  public void create(Pedido pedido) {
    this.repository.create(pedido);
  }

  public String getById(int idPedido) {
    return this.repository.getById(idPedido);
  }

  public void getAll() {
    List<Pedido> pedidos = this.repository.getAll();

    for (int i = 0; i < pedidos.size(); i++) {
      System.out.println(pedidos.get(i).toString());
    }
  }
}