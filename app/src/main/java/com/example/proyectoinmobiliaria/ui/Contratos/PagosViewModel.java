package com.example.proyectoinmobiliaria.ui.Contratos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.proyectoinmobiliaria.model.Contrato;
import com.example.proyectoinmobiliaria.model.Pago;
import com.example.proyectoinmobiliaria.resource.ApiClient;

import java.util.ArrayList;
import java.util.List;


public class PagosViewModel extends ViewModel {
    private MutableLiveData<List<Pago>> pagosLiveData;
    private ApiClient apiClient;

    public PagosViewModel() {
        pagosLiveData = new MutableLiveData<>();
        apiClient = ApiClient.getApi();
    }

    public LiveData<List<Pago>> getPagos() {
        return pagosLiveData;
    }

    public void fetchPagos(Contrato contrato) {
        List<Pago> pagos = apiClient.obtenerPagos(contrato);
        pagosLiveData.setValue(pagos);
    }
}
