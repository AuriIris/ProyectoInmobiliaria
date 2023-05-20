package com.example.proyectoinmobiliaria.ui.Contratos;
import androidx.lifecycle.ViewModel;

import com.example.proyectoinmobiliaria.model.Contrato;

public class DetalleContratoViewModel extends ViewModel {
    private Contrato contrato;

    public DetalleContratoViewModel() {
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public Contrato getContrato() {
        return contrato;
    }
}