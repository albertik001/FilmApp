package com.geektech.filmapi.ui.fragments.films.details;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.filmapi.data.models.Film;
import com.geektech.filmapi.databinding.ItemFilmsDetailBinding;

import java.util.ArrayList;
import java.util.List;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.DetailHolder> {
    private List<Film> list = new ArrayList<>();

    public void setList(List<Film> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DetailHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFilmsDetailBinding binding = ItemFilmsDetailBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new DetailHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    protected class DetailHolder extends RecyclerView.ViewHolder {
        private ItemFilmsDetailBinding binding;

        public DetailHolder(@NonNull ItemFilmsDetailBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Film film) {
            binding.tvDescription.setText(film.getDescription());
            binding.tvTitle.setText(film.getTitle());
            binding.director.setText(film.getDirector());
            binding.producer.setText(film.getProducer());
            binding.originalTitle.setText(film.getOriginalTitle());
            binding.releaseData.setText(film.getReleaseDate());
        }
    }
}
