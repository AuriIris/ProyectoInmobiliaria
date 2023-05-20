package com.example.proyectoinmobiliaria.ui.Inmuebles;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.proyectoinmobiliaria.model.Inmueble;
import com.example.proyectoinmobiliaria.resource.ApiClient;

import java.util.List;

public class InmueblesViewModel extends ViewModel {

    private MutableLiveData<List<Inmueble>> inmueblesLiveData;
    private ApiClient apiClient;

    public LiveData<List<Inmueble>> getInmuebles() {
        if (inmueblesLiveData == null) {
            inmueblesLiveData = new MutableLiveData<>();
            apiClient = ApiClient.getApi();
            cargarInmuebles();
        }
        return inmueblesLiveData;
    }

    private void cargarInmuebles() {
        List<Inmueble> inmuebles = apiClient.obtnerPropiedades();
        Log.d("inmueble3", inmuebles+"");
        inmueblesLiveData.setValue(inmuebles);
    }
}
