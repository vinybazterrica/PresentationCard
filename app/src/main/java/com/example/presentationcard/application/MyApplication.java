package com.example.presentationcard.application;

import android.app.Application;  // Importa la clase Application base
import androidx.appcompat.app.AppCompatDelegate;

import com.example.presentationcard.helper.StorageHelper;

public class MyApplication extends Application {  // Extiende Application base
    @Override
    public void onCreate() {
        super.onCreate();

        StorageHelper.getInstance().init(getApplicationContext());

        boolean isDarkMode = StorageHelper.getInstance().isDarkModeEnabled();

        AppCompatDelegate.setDefaultNightMode(
                isDarkMode ?
                        AppCompatDelegate.MODE_NIGHT_YES :
                        AppCompatDelegate.MODE_NIGHT_NO
        );
    }
}
