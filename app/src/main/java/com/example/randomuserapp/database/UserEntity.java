package com.example.randomuserapp.database;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "users")
public class UserEntity implements Serializable {
    @PrimaryKey
    public int id;
    public String thumb;
    public String login;
    public String name;
    public String email;
    public String address;
    public String phone;
    public String age;
}
