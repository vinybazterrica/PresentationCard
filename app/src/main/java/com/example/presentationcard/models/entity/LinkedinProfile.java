package com.example.presentationcard.models.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

public class LinkedinProfile implements Parcelable {

    private String city;
    private String company;
    private String country;
    private int current_company_join_month;
    private int current_company_join_year;
    private String current_job_duration;
    private List<LinkedinExperience> experiences;
    private String first_name;
    private int follower_count;
    private String full_name;
    private String headline;
    private boolean is_verified;
    private String job_title;
    private String last_name;
    private String linkedin_url;
    private String location;
    private String phone;
    private String profile_id;
    private String profile_image_url;
    private String public_id;
    private String state;
    private String urn;

    // Constructor vacío
    public LinkedinProfile() {}

    // Constructor Parcelable
    protected LinkedinProfile(Parcel in) {
        city = in.readString();
        company = in.readString();
        country = in.readString();
        current_company_join_month = in.readInt();
        current_company_join_year = in.readInt();
        current_job_duration = in.readString();
        experiences = in.readArrayList(LinkedinExperience.class.getClassLoader());
        first_name = in.readString();
        follower_count = in.readInt();
        full_name = in.readString();
        headline = in.readString();
        is_verified = in.readByte() != 0;
        job_title = in.readString();
        last_name = in.readString();
        linkedin_url = in.readString();
        location = in.readString();
        phone = in.readString();
        profile_id = in.readString();
        profile_image_url = in.readString();
        public_id = in.readString();
        state = in.readString();
        urn = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(city);
        dest.writeString(company);
        dest.writeString(country);
        dest.writeInt(current_company_join_month);
        dest.writeInt(current_company_join_year);
        dest.writeString(current_job_duration);
        dest.writeList(experiences);
        dest.writeString(first_name);
        dest.writeInt(follower_count);
        dest.writeString(full_name);
        dest.writeString(headline);
        dest.writeByte((byte) (is_verified ? 1 : 0));
        dest.writeString(job_title);
        dest.writeString(last_name);
        dest.writeString(linkedin_url);
        dest.writeString(location);
        dest.writeString(phone);
        dest.writeString(profile_id);
        dest.writeString(profile_image_url);
        dest.writeString(public_id);
        dest.writeString(state);
        dest.writeString(urn);
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


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getCurrent_company_join_month() {
        return current_company_join_month;
    }

    public void setCurrent_company_join_month(int current_company_join_month) {
        this.current_company_join_month = current_company_join_month;
    }

    public int getCurrent_company_join_year() {
        return current_company_join_year;
    }

    public void setCurrent_company_join_year(int current_company_join_year) {
        this.current_company_join_year = current_company_join_year;
    }

    public String getCurrent_job_duration() {
        return current_job_duration;
    }

    public void setCurrent_job_duration(String current_job_duration) {
        this.current_job_duration = current_job_duration;
    }

    public List<LinkedinExperience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<LinkedinExperience> experiences) {
        this.experiences = experiences;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public int getFollower_count() {
        return follower_count;
    }

    public void setFollower_count(int follower_count) {
        this.follower_count = follower_count;
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

    public boolean isIs_verified() {
        return is_verified;
    }

    public void setIs_verified(boolean is_verified) {
        this.is_verified = is_verified;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getLinkedin_url() {
        return linkedin_url;
    }

    public void setLinkedin_url(String linkedin_url) {
        this.linkedin_url = linkedin_url;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getPublic_id() {
        return public_id;
    }

    public void setPublic_id(String public_id) {
        this.public_id = public_id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUrn() {
        return urn;
    }

    public void setUrn(String urn) {
        this.urn = urn;
    }
}
