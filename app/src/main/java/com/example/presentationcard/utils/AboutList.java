package com.example.presentationcard.utils;

import android.content.Context;

import com.example.presentationcard.R;
import com.example.presentationcard.models.entity.SlideItem;

public class AboutList {
    public static SlideItem[] getAboutItems(Context context) {
        return new SlideItem[] {
                new SlideItem(R.drawable.ic_github, context.getString(R.string.about_01)),
                new SlideItem(R.drawable.ic_storage, context.getString(R.string.about_02)),
                new SlideItem(R.drawable.firebase_logo, context.getString(R.string.about_03))
        };
    }
}
