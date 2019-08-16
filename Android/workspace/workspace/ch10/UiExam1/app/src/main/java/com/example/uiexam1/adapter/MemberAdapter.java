package com.example.uiexam1.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.uiexam1.R;
import com.example.uiexam1.model.Member;

import java.util.List;

public class MemberAdapter extends ArrayAdapter<Member> {
    Activity activity;
    int resource;
    public MemberAdapter(Context context, int resource,  List<Member> objects) {
        super(context, resource, objects);
        activity = (Activity) context;
        this.resource = resource;
    }


    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = activity.getLayoutInflater().inflate(resource,null);
        }
        Member item = getItem(position);
        if (item != null){
            TextView textView1 = convertView.findViewById(R.id.textView1);
            TextView textView2 = convertView.findViewById(R.id.textView2);
            TextView textView3 = convertView.findViewById(R.id.textView3);
            TextView textView4 = convertView.findViewById(R.id.textView4);

            textView1.setText("이름 : " +item.getName());
            textView2.setText("이메일 : " +item.getEmail());
            textView3.setText("전화번호 : " +item.getPhone());
            textView4.setText("주소 : " +item.getAddr());
        }
        return convertView;
    }
}
