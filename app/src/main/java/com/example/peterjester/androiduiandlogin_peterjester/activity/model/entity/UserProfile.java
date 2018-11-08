package com.example.peterjester.androiduiandlogin_peterjester.activity.model.entity;

public class UserProfile {

    // container class for name, surname, username, birthday, mobile phone, email and password.

    private String name;
    private String surname;
    private String username;
    private String birthday;
    private String phoneNumber;
    private String email;


    public UserProfile(String name, String surname, String username, String birthday, String phoneNumber, String email) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}
