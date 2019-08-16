package com.example.a1_activityexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    // 변수 선언
    EditText editText;
    Button button1, button2;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        editText = findViewById(R.id.editText);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                // EditText에 사용자가 입력한 값 저장
                name = editText.getText().toString().trim();
                // 화면 이동을 위한 명시적 인텐트
                Intent intent = new Intent(this,ThirdActivity.class);
                // 인텐트에 데이터 저장
                intent.putExtra("name",name);
                startActivity(intent);
                break;
            case R.id.button2:
                finish();
                break;
        }
    }
}
