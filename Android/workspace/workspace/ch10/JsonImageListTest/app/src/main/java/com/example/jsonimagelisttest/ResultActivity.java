package com.example.jsonimagelisttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jsonimagelisttest.model.Job;
import com.nostra13.universalimageloader.core.ImageLoader;

public class ResultActivity extends AppCompatActivity {
    TextView textView1, textView2;
    ImageView imageView;
    ImageLoader imageLoader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Job item = (Job) getIntent().getSerializableExtra("item");
        ImageLoader imageLoader = ImageLoader.getInstance();

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        imageView = findViewById(R.id.imageView);

        textView1.setText(item.getSubject());
        textView2.setText(item.getContent());
        imageLoader.displayImage(item.getImgOrigin(),imageView);
    }
}
