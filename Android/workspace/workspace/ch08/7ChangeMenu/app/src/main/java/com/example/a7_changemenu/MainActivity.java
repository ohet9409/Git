package com.example.a7_changemenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //  객체 선언
    Button button1, button2;
    boolean beginer = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  객체 초기화
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        //  이벤트 설정
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                beginer = true;
                invalidateOptionsMenu();    // 기존 화면을 무효화 (메뉴화면 무효화 -> onCreateOptionMenu() 다시 호출)
                break;
            case R.id.button2:
                beginer = false;
                invalidateOptionsMenu();    // 기존 화면을 무효화 (메뉴화면 갱신)
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (beginer){
            getMenuInflater().inflate(R.menu.beginer,menu);
        } else {
            getMenuInflater().inflate(R.menu.expert,menu);
        }
        return super.onCreateOptionsMenu(menu);
    }
}
