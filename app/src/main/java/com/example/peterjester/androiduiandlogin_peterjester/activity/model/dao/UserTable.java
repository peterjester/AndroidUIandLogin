package com.example.peterjester.androiduiandlogin_peterjester.activity.model.dao;

/**
 * @author ezt157
 * A contract class is a container for constants that define names for URIs, tables, and columns.
 * The contract class allows you to use the same constants across all the other classes in the same
 * package. Therefore, you can change a column name in one place and have it propagate throughout
 * your code.
 */
public class UserTable {

    /** Defining the Table Content **/
    public static final String TABLE_NAME = "user";
    public static final String COLUMN_NAME_ID = "id";
    public static final String COLUMN_NAME_NAME = "name";
    public static final String COLUMN_NAME_SURNAME = "surname";
    public static final String COLUMN_NAME_USERNAME = "username";
    public static final String COLUMN_NAME_BIRTHDAY = "birthday";
    public static final String COLUMN_NAME_PHONENUMBER = "phoneNumber";
    public static final String COLUMN_NAME_EMAIL = "email";
    public static final String COLUMN_NAME_PASSWORD = "password";



    public static String create(){
        return new String ( "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_NAME_NAME + " TEXT," +
                COLUMN_NAME_SURNAME  + " TEXT," +
                COLUMN_NAME_USERNAME + " TEXT," +
                COLUMN_NAME_BIRTHDAY + " TEXT," +
                COLUMN_NAME_PHONENUMBER + " TEXT," +
                COLUMN_NAME_EMAIL + " TEXT," +
                COLUMN_NAME_PASSWORD + " TEXT)" );

    }

    public static String select(){
        return new String("SELECT * FROM " + TABLE_NAME);

    }

    public static final String delete(){
        return "DROP TABLE IF EXISTS " +TABLE_NAME;
    }
}




