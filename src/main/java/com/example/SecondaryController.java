package com.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SecondaryController {

    @FXML TextField senha;

    @FXML
    private void logar() throws IOException {
        if(senha.getText().equals("123")){
            App.setRoot("primary");
        }
    }
}