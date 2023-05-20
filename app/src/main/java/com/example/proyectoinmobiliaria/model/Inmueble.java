package com.example.proyectoinmobiliaria.model;

import java.io.Serializable;

public class Inmueble implements Serializable {
    private int id;
    private String direccion;
    private String tipo;
    private String descripcion;
    private int ambientes;
    private double precio;
    private Propietario propietario;
    private boolean disponible;
    private String imagenUrl;

    public Inmueble(int id, String direccion, String tipo, String descripcion, int ambientes, double precio, Propietario propietario, boolean disponible, String imagenUrl) {
        this.id = id;
        this.direccion = direccion;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.ambientes = ambientes;
        this.precio = precio;
        this.propietario = propietario;
        this.disponible = disponible;
        this.imagenUrl = imagenUrl;
    }

    public int getId() {
        return id;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getAmbientes() {
        return ambientes;
    }

    public double getPrecio() {
        return precio;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    @Override
    public String toString() {
        return "Inmueble{" +
                "id=" + id +
                ", direccion='" + direccion + '\'' +
                ", tipo='" + tipo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", ambientes=" + ambientes +
                ", precio=" + precio +
                ", propietario=" + propietario +
                ", disponible=" + disponible +
                ", imagenUrl='" + imagenUrl + '\'' +
                '}';
    }
}
