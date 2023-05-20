package com.example.proyectoinmobiliaria.ui.Perfil;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory;

import com.example.proyectoinmobiliaria.R;
import com.example.proyectoinmobiliaria.model.Propietario;

public class PerfilFragment extends Fragment {
    private EditText codigoEditText;
    private EditText nombreEditText;
    private EditText apellidoEditText;
    private EditText emailEditText;
    private EditText contraseñaEditText;
    private EditText telefonoEditText;
    private Button editarGuardarButton;

    private PerfilViewModel perfilViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        try {
            ActionBar actionBar = activity.getSupportActionBar();
            actionBar.setTitle("Perfil");
        } catch (Exception e) {
            e.printStackTrace();
        }

        codigoEditText = view.findViewById(R.id.codigoEditText);
        nombreEditText = view.findViewById(R.id.nombreEditText);
        apellidoEditText = view.findViewById(R.id.apellidoEditText);
        emailEditText = view.findViewById(R.id.emailEditText);
        contraseñaEditText = view.findViewById(R.id.contraseñaEditText);
        telefonoEditText = view.findViewById(R.id.telefonoEditText);
        editarGuardarButton = view.findViewById(R.id.editarGuardarButton);
        Context context = requireContext();
        perfilViewModel = new ViewModelProvider(this).get(PerfilViewModel.class);
        perfilViewModel.getPropietarioLiveData().observe(getViewLifecycleOwner(), new Observer<Propietario>() {
            @Override
            public void onChanged(Propietario propietario) {
                mostrarDatosPropietario(propietario);
            }
        });
        editarGuardarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editarGuardarButton.getText().equals("Editar")) {
                    habilitarEdicion();
                } else if (editarGuardarButton.getText().equals("Guardar")) {
                    guardarCambios();
                }
            }
        });
        perfilViewModel.obtenerDatosPropietario();

        return view;
    }

    private void mostrarDatosPropietario(Propietario propietario) {
        codigoEditText.setText(String.valueOf(propietario.getId()));
        nombreEditText.setText(String.valueOf(propietario.getNombre()));
        apellidoEditText.setText(String.valueOf(propietario.getApellido()));
        emailEditText.setText(String.valueOf(propietario.getEmail()));
        contraseñaEditText.setText(String.valueOf(propietario.getContraseña()));
        telefonoEditText.setText(String.valueOf(propietario.getTelefono()));
    }

    private void habilitarEdicion() {
        nombreEditText.setEnabled(true);
        apellidoEditText.setEnabled(true);
        emailEditText.setEnabled(true);
        contraseñaEditText.setEnabled(true);
        telefonoEditText.setEnabled(true);
        editarGuardarButton.setText("Guardar");
    }

    private void guardarCambios() {
        String nombre = nombreEditText.getText().toString();
        String apellido = apellidoEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String contraseña = contraseñaEditText.getText().toString();
        String telefono = telefonoEditText.getText().toString();

        perfilViewModel.actualizarDatosPropietario(nombre, apellido, email, contraseña, telefono);

        nombreEditText.setEnabled(false);
        apellidoEditText.setEnabled(false);
        emailEditText.setEnabled(false);
        contraseñaEditText.setEnabled(false);
        telefonoEditText.setEnabled(false);
        editarGuardarButton.setText("Editar");
    }
}