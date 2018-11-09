package com.example.peterjester.androiduiandlogin_peterjester.activity.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.peterjester.androiduiandlogin_peterjester.R;
import com.example.peterjester.androiduiandlogin_peterjester.activity.model.entity.UserProfile;

import java.util.List;

public class UserAdapter extends ArrayAdapter {

    public UserAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.custom_list_item, parent, false);
        }


        UserProfile user = (UserProfile) getItem(position);

        TextView nameView = (TextView) listItemView.findViewById(R.id.nameView);
        nameView.setText(user.getName());

        TextView surnameView = (TextView) listItemView.findViewById(R.id.surnameView);
        surnameView.setText(user.getSurname());

        TextView usernameView = (TextView) listItemView.findViewById(R.id.usernameView);
        usernameView.setText(user.getUsername());

        TextView  birthdayView = (TextView) listItemView.findViewById(R.id.birthdayView);
        birthdayView.setText(user.getBirthday());

        TextView phoneView = (TextView) listItemView.findViewById(R.id.phoneView);
        phoneView.setText(user.getPhoneNumber());

        TextView emailView = (TextView) listItemView.findViewById(R.id.emailView);
        emailView.setText(user.getEmail());

        return listItemView;

    }
}
