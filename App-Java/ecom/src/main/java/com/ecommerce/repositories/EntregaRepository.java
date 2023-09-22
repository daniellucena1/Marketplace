package com.ecommerce.repositories;

import java.sql.*;

import com.ecommerce.interfaces.IEntregaRepository;
import com.ecommerce.models.Entrega;

public class EntregaRepository implements IEntregaRepository {
  public Connection connection;

  public EntregaRepository(Connection connection) {
    this.connection = connection;
  }

  public Entrega findEntregaById(int numeroRastreio) {
    String sql = "SELECT * FROM entregas WHERE id=" + numeroRastreio + ";";
    Entrega entrega = null;

    try {
      Statement statement = this.connection.createStatement();
      ResultSet result = statement.executeQuery(sql);
      while (result.next()) {
        entrega = new Entrega(result.getInt("id"), result.getString("cliente_cpf"),
          result.getDouble("valorFrete"), result.getString("statusPedido"), result.getInt("idPedido"));
      }
    } catch (Exception e) {
      System.out.println(">> Erro na conexão com o servidor, volte aqui mais tarde :)");
    }
    return entrega;
  }

  public void create(Entrega entrega) {
    String sql = "INSERT INTO entregas(numeroRastreio, cliente_cpf, valorFrete, status) VALUES ("
        + entrega.getNumeroRastreio() + ", '"
        + entrega.getIdCliente() + "', " + entrega.getValorFrete() + ", '" + entrega.getStatus() + "');";

    try {
      Statement statement = this.connection.createStatement();
      statement.execute(sql);
    } catch (SQLException e) {
      System.out.println(">> Erro na conexão com o servidor, volte aqui mais tarde :)");
    }
  }

  public String update(int numeroRastreio, String novoStatus) {
    Entrega entrega = findEntregaById(numeroRastreio);
    String sql = "UPDATE entregas SET statusPedido='" + novoStatus + "'WHERE id=" + entrega.getNumeroRastreio() + ";";

    try {
      Statement statement = this.connection.createStatement();
      statement.execute(sql);
    } catch (SQLException e) {
      System.out.println(">> Erro na conexão com o servidor, volte aqui mais tarde :)");
    }

    return ">> Status da entrega atualizado com sucesso";
  }
}
