package com.example.proyectoinmobiliaria.ui.Contratos;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.proyectoinmobiliaria.R;
import com.example.proyectoinmobiliaria.model.Contrato;

public class DetalleContratoFragment extends Fragment {
    private TextView tvId;
    private TextView tvFechaInicio;
    private TextView tvFechaFin;
    private TextView tvPrecio;
    private TextView tvInquilino;
    private TextView tvInmueble;
    private Button btnVerPagos;

    public DetalleContratoFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalle_contrato, container, false);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        try {
            ActionBar actionBar = activity.getSupportActionBar();
            actionBar.setTitle("Detalle de Contrato");
        } catch (Exception e) {
            e.printStackTrace();
        }

        tvId = view.findViewById(R.id.tvId);
        tvFechaInicio = view.findViewById(R.id.tvFechaInicio);
        tvFechaFin = view.findViewById(R.id.tvFechaFin);
        tvPrecio = view.findViewById(R.id.tvPrecio);
        tvInquilino = view.findViewById(R.id.tvInquilino);
        tvInmueble = view.findViewById(R.id.tvInmueble);
        btnVerPagos = view.findViewById(R.id.btnVerPagos);
        Bundle bundle = getArguments();
        try {
            Contrato contrato = (Contrato) bundle.getSerializable("contrato");
            Log.d("ver3", contrato.toString());
            try {
                Log.d("ver2", contrato.toString());
                    tvId.setText("ID: " + String.valueOf(contrato.getId()));
                    tvFechaInicio.setText("Fecha De Inicio: " + contrato.getFechaInicio());
                    tvFechaFin.setText("Fecha Final: " + contrato.getFechaFin());
                    tvPrecio.setText("Precio: " + String.valueOf(contrato.getPrecio()));
                    tvInquilino.setText("Inquilino: " + contrato.getInquilino().toString());
                    tvInmueble.setText("Inmueble: " + contrato.getInmueble().getDireccion());

            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        } catch (ClassCastException e) {
            e.printStackTrace();
        }

        btnVerPagos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = getArguments();
                try {
                    Contrato contrato = (Contrato) bundle.getSerializable("contrato");
                    Bundle pagosBundle = new Bundle();
                    Log.d("ver6", contrato+"");
                    pagosBundle.putSerializable("contrato", contrato);

                    NavHostFragment.findNavController(DetalleContratoFragment.this)
                            .navigate(R.id.action_detalleContratoFragment_to_pagosFragment, pagosBundle);
                } catch (ClassCastException e) {
                    e.printStackTrace();
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            }
        });
       
        return view;
    }

}