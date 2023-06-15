package com.example.proyectoinmobiliaria.ui.Contratos;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.proyectoinmobiliaria.model.Contrato;
import com.example.proyectoinmobiliaria.model.Pago;
import com.example.proyectoinmobiliaria.resource.ApiClient;
import com.example.proyectoinmobiliaria.resource.ApiClientRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PagosViewModel extends AndroidViewModel {
    private MutableLiveData<List<Pago>> pagosLiveData;
    private ApiClientRetrofit.EndpointInmobiliaria apiClient;
    private Context contexto;

    public PagosViewModel(Application application) {
        super(application);
        contexto = application.getApplicationContext();
        apiClient = ApiClientRetrofit.getEndpoint();
    }

    public LiveData<List<Pago>> getPagos() {
        return pagosLiveData;
    }

    public void fetchPagos(Contrato contrato) {
        SharedPreferences sp = contexto.getSharedPreferences("token.xml", 0);
        String token = sp.getString("token", "");
        Call<List<Pago>> pagos = apiClient.obtenerPagos(token, contrato.getId());
        pagos.enqueue(new Callback<List<Pago>>() {
            @Override
            public void onResponse(Call<List<Pago>> call, Response<List<Pago>> response) {
                if (response.isSuccessful()) {
                    pagosLiveData.postValue(response.body());
                } else {
                    Toast.makeText(contexto, "No se pudo traer pagos 2", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<Pago>> call, Throwable t) {
                Toast.makeText(contexto, "No se pudo traer los pagos", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
