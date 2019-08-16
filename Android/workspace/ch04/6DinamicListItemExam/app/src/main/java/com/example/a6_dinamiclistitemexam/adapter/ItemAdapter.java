package com.example.a6_dinamiclistitemexam.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.a6_dinamiclistitemexam.R;
import com.example.a6_dinamiclistitemexam.model.Item;

import java.util.List;

public class ItemAdapter extends ArrayAdapter<Item> {
    Activity activity;
    int resource;
    public ItemAdapter( Context context, int resource, List<Item> objects) {
        super(context, resource, objects);
        activity = (Activity) context;
        this.resource = resource;
    }


    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        // 디버깅 용
        System.out.println("[TEST] position =" + position);
        Log.d("[EXAM] position", position+"");
        if (convertView == null){
            convertView = activity.getLayoutInflater().inflate(resource,null);
        }
        final Item item = getItem(position);
        if(item != null){
            Button button = convertView.findViewById(R.id.button);
            TextView textView = convertView.findViewById(R.id.textView);

            textView.setText(item.getNum() + ">> " + item.getName());
            //  버튼이 클릭되면 선택항목에 대하여 삭제처리를 한다.
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    remove(item);
                }
            });
        }
        return convertView;
    }
}
