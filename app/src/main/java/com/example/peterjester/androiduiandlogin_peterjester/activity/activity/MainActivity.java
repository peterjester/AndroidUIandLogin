package com.example.peterjester.androiduiandlogin_peterjester.activity.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import com.example.peterjester.androiduiandlogin_peterjester.R;

public class MainActivity extends AppCompatActivity {

    private TextView userNameView = null;
    private TextView passwordView = null;

    private Button signUpButton = null;
    private Button loginButton = null;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        allocateButtonsAndViews();

        setupListeners();

    }

    private void setupListeners(){
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SignUpActivity.class));
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginSuccessActivity.class));
            }
        });

    }

    private void allocateButtonsAndViews(){
        userNameView = findViewById(R.id.userTextView);
        passwordView = findViewById(R.id.passwordView);

        signUpButton = findViewById(R.id.signupButton);
        loginButton = findViewById(R.id.loginButton);
    }
}
