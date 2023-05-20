package com.example.proyectoinmobiliaria.ui.home;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.core.content.ContextCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<Boolean> permissionsGrantedLiveData = new MutableLiveData<>();

    public LiveData<Boolean> getPermissionsGrantedLiveData() {
        return permissionsGrantedLiveData;
    }

    public void checkPermissions(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
                    ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                permissionsGrantedLiveData.setValue(false);
            } else {
                permissionsGrantedLiveData.setValue(true);
            }
        } else {
            permissionsGrantedLiveData.setValue(true);
        }
    }
}
