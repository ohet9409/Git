package com.example.gradelistexam.adapter;

import android.app.Activity;
import android.bluetooth.BluetoothClass;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.gradelistexam.R;
import com.example.gradelistexam.model.Grade;

import java.util.List;

public class GradeAdapter extends ArrayAdapter<Grade> {
    Activity activity;
    int resource;
    public GradeAdapter(Context context, int resource,  List<Grade> objects) {
        super(context, resource, objects);
        activity = (Activity) context;
        this.resource = resource;
    }

    //  1줄 화면 + 데이터
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        if (convertView == null){
            convertView = activity.getLayoutInflater().inflate(resource, null);
        }
        Grade item = getItem(position);
        if (item!= null){
            TextView textView1 = convertView.findViewById(R.id.textView1);
            TextView textView2 = convertView.findViewById(R.id.textView2);
            TextView textView3 = convertView.findViewById(R.id.textView3);
            TextView textView4 = convertView.findViewById(R.id.textView4);

            textView1.setText("이름: "+item.getName());
            textView2.setText("국어: "+item.getKor());
            textView3.setText("영어: "+item.getEng());
            textView4.setText("수학: "+item.getMath());
        }
        return convertView;
    }


}
