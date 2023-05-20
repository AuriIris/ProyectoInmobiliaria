package com.example.proyectoinmobiliaria.ui.Contratos;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyectoinmobiliaria.R;
import com.example.proyectoinmobiliaria.model.Contrato;
import com.example.proyectoinmobiliaria.model.Inquilino;
import com.example.proyectoinmobiliaria.ui.Inquilinos.InquilinosAdapter;
import com.example.proyectoinmobiliaria.ui.Inquilinos.InquilinosViewModel;

import java.util.ArrayList;

public class ContratosFragment extends Fragment implements ContratosAdapter.OnItemClickListener {
    private ContratosViewModel contratosViewModel;
    private ContratosAdapter contratosAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        try {
             ActionBar actionBar = activity.getSupportActionBar();
             actionBar.setTitle("Contratos");
        } catch (Exception e) {
            e.printStackTrace();
        }
        contratosViewModel = new ViewModelProvider(this).get(ContratosViewModel.class);
        contratosAdapter = new ContratosAdapter(requireContext(), new ArrayList<>());
        contratosAdapter.setOnItemClickListener(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_contratos, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.rvContratos);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(contratosAdapter);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        contratosViewModel.getContratosLiveData().observe(getViewLifecycleOwner(), new Observer<ArrayList<Contrato>>() {
            @Override
            public void onChanged(ArrayList<Contrato> contratos) {
                Log.d("ver", contratos.toString());
                contratosAdapter.setContratos(contratos);
            }
        });
    }


    @Override
    public void onInquilinosClick(Inquilino inquilino) {

    }
}
