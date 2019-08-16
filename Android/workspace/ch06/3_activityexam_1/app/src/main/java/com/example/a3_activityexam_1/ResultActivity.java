package com.example.a3_activityexam_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.a3_activityexam_1.model.Answer;

public class ResultActivity extends AppCompatActivity {
    //  객체선언
    TextView textView1, textView2, textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // 객체 초기화
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);

        // intent에서 데이터 꺼내기
        Intent fromintent = getIntent();
        Answer answer = (Answer) fromintent.getSerializableExtra("answer");
        String id = answer.getId();
        String pw = answer.getPassword();
        String email = answer.getEmail();

        // textView에 출력
        textView1.setText("아이디 : " +id);
        textView2.setText("비밀번호 : " +pw);
        textView3.setText("이메일 : "+email);
    }
}
