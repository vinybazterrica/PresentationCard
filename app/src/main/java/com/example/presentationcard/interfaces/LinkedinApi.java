package com.example.presentationcard.interfaces;

import com.example.presentationcard.models.entity.LinkedinProfile;
import com.example.presentationcard.models.entity.LinkedinProfileResponse;
import com.example.presentationcard.utils.Constants;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface LinkedinApi {

    @GET(Constants.LINKEDIN_API_GET_PROFILE_PUBLIC_DATA)
    Call<LinkedinProfileResponse> getProfilePublicData(
            @Header("X-RapidAPI-Key") String apiKey,
            @Header("X-RapidAPI-Host") String apiHost,
            @Query("linkedin_url") String linkedinUrl,
            @Query("include_skills") boolean includeSkills,
            @Query("include_certifications") boolean includeCertifications,
            @Query("include_publications") boolean includePublications,
            @Query("include_honors") boolean includeHonors,
            @Query("include_volunteers") boolean includeVolunteers,
            @Query("include_projects") boolean includeProjects,
            @Query("include_patents") boolean includePatents,
            @Query("include_courses") boolean includeCourses,
            @Query("include_organizations") boolean includeOrganizations,
            @Query("include_profile_status") boolean includeProfileStatus
    );
}
