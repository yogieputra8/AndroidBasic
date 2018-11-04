package com.darkknight.yogieputra.simplerestapiclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.darkknight.yogieputra.simplerestapiclient.adapter.MovieAdapter;
import com.darkknight.yogieputra.simplerestapiclient.model.Movies;
import com.darkknight.yogieputra.simplerestapiclient.webservice.ApiInterface;
import com.darkknight.yogieputra.simplerestapiclient.webservice.ServiceGenerator;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private List<Movies> movies = new ArrayList<>();
    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        recyclerView = findViewById(R.id.rv_movie_list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        
        movieAdapter = new MovieAdapter(this, movies);
        recyclerView.setAdapter(movieAdapter);
        
        getMovies();
    }

    private void getMovies() {
        ApiInterface apiInterface = ServiceGenerator.createService(ApiInterface.class);
        Call<List<Movies>> call = apiInterface.getMovies();

        call.enqueue(new Callback<List<Movies>>() {
            @Override
            public void onResponse(Call<List<Movies>> call, Response<List<Movies>> response) {
                if (response.isSuccessful()){
                    for (Movies movies1 : response.body()){
                        movies.add(movies1);
                    }
                    movieAdapter.notifyDataSetChanged();
                } else {
                    Log.e(TAG, response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Movies>> call, Throwable t) {
                Log.e(TAG, t.getMessage());
            }
        });
    }
}
