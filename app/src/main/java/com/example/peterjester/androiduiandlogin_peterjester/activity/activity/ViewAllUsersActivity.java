package com.example.peterjester.androiduiandlogin_peterjester.activity.activity;

import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.peterjester.androiduiandlogin_peterjester.R;
import com.example.peterjester.androiduiandlogin_peterjester.activity.adapter.UserAdapter;
import com.example.peterjester.androiduiandlogin_peterjester.activity.model.dao.UserProfilePersistence;
import com.example.peterjester.androiduiandlogin_peterjester.activity.model.entity.UserProfile;

import java.util.ArrayList;

public class ViewAllUsersActivity extends AppCompatActivity {

    private ListView userListView;
    private UserAdapter userAdapter;
    private ArrayList<UserProfile> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_users);

        userListView = (ListView) findViewById(R.id.userListView);
        //movies = loadMovies();

        UserProfilePersistence persistenceProfile = new UserProfilePersistence(this);
        users = persistenceProfile.getDataFromDB();

        userAdapter = new UserAdapter(this,
                R.layout.custom_list_item,
                users);

        userListView.setAdapter(userAdapter);

    }



}
