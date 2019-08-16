package com.example.practice1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView textView1, textView2;
    ImageView imageView;
    String name, description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        imageView = findViewById(R.id.imageView);
        Intent fromIntent = getIntent();
        name = fromIntent.getStringExtra("title");
        description = fromIntent.getStringExtra("description");
        textView1.setText(name);
        textView2.setText(description);
    }
}
