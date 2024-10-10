package com.platzi.model;

public class Usuario {

    private int id_usuario;
    private String username;
    private String password;
    private String full_name;

    public Usuario() {
    }

    public Usuario(String full_name, int id_usuario, String password, String username) {
        this.full_name = full_name;
        this.id_usuario = id_usuario;
        this.password = password;
        this.username = username;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
