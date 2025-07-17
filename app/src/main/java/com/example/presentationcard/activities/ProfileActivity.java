package com.example.presentationcard.activities;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;

import com.example.presentationcard.R;
import com.example.presentationcard.databinding.ActivityProfileBinding;
import com.example.presentationcard.databinding.ViewThemeSwitchBinding;
import com.example.presentationcard.helper.IntentHelper;
import com.example.presentationcard.helper.StorageHelper;
import com.example.presentationcard.models.entity.LinkedinExperience;
import com.example.presentationcard.models.entity.LinkedinProfile;
import com.example.presentationcard.utils.Constants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends BaseActivity {

    private int button2Visibility = VISIBLE;
    private ActivityProfileBinding binding;
    private LinkedinProfile mLinkedinProfile;

    /**
     * Called when the activity is first created. Used to initialize the activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mLinkedinProfile = StorageHelper.getInstance().getLinkedinProfile();

        if (mLinkedinProfile == null) {
            getIntentData();
        }

        setProfileData();
        setOnClickListener();
    }

    private void getIntentData() {
        mLinkedinProfile = getIntent().getParcelableExtra(Constants.LINKEDIN_PROFILE);
    }

    private void setProfileData() {

        Picasso.get()
                .load(mLinkedinProfile.getProfile_image_url())
                .into(binding.ivProfileImage, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {
                        binding.progressBarImage.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError(Exception e) {
                        binding.progressBarImage.setVisibility(View.GONE);
                    }
                });

        binding.tvUserName.setText(mLinkedinProfile.getFull_name());
        binding.tvUserHeadLine.setText(mLinkedinProfile.getHeadline());

        binding.txtLinkedinProfile.setText(mLinkedinProfile.getFull_name());
    }

    private void goToExperiences(List<LinkedinExperience> experiencesList){
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(Constants.LINKEDIN_EXPERIENCES_LIST, new ArrayList<>(experiencesList));
        IntentHelper.goToExperience(this, bundle, false);
    }

    private void setOnClickListener() {
        binding.btnGoToExperience.setOnClickListener(view -> {
            goToExperiences(mLinkedinProfile.getExperiences());
        });

        binding.button1.setOnClickListener(v -> {
            // Example hiding second button
            binding.button2.setVisibility(binding.button2.getVisibility() == VISIBLE ? INVISIBLE : VISIBLE);
        });

        binding.llLinkedin.setOnClickListener(v -> {
            goToUrl(mLinkedinProfile.getLinkedin_url());
        });

        binding.btnGoToCertificates.setOnClickListener(v -> {
            IntentHelper.goToCertificates(this, null, false);
        });

        binding.llGithub.setOnClickListener(v -> {
            goToUrl(Constants.GITHUB_URL);
        });

        setListenerSwithTheme();
    }

    private void setListenerSwithTheme(){
        ViewThemeSwitchBinding themeSwitchBinding = ViewThemeSwitchBinding.bind(
                findViewById(R.id.themeSwitchContainer)
        );
        setupThemeSwitch(themeSwitchBinding.themeSwitch);
    }
}