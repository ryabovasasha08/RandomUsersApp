package com.example.randomuserapp.sources;

import com.example.randomuserapp.data.RandomUserData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {
    @GET("/api/")
    Call<RandomUserData> getDataFromServer(@Query("key")String key, @Query("results")String results);
}
