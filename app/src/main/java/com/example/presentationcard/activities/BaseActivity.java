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
import com.example.presentationcard.helper.IntentHelper;
import com.example.presentationcard.helper.StringHelper;
import com.example.presentationcard.models.entity.LinkedinProfile;
import com.example.presentationcard.network.LinkedinCallBack;
import com.example.presentationcard.network.LinkedinManager;
import com.example.presentationcard.utils.Constants;

public class BaseActivity extends AppCompatActivity {


    public void goToUrl(String url){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }


    /*Calls API*/
    public void getLinkedinUserData(Activity activity, LinkedinCallBack callback) {
        LinkedinManager.onGetLinkedinProfile(activity, new LinkedinCallBack() {
            @Override
            public void onSuccess(LinkedinProfile profile) {
                callback.onSuccess(profile);
            }

            @Override
            public void onError(String errorMessage) {
                Toast.makeText(activity, errorMessage, Toast.LENGTH_SHORT).show();
                callback.onError(errorMessage);
            }
        });
    }


    /*Internet*/
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        return false;
    }

}
