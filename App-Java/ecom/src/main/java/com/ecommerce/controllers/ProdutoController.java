package com.ecommerce.controllers;

import java.util.Scanner;
import java.util.UUID;

import java.util.List;

import com.ecommerce.interfaces.*;
import com.ecommerce.models.*;
import com.ecommerce.repositories.*;

public class ProdutoController implements IProdutoController {
  private IProdutoRepository repository;

  public ProdutoController(ProdutoRepository repository) {
    this.repository = repository;
  }

  public void getByCategoria(Categoria categoria) {
    List<Produto> produtosByCategoria = this.repository.getByCategoria(categoria);

    for (Produto produto : produtosByCategoria) {
      System.out.println(produto);
    }
  }

  public Produto findById() {
    Scanner sc = new Scanner(System.in);

    for (int i = 0; i < this.repository.getAll().size(); i++) {
      System.out.println(">> " + i + " - " + this.repository.getAll().get(i).getNome());
    }

    System.out.print(">> Digite o ID do produto: ");
    int idProduto = Integer.parseInt(sc.nextLine());

    return this.repository.findById(idProduto);
  }

  public void getAll() {
    List<Produto> produtos = this.repository.getAll();

    if (produtos.size() <= 0) {
      System.out.println("Você não tem produtos");
      return;
    }

    for (int i = 0; i < produtos.size(); i++) {
      System.out.println(produtos.get(i).toString());
    }
  }

  public String create(Categoria categoria) {
    Scanner scanner = new Scanner(System.in);
    System.out.print(">> Nome do produto: ");
    String produtoNome = scanner.nextLine().replace("\n", "");

    System.out.print(">> Descrição do produto: ");
    String produtoDesc = scanner.nextLine();

    System.out.print(">> Preço do produto: ");
    double produtoPreco = Double.parseDouble(scanner.nextLine());

    System.out.print(">> Quantidade do produto: ");
    int produtoQtd = Integer.parseInt(scanner.nextLine());

    Produto novoProduto = new Produto(produtoNome, produtoDesc, produtoPreco, categoria.getId(), produtoQtd);

    return this.repository.create(novoProduto);
  }

  public void remove() {
    Scanner scanner = new Scanner(System.in);
    System.out.print(">> Digite a id o produto a ser removido: ");
    int idProduto = Integer.parseInt(scanner.nextLine());

    System.out.println(this.repository.delete(idProduto));
  }

  public void update() {
    Scanner scanner = new Scanner(System.in);
    System.out.print(">> Digite a ID do produto que deseja atualizar: ");
    int idProduto = Integer.parseInt(scanner.nextLine());

    System.out.print(">> Novo nome: ");
    String nome = scanner.nextLine();

    System.out.print(">> Nova descrição: ");
    String descricao = scanner.nextLine();

    System.out.print(">> Novo preço: ");
    Double preco = Double.parseDouble(scanner.nextLine());

    System.out.print(">> Id da nova categoria: ");
    int categoriaID = Integer.parseInt(scanner.nextLine());

    System.out.print(">> Nova quantidade: ");
    int quantidade = Integer.parseInt(scanner.nextLine());

    // Input para receber as infos do produto!
    Produto produto = new Produto(nome, descricao, preco, categoriaID, quantidade);

    System.out.println(this.repository.update(idProduto, produto));
  }

}