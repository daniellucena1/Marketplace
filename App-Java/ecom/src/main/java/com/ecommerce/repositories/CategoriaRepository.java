package com.ecommerce.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ecommerce.interfaces.ICategoriaRepository;
import com.ecommerce.models.*;

public class CategoriaRepository implements ICategoriaRepository {
  public Connection connection;

  public CategoriaRepository(Connection connection) {
    this.connection = connection;
  }

  public List<Categoria> getCategorias() {
    String sql = "SELECT * FROM categorias;";
    List<Categoria> categorias = new ArrayList<Categoria>();

    try {
      Statement statement = this.connection.createStatement();
      ResultSet result = statement.executeQuery(sql);

      while (result.next()) {
        // int id = result.getInt("id");
        String nome = result.getString("nome");

        Categoria categoria = new Categoria(nome);
        categorias.add(categoria);
      }
    } catch (SQLException e) {
      System.out.println(">> Erro na conexão com o servidor, volte aqui mais tarde :)");
    }

    return categorias;
  }

  public void create(Categoria categoria) {
    String sql = "INSERT INTO categorias(id, nome) VALUES (" + categoria.getId() + ", '" + categoria.getNome() + "');";

    try {
      Statement statement = this.connection.createStatement();
      statement.execute(sql);
    } catch (SQLException e) {
      System.out.println(">> Erro na conexão com o servidor. volte aqui mais tarde :)");
    }
  }

  public Categoria getCategoriaById(int id) {
    String sql = "SELECT * FROM categorias WHERE id=" + id + ";";
    Categoria categoria = null;

    try {
      Statement statement = this.connection.createStatement();
      ResultSet result = statement.executeQuery(sql);
      categoria = new Categoria(result.getString("nome"));
    } catch (SQLException e) {
      System.out.println(">> Erro na conexão com o servidor, volte aqui mais tarde :)");
    }

    return categoria;
  }
}