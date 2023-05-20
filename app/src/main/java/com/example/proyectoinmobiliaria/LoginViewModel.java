package com.example.proyectoinmobiliaria;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.proyectoinmobiliaria.model.Propietario;
import com.example.proyectoinmobiliaria.resource.ApiClient;

public class LoginViewModel extends AndroidViewModel {
    private Context context;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public void login(String mail, String pass) {
        Propietario propietario = ApiClient.getApi().login(mail, pass);
        if (propietario == null) {
            Toast.makeText(context, "Datos incorrectos", Toast.LENGTH_SHORT).show();
            return;
        }

        Bundle bundle = new Bundle();
        bundle.putSerializable("login", true);
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }
}