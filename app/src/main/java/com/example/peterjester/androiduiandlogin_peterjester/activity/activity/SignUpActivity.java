package com.example.peterjester.androiduiandlogin_peterjester.activity.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.peterjester.androiduiandlogin_peterjester.R;
import com.example.peterjester.androiduiandlogin_peterjester.activity.model.dao.UserProfilePersistence;
import com.example.peterjester.androiduiandlogin_peterjester.activity.model.entity.UserProfile;

public class SignUpActivity extends AppCompatActivity {

    // SQLite
    private UserProfilePersistence userProfilePersistence;

    private Button confirmButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_sign_up);

        confirmButton = findViewById(R.id.confirmButton);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Context context = getApplicationContext();

            CharSequence text = "User Successfully Created";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            startActivity(new Intent(SignUpActivity.this, MainActivity.class));

            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        userProfilePersistence = new UserProfilePersistence(this);
        insertData(); // insert sample data
    }

    private void insertData(){

        userProfilePersistence.insert(new UserProfile("Jack", "Mah",
                "jack90", "10-10-2018",
                "215-777-9191", "jack90@psu.edu"));

        userProfilePersistence.insert(new UserProfile("peter", "jester", "pjj5049",
                "12/30/1991", "215-764-9495",
                "pjj5049@psu.edu"));

    }


}
