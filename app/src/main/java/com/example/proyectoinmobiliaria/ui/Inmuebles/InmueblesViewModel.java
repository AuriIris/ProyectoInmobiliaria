package com.example.proyectoinmobiliaria.ui.Inmuebles;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.proyectoinmobiliaria.model.Contrato;
import com.example.proyectoinmobiliaria.resource.ApiClientRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InmueblesViewModel extends AndroidViewModel {

    private MutableLiveData<List<Contrato>> inmueblesLiveData;
    private ApiClientRetrofit.EndpointInmobiliaria apiClient;
    private Context contexto;

    public InmueblesViewModel(Application application) {
        super(application);
        contexto = application.getApplicationContext();
        apiClient = ApiClientRetrofit.getEndpoint();
    }

    public LiveData<List<Contrato>> getInmuebles() {
        if (inmueblesLiveData == null) {
            inmueblesLiveData = new MutableLiveData<>();
            cargarInmuebles();
        }
        return inmueblesLiveData;
    }

    private void cargarInmuebles() {
        SharedPreferences sp = contexto.getSharedPreferences("token.xml", 0);
        String token = sp.getString("token", "");
        Call<List<Contrato>> contratos = apiClient.obtenerPropiedades(token);
        contratos.enqueue(new Callback<List<Contrato>>() {
            @Override
            public void onResponse(Call<List<Contrato>> call, Response<List<Contrato>> response) {
                if (response.isSuccessful()) {
                    List<Contrato> inmuebles = response.body();
                    inmueblesLiveData.postValue(inmuebles);
                } else {
                    Log.d("Salida", response.message());
                    Toast.makeText(contexto, "Error al Buscar Inmuebles", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Contrato>> call, Throwable t) {
                Toast.makeText(contexto, "Error al Buscar Inmuebles", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
