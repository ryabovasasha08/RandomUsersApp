package com.example.randomuserapp.sources;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import com.example.randomuserapp.data.RandomUserData;
import com.example.randomuserapp.data.Results;
import com.example.randomuserapp.database.UserEntity;
import com.example.randomuserapp.database.UsersDB;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LocalDataSource {
    final UsersDB db;

    public LocalDataSource(Context context) {
        db = Room.databaseBuilder(context, UsersDB.class, "table").build();
    }



    public String toUpper(String string){
        String[] words = string.split(" ");
        String resultString="";
        for (String word:words){
            String firstLetter = String.valueOf(word.charAt(0));
            firstLetter = firstLetter.toUpperCase();
            String resultWord = firstLetter.concat(word.substring(1));
            resultString = resultString.concat(resultWord+" ");
        }
        return resultString;
    }

    public void storeUsers(RandomUserData randomUserData) {
        if (randomUserData != null) {
            db.usersDao().delete();
            int ID = 1;
            List<UserEntity> userEntities = new ArrayList<>();
            for (Results results : randomUserData.getResults()) {
                UserEntity userEntity = new UserEntity();
                userEntity.login = "@".concat(results.getLogin().getUsername());
                userEntity.id = ID;
                userEntity.thumb = results.getPicture().getLarge();
                userEntity.name = toUpper(results.getName().getFirst()+" "+results.getName().getLast());
                userEntity.email=results.getEmail();
                userEntity.age=String.valueOf(results.getDob().getAge())+" y.o.";
                userEntity.address = toUpper(results.getLocation().getCity()+", "+results.getLocation().getState());
                userEntity.phone = String.valueOf(results.getPhone());
                userEntities.add(userEntity);
                ID++;
            }
            db.usersDao().insertUsers(userEntities);
            Log.i("Local", "storing data success");
        }
    }

    public LiveData<List<UserEntity>> getUsers() {
        LiveData<List<UserEntity>> usersList = db.usersDao().getUsers();
        Log.i("Local", "getUsers from db success");
        return usersList;

    }

}
