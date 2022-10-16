package com.example.service;

public class Criptografia {
    
    public String criptografar(String texto){
        var textoCriptografado = "";
        for (int i = 0; i < texto.length(); i++) {
            textoCriptografado += (char) (texto.charAt(i) + 1);
        }
        return textoCriptografado;
    }

    public String descriptografar(String texto){
        var textoDescriptografado = "";
        for (int i = 0; i < texto.length(); i++) {
            textoDescriptografado += (char) (texto.charAt(i) - 1);
        }
        return textoDescriptografado;
    }

}
