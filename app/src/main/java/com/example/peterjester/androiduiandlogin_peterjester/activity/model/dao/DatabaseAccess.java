package com.example.peterjester.androiduiandlogin_peterjester.activity.model.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author ezt157
 * A helper class to manage database creation and version management.
 * The DatabaseAccess should extend from SQLiteOpenHelper
 */
public class DatabaseAccess extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "users.db";


    public DatabaseAccess(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DatabaseAccess(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create the Movie table once the database is instantiated.
        // Create the User table once the database is instantiated.
        db.execSQL(UserTable.create());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // In case the database is a cache for online data, you can discard the existing data
        // once the app is gathering information from an external data source.
        db.execSQL(UserTable.delete());
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}



