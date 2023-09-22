package com.ecommerce.repositories;

import java.sql.*;

import com.ecommerce.interfaces.IDonoRepository;
import com.ecommerce.models.Dono;

public class DonoRepository implements IDonoRepository{
    public Connection connection;

    public DonoRepository(Connection connection) {
        this.connection = connection;
    }

    public Dono buscarDono(String cpf) {
        String sql = "SELECT * FROM usuarios WHERE cpf='" + cpf +"';";
        Dono dono = null;

        try {
            Statement statement = this.connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
              dono = new Dono(result.getString("cpf"), result.getString("senha"), result.getString("nome"), result.getBoolean("permissao"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(">> Erro na conexão com o servidor, volte aqui mais tarde :)");
        }

        return dono;
    }

  public String create(Dono dono) {
    // User usuario = (User) dono;
    String sql = "INSERT INTO usuarios (cpf, nome, senha, permissao, endereco, cep) VALUES ('" + dono.getCPF() + "', '" + 
    dono.getNome() + "', '" + dono.getSenha() + "', " + dono.isPermissao() + ", " +  
    null + ", " + null + ");";
    try {
      Statement statement = this.connection.createStatement();
      statement.execute(sql);
    } catch (SQLException e) {
      System.out.println(">> Erro na conexão com o servidor, volte aqui mais tarde :)");
    }

    return ">> Dono criado com sucesso";
  }

    public boolean login(String cpf, String senha) {
        Dono dono = buscarDono(cpf);

        if (dono != null && dono.getSenha().equals(senha)) {
            return true;
        }

        return false;
    }
}