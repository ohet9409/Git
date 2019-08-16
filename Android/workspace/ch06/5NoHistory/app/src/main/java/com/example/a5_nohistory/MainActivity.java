package com.example.a5_nohistory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //  화면 이동을 위한 명시적 인텐트
        Intent intent = new Intent(this,SecondActivity.class);
        //  SecondActivity가 History stack에 저장되지 않도록 플래그 설정
        //  다음 화면에 대한 history만 저장하지 않음
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        // 화면 이동 요청
        startActivity(intent);
    }
}
