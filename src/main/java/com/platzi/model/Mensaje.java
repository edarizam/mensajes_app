package com.platzi.model;

public class Mensaje {

    private int id_mensaje;
    private String mensaje;
    private String autor_mensaje;
    private String fecha_mensaje;

    public Mensaje(){}

    public Mensaje(String autor_mensaje, String fecha_mensaje, int id_mensaje, String mensaje) {
        this.autor_mensaje = autor_mensaje;
        this.fecha_mensaje = fecha_mensaje;
        this.id_mensaje = id_mensaje;
        this.mensaje = mensaje;
    }

    public int getId_mensaje() {
        return id_mensaje;
    }

    public void setId_mensaje(int id_mensaje) {
        this.id_mensaje = id_mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getAutor_mensaje() {
        return autor_mensaje;
    }

    public void setAutor_mensaje(String autor_mensaje) {
        this.autor_mensaje = autor_mensaje;
    }

    public String getFecha_mensaje() {
        return fecha_mensaje;
    }

    public void setFecha_mensaje(String fecha_mensaje) {
        this.fecha_mensaje = fecha_mensaje;
    }

}
