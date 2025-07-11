package com.example.presentationcard.helper;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.widget.TextView;

public class StringHelper {

    public static String getVersionApp(Context context) {
        String versionName = "";
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            versionName = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionName;
    }


    public static void addDotsToMessaje(String message, TextView tv) {
        final Handler handler = new Handler();
        final String[] dots = {"", ".", "..", "...", "...."};
        final int[] index = {0};

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                tv.setText(message + dots[index[0]]);
                index[0] = (index[0] + 1) % dots.length;
                handler.postDelayed(this, 500);
            }
        }, 500);
    }
}
