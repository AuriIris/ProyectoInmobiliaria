package com.example.proyectoinmobiliaria.ui.Perfil;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.proyectoinmobiliaria.model.Propietario;
import com.example.proyectoinmobiliaria.resource.ApiClient;

public class PerfilViewModel extends AndroidViewModel {
    private MutableLiveData<Propietario> propietarioLiveData = new MutableLiveData<>();
    private ApiClient apiClient;
    private Context contexto;

    public PerfilViewModel(Application application) {
        super(application);
        contexto = application.getApplicationContext();
        apiClient = ApiClient.getApi();
    }

    public LiveData<Propietario> getPropietarioLiveData() {
        return propietarioLiveData;
    }

    public void obtenerDatosPropietario() {
        Propietario propietario = apiClient.obtenerUsuarioActual();
        propietarioLiveData.setValue(propietario);
    }

    public void actualizarDatosPropietario(String nombre, String apellido, String email, String contraseña, String telefono) {
        Propietario propietarioActual = propietarioLiveData.getValue();
        if (propietarioActual != null) {
            // Actualiza los campos del propietario
            propietarioActual.setNombre(nombre);
            propietarioActual.setApellido(apellido);
            propietarioActual.setEmail(email);
            propietarioActual.setContraseña(contraseña);
            propietarioActual.setTelefono(telefono);

            // Actualiza el perfil del propietario en el ApiClient
            apiClient.actualizarPerfil(propietarioActual);

            // Notifica a los observadores del LiveData que los datos han cambiado
            propietarioLiveData.setValue(propietarioActual);
        }
    }
}
