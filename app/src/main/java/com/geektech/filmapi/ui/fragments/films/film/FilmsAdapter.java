package com.geektech.filmapi.ui.fragments.films.film;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.filmapi.data.models.Film;
import com.geektech.filmapi.databinding.ItemFilmsBinding;
import com.geektech.filmapi.ui.utils.Onclick;

import java.util.ArrayList;
import java.util.List;

public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.FilmsViewHolder> {
    private static Onclick onclick;
    private List<Film> films = new ArrayList<>();

    public void setOnclick(Onclick onclick) {
        FilmsAdapter.onclick = onclick;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FilmsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFilmsBinding binding = ItemFilmsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new FilmsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmsViewHolder holder, int position) {
        holder.bind(films.get(position));
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    protected static class FilmsViewHolder extends RecyclerView.ViewHolder {
        private final ItemFilmsBinding binding;

        public FilmsViewHolder(@NonNull ItemFilmsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Film film) {
            initListener(film);
            binding.tvDescription.setText(film.getDescription());
            binding.tvTitle.setText(film.getTitle());
            Log.e("TAG", "initListener: ");
        }

        private void initListener(Film film) {
            itemView.setOnClickListener(view -> onclick.onClick(film));
        }
    }
}
