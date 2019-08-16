package com.example.a2_buttonexam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1, button2;
    ImageButton imageButton1, imageButton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 선언한 객체의 초기화
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        imageButton1=findViewById(R.id.imageButton1);
        imageButton2=findViewById(R.id.imageButton2);

        // 이벤트 설정
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        imageButton1.setOnClickListener(this);
        imageButton2.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        String message = "";
        switch (v.getId()){
            case R.id.button1:  message="남자입니다.";
                break;
            case R.id.button2: message="여자입니다.";
                break;
            case R.id.imageButton1: message="소년입니다.";
                break;
            case R.id.imageButton2: message="소녀입니다.";
                break;
        }
        // makeText(context(어느 화면에 띄울것인가) this/ getApplicationContext() : 현재화면, 출력할 문자열, 출력시간)
//        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        Toast toast = Toast.makeText(getApplicationContext(),message, Toast.LENGTH_SHORT);
        toast.show();
    }
}
