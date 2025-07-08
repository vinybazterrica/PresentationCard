package com.example.presentationcard.activities;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.example.presentationcard.R;
import com.example.presentationcard.databinding.ActivitySplashBinding;
import com.example.presentationcard.helper.IntentHelper;
import com.example.presentationcard.helper.StringHelper;
import com.example.presentationcard.models.entity.LinkedinProfile;
import com.example.presentationcard.network.LinkedinCallBack;
import com.example.presentationcard.utils.Constants;

public class SplashActivity extends BaseActivity {

    private ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_PresentationCard);
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.tvVersionApp.setText(Constants.VERSION_APP + StringHelper.getVersionApp(this));

        getUserLinkdeinData();
    }

    private void loadingText() {
        final Handler handler = new Handler();
        final String[] dots = {"", ".", "..", "...", "...."};
        final int[] index = {0};

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                binding.tvLoading.setText(getString(R.string.loading_data) + dots[index[0]]);
                index[0] = (index[0] + 1) % dots.length;
                handler.postDelayed(this, 500);
            }
        }, 500);
    }

    private void getUserLinkdeinData() {
        if (!BaseActivity.isNetworkAvailable(this)){
            Toast.makeText(this, Constants.ERROR_NETWORK, Toast.LENGTH_LONG).show();
            return;
        }

        loadingText();

        getLinkedinUserData(this, new LinkedinCallBack() {
            @Override
            public void onSuccess(LinkedinProfile profile) {
                Log.d("ProfileActivity", "Perfil recibido: " + profile.getFull_name());
                Bundle bundle = new Bundle();
                bundle.putParcelable(Constants.LINKEDIN_PROFILE, profile);
                IntentHelper.goToProfile(SplashActivity.this, bundle);
            }

            @Override
            public void onError(String errorMessage) {
                Log.e("ProfileActivity", "Error: " + errorMessage);
            }
        });
    }
}