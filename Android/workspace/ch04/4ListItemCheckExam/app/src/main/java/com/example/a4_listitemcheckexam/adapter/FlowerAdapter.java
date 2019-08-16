package com.example.a4_listitemcheckexam.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a4_listitemcheckexam.R;
import com.example.a4_listitemcheckexam.model.Flower;

import java.util.List;

public class FlowerAdapter extends ArrayAdapter<Flower> {
    Activity activity;
    int resource;
    public FlowerAdapter( Context context, int resource,  List<Flower> objects) {
        super(context, resource, objects);
        activity = (Activity) context;
        this.resource = resource;
    }


    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        //  1. 1줄 화면 객체
        View itemView = convertView;
        if (itemView == null){
            itemView = activity.getLayoutInflater().inflate(resource,null);
        }
        //  2. List에서 데이터 꺼내기 : item에 데이터 저장
        // final : 익명클래스안에서 사용하는 지역변수는 반드시 final을 앞의 붙여야 함
        final Flower item = getItem(position);
        //  3. 1줄화면 객체 + 데이터
        if (itemView != null){
            CheckBox checkBox = itemView.findViewById(R.id.checkBox);
            ImageView imageView = itemView.findViewById(R.id.imageView);
            TextView textView1 = itemView.findViewById(R.id.textView1);
            TextView textView2 = itemView.findViewById(R.id.textView2);

            imageView.setImageResource(item.getImage());
            textView1.setText(item.getTitle());
            textView2.setText(item.getDescription());

            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    // isChecked : 상태 값 (setter에 저장)
                    item.setCheck(isChecked);
                }
            });
            //  isCheck() = getter : 가져오는 값
            checkBox.setChecked(item.isCheck());
        }
        return itemView;
    }
}
