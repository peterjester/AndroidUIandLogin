package com.example.peterjester.androiduiandlogin_peterjester.activity.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.peterjester.androiduiandlogin_peterjester.R;
import com.google.firebase.auth.FirebaseAuth;

public class LoginSuccessActivity extends AppCompatActivity {

    private Button viewAllUsersButton = null;

    private TextView nameView = null;

    // FirebaseAuth
    // The entry point of the Firebase Authentication SDK.
    // You need to obtain an instance of this class by calling getInstance()
    // https://firebase.google.com/docs/reference/android/com/google/firebase/auth/FirebaseAuth
    private FirebaseAuth mAuth = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);

        mAuth = FirebaseAuth.getInstance();
        nameView = findViewById(R.id.loginNameView);
        nameView.setText(mAuth.getCurrentUser().getEmail());

        viewAllUsersButton = findViewById(R.id.viewAllUsersButton);

        viewAllUsersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginSuccessActivity.this, ViewAllUsersActivity.class));
            }
        });
    }


}
