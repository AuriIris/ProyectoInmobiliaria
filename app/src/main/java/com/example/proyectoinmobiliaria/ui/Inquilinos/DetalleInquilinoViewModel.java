package com.example.proyectoinmobiliaria.ui.Inquilinos;

import androidx.lifecycle.ViewModel;

import com.example.proyectoinmobiliaria.model.Inquilino;

public class DetalleInquilinoViewModel extends ViewModel {
    private Inquilino inquilino;

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }
}