package com.example.a2_texttospeechexam;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

/*
    TTS 클래스는 엔진이 무겁기 때문에, 초기화 시간이 오래 걸린다.
    초기화가 진행되는 동안 App이 벽돌이 될수는 없으므로,
    초기화 작업은 백그라운드로 실행되며, 초기화가 완료되면 이벤트를 발생시킨다.
 */
public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, TextToSpeech.OnInitListener {
    // 객체 선언
    EditText editText;
    Button button;
    TextToSpeech tts;
    boolean init;       // TextToSpeech 초기화 여부 저장

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 객체 초기화
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        init =false;
        // TextToSpeech(Context, 이벤트 리스너 지정);
        tts = new TextToSpeech(this, this);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                // tts가 초기화 되었는 지 검사
                if(!init) {
                    Toast.makeText(this, "아직 초기화가 되지 않았습니다.",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                // 사용자가 입력한 내용
                String msg = editText.getText().toString().trim();
                if(msg.equals("")) {
                    Toast.makeText(this, "내용을 입력하세요", Toast.LENGTH_SHORT).show();
                    return;
                }
                /* tts 설정 */
                // 사용할 언어
                Locale locale = Locale.KOREA;
                // 해당 언어가 지원되는 지 검사.
                int available = tts.isLanguageAvailable(locale);
                if(available < 0) {
                    Toast.makeText(this, "지원되지 않은 언어입니다.",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                // 언어 설정
                tts.setLanguage(locale);
                tts.setSpeechRate(2);   // 1 보통 속도 (말하는 속도)
                // 읽어라
                tts.speak(msg, TextToSpeech.QUEUE_FLUSH, null);
                break;
        }
    }
    // tts의 초기화가 완료되면 자동 호출
    @Override
    public void onInit(int status) {
        // 초기화 여부를 전역변수에 설정함
        init = (status == TextToSpeech.SUCCESS);
        String msg = "";
        if(init) msg = "엔진이 초기화 되었습니다.";
        else msg = "엔진이 초기화에 실패했습니다.";

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    // tts는 App이 종료되어도 메모리에 상주하기 때문에
    // App이 종료될 시점에 직접 메모리에서 해제시켜야 한다.
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (tts != null) {  // TextToSpeech 객체가 생성되어 있다면
            tts.stop();     // 음성 출력 정지
            tts.shutdown(); // tts 종료
        }
    }
}
