package com.example.a4_activityforresultexam;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity implements View.OnClickListener {
    //  객체 선언
    EditText editText;
    Button button1, button2;
    String memo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        // 객체 초기화
        editText = findViewById(R.id.editText);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        //  intent에서 데이터 꺼내기
        Intent fromIntent = getIntent();
        memo = fromIntent.getStringExtra("memo");
        // editText에 출력
        editText.setText(memo);
        // 이벤트 설정
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:  //  완료버튼: 수정 내용 돌려주기
                //  수정 내용 읽어오기
                String edit = editText.getText().toString().trim();
                //  수정 내용을 저장할 빈 인텐트 (방향설정을 하지않음)
                Intent intent = new Intent();
                intent.putExtra("edit",edit);
                //  성공되었다는 결과와 함께, 수정된 내용을 시스템으로 돌려줌
                setResult(RESULT_OK, intent);
                //  현재 화면 종료
                finish();
                break;
            case R.id.button2:  //  취소버튼 : 작업이 취소되었음을 알려준다.
                setResult(RESULT_CANCELED);
                //  현재 화면 종료
                finish();
                break;
        }
    }

}
