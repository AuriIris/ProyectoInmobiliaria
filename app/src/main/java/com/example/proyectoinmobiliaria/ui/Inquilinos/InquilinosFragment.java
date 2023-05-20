package com.example.proyectoinmobiliaria.ui.Inquilinos;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
import com.example.proyectoinmobiliaria.model.Inquilino;

import java.util.ArrayList;

public class InquilinosFragment extends Fragment implements InquilinosAdapter.OnItemClickListener {
    private InquilinosViewModel inquilinosViewModel;
    private InquilinosAdapter inquilinosAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        try {
            ActionBar actionBar = activity.getSupportActionBar();
            actionBar.setTitle("Inquilinos");
        } catch (Exception e) {
            e.printStackTrace();
        }

        inquilinosViewModel = new ViewModelProvider(this).get(InquilinosViewModel.class);
        inquilinosAdapter = new InquilinosAdapter(requireContext(), new ArrayList<>());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_inquilinos, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.rvInquilinos);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(inquilinosAdapter);

        return rootView;
    }

    @Override
    public void onInquilinosClick(Inquilino inquilino) {
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        inquilinosViewModel.getContratosLiveData().observe(getViewLifecycleOwner(), new Observer<ArrayList<Contrato>>() {
            @Override
            public void onChanged(ArrayList<Contrato> contratos) {
                Log.d("ver", contratos.toString());
                inquilinosAdapter.setContratos(contratos);
            }
        });

        inquilinosAdapter.setOnItemClickListener(this);
    }
}
