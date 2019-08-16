package com.example.a4_activityforresultexam;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //  객체 선언
    Button button;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 객체 초기화
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button1);
        // 이벤트 설정
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                //  textView의 문자열 읽어오기
                String memo = textView.getText().toString();
                //  intent 설정
                Intent intent = new Intent(this, EditActivity.class);
                intent.putExtra("memo",memo);
                //  수정된 내용을 되돌려줄 것을 예약한 화면으로 이동 요청
                //  => 이동할 화면에 대하여 일렬번호를 지정한다.
                startActivityForResult(intent,100);
            break;
        }
    }
    /**
     * startActivityForResult()에 의해서 화면이 이동되었다가
     * 이 화면으로 되돌아 올 경우, 자동으로 실행된다.
     * @param requestCode   :   요청 Activity에 설정한 id
     * @param resultCode    :   되돌아 오기전, selfResult()에서 설정한 결과값 (OK / CANCEL)
     * @param data          :   되돌아 오기전, selfResult()에 설정한 Intent
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode,  @Nullable Intent data) {
        // 나에게 온 정보인지 확인
        switch (requestCode){
            case  100:
                //  결과값이 "성공"일 경우만 처리
                if (resultCode == RESULT_OK){
                    //  되돌려받은 수정내용 추출
                    String edit = data.getStringExtra("edit");
                    textView.setText(edit);
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
