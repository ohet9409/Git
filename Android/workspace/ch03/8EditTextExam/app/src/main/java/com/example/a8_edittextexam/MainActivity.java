package com.example.a8_edittextexam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//  1. 리스너 설정
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //  2. 객체 선언
    EditText editText1, editText2;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 3. 객체 초기화
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        button = findViewById(R.id.button);
        // 4. 이벤트 설정
        button.setOnClickListener(this);
    }
    //  5. 이벤트 처리
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                // 입력값 읽어오기
                String id = editText1.getText().toString().trim();
                String pw = editText2.getText().toString().trim();
                // 입력값 검사
                if (id.equals("")){
                    Toast.makeText(this,"아이디를 입력하세요.",Toast.LENGTH_SHORT).show();
                    return; // 함수 종료 : 처리중단
                } else if (pw.equals("")){
                    Toast.makeText(this,"비밀번호를 입력하세요.",Toast.LENGTH_SHORT).show();
                    return;
                }
                // 입력내용 출력
                Toast.makeText(this,id + " / " + pw, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
