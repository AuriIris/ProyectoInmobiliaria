package com.example.proyectoinmobiliaria.ui.Inquilinos;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

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

public class InquilinosViewModel extends AndroidViewModel {
    private MutableLiveData<ArrayList<Contrato>> contratosLiveData;
    private ApiClientRetrofit.EndpointInmobiliaria apiClient;
    private Context contexto;
    public InquilinosViewModel(Application application) {
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
                    Log.d("ver2", response.body() + "");
                   ArrayList<Contrato> contratos = new ArrayList<>();
                    List<Contrato> contratosAlquilados = response.body();
                    if (inmueblesAlquilados != null) {
                        for (Contrato cont : contratosAlquilados) {
                            Contrato contrato = cont;
                            Inquilino inquilino = cont.getInquilino1();
                            if (contrato != null && inquilino != null) {
                                contrato.setInmueble1(contrato.getInmueble1());
                                contrato.setInquilino1(inquilino);
                                contratos.add(contrato);
                            }
                        }
                    }
                    Log.d("Ver 2" ,contratos+"");
                    contratosLiveData.setValue(contratos);
            }
                else {
                    Log.d("Ver", response.message());

                }
            }

            @Override
            public void onFailure(Call<List<Contrato>> call, Throwable t) {
                Toast.makeText(contexto, "Error al Buscar Inquilinos 1", Toast.LENGTH_SHORT).show();
            }
        });

    }

    }

