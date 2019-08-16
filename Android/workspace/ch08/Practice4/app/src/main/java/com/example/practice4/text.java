package com.example.practice4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.practice4.helper.FileHelper;

public class text extends AppCompatActivity implements View.OnClickListener {

    // 객체 선언
    TextView textView;
    Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        // 객체 초기화
        textView = findViewById(R.id.textView);
        buttonBack = findViewById(R.id.buttonBack);
        // 이벤트 설정
        buttonBack.setOnClickListener(this);
        // 인텐트 데이터 추출
        String filePath = getIntent().getStringExtra("filePath");
        // 화면 설정
        String content = FileHelper.getInstance().readString(filePath, "utf-8");
        textView.setText(content);
    }
    @Override
    public void onClick(View v) {
        finish();
    }
}
