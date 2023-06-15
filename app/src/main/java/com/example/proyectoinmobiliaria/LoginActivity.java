package com.example.proyectoinmobiliaria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.proyectoinmobiliaria.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity implements SensorEventListener {

    private ActivityLoginBinding binding;
    private LoginViewModel viewModel;

    private SensorManager sensorManager;
    private Sensor accelerometerSensor;
    private Sensor gyroscopeSensor;
    private long lastShakeTime;
    private static final int SHAKE_INTERVAL = 1000;
    private static final float GYROSCOPE_THRESHOLD = 0.5f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        binding.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.editTextMail.getText().toString();
                String password = binding.editTextPass.getText().toString();
                viewModel.login(email, password);
            }        });
            sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (sensorManager != null) {
            accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            gyroscopeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (accelerometerSensor != null) {
            sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (gyroscopeSensor != null) {
            sensorManager.registerListener(this, gyroscopeSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];
            float acceleration = (float) Math.sqrt(x * x + y * y + z * z);
            if (acceleration > SensorManager.GRAVITY_EARTH && System.currentTimeMillis() - lastShakeTime >= SHAKE_INTERVAL) {
                lastShakeTime = System.currentTimeMillis();
                makeCallToInmobiliaria();
            }
        } else if (sensorEvent.sensor.getType() == Sensor.TYPE_GYROSCOPE) {
            float gyroscopeX = sensorEvent.values[0];
            float gyroscopeY = sensorEvent.values[1];
            float gyroscopeZ = sensorEvent.values[2];

            if (Math.abs(gyroscopeX) > GYROSCOPE_THRESHOLD || Math.abs(gyroscopeY) > GYROSCOPE_THRESHOLD || Math.abs(gyroscopeZ) > GYROSCOPE_THRESHOLD) {
                makeCallToInmobiliaria();
            }
        }
    }

    private void makeCallToInmobiliaria() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastShakeTime >= SHAKE_INTERVAL) {
            lastShakeTime = currentTime;
            llamarInmobiliaria();
            Toast.makeText(this, "Llamando a la inmobiliaria...", Toast.LENGTH_SHORT).show();
        }
    }
    private void llamarInmobiliaria() {
        int permissionCheck = ContextCompat.checkSelfPermission(LoginActivity.this, Manifest.permission.CALL_PHONE);
        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + "2664389548"));
            startActivity(intent);

        } else {
            Toast.makeText(LoginActivity.this, "Permiso para llamadas denegado", Toast.LENGTH_SHORT).show();
            ActivityCompat.requestPermissions(LoginActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}