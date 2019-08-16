package com.example.prac1_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prac1_1.model.Job;

public class ResultActivity extends AppCompatActivity {
    // 객체 선언
    TextView textView1, textView2;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        //  객체 초기화
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        imageView = findViewById(R.id.imageView);

        //  intent로 부터 데이터 꺼내기
        Intent frominten  = getIntent();
        Job item = (Job) frominten.getSerializableExtra("item");

        String title = item.getTitle();
        String description = item.getDescription();
        int image = item.getImage();
        /*String title = frominten.getStringExtra("title");
        String description = frominten.getStringExtra("description");
        int image = frominten.getIntExtra("image",0);*/

        textView1.setText(title);
        textView2.setText(description);
        imageView.setImageResource(image);
    }
}
