package com.example.presentationcard.helper;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ResourcesHelper {

    /*INTERNET*/
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        return false;
    }

    /*Orientation*/
    public static boolean isLandscape(Activity activity) {
        int orientation = activity.getResources().getConfiguration().orientation;
        return orientation == android.content.res.Configuration.ORIENTATION_LANDSCAPE;
    }
}
