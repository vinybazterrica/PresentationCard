package com.example.presentationcard.models.entity;

public class SlideItem {
    public int imageResId;
    public String description;

    public SlideItem(int imageResId, String title) {
        this.imageResId = imageResId;
        this.description = title;
    }
}
