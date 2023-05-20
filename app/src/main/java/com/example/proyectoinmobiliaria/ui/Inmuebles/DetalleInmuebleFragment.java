package com.example.proyectoinmobiliaria.ui.Inmuebles;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyectoinmobiliaria.R;
import com.example.proyectoinmobiliaria.model.Inmueble;
import com.squareup.picasso.Picasso;

public class DetalleInmuebleFragment extends Fragment {
    private ImageView imageView;
    private TextView codigoTextView;
    private TextView ambientesTextView;
    private TextView direccionTextView;
    private TextView precioTextView;
    private TextView usoTextView;
    private CheckBox disponibleCheckBox;
    private TextView tipoTextView;

    public DetalleInmuebleFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalle_inmueble, container, false);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        try {
            ActionBar actionBar = activity.getSupportActionBar();
            actionBar.setTitle("Detalle del Inmueble");
        } catch (Exception e) {
            e.printStackTrace();
        }

        imageView = view.findViewById(R.id.imageView);
        codigoTextView = view.findViewById(R.id.codigoTextView);
        ambientesTextView = view.findViewById(R.id.ambientesTextView);
        direccionTextView = view.findViewById(R.id.direccionTextView);
        precioTextView = view.findViewById(R.id.precioTextView);
        usoTextView = view.findViewById(R.id.usoTextView);
        disponibleCheckBox = view.findViewById(R.id.disponibleCheckBox);
        tipoTextView = view.findViewById(R.id.tipoTextView);

        Bundle bundle = getArguments();
        try {
            Inmueble inmueble = (Inmueble) bundle.getSerializable("inmueble");
            try {
                Picasso.get().load(inmueble.getImagenUrl()).into(imageView);
                codigoTextView.setText(String.valueOf(inmueble.getId()+""));
                ambientesTextView.setText(String.valueOf(inmueble.getAmbientes()));
                direccionTextView.setText(String.valueOf(inmueble.getDireccion()));
                precioTextView.setText(String.valueOf(inmueble.getPrecio()+""));
                disponibleCheckBox.setChecked(inmueble.isDisponible());
                tipoTextView.setText(String.valueOf(inmueble.getTipo()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;
    }
}