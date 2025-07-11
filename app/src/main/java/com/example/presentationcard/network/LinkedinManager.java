package com.example.presentationcard.network;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.example.presentationcard.activities.BaseActivity;
import com.example.presentationcard.models.entity.LinkedinProfile;
import com.example.presentationcard.models.entity.LinkedinProfileResponse;
import com.example.presentationcard.utils.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LinkedinManager {

    public static void onGetLinkedinProfile(Context context, LinkedinCallBack callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.LINKEDIN_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LinkedinApi linkedinApi = retrofit.create(LinkedinApi.class);

        Call<LinkedinProfileResponse> call = linkedinApi.getProfilePublicData(
                Constants.LINKEDIN_API_KEY,
                Constants.LINKEDIN_API_HOST,
                Constants.LINKEDIN_VINY_PROFILE_URL,
                false, false, false,
                false, false, false,
                false, false, false, false
        );

        call.enqueue(new Callback<LinkedinProfileResponse>() {
            @Override
            public void onResponse(Call<LinkedinProfileResponse> call, Response<LinkedinProfileResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    LinkedinProfile profile = response.body().getData();
                    if (profile != null && profile.getProfile_id() != null) {
                        callback.onSuccess(profile);
                    } else {
                        callback.onError(Constants.LINKEDIN_NO_DATA);
                    }
                } else {
                    String msg = Constants.LINKEDIN_ERROR + ": " + response.code();
                    Log.e("LinkedinManager", msg);
                    callback.onError(msg);
                }
            }

            @Override
            public void onFailure(Call<LinkedinProfileResponse> call, Throwable t) {
                String msg = "Error de red: " + t.getMessage();
                Log.e("LinkedinManager", msg);
                callback.onError(msg);
            }
        });
    }

    public static void getLinkedinUserData(Activity activity, LinkedinCallBack callback) {
        LinkedinManager.onGetLinkedinProfile(activity, new LinkedinCallBack() {
            @Override
            public void onSuccess(LinkedinProfile profile) {
                callback.onSuccess(profile);
            }

            @Override
            public void onError(String errorMessage) {
                BaseActivity.showToast(activity, errorMessage);
                callback.onError(errorMessage);
            }
        });
    }
}
