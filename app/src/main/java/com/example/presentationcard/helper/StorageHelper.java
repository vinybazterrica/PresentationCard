package com.example.presentationcard.helper;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.presentationcard.models.entity.LinkedinProfile;
import com.example.presentationcard.utils.Constants;
import com.google.gson.Gson;

public class StorageHelper {

    private SharedPreferences sharedPreferences;
    private static final String SHARED_PREFERENCES = "summary";
    private Context ctx;
    private final Gson gson = new Gson();
    private static StorageHelper instance;

    public static synchronized StorageHelper getInstance() {
        if (instance == null) {
            instance = new StorageHelper();
        }
        return instance;
    }

    public void init(Context ctx) {
        this.ctx = ctx;
        if (sharedPreferences == null) {
            sharedPreferences = ctx.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE);
        }
    }

    public void saveLinkedinProfile(LinkedinProfile profile) {
        String jsonProfile = gson.toJson(profile);
        sharedPreferences.edit()
                .putString(Constants.LINKEDIN_PROFILE_STORAGE, jsonProfile)
                .apply();
    }

    public LinkedinProfile getLinkedinProfile() {
        String jsonProfile = sharedPreferences.getString(Constants.LINKEDIN_PROFILE_STORAGE, "");
        if (jsonProfile.isEmpty()) {
            return null;
        }
        return gson.fromJson(jsonProfile, LinkedinProfile.class);
    }

    public long getLongPreferences(String key) {
        return sharedPreferences.getLong(key, 0);
    }

    public void putLongPreferences(String key, long value) {
        if (key != null && key.trim().length() > 0) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putLong(key, value);
            editor.commit();
        }
    }

    public static void saveLinkedinProfileStorage(Context context, LinkedinProfile profile) {
        StorageHelper.getInstance().init(context);
        StorageHelper.getInstance().saveLinkedinProfile(profile);
    }

    public static LinkedinProfile getLinkedinProfileStorage() {
        return StorageHelper.getInstance().getLinkedinProfile();
    }
}
