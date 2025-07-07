package com.example.presentationcard.network;

import com.example.presentationcard.models.entity.LinkedinProfile;

public interface LinkedinCallBack {
    void onSuccess(LinkedinProfile profile);
    void onError(String errorMessage);
}
