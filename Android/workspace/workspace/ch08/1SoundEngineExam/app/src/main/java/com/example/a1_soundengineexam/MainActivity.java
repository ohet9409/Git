package com.example.a1_soundengineexam;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // 변수 선언
    Button button1, button2;
    TextView textView;
    //  음성 인식을 구별하기 위한 상수
    private final int SEARCH = 1;   // 음성 검색
    private final int SPEECH = 2;   // 음성 인식

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 객체 초기화
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        textView = findViewById(R.id.textView);
        // 이벤트 설정
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:  // 구글 검색
                callSoundEngine(SEARCH);
                break;
            case R.id.button2:  // 음성 인식
                callSoundEngine(SPEECH);
                break;
        }
    }
    // 음성 인식을 위한 내장 APP을 호출한다.
    private void callSoundEngine(int type) {
        String intent_action = null;
        if (type == SEARCH) {
            intent_action = RecognizerIntent.ACTION_WEB_SEARCH;
        } else if(type == SPEECH) {
            intent_action = RecognizerIntent.ACTION_RECOGNIZE_SPEECH;
        }

        try {
            Intent intent = new Intent(intent_action);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                    RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "음성검색");

            if(type == SEARCH) {
                startActivity(intent);                  // 웹 검색은 결과를 받을 필요가 없어서, 그냥 호출
            } else if (type == SPEECH) {
                startActivityForResult(intent, type);   // 음성 인식은 인식 결과를 받기위한 호출
            }
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "이 기능을 지원하지 않는 단말입니다.",
                    Toast.LENGTH_SHORT).show();
        }
    }

    // 음성인식인 경우, 화면 이동에 대한 결과를 받기 위한 메소드 재정의
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case SPEECH:
                if(resultCode == RESULT_OK) {
                    // 음성 인식된 결과는 List로 Intent에 담겨져 있다.
                    ArrayList<String> list = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    // 전체 다섯개의 결과 중에서 첫번째 데이터가 가장 정확도가 높다.
                    String str = list.get(0);
                    // 출력
                    textView.setText(str);
                }
                break;
        }
    }
}

