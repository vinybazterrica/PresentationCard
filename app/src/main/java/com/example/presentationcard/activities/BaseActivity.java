package com.example.presentationcard.activities;

import android.content.Intent;
import android.net.Uri;

import androidx.appcompat.app.AppCompatActivity;

import com.example.presentationcard.models.entity.LinkedinProfile;

public class BaseActivity extends AppCompatActivity {


    public void goToUrl(String url){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

}
