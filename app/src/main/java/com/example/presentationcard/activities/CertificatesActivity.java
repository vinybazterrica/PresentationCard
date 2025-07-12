package com.example.presentationcard.activities;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.presentationcard.R;
import com.example.presentationcard.adapter.CertificatesAdapter;
import com.example.presentationcard.adapter.ExperiencesAdapter;
import com.example.presentationcard.databinding.ActivityCertificatesBinding;
import com.example.presentationcard.helper.IntentHelper;
import com.example.presentationcard.helper.ResourcesHelper;
import com.example.presentationcard.utils.Constants;

public class CertificatesActivity extends AppCompatActivity {
    
    private ActivityCertificatesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCertificatesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        showCertificatesRecycler();
    }

    private void showCertificatesRecycler() {
        binding.rvCertificates.setHasFixedSize(true);
        binding.rvCertificates.setLayoutManager(new StaggeredGridLayoutManager(1, setOrientationRecycler()));
        binding.rvCertificates.setAdapter(new CertificatesAdapter(position -> {
            Bundle bundle = new Bundle();
            bundle.putString(Constants.FULL_SCREEN_IMAGE_URL , Constants.CERTIFICATES[position]);
            IntentHelper.goToFullImage(this, bundle, false);
        }));
    }

    private int setOrientationRecycler(){
        int orientation = 1;
        if (ResourcesHelper.isLandscape(this))
            orientation = 0;
        return orientation;
    }
}