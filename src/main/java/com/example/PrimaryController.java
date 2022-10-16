package com.example;

import java.sql.SQLException;

import com.example.model.Acesso;
import com.example.model.dao.AcessoDao;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML TextField textFieldLocal;
    @FXML TextField textFieldLogin;
    @FXML TextField passwordFieldSenha;

    public void salvar(){
        
        try {
            new AcessoDao().salvar(carregarAcessoDoForm());
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

    private Acesso carregarAcessoDoForm(){
        var acesso = new Acesso();
        acesso.setLocal(textFieldLocal.getText());
        acesso.setLogin(textFieldLogin.getText());
        acesso.setSenha(passwordFieldSenha.getText());
        return acesso;
    }



}
