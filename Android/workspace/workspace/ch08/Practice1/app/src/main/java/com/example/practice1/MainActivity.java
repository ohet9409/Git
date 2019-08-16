package com.example.practice1;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.speech.tts.TextToSpeech;
import android.speech.tts.Voice;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practice1.helper.FileHelper;

import java.util.Locale;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, TextToSpeech.OnInitListener {
    // 객체 선언
    Button button, button2;
    TextView textView;
    TextToSpeech tts;
    boolean init;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 객체 초기화
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        textView = findViewById(R.id.textView);
        init = false;
        tts = new TextToSpeech(this, this, "com.google.android.tts");
        // 이벤트 설정
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        // 퍼미션 체크
        permissionCheck();
    }

    private void permissionCheck() {
        if(ActivityCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED) {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 100);
            }
        }
    }

    @Override
    public void onInit(int status) {
        init = (status == TextToSpeech.SUCCESS);
        String msg = "";
        if(init) msg = "엔진이 초기화 되었습니다.";
        else msg = "엔진이 초기화에 실패했습니다.";

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    // 앱이 끝날 때, tts 종료 처리
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(tts != null) {
            tts.stop();     // 음성 출력 정지
            tts.shutdown(); // TextToSpeech 종료
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                if(!init) {
                    Toast.makeText(this, "아직 초기화 되지 않았습니다.",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                // 파일 내용 읽어오기
                String filePath = Environment.getExternalStorageDirectory().getAbsolutePath()
                        + "/memo.txt";
                String msg = FileHelper.getInstance().readString(filePath, "utf-8");
                // 읽어줄 내용이 있는 지 확인
                if(msg.equals("") || msg == null) {
                    Toast.makeText(this, "읽어줄 내용이 없습니다.",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                // 사용할 언어
                Locale locale = Locale.KOREA;
                // 해당언어가 지원되는 지 검사
                if(tts.isLanguageAvailable(locale) < 0) {
                    Toast.makeText(this, "지원되지 않는 언어입니다.",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                // textView 출력
                textView.setText(msg);
                // tts 설정
                tts.setLanguage(locale);
                tts.setSpeechRate(1);
                // 남자 목소리로 바꾸기
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    for(Voice voice : tts.getVoices()) {
                        if(voice.getName().equals("ko-kr-x-kod-network")) {
                            tts.setVoice(voice);
                        }
                    }
                }
                // 읽어라...
                tts.speak(msg, TextToSpeech.QUEUE_FLUSH, null);
                break;
            case R.id.button2:
                tts.stop();
                break;
        }
    }
}










