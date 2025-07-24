package com.example.presentationcard.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.presentationcard.R;
import com.example.presentationcard.models.entity.SlideItem;

import java.util.List;

public class AboutAdapter extends RecyclerView.Adapter<AboutAdapter.SlideViewHolder> {

    List<SlideItem> slideItems;

    public AboutAdapter(List<SlideItem> items) {
        this.slideItems = items;
    }

    @NonNull
    @Override
    public SlideViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_about, parent, false);
        return new SlideViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SlideViewHolder holder, int position) {
        SlideItem item = slideItems.get(position);
        holder.imageView.setImageResource(item.imageResId);
        holder.description.setText(item.description);
    }

    @Override
    public int getItemCount() {
        return slideItems.size();
    }

    class SlideViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView description;

        SlideViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.imageView);
            description = view.findViewById(R.id.description);
        }
    }
}
