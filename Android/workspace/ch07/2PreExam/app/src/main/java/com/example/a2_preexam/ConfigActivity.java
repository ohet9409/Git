package com.example.a2_preexam;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class ConfigActivity extends AppCompatActivity {
    //  객체 선언
    EditText editText1, editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        //  객체 초기화
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
    }

    // 이 화면에서 빠져 나가는 경우 자동 호출
    @Override
    protected void onPause() {
        super.onPause();    // 반드시 부모 클래스의 원래 기능을 호출해야 한다.
        //  사용자가 입력한 값
        String name = editText1.getText().toString().trim();
        String id = editText2.getText().toString().trim();

        //  설정 파일에 저장 처리
        //  1) 공통 정보 관리 객체 생성 -> 파일 이름, 접근 권한
        SharedPreferences pref = getSharedPreferences("CONFIG", MODE_PRIVATE);
        //  2) 저장, 수정 객체
        SharedPreferences.Editor editor = pref.edit();
        //  3) 내용쓰기
        editor.putString("name", name);
        editor.putString("id", id);
        editor.putInt("kor",90);
        editor.putFloat("avg", 85.5f);
        //  4) 저장
        editor.commit();
    }
}
