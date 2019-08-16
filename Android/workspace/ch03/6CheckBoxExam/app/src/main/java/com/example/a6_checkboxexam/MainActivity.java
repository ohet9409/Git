package com.example.a6_checkboxexam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

//  1. 이벤트 처리를 위한 인터페이스 상속후, 메소드 재정의
public class MainActivity extends AppCompatActivity implements View.OnClickListener , CompoundButton.OnCheckedChangeListener {
    //  2. 사용할 컴포넌트 객체 선언
    CheckBox checkBox1, checkBox2, checkBox3;
    TextView textView2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  3. 객체 초기화 : 객체 할당
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        textView2 = findViewById(R.id.textView2);
        button = findViewById(R.id.button);
        // 4. 이벤트 설정
        checkBox1.setOnCheckedChangeListener(this);
        checkBox2.setOnCheckedChangeListener(this);
        checkBox3.setOnCheckedChangeListener(this);
        button.setOnClickListener(this);
    }
    //  5. 이벤트 처리
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.button :
                String msg = "";    // 내용을 생성해서 저장
                if (checkBox1.isChecked()){
                    msg += checkBox1.getText().toString() + " ";
                }
                if (checkBox2.isChecked()){
                    msg += checkBox2.getText().toString() + " ";
                }
                if (checkBox3.isChecked()){
                    msg += checkBox3.getText().toString() + " ";
                }
                if (msg.equals("")){
                    msg = "체크된 것이 없습니다.";
                }
                Toast.makeText(this,msg, Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /**
     * 체크박스의 선택상태가 변경될 경우 자동 실행된다.
     * @param buttonView : 체크된 CheckBox 객체
     * @param isChecked : true = 체크됨, false = 체크안됨
     */
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String msg = buttonView.getText().toString();

        if (isChecked){
            msg += "가 체크되었습니다.";
        } else {
            msg += "가 체크해제되었습니다.";
        }
        textView2.setText(msg);
    }
}
