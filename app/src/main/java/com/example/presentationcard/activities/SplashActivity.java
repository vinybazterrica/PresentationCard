package com.example.presentationcard.activities;

import static com.example.presentationcard.helper.StorageHelper.getLinkedinProfileStorage;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.example.presentationcard.R;
import com.example.presentationcard.databinding.ActivitySplashBinding;
import com.example.presentationcard.helper.ResourcesHelper;
import com.example.presentationcard.helper.StorageHelper;
import com.example.presentationcard.helper.StringHelper;
import com.example.presentationcard.models.entity.LinkedinProfile;
import com.example.presentationcard.network.LinkedinCallBack;
import com.example.presentationcard.network.LinkedinManager;
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

        shouldGetLinkedinData();
    }

    private void shouldGetLinkedinData() {
        LinkedinProfile linkedinProfile = StorageHelper.getLinkedinProfileStorage();
        long lastLinkedinData = StorageHelper.getInstance().getLongPreferences(Constants.KEY_LAST_GET_LINKEDIN_DATA);

        if (lastLinkedinData == 0 ||
                System.currentTimeMillis() - lastLinkedinData > Constants.TWENTY_FOUR_HOURS_IN_MILLS ||
                    linkedinProfile == null){
            StorageHelper.getInstance().putLongPreferences(Constants.KEY_LAST_GET_LINKEDIN_DATA, System.currentTimeMillis());
            getUserLinkdeinData();
        } else {
            showToast(this,  Constants.USING_STORAGE_USER);
            goToProfile(linkedinProfile);
        }
    }

    private void getUserLinkdeinData() {
        if (!ResourcesHelper.isNetworkAvailable(this)){
            showToast(this,  Constants.ERROR_NETWORK);
            return;
        }

        StringHelper.addDotsToMessaje(getString(R.string.loading_data), binding.tvLoading);

        LinkedinManager.getLinkedinUserData(this, new LinkedinCallBack() {
            @Override
            public void onSuccess(LinkedinProfile profile) {
                Log.d("ProfileActivity", "Perfil recibido: " + profile.getFull_name());
                StorageHelper.saveLinkedinProfileStorage(SplashActivity.this, profile);
                showToast(SplashActivity.this,  Constants.SAVE_LINKEDIN_DATA);
                goToProfile(profile);
            }

            @Override
            public void onError(String errorMessage) {
                Log.e("ProfileActivity", "Error: " + errorMessage);
            }
        });
    }
}