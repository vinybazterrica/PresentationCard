package com.example.presentationcard.activities;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.presentationcard.R;
import com.example.presentationcard.adapter.AboutAdapter;
import com.example.presentationcard.databinding.ActivityAboutBinding;
import com.example.presentationcard.models.entity.SlideItem;
import com.example.presentationcard.utils.AboutList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AboutActivity extends AppCompatActivity {

    private ActivityAboutBinding binding;
    private List<SlideItem> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAboutBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        items = new ArrayList<>(Arrays.asList(AboutList.getAboutItems(this)));

        setupViewPager();
        setupFab();
    }

    private void setupViewPager() {
        AboutAdapter adapter = new AboutAdapter(items);
        binding.vpAbout.setAdapter(adapter);
    }

    private void setupFab() {
        binding.fabNext.setOnClickListener(view -> {
            int currentItem = binding.vpAbout.getCurrentItem();
            if (currentItem < items.size() - 1) {
                binding.vpAbout.setCurrentItem(currentItem + 1, true);
            } else {
                binding.vpAbout.setCurrentItem(0, true); // reinicia
            }
        });
    }
}