package com.example.proyectoinmobiliaria.ui.Perfil;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.proyectoinmobiliaria.model.Propietario;
import com.example.proyectoinmobiliaria.resource.ApiClient;
import com.example.proyectoinmobiliaria.resource.ApiClientRetrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerfilViewModel extends AndroidViewModel {
    private MutableLiveData<Propietario> propietarioLiveData = new MutableLiveData<>();
    private ApiClientRetrofit.EndpointInmobiliaria apiClient;
    private Context contexto;

    public PerfilViewModel(Application application) {
        super(application);
        contexto = application.getApplicationContext();
        apiClient = ApiClientRetrofit.getEndpoint();
    }

    public LiveData<Propietario> getPropietarioLiveData() {
        return propietarioLiveData;
    }

    public void obtenerDatosPropietario() {
        SharedPreferences sp = contexto.getSharedPreferences("token.xml", 0);
        String token= sp.getString("token","");
        Call<Propietario> perfil=apiClient.obtenerPerfil(token);
        perfil.enqueue(new Callback<Propietario>() {
            @Override
            public void onResponse(Call<Propietario> call, Response<Propietario> response) {
                if(response.isSuccessful()){
                    propietarioLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<Propietario> call, Throwable t) {
                Toast.makeText(contexto, "Error al acceder al perfil", Toast.LENGTH_SHORT).show();
            }
        });

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
            SharedPreferences sp = contexto.getSharedPreferences("token.xml", 0);
            String token = sp.getString("token", "");
            int propietarioId = propietarioActual.getId(); // Asegúrate de obtener el id del propietario adecuadamente

            Call<Propietario> actualizarPerfilCall = apiClient.actualizarPerfil(token, propietarioId, propietarioActual);
            actualizarPerfilCall.enqueue(new Callback<Propietario>() {
                @Override
                public void onResponse(Call<Propietario> call, Response<Propietario> response) {
                    Log.d("ver", response.message());
                    if (response.isSuccessful()) {
                        propietarioLiveData.setValue(response.body());
                    } else {
                        Toast.makeText(contexto, "Error al actualizar el perfil", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Propietario> call, Throwable t) {
                    // Error de conexión o solicitud fallida
                    Toast.makeText(contexto, "Error al conectar con el servidor", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}
