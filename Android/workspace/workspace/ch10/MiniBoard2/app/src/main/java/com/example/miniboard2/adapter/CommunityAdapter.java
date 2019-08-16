package com.example.miniboard2.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.miniboard2.R;
import com.example.miniboard2.model.Community;

import java.util.List;

public class CommunityAdapter extends ArrayAdapter<Community> {
    Activity activity;
    int resource;
    public CommunityAdapter(Context context, int resource,  List<Community> objects) {
        super(context, resource, objects);
        activity = (Activity) context;
        this.resource = resource;
    }


    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = activity.getLayoutInflater().inflate(resource,null);
        }
        Community item = getItem(position);
        if (item != null){
            TextView textView1 = convertView.findViewById(R.id.textView1);
            TextView textView2 = convertView.findViewById(R.id.textView2);

            textView1.setText(item.getSubject());
            textView2.setText(item.getUser_name()+" / "+item.getEdit_date());
        }
        return convertView;
    }
}
