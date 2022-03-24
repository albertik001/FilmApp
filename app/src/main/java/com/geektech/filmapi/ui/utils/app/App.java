package com.geektech.filmapi.ui.utils.app;

import android.app.Application;

import com.geektech.filmapi.data.remote.FilmApi;
import com.geektech.filmapi.data.remote.RetrofitClint;

public class App extends Application {
    private RetrofitClint retrofitClint;
    public static FilmApi filmApi;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofitClint = new RetrofitClint();
        filmApi = retrofitClint.createFilmAPi();
    }
}
