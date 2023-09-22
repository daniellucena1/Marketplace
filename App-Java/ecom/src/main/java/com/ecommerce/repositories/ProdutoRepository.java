package com.ecommerce.repositories;

import java.sql.*;
import java.util.*;

import com.ecommerce.interfaces.IProdutoRepository;
import com.ecommerce.models.*;

public class ProdutoRepository implements IProdutoRepository {
  private Connection connection;

  public ProdutoRepository(Connection connection) {
    this.connection = connection;
  }

  public Produto findById(int idProduto) {
    String sql = "SELECT * FROM produtos WHERE id=" + idProduto + ";";

    Produto produto = null;

    try {
      Statement statement = this.connection.createStatement();
      ResultSet result = statement.executeQuery(sql);
      while (result.next()) {
        produto = new Produto(result.getString("nome"), result.getString("descricao"),
            result.getDouble("preco"), result.getInt("quantidade"), result.getInt("categoria_id"));
      }
    } catch (Exception e) {
      System.out.println(">> Erro na conexão com o servidor, volte aqui mais tarde :)");
    }

    return produto;
  }

  public List<Produto> getByCategoria(Categoria categoria) {
    String sql = "SELECT * FROM produtos WHERE categoria_id=" + categoria.getId() + ";";
    List<Produto> produtosByCategoria = new ArrayList<Produto>();

    try {
      Statement statement = this.connection.createStatement();
      ResultSet result = statement.executeQuery(sql);
      while (result.next()) {
        Produto produto = new Produto(result.getString("nome"), result.getString("descricao"),
            result.getDouble("preco"), result.getInt("quantidade"), result.getInt("categoria_id"));
        produtosByCategoria.add(produto);
      }
    } catch (Exception e) {
      System.out.println(">> Erro na conexão com o servidor, volte aqui mais tarde :)");
    }

    return produtosByCategoria;
  }

  public List<Produto> getAll() {
    String sql = "SELECT * FROM produtos;";

    List<Produto> produtos = new ArrayList<Produto>();

    try {
      Statement statement = this.connection.createStatement();
      ResultSet result = statement.executeQuery(sql);
      while (result.next()) {
        Produto produto = new Produto(result.getString("nome"), result.getString("descricao"),
            result.getDouble("preco"), result.getInt("quantidade"), result.getInt("categoria_id"));
        produtos.add(produto);
      }
    } catch (Exception e) {
      System.out.println(">> Erro na conexão com o servidor, volte aqui mais tarde :)");
    }

    return produtos;
  }

  public String create(Produto produto) {
    String sql = "INSERT INTO produtos (id, nome, descricao, preco, quantidade, categoria_id) VALUES ("
        + produto.getID() + ", '" + produto.getNome() + "', '" + produto.getDescricao() + "', " + produto.getPreco() + ", "
        + produto.getQuantidade() + ", " + produto.getCategoriaId() + " );";

    try {
      Statement statement = this.connection.createStatement();
      statement.execute(sql);
    } catch (SQLException e) {
      System.out.println(">> Erro na conexão com o servidor, volte aqui mais tarde :)");
    }

    return ">> Produto adicionado com sucesso";
  };

  public String delete(int idProduto) {
    String sql = "DELETE FROM produtos WHERE id=" + idProduto + ";";

    try {
      Statement statement = this.connection.createStatement();
      statement.execute(sql);
    } catch (SQLException e) {
      System.out.println(">> Erro na conexão com o servidor, volte aqui mais tarde :)");
    }

    return ">> Produto não existe";
  };

  public String update(int idProduto, Produto produtoAtualizado) {
    Produto produto = findById(idProduto);
    String sql = "UPDATE produtos SET nome='" + produtoAtualizado.getNome() + "', descricao='"
        + produtoAtualizado.getDescricao() +
        "', preco=" + produtoAtualizado.getPreco() + ", categoria_id=" + produtoAtualizado.getCategoriaId()
        + ", quantidade=" + produtoAtualizado.getQuantidade() +
        "WHERE id=" + produto.getID() + ";";

    try {
      Statement statement = this.connection.createStatement();
      statement.execute(sql);
    } catch (SQLException e) {
      System.out.println(">> Erro na conexão com o servidor, volte aqui mais tarde :)");
    }

    return ">> Produto atualizado com sucesso!";

  };
}
