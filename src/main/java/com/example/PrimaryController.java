package com.example;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.model.Acesso;
import com.example.model.dao.AcessoDao;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TextField;

public class PrimaryController implements Initializable {

    @FXML TextField textFieldLocal;
    @FXML TextField textFieldLogin;
    @FXML TextField passwordFieldSenha;
    @FXML TableView<Acesso> tabela;
    @FXML TableColumn<Acesso, String> colunaLocal;
    @FXML TableColumn<Acesso, String> colunaLogin;
    @FXML TableColumn<Acesso, String> colunaSenha;

    public void salvar(){
        
        try {
            new AcessoDao().salvar(carregarAcessoDoForm());
            carregarDados();
        } catch (SQLException e) {
            mostrarMensagem("Erro ao conectar com o banco de dados");        
            e.printStackTrace();
        }
    }

    private void carregarDados(){
        tabela.getItems().clear();
        try {
            tabela.getItems().setAll(new AcessoDao().listar());
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

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        colunaLocal.setCellValueFactory(new PropertyValueFactory<>("local"));        
        colunaLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
        colunaSenha.setCellValueFactory(new PropertyValueFactory<>("senha"));
        carregarDados();
    }



}
