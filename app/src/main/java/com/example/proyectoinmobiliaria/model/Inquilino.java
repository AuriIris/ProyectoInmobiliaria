package com.example.proyectoinmobiliaria.model;

import java.io.Serializable;

public class Inquilino implements Serializable {
    private int id;
    private long dni;
    private String nombre;
    private String apellido;
    private String direccion;
    private String email;
    private String telefono;
    private String nombreGarante;
    private String telefonoGarante;

    public Inquilino(int id, long dni, String nombre, String apellido, String direccion, String email, String telefono, String nombreGarante, String telefonoGarante) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
        this.nombreGarante = nombreGarante;
        this.telefonoGarante = telefonoGarante;
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

    public String getDireccion() {
        return direccion;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getNombreGarante() {
        return nombreGarante;
    }

    public String getTelefonoGarante() {
        return telefonoGarante;
    }

    @Override
    public String toString() {
        return "Inquilino{" +
                "id=" + id +
                ", dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", nombreGarante='" + nombreGarante + '\'' +
                ", telefonoGarante='" + telefonoGarante + '\'' +
                '}';
    }
}
