package com.example.presentationcard.models.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class LinkedinExperience implements Parcelable {
    private String company;
    private String company_id;
    private String company_linkedin_url;
    private String company_logo_url;
    private String date_range;
    private String description;
    private String duration;
    private String end_month;
    private String end_year;
    private boolean is_current;
    private String job_type;
    private String location;
    private String skills;
    private int start_month;
    private int start_year;
    private String title;

    // Constructor vacío
    public LinkedinExperience() {}

    // Constructor Parcelable
    protected LinkedinExperience(Parcel in) {
        company = in.readString();
        company_id = in.readString();
        company_linkedin_url = in.readString();
        company_logo_url = in.readString();
        date_range = in.readString();
        description = in.readString();
        duration = in.readString();
        end_month = in.readString();
        end_year = in.readString();
        is_current = in.readByte() != 0;
        job_type = in.readString();
        location = in.readString();
        skills = in.readString();
        start_month = in.readInt();
        start_year = in.readInt();
        title = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(company);
        dest.writeString(company_id);
        dest.writeString(company_linkedin_url);
        dest.writeString(company_logo_url);
        dest.writeString(date_range);
        dest.writeString(description);
        dest.writeString(duration);
        dest.writeString(end_month);
        dest.writeString(end_year);
        dest.writeByte((byte) (is_current ? 1 : 0));
        dest.writeString(job_type);
        dest.writeString(location);
        dest.writeString(skills);
        dest.writeInt(start_month);
        dest.writeInt(start_year);
        dest.writeString(title);
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public String getCompany_linkedin_url() {
        return company_linkedin_url;
    }

    public void setCompany_linkedin_url(String company_linkedin_url) {
        this.company_linkedin_url = company_linkedin_url;
    }

    public String getCompany_logo_url() {
        return company_logo_url;
    }

    public void setCompany_logo_url(String company_logo_url) {
        this.company_logo_url = company_logo_url;
    }

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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getEnd_month() {
        return end_month;
    }

    public void setEnd_month(String end_month) {
        this.end_month = end_month;
    }

    public String getEnd_year() {
        return end_year;
    }

    public void setEnd_year(String end_year) {
        this.end_year = end_year;
    }

    public boolean isIs_current() {
        return is_current;
    }

    public void setIs_current(boolean is_current) {
        this.is_current = is_current;
    }

    public String getJob_type() {
        return job_type;
    }

    public void setJob_type(String job_type) {
        this.job_type = job_type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public int getStart_month() {
        return start_month;
    }

    public void setStart_month(int start_month) {
        this.start_month = start_month;
    }

    public int getStart_year() {
        return start_year;
    }

    public void setStart_year(int start_year) {
        this.start_year = start_year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
