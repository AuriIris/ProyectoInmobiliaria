package com.example.proyectoinmobiliaria.ui.Contratos;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.proyectoinmobiliaria.model.Contrato;
import com.example.proyectoinmobiliaria.model.Inmueble;
import com.example.proyectoinmobiliaria.model.Inquilino;
import com.example.proyectoinmobiliaria.resource.ApiClient;
import com.example.proyectoinmobiliaria.resource.ApiClientRetrofit;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContratosViewModel  extends AndroidViewModel {
    private MutableLiveData<ArrayList<Contrato>> contratosLiveData;
    private ApiClientRetrofit.EndpointInmobiliaria apiClient;
    private Context contexto;

    public ContratosViewModel(Application application) {
        super(application);
        contexto = application.getApplicationContext();
        apiClient = ApiClientRetrofit.getEndpoint();
    }

    public LiveData<ArrayList<Contrato>> getContratosLiveData() {
        if (contratosLiveData == null) {
            contratosLiveData = new MutableLiveData<>();
            loadContratos();
        }
        return contratosLiveData;
    }

    private void loadContratos() {
        SharedPreferences sp = contexto.getSharedPreferences("token.xml", 0);
        String token = sp.getString("token", "");
        Call<List<Contrato>> inmueblesAlquilados = apiClient.obtenerPropiedadesAlquiladas(token);
        inmueblesAlquilados.enqueue(new Callback<List<Contrato>>() {
            @Override
            public void onResponse(Call<List<Contrato>> call, Response<List<Contrato>> response) {
                if (response.isSuccessful()) {
                    List<Contrato> inmuebles = response.body();
                    ArrayList<Contrato> contratos = new ArrayList<>();

                    for (Contrato contrato : inmuebles) {
                        Inmueble inmueble = contrato.getInmueble1();
                        Inquilino inquilino = contrato.getInquilino1();
                        if (inmueble != null && inquilino != null) {
                            contratos.add(contrato);
                        }
                    }
                    contratosLiveData.postValue(contratos);
                } else {
                    Log.d("ver", response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Contrato>> call, Throwable t) {
                Log.d("ver", "Error: " + t.getMessage());
            }
        });



    }
}
