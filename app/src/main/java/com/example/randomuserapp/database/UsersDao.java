package com.example.randomuserapp.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.randomuserapp.data.Results;

import java.util.List;
@Dao
public interface UsersDao {
    @Insert
    public void insertUsers(List<UserEntity> userEntities);

    @Query("SELECT * FROM users")
    public LiveData<List<UserEntity>> getUsers();

    @Query("DELETE FROM users")
    public void delete();
}