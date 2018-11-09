package com.example.peterjester.androiduiandlogin_peterjester.activity.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.peterjester.androiduiandlogin_peterjester.R;
import com.example.peterjester.androiduiandlogin_peterjester.activity.model.entity.UserProfile;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {
    private ArrayList mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public View listView;
        public MyViewHolder(View v) {
            super(v);
            listView = v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public UserAdapter(ArrayList myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public UserAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_list_item, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        UserProfile user = (UserProfile) mDataset.get(position);

        TextView nameView = (TextView) holder.listView.findViewById(R.id.nameView);
        nameView.setText(user.getName());

        TextView surnameView = (TextView) holder.listView.findViewById(R.id.surnameView);
        surnameView.setText(user.getSurname());

        TextView usernameView = (TextView) holder.listView.findViewById(R.id.usernameView);
        usernameView.setText(user.getUsername());

        TextView  birthdayView = (TextView) holder.listView.findViewById(R.id.birthdayView);
        birthdayView.setText(user.getBirthday());

        TextView phoneView = (TextView) holder.listView.findViewById(R.id.phoneView);
        phoneView.setText(user.getPhoneNumber());

        TextView emailView = (TextView) holder.listView.findViewById(R.id.emailView);
        emailView.setText(user.getEmail());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}


// Old Array Adapter
//public class UserAdapter extends ArrayAdapter {
//
//    public UserAdapter(Context context, int resource, List objects) {
//        super(context, resource, objects);
//    }
//
//    @NonNull
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        View listItemView = convertView;
//
//        if(listItemView == null) {
//            listItemView = LayoutInflater.from(getContext()).inflate(
//                    R.layout.custom_list_item, parent, false);
//        }
//
//
//        UserProfile user = (UserProfile) getItem(position);
//
//        TextView nameView = (TextView) listItemView.findViewById(R.id.nameView);
//        nameView.setText(user.getName());
//
//        TextView surnameView = (TextView) listItemView.findViewById(R.id.surnameView);
//        surnameView.setText(user.getSurname());
//
//        TextView usernameView = (TextView) listItemView.findViewById(R.id.usernameView);
//        usernameView.setText(user.getUsername());
//
//        TextView  birthdayView = (TextView) listItemView.findViewById(R.id.birthdayView);
//        birthdayView.setText(user.getBirthday());
//
//        TextView phoneView = (TextView) listItemView.findViewById(R.id.phoneView);
//        phoneView.setText(user.getPhoneNumber());
//
//        TextView emailView = (TextView) listItemView.findViewById(R.id.emailView);
//        emailView.setText(user.getEmail());
//
//        return listItemView;
//
//    }
//}
