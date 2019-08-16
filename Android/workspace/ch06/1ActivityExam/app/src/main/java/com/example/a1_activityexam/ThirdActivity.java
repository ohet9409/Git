package com.example.a1_activityexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText;
    Button button1,button2;
    int age=0;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        // 객체 초기화
        editText = findViewById(R.id.editText);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        // name 변수 초기화  : Intent에 저장된 값 추출
        Intent fromIntent = getIntent();
        name = fromIntent.getStringExtra("name");
        // 이벤트 설정
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                // EditText에 사용자가 입력한 값 저장
                String input = editText.getText().toString().trim();
                if (!input.equals("")) {
                    age = Integer.parseInt(input);
                }
                // 화면 이동을 위한 명시적 인텐트
                Intent intent = new Intent(this,ResultActivity.class);
                intent.putExtra("age",age);
                intent.putExtra("name",name);
                startActivity(intent);
                break;
            case R.id.button2:
                finish();   // 현재 Activity 종료 -> 이전 화면 되돌아가기
                break;
        }
    }
}
