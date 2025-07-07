package com.example.presentationcard.activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.presentationcard.R;
import com.example.presentationcard.databinding.ActivitySplashBinding;
import com.example.presentationcard.helper.IntentHelper;
import com.example.presentationcard.network.LinkedinApi;
import com.example.presentationcard.models.entity.LinkedinProfile;
import com.example.presentationcard.models.entity.LinkedinProfileResponse;
import com.example.presentationcard.network.LinkedinCallBack;
import com.example.presentationcard.network.LinkedinManager;
import com.example.presentationcard.utils.Constants;
import com.squareup.picasso.BuildConfig;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SplashActivity extends BaseActivity {

    private ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_PresentationCard);
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.tvVersionApp.setText(Constants.VERSION_APP + BuildConfig.VERSION_NAME);

        getUserLinkdeinData();
    }

    private void getUserLinkdeinData(){
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