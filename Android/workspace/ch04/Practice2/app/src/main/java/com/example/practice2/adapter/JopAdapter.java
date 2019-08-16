package com.example.practice2.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.practice2.R;
import com.example.practice2.model.Job;

import java.util.List;

public class JopAdapter extends ArrayAdapter<Job> {
    Activity activity;
    int resource;

    public JopAdapter( Context context, int resource,  List<Job> objects) {
        super(context, resource, objects);
        activity = (Activity) context;
        this.resource = resource;
    }


    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null){
            itemView = activity.getLayoutInflater().inflate(resource,null);
        }
        Job item = getItem(position);
        if(itemView != null){
            ImageView imageView = itemView.findViewById(R.id.imageView2);

            TextView textView2 = itemView.findViewById(R.id.textView2);
            TextView textView3 = itemView.findViewById(R.id.textView3);

            imageView.setImageResource(item.getImage());
            textView2.setText(item.getTitle());
            textView3.setText(item.getDescription());
        }
        return itemView;
    }
}
