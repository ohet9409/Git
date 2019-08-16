package com.example.practice3.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.practice3.R;
import com.example.practice3.model.Local;

import java.util.List;

public class LocalAdapter extends ArrayAdapter<Local> {
    Activity activity;
    int resource;

    public LocalAdapter(Context context, int resource, List<Local> objects) {
        super(context, resource, objects);
        activity = (Activity) context;
        this.resource = resource;
    }




    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        if (convertView == null){
            convertView =  activity.getLayoutInflater().inflate(resource,null);
        }
        Local item = getItem(position);
        if (item != null){
            TextView textView1 = convertView.findViewById(R.id.textView1);
            TextView textView2 = convertView.findViewById(R.id.textView2);

            textView1.setText(item.getPlace_name());
            textView2.setText(item.getCategory_name());

        }
        return convertView;
    }
}
