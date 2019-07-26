package com.example.randomuserapp.sources;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.randomuserapp.data.RandomUserData;
import com.example.randomuserapp.database.UserEntity;
import com.example.randomuserapp.sources.LocalDataSource;
import com.example.randomuserapp.sources.RemoteDataSource;

import java.util.List;
import java.util.concurrent.Executors;

public class Repository {
    private RemoteDataSource remoteDataSource;
    private LocalDataSource localDataSource;

    public Repository(Context context) {
        localDataSource = new LocalDataSource(context);
        remoteDataSource = new RemoteDataSource();
    }

    public LiveData<List<UserEntity>> getRandomUserData() {
        Executors.newSingleThreadExecutor().execute(() -> {
            RandomUserData randomUserData = remoteDataSource.getRandomUsersData();
            localDataSource.storeUsers(randomUserData);
        });
        return localDataSource.getUsers();
    }
}
