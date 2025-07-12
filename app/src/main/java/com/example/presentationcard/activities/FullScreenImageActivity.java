package com.example.presentationcard.activities;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.presentationcard.R;
import com.example.presentationcard.databinding.ActivityFullScreenImageBinding;
import com.example.presentationcard.utils.Constants;
import com.squareup.picasso.Picasso;

public class FullScreenImageActivity extends AppCompatActivity {

    private ActivityFullScreenImageBinding binding;
    private String imageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFullScreenImageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        imageUrl = getIntent().getStringExtra(Constants.FULL_SCREEN_IMAGE_URL);

        showFullScreenImage(imageUrl);
    }

    private void showFullScreenImage(String imageUrl) {
        Picasso.get().load(imageUrl).into(binding.pvImage);
    }
}