package com.ecommerce.controllers;

import java.util.Scanner;

import com.ecommerce.interfaces.*;
import com.ecommerce.models.*;
import com.ecommerce.repositories.*;

public class EntregaController implements IEntregaController {
  private IEntregaRepository repository;

  public EntregaController(EntregaRepository repository) {
    this.repository = repository;
  }

  public void create(Entrega entrega) {
    this.repository.create(entrega);
  }

  public void update() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Digite o numero de rastreio: ");
    int numeroRastreio = Integer.parseInt(scanner.nextLine());

    System.out.println("Digite o novo status: ");
    String novoStatus = scanner.nextLine();

    System.out.println(this.repository.update(numeroRastreio, novoStatus));
  }
}