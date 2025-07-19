package com.example.presentationcard.models.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class LinkedinExperience implements Parcelable {
    private String date_range;
    private String description;
    private String title;
    private String job_type;

    // Constructor vacío
    public LinkedinExperience() {}

    // Constructor Parcelable
    protected LinkedinExperience(Parcel in) {
        date_range = in.readString();
        description = in.readString();
        title = in.readString();
        job_type = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(date_range);
        dest.writeString(description);
        dest.writeString(title);
        dest.writeString(job_type);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<LinkedinExperience> CREATOR = new Creator<LinkedinExperience>() {
        @Override
        public LinkedinExperience createFromParcel(Parcel in) {
            return new LinkedinExperience(in);
        }

        @Override
        public LinkedinExperience[] newArray(int size) {
            return new LinkedinExperience[size];
        }
    };

    public String getDate_range() {
        return date_range;
    }

    public void setDate_range(String date_range) {
        this.date_range = date_range;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJob_type() {
        return job_type;
    }

    public void setJob_type(String job_type) {
        this.job_type = job_type;
    }
}
