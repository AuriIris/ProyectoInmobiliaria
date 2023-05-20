package com.example.proyectoinmobiliaria.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.proyectoinmobiliaria.R;
import com.example.proyectoinmobiliaria.databinding.FragmentHomeBinding;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class HomeFragment extends Fragment implements OnMapReadyCallback {
    private static final LatLng MIUBICACION = new LatLng(-32.960572, -61.547538);
    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        try {
            ActionBar actionBar = activity.getSupportActionBar();
            actionBar.setTitle("Ubicacion");
        } catch (Exception e) {
            e.printStackTrace();
        }

        SupportMapFragment smf = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        smf.getMapAsync(this);

        return root;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        googleMap.addMarker(new MarkerOptions().position(MIUBICACION).title("Aca estoy"));
        CameraPosition camPos = new CameraPosition.Builder()
                .target(MIUBICACION)
                .zoom(19)
                .bearing(45)
                .tilt(70)
                .build();
        CameraUpdate update = CameraUpdateFactory.newCameraPosition(camPos);
        googleMap.animateCamera(update);
    }
}
