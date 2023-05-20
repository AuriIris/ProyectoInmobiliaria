package com.example.proyectoinmobiliaria.model;


import java.io.Serializable;

public class Propietario implements Serializable {
    private int id;
    private long dni;
    private String nombre;
    private String apellido;
    private String email;
    private String contraseña;
    private String telefono;
    private int imagen;

    public Propietario(int id, long dni, String nombre, String apellido, String email, String contraseña, String telefono, int imagen) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contraseña = contraseña;
        this.telefono = telefono;
        this.imagen = imagen;
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
        return email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getImagen() {
        return imagen;
    }

    @Override
    public String toString() {
        return "Propietario{" +
                "id=" + id +
                ", dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", telefono='" + telefono + '\'' +
                ", imagen=" + imagen +
                '}';
    }
}
