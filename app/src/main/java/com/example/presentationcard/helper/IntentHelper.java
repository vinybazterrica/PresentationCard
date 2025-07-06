package com.example.presentationcard.helper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.presentationcard.activities.ProfileActivity;

public class IntentHelper {
    public static void goToProfile(Activity activity, Bundle bundle) {
        launchIntentAndFinish(activity, ProfileActivity.class, bundle);
    }

    private static void launchIntentAndFinish(Activity activity, Class<?> className, Bundle params) {
        Intent intent = new Intent(activity, className);
        if (params != null) {
            intent.putExtras(params);
        }
        activity.startActivity(intent);
        activity.finish();
    }
}
