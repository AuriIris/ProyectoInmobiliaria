package com.example.proyectoinmobiliaria.ui.Inquilinos;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.proyectoinmobiliaria.model.Contrato;
import com.example.proyectoinmobiliaria.model.Inmueble;
import com.example.proyectoinmobiliaria.model.Inquilino;
import com.example.proyectoinmobiliaria.resource.ApiClient;

import java.util.ArrayList;

public class InquilinosViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Contrato>> contratosLiveData;

    public LiveData<ArrayList<Contrato>> getContratosLiveData() {
        if (contratosLiveData == null) {
            contratosLiveData = new MutableLiveData<>();
            loadContratos();
        }
        return contratosLiveData;
    }

    private void loadContratos() {

        ArrayList<Inmueble> inmueblesAlquilados = ApiClient.getApi().obtenerPropiedadesAlquiladas();
        Log.d("ver", inmueblesAlquilados+"");
        ArrayList<Contrato> contratos = new ArrayList<>();

        for (Inmueble inmueble : inmueblesAlquilados) {
            Contrato contrato = ApiClient.getApi().obtenerContratoVigente(inmueble);
            Log.d("ver", contrato.toString());
            Inquilino inquilino = ApiClient.getApi().obtenerInquilino(inmueble);
            Log.d("ver", inquilino.toString());
            if (contrato != null && inquilino != null) {
                contrato.setInmueble(inmueble);
                contrato.setInquilino(inquilino);
                contratos.add(contrato);
            }
        }
        contratosLiveData.setValue(contratos);
    }
}
