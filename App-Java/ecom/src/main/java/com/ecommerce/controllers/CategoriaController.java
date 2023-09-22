package com.ecommerce.controllers;

import java.util.List;
import java.util.Scanner;

import com.ecommerce.interfaces.*;
import com.ecommerce.models.*;
import com.ecommerce.repositories.*;

public class CategoriaController implements ICategoriaController {
  private ICategoriaRepository repository;

  public CategoriaController(CategoriaRepository repository) {
    this.repository = repository;
  }

  public int getPos() {
    if (this.repository.getCategorias().size() <= 0) {
      return -1;
    }

    Scanner scanner = new Scanner(System.in);
    System.out.println(">> Selecione a categoria do produto: ");
    this.getAll();

    int posicaoCategoria = Integer.parseInt(scanner.nextLine());

    for (int i = 0; i < this.repository.getCategorias().size(); i++) {
      if (posicaoCategoria > this.repository.getCategorias().size() - 1) {
        return -1;
      }

      if (this.repository.getCategorias().get(i).getId() == this.repository.getCategorias()
          .get(posicaoCategoria).getId()) {
        return i;
      }
    }

    return -1;
  }

  public Categoria create() {
    Scanner scanner = new Scanner(System.in);

    System.out.println(">> Nova categoria: ");
    System.out.print(">> Digite um nome para a categoria: ");

    String nomeCategoria = scanner.nextLine();
    Categoria categoria = new Categoria(nomeCategoria);

    this.repository.create(categoria);
    return categoria;
  }

  public void getAll() {
    System.out.println(this.repository.getCategorias().size());
    List<Categoria> categorias = this.repository.getCategorias();
    for (int i = 0; i < categorias.size(); i++) {
      System.out.println(">> " + i + " - " + categorias.get(i).getNome());
    }
  }

  public Categoria getCategoria(int id) {
    return this.repository.getCategoriaById(id);
  }
}