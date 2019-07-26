package com.example.randomuserapp.sources;

import android.util.Log;

import com.example.randomuserapp.data.RandomUserData;
import com.example.randomuserapp.sources.APIService;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteDataSource {
    private APIService apiService;
    public RemoteDataSource() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://randomuser.me")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(APIService.class);
    }

    public RandomUserData getRandomUsersData(){
        String results = "20";
        String apiKey = "FK38-DONB-8M2R-WZO9";
        Call<RandomUserData> call = apiService.getDataFromServer(apiKey, results);
        Log.i("Remote", "take data from server");
        try {
            Response<RandomUserData> response = call.execute();
            if (response.isSuccessful()) {
                Log.i("Remote", "take data from server success");
                return response.body();

            }
        }
        catch (IOException ioex) {
            Log.e("Remote", "GetDataFromServerError");
        }
        return null;
    }
}
