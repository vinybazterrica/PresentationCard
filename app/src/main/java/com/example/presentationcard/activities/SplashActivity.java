package com.example.presentationcard.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.presentationcard.R;
import com.example.presentationcard.helper.IntentHelper;
import com.example.presentationcard.interfaces.LinkedinApi;
import com.example.presentationcard.models.entity.LinkedinProfile;
import com.example.presentationcard.models.entity.LinkedinProfileResponse;
import com.example.presentationcard.utils.Constants;

import java.io.Serializable;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_PresentationCard);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        findProfile();
    }

    private void findProfile() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.LINKEDIN_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LinkedinApi linkedinApi = retrofit.create(LinkedinApi.class);
        Call<LinkedinProfileResponse> call = linkedinApi.getProfilePublicData(
                Constants.LINKEDIN_API_KEY
                , Constants.LINKEDIN_API_HOST
                , Constants.LINKEDIN_VINY_PROFILE_URL,
                false, false, false
                , false, false, false
                , false, false, false, false);

        call.enqueue(new retrofit2.Callback<LinkedinProfileResponse>() {
            @Override
            public void onResponse(Call<LinkedinProfileResponse> call, retrofit2.Response<LinkedinProfileResponse> response) {
                if (response.isSuccessful()) {
                    LinkedinProfile profile = response.body().getData();
                    if (profile.getExperiences() != null) {
                        Bundle bundle = new Bundle();
                        bundle.putParcelable(Constants.LINKEDIN_PROFILE, profile);
                        IntentHelper.goToProfile(SplashActivity.this, bundle);
                    } else {
                        Toast.makeText(SplashActivity.this, Constants.LINKEDIN_NO_DATA, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(SplashActivity.this, Constants.LINKEDIN_ERROR, Toast.LENGTH_SHORT).show();
                    Log.e("SplashActivity", "Error: " + response.code() + " - " + response.message());
                }
            }

            @Override
            public void onFailure(Call<LinkedinProfileResponse> call, Throwable t) {
                Log.e("SplashActivity", "Error: " + t.getMessage());
            }
        });
    }
}