package com.example.presentationcard.application;

import android.app.Application;
import androidx.appcompat.app.AppCompatDelegate;

import com.example.presentationcard.helper.StorageHelper;

public class MyApplication extends Application {
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
