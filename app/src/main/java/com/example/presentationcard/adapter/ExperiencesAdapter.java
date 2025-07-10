package com.example.presentationcard.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.presentationcard.databinding.ItemExperiencesLinkedinBinding;
import com.example.presentationcard.models.entity.LinkedinExperience;

import java.util.List;

public class ExperiencesAdapter extends RecyclerView.Adapter<ExperiencesAdapter.ExperienceViewHolder> {

    private List<LinkedinExperience> mExperiencesList;
    private Activity mActivity;

    public ExperiencesAdapter(List<LinkedinExperience> experiences, Activity ctx) {
        this.mExperiencesList = experiences;
        this.mActivity = ctx;
    }

    public class ExperienceViewHolder extends RecyclerView.ViewHolder {
        private ItemExperiencesLinkedinBinding binding;

        public ExperienceViewHolder(ItemExperiencesLinkedinBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @NonNull
    @Override
    public ExperienceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemExperiencesLinkedinBinding binding = ItemExperiencesLinkedinBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false
        );
        return new ExperienceViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ExperienceViewHolder holder, int position) {
        LinkedinExperience experience = mExperiencesList.get(position);

        holder.binding.tvExperience.setText(experience.getTitle());
        holder.binding.tvPeriod.setText(experience.getDate_range());
        holder.binding.tvDescription.setText(experience.getDescription());

    }

    @Override
    public int getItemCount() {
        return mExperiencesList != null ? mExperiencesList.size() : 0;
    }
}
