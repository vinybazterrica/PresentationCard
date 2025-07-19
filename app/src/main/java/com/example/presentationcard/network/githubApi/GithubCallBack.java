package com.example.presentationcard.network.githubApi;

import com.example.presentationcard.models.entity.LinkedinProfile;

public interface GithubCallBack {
    void onSuccess(LinkedinProfile profile);
    void onError(String errorMessage);
}
