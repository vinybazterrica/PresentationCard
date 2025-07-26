package com.example.presentationcard.activities;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

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
    private Handler autoScrollHandler = new Handler(Looper.getMainLooper());
    private Runnable autoScrollRunnable;
    private static final int AUTO_SCROLL_DELAY = 5000; // 5 segundos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAboutBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        items = new ArrayList<>(Arrays.asList(AboutList.getAboutItems(this)));

        setupViewPager();
        setupFab();
        startAutoScroll();
    }

    private void setupViewPager() {
        AboutAdapter adapter = new AboutAdapter(items);
        binding.vpAbout.setAdapter(adapter);
    }

    private void advanceViewPager() {
        int currentItem = binding.vpAbout.getCurrentItem();
        int nextItem = (currentItem + 1) % items.size();
        binding.vpAbout.setCurrentItem(nextItem, true);
    }

    private void startAutoScroll() {
        autoScrollRunnable = new Runnable() {
            @Override
            public void run() {
                advanceViewPager();
                autoScrollHandler.postDelayed(this, AUTO_SCROLL_DELAY);
            }
        };
        autoScrollHandler.postDelayed(autoScrollRunnable, AUTO_SCROLL_DELAY);
    }

    private void setupFab() {
        binding.fabNext.setOnClickListener(view -> {
            advanceViewPager();
        });
    }
}