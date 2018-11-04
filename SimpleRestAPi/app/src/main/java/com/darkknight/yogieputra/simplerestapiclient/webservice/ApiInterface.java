package com.darkknight.yogieputra.simplerestapiclient.webservice;

import com.darkknight.yogieputra.simplerestapiclient.model.Movies;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("films")
    Call<List<Movies>> getMovies();
}
