package com.geektech.filmapi.ui.fragments.films.film;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.geektech.filmapi.ui.utils.Onclick;
import com.geektech.filmapi.ui.utils.app.App;
import com.geektech.filmapi.data.models.Film;
import com.geektech.filmapi.databinding.FragmentFilmsBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FilmsFragment extends Fragment implements Onclick {
    private FragmentFilmsBinding binding;
    private FilmsAdapter adapter;

    public FilmsFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new FilmsAdapter();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFilmsBinding.inflate(LayoutInflater.from(getContext()), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recyclerFilms.setAdapter(adapter);
        adapter.setOnclick(this);
        App.filmApi.getFilms().enqueue(new Callback<List<Film>>() {
            @Override
            public void onResponse(@NonNull Call<List<Film>> call, @NonNull Response<List<Film>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    adapter.setFilms(response.body());
                    Log.e("TAG", "onResponse: fuck you ");
                } else {
                    Log.e("TAG", "onFailure: fuck you ");
                }
            }
            @Override
            public void onFailure(@NonNull Call<List<Film>> call, Throwable t) {
                Log.e("TAG", "onFailure: fuck you ");
            }
        });
    }

    @Override
    public void onClick(Film film) {
        String id = film.getId();
        Navigation.findNavController(requireView()).navigate(FilmsFragmentDirections.actionFilmsFragmentToFilmDetailFragment(id));
    }
}