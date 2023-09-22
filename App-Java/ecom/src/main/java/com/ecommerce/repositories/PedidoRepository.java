package com.ecommerce.repositories;

import java.sql.*;
import java.util.*;

import com.ecommerce.interfaces.IPedidoRepository;
import com.ecommerce.models.*;

public class PedidoRepository implements IPedidoRepository {
  public Connection connection;

  public PedidoRepository(Connection connection) {
    this.connection = connection;
  }

  public void create(Pedido pedido) {
    String sql = "INSERT INTO pedidos (id, cpf_usuario, produtos) VALUES (" + pedido.getId() + ", '"
        + pedido.getClienteId() + "', '" + pedido.getProdutos() + "');";

    try {
      Statement statement = this.connection.createStatement();
      statement.execute(sql);
    } catch (SQLException e) {
      System.out.println(">> Erro na conexão com o servidor, volte aqui mais tarde :)");
    }
  }

  public Pedido getPedidoByUserId(String cpf) {
    String sql = "SELECT * FROM pedidos WHERE cpf_usuario='" + cpf + "';";

    Pedido pedido = null;

    try {
      Statement statement = this.connection.createStatement();
      ResultSet result = statement.executeQuery(sql);
      while (result.next()) {
        pedido = new Pedido(result.getString("cpf_usuario"), result.getString("produtos"));
      }
    } catch (Exception e) {
      System.out.println(">> Erro na conexão com o servidor, volte aqui mais tarde :)");
    }

    return pedido;
  }

  public String getById(int idPedido) {
    String sql = "SELECT * FROM pedidos WHERE id=" + idPedido + ";";

    try {
      Statement statement = this.connection.createStatement();
      ResultSet result = statement.executeQuery(sql);
      while (result.next()) {
        System.out.println(">> Pedido encontrado: " + result.getString("produtos"));
      }
    } catch (Exception e) {
      System.out.println(">> Erro na conexão com o servidor, volte aqui mais tarde :)");
    }

    return ">> Pedido nao existe";
  };

  public List<Pedido> getAll() {
    String sql = "SELECT * FROM pedidos;";

    List<Pedido> pedidos = new ArrayList<Pedido>();

    try {
      Statement statement = this.connection.createStatement();
      ResultSet result = statement.executeQuery(sql);
      while (result.next()) {
        Pedido pedido = new Pedido(result.getString("cpf_usuario"), result.getString("produtos"));
        pedidos.add(pedido);
      }
    } catch (Exception e) {
      System.out.println(">> Erro na conexão com o servidor, volte aqui mais tarde :)");
    }

    return pedidos;
  };
}
