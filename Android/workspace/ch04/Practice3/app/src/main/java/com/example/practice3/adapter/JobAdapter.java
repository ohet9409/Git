package com.example.practice3.adapter;

import android.app.Activity;
import android.content.Context;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.practice3.R;
import com.example.practice3.model.Job;

import java.util.List;

public class JobAdapter extends ArrayAdapter {
    Activity activity;
    int resources;
    public JobAdapter( Context context, int resource,  List objects) {
        super(context, resource, objects);
        activity = (Activity) context;
        this.resources = resource;
    }


    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null){
            itemView = activity.getLayoutInflater().inflate(resources,null);
        }
        Job item = (Job) getItem(position);

        if (itemView != null){
            ImageView imageView = itemView.findViewById(R.id.imageView2);
            TextView textView1 = itemView.findViewById(R.id.textView1);
            TextView textView2 = itemView.findViewById(R.id.textView2);

            imageView.setImageResource(item.getImage());
            textView1.setText(item.getTitle());
            textView2.setText(item.getDescription());
        }
        return itemView;
    }
}
