package com.example.proyectoinmobiliaria.model;

public class Usuario {
    private String Mail;
    private String clave;

    public Usuario(String usuario, String clave) {
        this.Mail = usuario;
        this.clave = clave;
    }

    public void setUsuario(String usuario) {
        this.Mail = usuario;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getUsuario() {
        return Mail;
    }

    public String getClave() {
        return clave;
    }
}
