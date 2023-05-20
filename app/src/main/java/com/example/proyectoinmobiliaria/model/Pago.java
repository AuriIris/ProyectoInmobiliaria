package com.example.proyectoinmobiliaria.model;

import java.io.Serializable;

public class Pago implements Serializable {
    private int id;
    private int numeroPago;
    private Contrato contrato;
    private double monto;
    private String fecha;

    public Pago(int id, int numeroPago, Contrato contrato, double monto, String fecha) {
        this.id = id;
        this.numeroPago = numeroPago;
        this.contrato = contrato;
        this.monto = monto;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public int getNumeroPago() {
        return numeroPago;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public double getMonto() {
        return monto;
    }

    public String getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Pago{" +
                "id=" + id +
                ", numeroPago=" + numeroPago +
                ", contrato=" + contrato +
                ", monto=" + monto +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
