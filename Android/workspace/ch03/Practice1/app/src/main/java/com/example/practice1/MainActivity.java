package com.example.practice1;

import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView3;
    private TextView textView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);

        textView3.setText("오늘도 열심히..");
        textView4.setText("겨울의 입구에서..");

        int color = Color.rgb(225,0,0);
        textView3.setTextColor(color);


        int color2 = getResources().getColor(R.color.my_blue);
        textView4.setTextColor(color2);

        textView3.setBackgroundColor(Color.rgb(0,255,10));
        textView4.setBackgroundColor(getResources().getColor(R.color.my_puple));

        textView3.setTextSize(30);
        textView4.setTextSize(getResources().getDimension(R.dimen.my_size)/(float)2.5);

        textView4.setSingleLine(true);

    }
}
