package com.example.proyectoinmobiliaria.model;

import java.io.Serializable;

public class Contrato implements Serializable {
    private int id;
    private String fecDesde;
    private String fecHasta;
    private double precio;
    private Inquilino inquilino1;
    private Inmueble inmueble1;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecDesde() {
        return fecDesde;
    }

    public void setFecDesde(String fecDesde) {
        this.fecDesde = fecDesde;
    }

    public String getFecHasta() {
        return fecHasta;
    }

    public void setFecHasta(String fecHasta) {
        this.fecHasta = fecHasta;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Inquilino getInquilino1() {
        return inquilino1;
    }

    public Contrato(int id, String fecDesde, String fecHasta, double precio, Inquilino inquilino1, Inmueble inmueble1) {
        this.id = id;
        this.fecDesde = fecDesde;
        this.fecHasta = fecHasta;
        this.precio = precio;
        this.inquilino1 = inquilino1;
        this.inmueble1 = inmueble1;
    }

    public void setInquilino1(Inquilino inquilino1) {
        this.inquilino1 = inquilino1;
    }

    public Inmueble getInmueble1() {
        return inmueble1;
    }

    public void setInmueble1(Inmueble inmueble1) {
        this.inmueble1 = inmueble1;
    }

    @Override
    public String toString() {
        return "Contrato{" +
                "id=" + id +
                ", fecDesde='" + fecDesde + '\'' +
                ", fecHasta='" + fecHasta + '\'' +
                ", precio=" + precio +
                ", inquilino1=" + inquilino1 +
                ", inmueble1=" + inmueble1 +
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
