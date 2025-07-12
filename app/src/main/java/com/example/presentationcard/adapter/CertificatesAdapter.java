package com.example.presentationcard.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.presentationcard.databinding.ItemCertificatesBinding;
import com.example.presentationcard.databinding.ItemExperiencesLinkedinBinding;
import com.example.presentationcard.models.entity.LinkedinExperience;
import com.example.presentationcard.utils.Constants;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CertificatesAdapter extends RecyclerView.Adapter<CertificatesAdapter.CertificatesViewHolder> {

    private OnCertificateClickListener listener;

    public interface OnCertificateClickListener {
        void onCertificateClick(int position);
    }

    public CertificatesAdapter(OnCertificateClickListener listener) {
        this.listener = listener;
    }

    public class CertificatesViewHolder extends RecyclerView.ViewHolder {
        private ItemCertificatesBinding binding;

        public CertificatesViewHolder(ItemCertificatesBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            itemView.setOnClickListener(v -> {
                if (listener != null && getAdapterPosition() != RecyclerView.NO_POSITION) {
                    listener.onCertificateClick(getAdapterPosition());
                }
            });
        }
    }

    @NonNull
    @Override
    public CertificatesAdapter.CertificatesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCertificatesBinding binding = ItemCertificatesBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false
        );
        return new CertificatesAdapter.CertificatesViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CertificatesAdapter.CertificatesViewHolder holder, int position) {
        Picasso.get().load(Constants.CERTIFICATES[position]).into(holder.binding.ivCertificateImage);
    }

    @Override
    public int getItemCount() {
        return Constants.CERTIFICATES.length;
    }
}
