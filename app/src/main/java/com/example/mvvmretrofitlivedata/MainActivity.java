package com.example.mvvmretrofitlivedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mvvmretrofitlivedata.adapter.MovieListAdapter;
import com.example.mvvmretrofitlivedata.model.MovieModel;
import com.example.mvvmretrofitlivedata.viewmodel.MovieListViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<MovieModel> modelList;
    private MovieListAdapter movieListAdapter;
    private MovieListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        movieListAdapter = new MovieListAdapter(this,modelList);
        recyclerView.setAdapter(movieListAdapter);


        viewModel = ViewModelProviders.of(this).get(MovieListViewModel.class);
        viewModel.getMovieListObserver().observe(this, new Observer<List<MovieModel>>() {
            @Override
            public void onChanged(List<MovieModel> movieModels) {
                if(movieModels != null){
                    modelList = movieModels;
                    movieListAdapter.setMovieList(movieModels);
                }
            }
        });

        viewModel.makeApiCall();


    }
}