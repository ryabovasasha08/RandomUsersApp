package com.example.randomuserapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.randomuserapp.R;
import com.example.randomuserapp.database.UserEntity;
import com.squareup.picasso.Picasso;

public class UsersItemActivity extends AppCompatActivity {
    public ImageView thumb;
    public TextView name;
    public TextView email;
    public TextView phone;
    public TextView address;
    public TextView age;
    public TextView login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        Intent intent = getIntent();
        setContentView(R.layout.user_full_description);
        UserEntity thisUser = (UserEntity) intent.getSerializableExtra("thisuser");
        thumb = findViewById(R.id.thumb);
        name = findViewById(R.id.name);
        login = findViewById(R.id.login);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        address = findViewById(R.id.address);
        age = findViewById(R.id.age);
        Picasso.get().load(String.valueOf(thisUser.thumb)).fit().into(thumb);
        name.setText(thisUser.name);
        login.setText(thisUser.login);
        email.setText(thisUser.email);
        age.setText(thisUser.age);
        address.setText(thisUser.address);
        phone.setText(thisUser.phone);

    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
