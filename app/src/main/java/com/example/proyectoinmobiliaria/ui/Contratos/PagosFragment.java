package com.example.proyectoinmobiliaria.ui.Contratos;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectoinmobiliaria.R;
import com.example.proyectoinmobiliaria.model.Contrato;
import com.example.proyectoinmobiliaria.model.Pago;

import java.util.List;

public class PagosFragment extends Fragment {

    private RecyclerView rvPagos;
    private PagoAdapter pagoAdapter;
    private PagosViewModel pagosViewModel;
    private Contrato contrato;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatActivity activity = (AppCompatActivity) getActivity();

        try {
            ActionBar actionBar = activity.getSupportActionBar();
            actionBar.setTitle("Pagos");
        } catch (Exception e) {
            e.printStackTrace();
        }
        pagosViewModel = new ViewModelProvider(this).get(PagosViewModel.class);

        Bundle bundle = getArguments();
        try {
            contrato = (Contrato) bundle.getSerializable("contrato");
        } catch (ClassCastException e) {
            contrato = null;
            e.printStackTrace();
        } catch (NullPointerException e) {
            contrato = null;
            e.printStackTrace();
        }

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pagos, container, false);

        rvPagos = view.findViewById(R.id.rvPagos);
        rvPagos.setLayoutManager(new LinearLayoutManager(requireContext()));
        pagoAdapter = new PagoAdapter(requireContext());
        rvPagos.setAdapter(pagoAdapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        try {
            pagosViewModel.getPagos().observe(getViewLifecycleOwner(), new Observer<List<Pago>>() {
                @Override
                public void onChanged(List<Pago> pagos) {
                    Log.d("ver4", pagos.toString());
                    pagoAdapter.setPagos(pagos);
                }
            });
            Log.d("verContrato1", contrato+"");
            pagosViewModel.fetchPagos(contrato);
        } catch (NullPointerException e) {
            e.printStackTrace();
            Toast.makeText(getContext(), "Este contrato no tiene pagos", Toast.LENGTH_SHORT).show();
        }
    }
}
