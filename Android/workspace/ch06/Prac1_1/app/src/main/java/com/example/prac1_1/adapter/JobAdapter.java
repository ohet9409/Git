package com.example.prac1_1.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prac1_1.R;
import com.example.prac1_1.model.Job;

import java.util.List;
//  리스트를 채우는 용도
public class JobAdapter extends ArrayAdapter<Job> {
    Activity activity;
    int resource;       // 데이터 값
    //                     this            list_item     list
    public JobAdapter(Context context, int resource,  List<Job> objects) {
        super(context, resource, objects);
        activity = (Activity) context;  // MainActivity
        this.resource = resource;
    }

    // 1줄 화면 만들기
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        // convertView는 초기값이 null
        if (convertView == null){
            // 객체화 시킴
            convertView = activity.getLayoutInflater().inflate(resource,null);
        }
        Job item = getItem(position);
        // 데이터가 있을경우
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
