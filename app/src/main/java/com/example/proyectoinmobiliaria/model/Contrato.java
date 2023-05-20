package com.example.proyectoinmobiliaria.model;

import java.io.Serializable;

public class Contrato implements Serializable {
    private int id;
    private String fechaInicio;
    private String fechaFin;
    private double precio;
    private Inquilino inquilino;
    private Inmueble inmueble;

    public void setId(int id) {
        this.id = id;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public Contrato(int id, String fechaInicio, String fechaFin, double precio, Inquilino inquilino, Inmueble inmueble) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precio = precio;
        this.inquilino = inquilino;
        this.inmueble = inmueble;
    }

    public int getId() {
        return id;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public double getPrecio() {
        return precio;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    @Override
    public String toString() {
        return "Contrato{" +
                "id=" + id +
                ", fechaInicio='" + fechaInicio + '\'' +
                ", fechaFin='" + fechaFin + '\'' +
                ", precio=" + precio +
                ", inquilino=" + inquilino +
                ", inmueble=" + inmueble +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contrato contrato = (Contrato) o;
        return id == contrato.id;
    }
}
