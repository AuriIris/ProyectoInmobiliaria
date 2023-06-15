package com.example.proyectoinmobiliaria.model;


import java.io.Serializable;

public class Propietario implements Serializable {
    private int id;
    private String dni;
    private String nombre;
    private String apellido;
    private String mail;
    private String clave;
    private String telefono;
    private int imagen;

    public Propietario(int id, String dni, String nombre, String apellido, String mail, String clave, String telefono, int imagen) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.clave = clave;
        this.telefono = telefono;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public String getDni() {
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

    public String getContraseña() {
        return clave;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.mail = email;
    }

    public void setContraseña(String contraseña) {
        this.clave = contraseña;
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
                ", email='" + mail + '\'' +
                ", contraseña='" + clave + '\'' +
                ", telefono='" + telefono + '\'' +
                ", imagen=" + imagen +
                '}';
    }
}
