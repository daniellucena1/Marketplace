package com.ecommerce.repositories;

import java.sql.*;

import com.ecommerce.interfaces.IClienteRepository;
import com.ecommerce.models.Cliente;

public class ClienteRepository implements IClienteRepository {
  public Connection connection;

  public ClienteRepository(Connection connection) {
    this.connection = connection;
  }

  public Cliente findClienteById(String id) {
    String sql = "SELECT * FROM usuarios WHERE cpf='" + id + "';";
    Cliente cliente = null;

    try {
      Statement statement = this.connection.createStatement();
      ResultSet result = statement.executeQuery(sql);
      while (result.next()) {
        cliente = new Cliente(result.getString("cpf"), result.getString("senha"), result.getString("nome"),
            result.getBoolean("permissao"), result.getString("endereco"),
            result.getString("cep"));
      }
    } catch (SQLException e) {
      System.out.println(">> Erro na conexão com o servidor , volte aqui mais tarde :)!");
      return null;
    }

    return cliente;
  }

  public String remove(String CPF) {
    Cliente cliente = findClienteById(CPF);

    if (cliente != null) {
      String sql = "DELETE FROM usuarios WHERE cpf='" + cliente.getCPF() + "';";

      try {
        Statement statement = this.connection.createStatement();
        statement.execute(sql);
      } catch (SQLException e) {
        System.out.println(">> Erro na conexão com o servidor, volte mais tarde :)");
      }

      return "Cliente deletado com sucesso!";
    } else {
      return "Cliente não existe ou já foi deletado do nosso banco de dados";
    }
  };

  public String create(Cliente cliente) {
    // User usuario = (User) cliente;
    String sql = "INSERT INTO usuarios(cpf, senha, nome, permissao, endereco, cep) VALUES ('" + cliente.getCPF() + "', '" +
        cliente.getSenha() + "', '" + cliente.getNome() + "', " + cliente.isPermissao() + ", '" +
        cliente.getEndereco() + "', '" + cliente.getCep() + "');";

    try {
      Statement statement = this.connection.createStatement();
      statement.execute(sql);
    } catch (SQLException e) {
      System.out.println(">> Erro na conexão com o servidor, volte aqui mais tarde :)");
      return ">> Cliente não criado";
    }

    return ">> Cliente criado com sucesso";
  }

  public String update(Cliente clienteAtualizado) {
    Cliente cliente = findClienteById(clienteAtualizado.getCPF());
    String sql = "UPDATE usuarios SET nome='" + clienteAtualizado.getNome() + "', endereco='" +
        clienteAtualizado.getEndereco() + "', cep='" + clienteAtualizado.getCep() + "'WHERE cpf='" + cliente.getCPF() + "';";

    try {
      Statement statement = this.connection.createStatement();
      statement.execute(sql);
    } catch (SQLException e) {
      System.out.println(">> Erro na conexão com o servidor, volte aqui mais tarde :)");
      return ">> Cliente não foi atualizado";
    }

    return ">> Cliente atualizado com sucesso";
  }

  public boolean login(String cpf, String senha) {
    Cliente cliente = findClienteById(cpf);

    if (cliente != null && cliente.getSenha().equals(senha)) {
      return true;
    }
    
    return false;
  }
}