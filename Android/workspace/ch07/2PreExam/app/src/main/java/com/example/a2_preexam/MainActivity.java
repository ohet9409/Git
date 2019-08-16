package com.example.a2_preexam;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //  객체 선언
    Button button;
    TextView textView1, textView2;

    //  Activity 클래스가 실행되었을 때, 제일 먼저 호출되어짐
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  객체 초기화
        button = findViewById(R.id.button);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);

        //  이벤트 설정
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                Intent intent = new Intent(this, ConfigActivity.class);
                startActivity(intent);
                break;
        }
    }
    //  Activity 화면이 뜨기 직전에 자동 호출
    @Override
    protected void onResume() {
        super.onResume();   // 반드시 부모클래스의 원래 기능을 호출해야 한다.
        //  설정파일에 저장된 데이터를 읽는다.
        //  1) 공통 정보 관리 객체 생성 --> 파일이름, 접근 권한
        SharedPreferences pref = getSharedPreferences("CONFIG",MODE_PRIVATE);
        //  2) 설정 파일에 저장된 데이터 읽어오기
        String name = pref.getString("name", "설정안됨");
        String id = pref.getString("id", "알수없음");
        //  3) 결과 출력
        textView1.setText("이름 : " + name);
        textView2.setText("아이디 : " + id);
    }
}
