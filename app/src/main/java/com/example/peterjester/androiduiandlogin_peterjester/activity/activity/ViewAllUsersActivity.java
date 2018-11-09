package com.example.peterjester.androiduiandlogin_peterjester.activity.activity;

import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;

import com.example.peterjester.androiduiandlogin_peterjester.R;
import com.example.peterjester.androiduiandlogin_peterjester.activity.adapter.UserAdapter;
import com.example.peterjester.androiduiandlogin_peterjester.activity.model.dao.UserProfilePersistence;
import com.example.peterjester.androiduiandlogin_peterjester.activity.model.entity.UserProfile;

import java.util.ArrayList;

public class ViewAllUsersActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<UserProfile> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_users);

        mRecyclerView = (RecyclerView) findViewById(R.id.userListView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        UserProfilePersistence persistenceProfile = new UserProfilePersistence(this);
        users = persistenceProfile.getDataFromDB();
        mAdapter = new UserAdapter(users);
        mRecyclerView.setAdapter(mAdapter);


    }



}
