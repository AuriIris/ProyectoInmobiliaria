package com.example.proyectoinmobiliaria.resource;

import com.example.proyectoinmobiliaria.model.Contrato;
import com.example.proyectoinmobiliaria.model.Inmueble;
import com.example.proyectoinmobiliaria.model.Inquilino;
import com.example.proyectoinmobiliaria.model.Pago;
import com.example.proyectoinmobiliaria.model.Propietario;
import com.example.proyectoinmobiliaria.model.Usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public class ApiClientRetrofit {

    private static final String BASE_URL = "http://192.168.0.2:5207/";
    private static EndpointInmobiliaria endpoint;

    public static EndpointInmobiliaria getEndpoint() {

        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        endpoint = retrofit.create(EndpointInmobiliaria.class);
        return endpoint;
    }

    public interface EndpointInmobiliaria {
        @POST("Propietario/login")
        Call<String> login(@Body Usuario user);

        @GET("Propietario/perfil")
        Call<Propietario> obtenerPerfil(@Header("Authorization") String token);

        @PUT("Propietario/{id}")
        Call<Propietario> actualizarPerfil(@Header("Authorization") String token, @Path("id") int id, @Body Propietario propietario);

        @GET("Inmueble/propiedades")
        Call<List<Contrato>> obtenerPropiedades(@Header("Authorization") String token);

        @GET("Inmueble/alquiladas")
        Call<List<Contrato>> obtenerPropiedadesAlquiladas(@Header("Authorization") String token);

        @GET("Contrato/contrato-vigente/{idInmueble}")
        Call<Contrato> obtenerContratoVigente(@Header("Authorization") String token, @Path("idInmueble") int idInmueble);

        @GET("Contrato/inquilino/{idInmueble}")
        Call<Inquilino> obtenerInquilino(@Header("Authorization") String token, @Path("idInmueble") int idInmueble);

        @GET("Contrato/{idContrato}/pagos")
        Call<List<Pago>> obtenerPagos(@Header("Authorization") String token, @Path("idContrato") int idContrato);
    }
}