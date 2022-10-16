package com.example.model;

public class Acesso {

    private int id;

    private String local;
    private String login;
    private String senha;

    public Acesso() {
    }

    public Acesso(String local, String login, String senha) {
        this.local = local;
        this.login = login;
        this.senha = senha;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Acesso [local=" + local + ", login=" + login + ", senha=" + senha + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
