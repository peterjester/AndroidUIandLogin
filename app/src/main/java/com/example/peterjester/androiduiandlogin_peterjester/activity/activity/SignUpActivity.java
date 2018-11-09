package com.example.peterjester.androiduiandlogin_peterjester.activity.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.peterjester.androiduiandlogin_peterjester.R;
import com.example.peterjester.androiduiandlogin_peterjester.activity.model.dao.UserProfilePersistence;
import com.example.peterjester.androiduiandlogin_peterjester.activity.model.entity.UserProfile;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.example.peterjester.androiduiandlogin_peterjester.activity.model.entity.UserData;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    // SQLite
    private UserProfilePersistence userProfilePersistence;

    private Button confirmButton = null;

    private EditText fnameView = null;
    private EditText surnameView = null;
    private EditText usernameView = null;
    private EditText birthdayView = null;
    private EditText phoneView = null;
    private EditText emailView = null;
    private EditText passwordView = null;

    private String email = null;
    private String password = null;

    // FirebaseAuth
    // The entry point of the Firebase Authentication SDK.
    // You need to obtain an instance of this class by calling getInstance()
    // https://firebase.google.com/docs/reference/android/com/google/firebase/auth/FirebaseAuth
    private FirebaseAuth mAuth = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sign_up);

        // Recover the data from the other activity passed through the intent.
        UserData userData = (UserData) getIntent().getSerializableExtra("USER_DATA");

        confirmButton = findViewById(R.id.confirmButton);
        confirmButton.setOnClickListener(this);

        fnameView = findViewById(R.id.nameView);
        surnameView = findViewById(R.id.surnameView);
        usernameView = findViewById(R.id.usernameView);
        birthdayView = findViewById(R.id.birthdayView);
        phoneView = findViewById(R.id.phoneView);
        emailView = findViewById(R.id.emailView);
        passwordView = findViewById(R.id.passwordView);

        email = userData.getName();
        password = userData.getProvider(); // provider, but password in this instance

        emailView.setHint(email);
        passwordView.setHint(password);
    }

    @Override
    public void onClick(View v) {
        signUp();
    }


    @Override
    protected void onStart() {
        super.onStart();

        /*
         * The entry point of the Firebase Authentication SDK.
         * Obtain an instance of this class by calling getInstance()
         */
        mAuth = FirebaseAuth.getInstance();

        userProfilePersistence = new UserProfilePersistence(this);
//        insertData(); // insert sample data
    }

    private void signUp(){

        /*
         * The entry point of the Firebase Authentication SDK.
         * Obtain an instance of this class by calling getInstance()
         */

        final String email = emailView.getText().toString();
        final String password = passwordView.getText().toString();

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    // If sign in sucessfull, display a message to the user.
                    Log.d("USER_AUTH", "createUserWithEmailAndPassword.success");
                    // Get user information.
                    FirebaseUser user = mAuth.getCurrentUser();

                    String msg = "Someone: "+user.getEmail()+" , ID: "+user.getProviderId();
                    Toast.makeText(SignUpActivity.this, msg, Toast.LENGTH_SHORT).show();

                    String first = fnameView.getText().toString();
                    String last = surnameView.getText().toString();
                    String username = usernameView.getText().toString();
                    String phone = phoneView.getText().toString();
                    String birthday = birthdayView.getText().toString();

                    UserProfile userProfile = new UserProfile(first, last,
                            username, birthday, phone, email, password);

                    userProfilePersistence.insert(userProfile);

                    Intent intent = new Intent(SignUpActivity.this, LoginSuccessActivity.class);
                    startActivity(intent);

                }else{
                    // TODO
                    // If sign in fails, display a message to the user.
                    Log.w("TAG", "createUserWithEmailAndPassword:failure", task.getException());
                    Toast.makeText(SignUpActivity.this, "Authentication failed "+task.getException().getMessage() ,
                            Toast.LENGTH_SHORT).show();

                }
            }
        });

    }


    private void insertData(){

        userProfilePersistence.insert(new UserProfile("Jack", "Mah",
                "jack90", "10-10-2018",
                "215-777-9191", "jack90@psu.edu", "pass123"));

        userProfilePersistence.insert(new UserProfile("peter", "jester", "pjj5049",
                "12/30/1991", "215-764-9495",
                "pjj5049@psu.edu", "pass123"));
    }


}
