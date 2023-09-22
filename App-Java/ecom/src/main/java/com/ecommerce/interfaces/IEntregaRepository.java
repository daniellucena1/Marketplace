package com.ecommerce.interfaces;

import com.ecommerce.models.Entrega;

public interface IEntregaRepository {
  public Entrega findEntregaById(int numeroRastreio);

  public void create(Entrega entrega);

  public String update(int numeroRastreio, String novoStatus);
}
