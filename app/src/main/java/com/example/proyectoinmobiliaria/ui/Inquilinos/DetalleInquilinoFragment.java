package com.example.proyectoinmobiliaria.ui.Inquilinos;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.proyectoinmobiliaria.R;
import com.example.proyectoinmobiliaria.model.Inquilino;

public class DetalleInquilinoFragment extends Fragment {
    private TextView tvCodigo;
    private TextView tvNombre;
    private TextView tvApellido;
    private TextView tvDni;
    private TextView tvEmail;
    private TextView tvTelefono;
    private TextView tvGarante;
    private TextView tvTelefonoGarante;
    private ImageView ivImagen;

    public DetalleInquilinoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalle_inquilino, container, false);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        try {
            ActionBar actionBar = activity.getSupportActionBar();
            actionBar.setTitle("Detalle Inquilino");
        } catch (Exception e) {
            e.printStackTrace();
        }

        tvCodigo = view.findViewById(R.id.tvCodigo);
        tvNombre = view.findViewById(R.id.tvNombre);
        tvApellido = view.findViewById(R.id.tvApellido);
        tvDni = view.findViewById(R.id.tvDni);
        tvEmail = view.findViewById(R.id.tvEmail);
        tvTelefono = view.findViewById(R.id.tvTelefono);

        Bundle bundle = getArguments();
        try {
            Inquilino inquilino = (Inquilino) bundle.getSerializable("inquilino");
            try {
                tvCodigo.setText(String.valueOf(inquilino.getId()));
                tvNombre.setText(inquilino.getNombre());
                tvApellido.setText(inquilino.getApellido());
                tvDni.setText(String.valueOf(inquilino.getDni()));
                tvEmail.setText(inquilino.getEmail());
                tvTelefono.setText(inquilino.getTelefono());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;
    }
}
