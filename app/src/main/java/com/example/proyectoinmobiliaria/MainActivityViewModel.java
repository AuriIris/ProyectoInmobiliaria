package com.example.proyectoinmobiliaria;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.proyectoinmobiliaria.model.Propietario;
import com.example.proyectoinmobiliaria.resource.ApiClientRetrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends AndroidViewModel {
    private Context contexto;
    private MutableLiveData<Propietario> usuarioLiveData = new MutableLiveData<>();
    private ApiClientRetrofit.EndpointInmobiliaria apiClient;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        contexto = application.getApplicationContext();
        apiClient = ApiClientRetrofit.getEndpoint();
    }

    public LiveData<Propietario> getUsuarioLiveData() {
        return usuarioLiveData;
    }

    public void obtenerDatosUsuario() {
        SharedPreferences sp = contexto.getSharedPreferences("token.xml", 0);
        String token = sp.getString("token", "");
        Call<Propietario> perfil = apiClient.obtenerPerfil(token);
        perfil.enqueue(new Callback<Propietario>() {
            @Override
            public void onResponse(Call<Propietario> call, Response<Propietario> response) {
                if (response.isSuccessful()) {
                    usuarioLiveData.postValue(response.body());
                } else {
                    Log.d("ver23", response.message());
                }
            }

            @Override
            public void onFailure(Call<Propietario> call, Throwable t) {
                Toast.makeText(contexto, "Error al acceder al perfil", Toast.LENGTH_SHORT).show();
            }
        });

    }
}