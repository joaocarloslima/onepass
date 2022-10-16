package com.example;

import java.sql.Connection;
import java.sql.SQLException;

import com.example.conexao.ConnectionFactory;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PrimaryController {

    public void salvar(){
        try {
            Connection connection = ConnectionFactory.getConnection();
            connection.close();
            System.out.println("conectado");
        } catch (SQLException e) {
            mostrarMensagem("Erro ao conectar com o banco de dados");        
            e.printStackTrace();
        }
    }

    private void mostrarMensagem(String mensagem) {
        var alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setContentText(mensagem);
        alert.showAndWait();
    }



}
