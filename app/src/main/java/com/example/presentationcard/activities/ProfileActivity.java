package com.example.presentationcard.activities;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.presentationcard.R;
import com.example.presentationcard.databinding.ActivityProfileBinding;
import com.example.presentationcard.interfaces.LinkedinApi;
import com.example.presentationcard.models.entity.LinkedinProfile;
import com.example.presentationcard.models.entity.LinkedinProfileResponse;
import com.example.presentationcard.utils.Constants;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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

        if (savedInstanceState != null) {
            mLinkedinProfile = savedInstanceState.getParcelable(Constants.LINKEDIN_PROFILE);
        } else {
            getIntentData();
        }

        setProfileData();
        setOnClickListener();
    }

    private void getIntentData() {
        mLinkedinProfile = getIntent().getParcelableExtra(Constants.LINKEDIN_PROFILE);
    }

    private void setProfileData() {
        //Image Profile
        Picasso.get().load(mLinkedinProfile.getProfile_image_url()).into(binding.ivProfileImage);

        binding.tvUserName.setText(mLinkedinProfile.getFull_name());
        binding.tvUserHeadLine.setText(mLinkedinProfile.getHeadline());

        binding.txtLinkedinProfile.setText(mLinkedinProfile.getFull_name());
    }

    private void setOnClickListener() {
        binding.btnGoToEducation.setOnClickListener(view -> {
            Intent intent = new Intent(ProfileActivity.this, EducationActivity.class);
            intent.putExtra(Constants.EXTRA_STRING_KEY, "Hello from ProfileActivity!");
            startActivity(intent);
        });

        binding.button1.setOnClickListener(v -> {
            // Example hiding second button
            binding.button2.setVisibility(binding.button2.getVisibility() == VISIBLE ? INVISIBLE : VISIBLE);
        });

        binding.llLinkedin.setOnClickListener(v -> {
            goToUrl(mLinkedinProfile.getLinkedin_url());
        });
    }

    /**
     * Called when the activity is about to become visible.
     */
    @Override
    protected void onStart() {
        super.onStart();
    }

    /**
     * Called when the activity has become visible (it is now "resumed").
     */
    @Override
    protected void onResume() {
        super.onResume();
        // Restore button2 visibility
        /*Button button2 = findViewById(R.id.button2);
        button2.setVisibility(button2Visibility);*/
    }

    /**
     * Called when another activity is taking focus (this activity is about to be "paused").
     */
    @Override
    protected void onPause() {
        super.onPause();
        // Save button2 visibility
        /*Button button2 = findViewById(R.id.button2);
        button2Visibility = button2.getVisibility();*/
    }

    /**
     * Called when the activity is no longer visible (it is now "stopped").
     */
    @Override
    protected void onStop() {
        super.onStop();
    }

    /**
     * Called just before the activity is destroyed. Used to clean up resources.
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * Called after your activity has been stopped, prior to it being started again.
     */
    @Override
    protected void onRestart() {
        super.onRestart();
    }

    /**
     * Saves the state of the activity.
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save button2 visibility state
        outState.putParcelable(Constants.LINKEDIN_PROFILE, mLinkedinProfile);
    }
}