package com.example.presentationcard.models.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

public class LinkedinProfile implements Parcelable {

    private List<LinkedinExperience> experiences;
    private String full_name;
    private String headline;
    private String linkedin_url;
    private String profile_id;
    private String profile_image_url;
    private String[] certificates;
    private String phone;
    private String email;
    private String github_url;

    // Constructor vacío
    public LinkedinProfile() {
    }

    // Constructor Parcelable
    protected LinkedinProfile(Parcel in) {
        experiences = in.readArrayList(LinkedinExperience.class.getClassLoader());
        full_name = in.readString();
        headline = in.readString();
        linkedin_url = in.readString();
        profile_id = in.readString();
        profile_image_url = in.readString();
        certificates = in.createStringArray();
        phone = in.readString();
        email = in.readString();
        github_url = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(experiences);
        dest.writeString(full_name);
        dest.writeString(headline);
        dest.writeString(linkedin_url);
        dest.writeString(profile_id);
        dest.writeString(profile_image_url);
        dest.writeStringArray(certificates);
        dest.writeString(phone);
        dest.writeString(email);
        dest.writeString(github_url);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<LinkedinProfile> CREATOR = new Creator<LinkedinProfile>() {
        @Override
        public LinkedinProfile createFromParcel(Parcel in) {
            return new LinkedinProfile(in);
        }

        @Override
        public LinkedinProfile[] newArray(int size) {
            return new LinkedinProfile[size];
        }
    };


    public List<LinkedinExperience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<LinkedinExperience> experiences) {
        this.experiences = experiences;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getLinkedin_url() {
        return linkedin_url;
    }

    public void setLinkedin_url(String linkedin_url) {
        this.linkedin_url = linkedin_url;
    }

    public String getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(String profile_id) {
        this.profile_id = profile_id;
    }

    public String getProfile_image_url() {
        return profile_image_url;
    }

    public void setProfile_image_url(String profile_image_url) {
        this.profile_image_url = profile_image_url;
    }

    public String[] getCertificates() {
        return certificates;
    }

    public void setCertificates(String[] certificates) {
        this.certificates = certificates;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGithub_url() {
        return github_url;
    }

    public void setGithub_url(String github_url) {
        this.github_url = github_url;
    }
}
