package com.example.peterjester.androiduiandlogin_peterjester.activity.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Movie;

import com.example.peterjester.androiduiandlogin_peterjester.activity.model.entity.UserProfile;

import java.util.ArrayList;

/**
 * @author ezt157
 * It is responsible for implementing the database operations for a given table.
 */
public class UserProfilePersistence implements IPersistence{

    public DatabaseAccess databaseAccess;

    public UserProfilePersistence(Context context){
        this.databaseAccess = new DatabaseAccess(context);
    }

    @Override
    public void insert(Object o) {

        // Cast the generic object to have access to the movie info.
        UserProfile user = (UserProfile) o;

        SQLiteDatabase sqLiteDatabase = databaseAccess.getWritableDatabase();

        // The ContentValues object create a map of values, where the columns are the keys
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserTable.COLUMN_NAME_NAME, user.getName());
        contentValues.put(UserTable.COLUMN_NAME_SURNAME, user.getSurname());
        contentValues.put(UserTable.COLUMN_NAME_USERNAME, user.getUsername());
        contentValues.put(UserTable.COLUMN_NAME_BIRTHDAY, user.getBirthday());
        contentValues.put(UserTable.COLUMN_NAME_PHONENUMBER, user.getPhoneNumber());
        contentValues.put(UserTable.COLUMN_NAME_EMAIL, user.getEmail());

        // Insert the ContentValues into the Movie table.
        sqLiteDatabase.insert(UserTable.TABLE_NAME, null, contentValues);

        sqLiteDatabase.close();
    }

    @Override
    public void delete(Object o) {

        UserProfile user = (UserProfile) o;

        // Define which column will be the parameter for deleting the record.
        String selection = UserTable.COLUMN_NAME_NAME + "LIKE ? ";

        // Arguments must be identidied in the placehold order
        String [] selectionArgs = { user.getName().trim() };

        // Get database instance
        SQLiteDatabase sqLiteDatabase = databaseAccess.getWritableDatabase();
        sqLiteDatabase.delete(UserTable.TABLE_NAME, selection, selectionArgs);
    }

    @Override
    public void edit(Object o) {
        // TODO for the students to practice
    }

    @Override
    public ArrayList getDataFromDB() {

        // Create ArrayList of movies
        ArrayList<Movie> movies = null;

        // Instatiate the database.
        SQLiteDatabase sqLiteDatabase = databaseAccess.getWritableDatabase();

        // Gather all the records found for the MOVIE table.
        Cursor cursor = sqLiteDatabase.rawQuery(UserTable.select(), null);

        // It will iterate since the first record gathered from the database.
        cursor.moveToFirst();

        // Check if there exist other records in the cursor
        movies = new ArrayList<>();

        if(cursor != null && cursor.moveToFirst()){

            do {
//                String title = cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_NAME_TITLE));
//                String category = cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_NAME_CATEGORY));
//                String rating = cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_NAME_RATING));
//                String year = cursor.getString(cursor.getColumnIndex(MovieTable.COLUMN_NAME_YEAR));

                // Convert to Movie object.
//                UserProfile user = new UserProfile( )
//                Movie movie = new Movie(title, category, rating, year);
//                movies.add(movie);

            } while (cursor.moveToNext()) ;
        }

        return movies;
    }
}
