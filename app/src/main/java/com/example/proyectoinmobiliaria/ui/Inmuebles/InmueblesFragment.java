package com.example.proyectoinmobiliaria.ui.Inmuebles;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.proyectoinmobiliaria.R;
import com.example.proyectoinmobiliaria.model.Inmueble;

import java.util.ArrayList;
import java.util.List;
public class InmueblesFragment extends Fragment implements InmueblesAdapter.OnItemClickListener {
    private RecyclerView recyclerView;
    private InmueblesAdapter inmueblesAdapter;
    private InmueblesViewModel inmueblesViewModel;

    public InmueblesFragment() {
        // Constructor vacío requerido
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inmuebles, container, false);
        recyclerView = view.findViewById(R.id.rvInmueble);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        try {
            ActionBar actionBar = activity.getSupportActionBar();
            actionBar.setTitle("Inmuebles ");
        } catch (Exception e) {
            e.printStackTrace();
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        inmueblesAdapter = new InmueblesAdapter(getActivity(), this);
        recyclerView.setAdapter(inmueblesAdapter);

        inmueblesViewModel = new ViewModelProvider(this).get(InmueblesViewModel.class);
        inmueblesViewModel.getInmuebles().observe(getViewLifecycleOwner(), new Observer<List<Inmueble>>() {
            @Override
            public void onChanged(List<Inmueble> inmuebles) {

                Log.d("Inmuebles", inmuebles.toString());
                inmueblesAdapter.setInmuebles(inmuebles);
            }
        });
        inmueblesViewModel.getInmuebles(); // Cargar los datos de los inmuebles
    }

    @Override
    public void onInmuebleClick(Inmueble inmueble) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("inmueble", inmueble);
        Navigation.findNavController(requireView()).navigate(R.id.action_inmueblesFragment_to_detalleInmuebleFragment, bundle);
    }
}
