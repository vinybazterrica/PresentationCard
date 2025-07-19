package com.example.presentationcard.activities;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.example.presentationcard.R;
import com.example.presentationcard.databinding.ActivitySplashBinding;
import com.example.presentationcard.helper.ResourcesHelper;
import com.example.presentationcard.helper.StorageHelper;
import com.example.presentationcard.helper.StringHelper;
import com.example.presentationcard.models.entity.LinkedinProfile;
import com.example.presentationcard.network.githubApi.GithubCallBack;
import com.example.presentationcard.network.githubApi.GithubManager;
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

        shouldGetApiData();
    }

    private void shouldGetApiData() {
        LinkedinProfile linkedinProfile = StorageHelper.getLinkedinProfileStorage();
        long lastLinkedinData = StorageHelper.getInstance().getLongPreferences(Constants.KEY_LAST_GET_LINKEDIN_DATA);

        if (lastLinkedinData == 0 ||
                System.currentTimeMillis() - lastLinkedinData > Constants.THIRTY_MINUTES_IN_MILLIS ||
                linkedinProfile == null) {
            StorageHelper.getInstance().putLongPreferences(Constants.KEY_LAST_GET_LINKEDIN_DATA, System.currentTimeMillis());
            getDataFromGithub();
        } else {
            showToast(this, Constants.USING_STORAGE_USER);
            goToProfile(linkedinProfile);
        }
    }

    private void getDataFromGithub() {
        if (!ResourcesHelper.isNetworkAvailable(this)) {
            showToast(this, getString(R.string.error_no_internet));
            return;
        }

        StringHelper.addDotsToMessaje(getString(R.string.loading_data), binding.tvLoading);


        //Espera 3 segundos para simular carga
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            GithubManager.getGithubData(this, new GithubCallBack() {
                @Override
                public void onSuccess(LinkedinProfile profile) {
                    Log.d("ProfileActivity GitHub", "Perfil recibido: " + profile.getFull_name());
                    goToProfileWithData(profile);
                }

                @Override
                public void onError(String errorMessage) {
                    Log.e("ProfileActivity", "Error: " + errorMessage);
                    showToast(SplashActivity.this, errorMessage);
                }
            });
        }, Constants.SPLASH_SLEEP);
    }

    private void goToProfileWithData(LinkedinProfile profile) {
        StorageHelper.saveLinkedinProfileStorage(profile);
        showToast(SplashActivity.this, Constants.SAVE_LINKEDIN_DATA);
        goToProfile(profile);
    }
}