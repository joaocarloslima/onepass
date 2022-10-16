package com.example.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Acesso> listar() throws SQLException {
        var lista = new ArrayList<Acesso>();

        Connection connection = ConnectionFactory.getConnection();
        
        var sql = "SELECT * FROM senhas";
        var statement = connection.prepareStatement(sql);
        var resultSet = statement.executeQuery();

        while(resultSet.next()){
            var acesso = new Acesso();
            acesso.setId(resultSet.getInt("id"));
            acesso.setLocal(resultSet.getString("local"));
            acesso.setLogin(resultSet.getString("login"));
            acesso.setSenha(resultSet.getString("senha"));
            lista.add(acesso);
        }

        connection.close();
        return lista;
    }

    
    
}
