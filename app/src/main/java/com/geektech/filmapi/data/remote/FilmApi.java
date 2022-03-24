package com.geektech.filmapi.data.remote;

import com.geektech.filmapi.data.models.Film;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;

public  interface FilmApi {

    @GET("/films")
    Call<List<Film>> getFilms();

    @GET("/films/{id}")
    Call<Film>
    getFilmDetail(@Path("id") String id);


}
