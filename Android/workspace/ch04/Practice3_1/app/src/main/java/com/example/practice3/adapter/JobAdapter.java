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

public class JobAdapter extends ArrayAdapter<Job> {
    Activity activity;
    int resource;

    public JobAdapter(Context context, int resource, List<Job> objects) {
        super(context, resource, objects);
        activity = (Activity) context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemvView = convertView;
        if(itemvView == null) {
            itemvView = activity.getLayoutInflater().inflate(resource, null);
        }
        Job item = getItem(position);
        if(item != null) {
            ImageView imageView = itemvView.findViewById(R.id.imageView);
            TextView textView1 = itemvView.findViewById(R.id.textView1);
            TextView textView2 = itemvView.findViewById(R.id.textView2);

            imageView.setImageResource(item.getThumbImgae());
            textView1.setText(item.getTitle());
            textView2.setText(item.getDescription());
        }
        return itemvView;
    }
}










