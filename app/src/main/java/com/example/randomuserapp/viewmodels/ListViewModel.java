package com.example.randomuserapp.viewmodels;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.randomuserapp.database.UserEntity;
import com.example.randomuserapp.sources.Repository;

import java.util.List;

public class ListViewModel extends ViewModel {
    public ListViewModel() {}

    private Repository repository;
    private LiveData<List<UserEntity>> randomUsersData;

    public LiveData<List<UserEntity>> getRandomUsersData(Context context) {
        if (randomUsersData == null) {
            repository = new Repository(context);
            randomUsersData = repository.getRandomUserData();
        }
        return randomUsersData;
    }
}