package com.example.presentationcard.network.githubApi;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.example.presentationcard.R;
import com.example.presentationcard.activities.BaseActivity;
import com.example.presentationcard.models.entity.LinkedinProfile;
import com.example.presentationcard.models.entity.LinkedinProfileResponse;
import com.example.presentationcard.network.services.Service;
import com.example.presentationcard.utils.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GithubManager {

    public static void onGetGithubData(Context context, GithubCallBack callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Service.GITHUB_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GithubApi githubApi = retrofit.create(GithubApi.class);

        Call<LinkedinProfileResponse> call = githubApi.getGithubData();

        call.enqueue(new Callback<LinkedinProfileResponse>() {
            @Override
            public void onResponse(Call<LinkedinProfileResponse> call, Response<LinkedinProfileResponse> response) {
                if (response.isSuccessful() && response.body() != null){
                    LinkedinProfile profile = response.body().getData();
                    if (profile != null && profile.getProfile_id() != null) {
                        callBack.onSuccess(profile);
                    } else {
                        callBack.onError(context.getString(R.string.error_not_found));
                    }
                } else {
                    String msg = context.getString(R.string.error_data) + ": " + response.code();
                    Log.e("GithubManager", msg);
                    callBack.onError(msg);
                }
            }

            @Override
            public void onFailure(Call<LinkedinProfileResponse> call, Throwable t) {
                String msg = "Error de red: " + t.getMessage();
                Log.e("GithubManager", msg);
                callBack.onError(msg);
            }
        });
    }

    public static void getGithubData(Activity activity, GithubCallBack callBack){
        GithubManager.onGetGithubData(activity, new GithubCallBack() {

            @Override
            public void onSuccess(LinkedinProfile profile) {
                callBack.onSuccess(profile);
            }

            @Override
            public void onError(String errorMessage) {
                BaseActivity.showToast(activity, errorMessage);
                callBack.onError(errorMessage);
            }
        });
    }
}
