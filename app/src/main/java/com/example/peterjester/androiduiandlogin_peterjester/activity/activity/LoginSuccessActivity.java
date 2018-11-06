package com.example.peterjester.androiduiandlogin_peterjester.activity.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.peterjester.androiduiandlogin_peterjester.R;

public class LoginSuccessActivity extends AppCompatActivity {

    private Button viewAllUsersButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);

        viewAllUsersButton = findViewById(R.id.viewAllUsersButton);

        viewAllUsersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginSuccessActivity.this, ViewAllUsersActivity.class));
            }
        });
    }


}
