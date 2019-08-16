package com.example.a6_cleartopexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Join3Activity extends AppCompatActivity implements View.OnClickListener {
    EditText editText;
    Button button;
    String id, pw, hobby;
    int age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join3);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button3);

        button.setOnClickListener(this);

        Intent fromIntent = getIntent();
        id = fromIntent.getStringExtra("id");
        pw = fromIntent.getStringExtra("pw");
        hobby = fromIntent.getStringExtra("hobby");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button3:
                age = Integer.parseInt(editText.getText().toString().trim());
                String result = "아이디 : " + id + "\n비밀번호 : " + pw + "\n취미 : " + hobby + "\n나이 : " + age;
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MainActivity.class);
                // history stack 내용 지우기 옵션 설정
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                // 대상 Activity가 존재한다면 새로 만들지 말고, 기존 것을 사용하겠다는 설정
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                break;
        }
    }
}
