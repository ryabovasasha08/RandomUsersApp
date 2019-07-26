package com.example.randomuserapp.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.randomuserapp.R;
import com.example.randomuserapp.database.UserEntity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class UsersListAdapter  extends RecyclerView.Adapter<UsersListAdapter.UsersListHolder> {

    private List<UserEntity> randomUserData;
    private OnThisUserListener onThisUserListener;

    public UsersListAdapter(List<UserEntity> randomUserData, OnThisUserListener onThisUserListener) {
        this.randomUserData = randomUserData;
        this.onThisUserListener=onThisUserListener;
    }

    public void changeData(List<UserEntity> randomUserData) {
        this.randomUserData = randomUserData;
        notifyDataSetChanged();
    }

    class UsersListHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView name;
        private ImageView thumb;
        private TextView login;
        OnThisUserListener onThisUserListener;
        public UsersListHolder(View view, OnThisUserListener onThisUserListener) {
            super(view);
            name = view.findViewById(R.id.name);
            thumb = view.findViewById(R.id.thumb);
            login = view.findViewById(R.id.login);
            this.onThisUserListener = onThisUserListener;
            itemView.setOnClickListener(this);

        }

        public void setContent(UserEntity theRandomUserData) {
            Picasso.get().load(String.valueOf(theRandomUserData.thumb)).fit().into(thumb);
            name.setText(theRandomUserData.name);
            login.setText(theRandomUserData.login);
        }

        @Override
        public void onClick(View v) {
            onThisUserListener.onThisUserClick(getAdapterPosition());
        }
    }
    public interface OnThisUserListener{
        void onThisUserClick(int position);
    }


    @NonNull
    @Override
    public UsersListHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.random_users_list_item, viewGroup, false);
        return new UsersListHolder(view, onThisUserListener);
    }

    @Override
    public void onBindViewHolder(UsersListHolder usersListHolder, int i) {
        usersListHolder.setContent(randomUserData.get(i));
    }

    @Override
    public int getItemCount() {
        return randomUserData.size();
    }
}