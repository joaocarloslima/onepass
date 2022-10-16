package com.example.model.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.example.conexao.ConnectionFactory;
import com.example.model.Acesso;

public class AcessoDao {

    public void salvar(Acesso acesso) throws SQLException{
        
        Connection connection = ConnectionFactory.getConnection();

        var sql = "INSERT INTO senhas (id, local, login, senha) VALUES (null, ?, ?, ?)";
        var statement = connection.prepareStatement(sql);
        statement.setString(1, acesso.getLocal());
        statement.setString(2, acesso.getLogin());
        statement.setString(3, acesso.getSenha());

        statement.execute();
        connection.close();
    }

    
    
}
