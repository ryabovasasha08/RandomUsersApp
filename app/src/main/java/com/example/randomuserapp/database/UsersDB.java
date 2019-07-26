package com.example.randomuserapp.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {UserEntity.class}, version = 1, exportSchema = false)
public abstract class UsersDB extends RoomDatabase {
    public abstract UsersDao usersDao();
}