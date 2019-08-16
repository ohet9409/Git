package com.example.a3_activityexam_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.a3_activityexam_1.model.Answer;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //  객체 선언
    EditText editText1, editText2, editText3;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 객체 초기화
        editText1 = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        button = findViewById(R.id.button);

        // 이벤트 설정
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                //  입력값 받기
                String id = editText1.getText().toString().trim();
                String pw = editText2.getText().toString().trim();
                String email = editText3.getText().toString().trim();
                //  입력값을 하나의 객체에 묶기
                Answer answer = new Answer(id,pw,email);
                //  화면이동을 위한 명시적 인텐트
                Intent intent = new Intent(this, ResultActivity.class);
                //  intent에 객체 저장
                intent.putExtra("answer", answer);
                startActivity(intent);
                break;
        }
    }
}
