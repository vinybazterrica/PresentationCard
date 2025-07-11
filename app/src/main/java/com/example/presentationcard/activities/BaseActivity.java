package com.example.presentationcard.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.presentationcard.R;
import com.example.presentationcard.databinding.ActivitySplashBinding;
import com.example.presentationcard.helper.IntentHelper;
import com.example.presentationcard.helper.StorageHelper;
import com.example.presentationcard.helper.StringHelper;
import com.example.presentationcard.models.entity.LinkedinProfile;
import com.example.presentationcard.network.LinkedinCallBack;
import com.example.presentationcard.network.LinkedinManager;
import com.example.presentationcard.utils.Constants;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StorageHelper storage = StorageHelper.getInstance();
        storage.init(this);
    }


    /*GO TO*/
    public void goToUrl(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    public void goToProfile(LinkedinProfile profile) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constants.LINKEDIN_PROFILE, profile);
        IntentHelper.goToProfile(this, bundle);
    }

    /*MESSAGES*/
    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
