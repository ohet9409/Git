package com.example.prac1;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.logging.FileHandler;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TextToSpeech.OnInitListener {
    // 객체 선언
    Button button;
    TextView textView;
    TextToSpeech tts;
    boolean init;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  객체 초기화
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        init = false;
        tts = new TextToSpeech(this, this);

        button.setOnClickListener(this);
    }

    @Override
    public void onInit(int status) {
        init = (status == TextToSpeech.SUCCESS);
        String msg = "";
        if (init) msg = "엔진이 초기화 되었습니다.";
        else msg = "엔진이 초기화에 실패했습니다.";
        Toast.makeText(this, msg,Toast.LENGTH_SHORT).show();
    }
    // 앱이 끝날때, tts 종료 처리
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (tts != null){
            tts.stop();
            tts.shutdown();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                if (!init){
                    Toast.makeText(this,"아직 초기화 되지 않았습니다.",Toast.LENGTH_SHORT);
                    return;
                }
                //  파일 내용 읽어오기


        }
    }
}
