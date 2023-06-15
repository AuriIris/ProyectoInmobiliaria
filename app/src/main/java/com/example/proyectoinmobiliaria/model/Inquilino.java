package com.example.proyectoinmobiliaria.model;

import java.io.Serializable;

public class Inquilino implements Serializable {
    private int id;
    private long dni;
    private String nombre;
    private String apellido;
    private String mail;
    private String telefono;

    public Inquilino(int id, long dni, String nombre, String apellido, String direccion, String email, String telefono, String nombreGarante, String telefonoGarante) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = email;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public long getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return mail;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return "Inquilino{" +
                "id=" + id +
                ", dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + mail + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
