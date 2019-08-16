package com.example.booklist.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.booklist.R;
import com.example.booklist.model.Book;

import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {
    // MainActivity를 전달받아서 저장
    Activity activity;
    // R.layout.list_item 값 저장
    int resource;

    public BookAdapter(Context context, int resource, List<Book> objects) {
        super(context, resource, objects);
        activity = (Activity) context;
        this.resource = resource;
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        System.out.println("position = " + position);
        // 1줄 화면
        View itemView = convertView;
        if (itemView == null){
            itemView = activity.getLayoutInflater().inflate(resource,null);
        }
        //  1개 데이터 얻기
        Book item = getItem(position);
        // 결합 : 1줄 화면 + 데이터
        if (item != null){
            ImageView imageView = itemView.findViewById(R.id.imageView);
            TextView textView1 = itemView.findViewById(R.id.textView1);
            TextView textView2 = itemView.findViewById(R.id.textView2);
            TextView textView3 = itemView.findViewById(R.id.textView3);

            imageView.setImageResource(item.getImage());
            textView1.setText(item.getSubject());
            textView2.setText(item.getWriter());
            textView3.setText(item.getPublisher());
        }
        return itemView;
    }
}
