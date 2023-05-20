package com.example.proyectoinmobiliaria.ui.Logout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyectoinmobiliaria.LoginActivity;
import com.example.proyectoinmobiliaria.R;
import com.google.android.material.navigation.NavigationView;

public class LogoutFragment extends Fragment {

    public LogoutFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_logout, container, false);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        try {
            ActionBar actionBar = activity.getSupportActionBar();
            actionBar.setTitle("Logout");
        } catch (Exception e) {
            e.printStackTrace();
        }

        mostrarAlertDialog();
        return root;
    }

    private void mostrarAlertDialog() {
        new AlertDialog.Builder(getContext())
                .setTitle("Confirmación")
                .setMessage("¿Desea cerrar sesión?")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getActivity(), LoginActivity.class);
                        startActivity(intent);
                        getActivity().finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

}
