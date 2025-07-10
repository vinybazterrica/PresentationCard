package com.example.presentationcard.activities;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.presentationcard.R;
import com.example.presentationcard.adapter.ExperiencesAdapter;
import com.example.presentationcard.databinding.ActivityExperienceBinding;
import com.example.presentationcard.models.entity.LinkedinExperience;
import com.example.presentationcard.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class ExperienceActivity extends AppCompatActivity {

    private ActivityExperienceBinding binding;

    private List<LinkedinExperience> mLinkedinExperiences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExperienceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (savedInstanceState != null) {
            mLinkedinExperiences = savedInstanceState.getParcelableArrayList(Constants.LINKEDIN_EXPERIENCES_LIST);
        } else {
            getIntentData();
        }

        showExperiencesRecycler();
    }

    private void showExperiencesRecycler() {
        binding.rvExperiences.setHasFixedSize(true);
        binding.rvExperiences.setLayoutManager(new StaggeredGridLayoutManager(1, 1));
        binding.rvExperiences.setAdapter(new ExperiencesAdapter(mLinkedinExperiences, this));
    }

    private void getIntentData() {
        mLinkedinExperiences = getIntent().getParcelableArrayListExtra(Constants.LINKEDIN_EXPERIENCES_LIST);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save button2 visibility state
        outState.putParcelableArrayList(Constants.LINKEDIN_EXPERIENCES_LIST,
                new ArrayList<>(mLinkedinExperiences));    }
}