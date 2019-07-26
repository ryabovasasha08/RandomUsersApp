package com.example.randomuserapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;

import com.example.randomuserapp.R;
import com.example.randomuserapp.adapters.UsersListAdapter;
import com.example.randomuserapp.database.UserEntity;
import com.example.randomuserapp.viewmodels.ListViewModel;

import java.util.ArrayList;
import java.util.List;

public class UsersListActivity extends AppCompatActivity implements UsersListAdapter.OnThisUserListener, Observer<List<UserEntity>> {
    public RecyclerView recyclerView;
    public LiveData<List<UserEntity>> randomUserData;
    @Override
    public void onChanged(List<UserEntity> userEntities) {
        ((UsersListAdapter) recyclerView.getAdapter()).changeData(userEntities);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.random_users_list);
        ListViewModel listViewModel = ViewModelProviders.of(this).get(ListViewModel.class);
        randomUserData = listViewModel.getRandomUsersData(this);
        randomUserData.observe(this,this);
        getSupportActionBar().hide();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_list);
        UsersListAdapter usersListAdapter = new UsersListAdapter(new ArrayList<UserEntity>(),this);
        recyclerView.setAdapter(usersListAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onThisUserClick(int position) {
        Intent intent = new Intent(this, UsersItemActivity.class);
        intent.putExtra("thisuser", randomUserData.getValue().get(position));
        startActivity(intent);
    }
    @Override
    public void onStart() {
        super.onStart();
    }

}
