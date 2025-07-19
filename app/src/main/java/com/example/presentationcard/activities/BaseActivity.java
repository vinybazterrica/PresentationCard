package com.example.presentationcard.activities;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.example.presentationcard.R;
import com.example.presentationcard.helper.IntentHelper;
import com.example.presentationcard.helper.StorageHelper;
import com.example.presentationcard.models.entity.LinkedinProfile;
import com.example.presentationcard.utils.Constants;

public class BaseActivity extends AppCompatActivity {

    private StorageHelper mStorage = StorageHelper.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    /*GO TO*/
    public void goToUrl(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    public void goToWhatsApp(String phoneNumber) {
        String url = Constants.WHATSAPP_WAME + Constants.START_WHASTAPP + phoneNumber;
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            goToUrl(url);
        }
    }

    public void sendEmail(String emailAddress) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse(Constants.MAILTO + emailAddress));

        startActivity(intent);
    }

    public void goToProfile(LinkedinProfile profile) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constants.LINKEDIN_PROFILE, profile);
        IntentHelper.goToProfile(this, bundle, true);
    }

    /*MESSAGES*/
    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    /*VIEWS*/
    public void setGoneView(View view) {
        if (view != null)
            view.setVisibility(GONE);
    }

    protected void setupThemeSwitch(Switch themeSwitch) {
        if (themeSwitch == null) return;

        boolean isDarkMode = mStorage.isDarkModeEnabled();
        themeSwitch.setChecked(isDarkMode);

        themeSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            mStorage.setDarkModeEnabled(isChecked);

            AppCompatDelegate.setDefaultNightMode(
                    isChecked ?
                            AppCompatDelegate.MODE_NIGHT_YES :
                            AppCompatDelegate.MODE_NIGHT_NO
            );
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Switch themeSwitch = findViewById(R.id.themeSwitch);
        if (themeSwitch != null) {
            setupThemeSwitch(themeSwitch);
        }
    }
}
