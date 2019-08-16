package com.example.a1_activityexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView textView;
    //  이전 화면에서 넘어온 데이터 저장
    String name;
    int age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        // 변수 초기화
        textView = findViewById(R.id.textView);
        // name, age 초기화
        Intent fromIntent = getIntent();
        //  파라미터로 전달된 값을 추출할 경우, 각 데이터 형에 따라서 메소드를 구분한다.
        //  기본 데이터형을 리턴하는 경우, 두번째 파라미터로 값이 없을 경우에 대한 기본값을 함께 설정해야 한다.
        name = fromIntent.getStringExtra("name");
        // 정수나 실수형은 기본값 설정이 필요하다.
        age = fromIntent.getIntExtra("age", 0);


        // 결과 출력력
        String result = "<font color='blue'>"+name + "</font>님의 나이는 <font color='red'>" + age + "세</font> 입니다.";
       textView.setText(Html.fromHtml(result));
    }
}
