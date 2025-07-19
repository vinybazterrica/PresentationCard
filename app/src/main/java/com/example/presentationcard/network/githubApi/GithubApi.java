package com.example.presentationcard.network.githubApi;

import com.example.presentationcard.models.entity.LinkedinProfileResponse;
import com.example.presentationcard.network.services.Service;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GithubApi {

    @GET(Service.GITHUB_JSON_DATA)
    Call<LinkedinProfileResponse> getGithubData();
}
