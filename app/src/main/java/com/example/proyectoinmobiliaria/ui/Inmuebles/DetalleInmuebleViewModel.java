package com.example.proyectoinmobiliaria.ui.Inmuebles;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.proyectoinmobiliaria.model.Inmueble;

public class DetalleInmuebleViewModel extends ViewModel {
    private MutableLiveData<Inmueble> inmuebleLiveData = new MutableLiveData<>();

    public void setInmueble(Inmueble inmueble) {
        inmuebleLiveData.setValue(inmueble);
    }

    public LiveData<Inmueble> getInmueble() {
        return inmuebleLiveData;
    }
}
