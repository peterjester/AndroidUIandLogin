package com.example.peterjester.androiduiandlogin_peterjester.activity.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.*;

import com.example.peterjester.androiduiandlogin_peterjester.activity.model.entity.UserData;


import com.example.peterjester.androiduiandlogin_peterjester.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView userNameView = null;
    private TextView passwordView = null;

    private Button signUpButton = null;
    private Button loginButton = null;

    // FirebaseAuth
    // The entry point of the Firebase Authentication SDK.
    // You need to obtain an instance of this class by calling getInstance()
    // https://firebase.google.com/docs/reference/android/com/google/firebase/auth/FirebaseAuth
    private FirebaseAuth mAuth = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        allocateButtonsAndViews();

        setupListeners();

    }

    @Override
    protected void onStart() {
        super.onStart();
        /*
         * The entry point of the Firebase Authentication SDK.
         * Obtain an instance of this class by calling getInstance()
         */
        mAuth = FirebaseAuth.getInstance();
    }

    private void setupListeners(){
        signUpButton.setOnClickListener(this);
        loginButton.setOnClickListener(this);
    }

    private void allocateButtonsAndViews(){
        userNameView = findViewById(R.id.userTextView);
        passwordView = findViewById(R.id.passwordView);

        signUpButton = findViewById(R.id.signupButton);
        loginButton = findViewById(R.id.loginButton);
    }

    @Override
    public void onClick(View v) {

        String email = userNameView.getText().toString();
        String password = passwordView.getText().toString();

        switch (v.getId()){
            case R.id.loginButton: signIn(email, password); break;
            case R.id.signupButton: signUp(email, password); break;
        }
    }

    private void signIn(String email, String password){

        mAuth = FirebaseAuth.getInstance();

        // Tries to sign in a user with the given email address and password.
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // If sign is sucessful, update UI with the signed-in user's information
                            Log.d("TAG", "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();

                            // Accessing the user information
                            // Creating a Toast to update the UI
                            String msg = "User: "+user.getEmail()+" , ID: "+user.getProviderId();
                            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();

                            // Pass the user info as paramater to the next activity.
                            Intent intent = new Intent(MainActivity.this, LoginSuccessActivity.class);
                            intent.putExtra("USER_DATA", new UserData(user.getEmail(), user.getProviderId()));
                            startActivity(intent);

                        } else {
                            // TODO Implemnt the validation in case password or user is wrong.
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "signInWithEmail:failure", task.getException());
                            String msgFailed = "Authentication failed: "+task.getException().getMessage();
                            Toast.makeText(MainActivity.this,msgFailed,
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void signUp(String email, String password){

        // Pass the user info as paramater to the next activity.
        Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
        intent.putExtra("USER_DATA", new UserData(email, password));
        startActivity(intent);
    }
}
