package com.example.a5_listfooterexam.adapter;

import android.app.Activity;
import android.content.Context;
import android.provider.ContactsContract;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a5_listfooterexam.R;
import com.example.a5_listfooterexam.model.Job;

import java.util.List;

public class JobAdapter extends ArrayAdapter<Job> {
    Activity activity;
    int resource;
    public JobAdapter( Context context, int resource, List objects) {
        super(context, resource, objects);
        activity = (Activity) context;
        this.resource = resource;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = activity.getLayoutInflater().inflate(resource,null);
        }
        Job item = getItem(position);
        if (item != null){
            ImageView imageView = convertView.findViewById(R.id.imageView);
            TextView textView1 = convertView.findViewById(R.id.textView1);
            TextView textView2 = convertView.findViewById(R.id.textView2);

            imageView.setImageResource(item.getImage());
            textView1.setText(item.getTitle());
            textView2.setText(item.getDescription());
        }
        return convertView;
    }
}
