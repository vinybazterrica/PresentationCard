package com.example.presentationcard.helper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.presentationcard.activities.CertificatesActivity;
import com.example.presentationcard.activities.ExperienceActivity;
import com.example.presentationcard.activities.FullScreenImageActivity;
import com.example.presentationcard.activities.ProfileActivity;

public class IntentHelper {
    public static void goToProfile(Activity activity, Bundle bundle, boolean finish) {
        launchIntentAndFinish(activity, ProfileActivity.class, bundle, finish);
    }

    public static void goToExperience(Activity activity, Bundle bundle, boolean finish) {
        launchIntentAndFinish(activity, ExperienceActivity.class, bundle, finish);
    }

    public static void goToCertificates(Activity activity, Bundle bundle, boolean finish) {
        launchIntentAndFinish(activity, CertificatesActivity.class, bundle , finish);
    }

    public static void goToFullImage(Activity activity, Bundle bundle, boolean finish) {
        launchIntentAndFinish(activity, FullScreenImageActivity.class, bundle , finish);
    }

    private static void launchIntentAndFinish(Activity activity, Class<?> className, Bundle params, boolean finish) {
        Intent intent = new Intent(activity, className);
        if (params != null) {
            intent.putExtras(params);
        }
        activity.startActivity(intent);
        if (finish)
            activity.finish();
    }
}
