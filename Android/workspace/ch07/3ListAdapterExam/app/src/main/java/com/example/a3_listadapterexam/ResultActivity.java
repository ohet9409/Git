package com.example.a3_listadapterexam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a3_listadapterexam.model.Job;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    // 객체 선언
    TextView textView1, textView2;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        // 객체 초기화
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        imageView = findViewById(R.id.imageView);

        // intent 값 추출1
        //Job item = (Job) getIntent().getSerializableExtra("item");

        // intent 값 추출2
        ArrayList<Job> list = (ArrayList<Job>) getIntent().getSerializableExtra("list");
        int position = (int) getIntent().getIntExtra("position", 0);
        Job item = null;
        if(list.size() > 0 ) {
            item = list.get(position);
        } else {
            return;
        }
        // 화면 설정
        textView1.setText(item.getTitle());
        textView2.setText(item.getDescription());
        imageView.setImageResource(item.getImage());
    }
}
