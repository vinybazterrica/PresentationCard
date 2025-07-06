package com.example.presentationcard.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.presentationcard.R;
import com.example.presentationcard.utils.Constants;

public class EducationActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);

        // Get the string extra from the intent
        String receivedString = getIntent().getStringExtra(Constants.EXTRA_STRING_KEY);
    }
}

