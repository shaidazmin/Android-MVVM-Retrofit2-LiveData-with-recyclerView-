package com.example.mvvmretrofitlivedata.network;

import com.example.mvvmretrofitlivedata.model.MovieModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("/photos")
    Call<List<MovieModel>> getMovieList();


}
