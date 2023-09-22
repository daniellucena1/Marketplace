package com.ecommerce.database;

import java.sql.*;

public class DatabaseConnection {
  public Connection connection() {
    String conexao = "jdbc:postgresql://localhost:5432/ecommerce";
    String usuario = "root";
    String senha = "root";

    try {
      // Class.forName("org.postgresql.Driver");
      Connection connection = DriverManager.getConnection(conexao, usuario, senha);

      System.out.println("Conectado com sucesso!");
      if (connection != null) { 
        return connection;
      } 
    } catch (Exception ex) {
      throw new RuntimeException("Erro ao conectar com o banco de dados");
    }

    return null;
  }
}
