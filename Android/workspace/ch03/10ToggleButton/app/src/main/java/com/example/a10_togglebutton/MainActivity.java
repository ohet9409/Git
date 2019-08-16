package com.example.a10_togglebutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

//  1. 리스너 설정
public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    //  2. 객체 선언
    ToggleButton toggleButton1, toggleButton2;
    TextView textView1, textView2;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  3. 객체 초기화
        toggleButton1 = findViewById(R.id.toggleButton1);
        toggleButton2 = findViewById(R.id.toggleButton2);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        button = findViewById(R.id.button);
        //  4. 이벤트 설정
        toggleButton1.setOnCheckedChangeListener(this);
        toggleButton2.setOnCheckedChangeListener(this);
        button.setOnClickListener(this);
        // toggleButton2 on 상태로 설정
        toggleButton2.setChecked(true);
    }
    //  5. 이벤트 처리
    @Override
    public void onClick(View v) {
        // 각 ToggleButton의 상태 얻어오기
        boolean checked1 = toggleButton1.isChecked();
        boolean checked2 = toggleButton2.isChecked();

        String msg1 = "";
        String msg2 = "";
        if (checked1){
            msg1 = "설정됨";
        } else {
            msg1 = "설정 해제";
        }
        if (checked2){
            msg2 = "설정됨";
        } else {
            msg2 = "설정 해제";
        }

        Toast.makeText(this, "기본버튼 : " + msg1 + " / 이미지버튼 : "+msg2,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()){
            case R.id.toggleButton1:
                //  buttonView는 부모클래스이기 때문에, 형변환을 통해 자식 클래스에 저장함
               // ToggleButton toggleButton = (ToggleButton)buttonView;
                if (isChecked){
                    textView1.setText(toggleButton1.getTextOn());
                } else {
                    textView1.setText(toggleButton1.getTextOff());
                }
                break;
            case R.id.toggleButton2:
                if (isChecked){
                    textView2.setText("좋아요 눌러짐");
                } else {
                    textView2.setText("좋아요 취소됨");
                }
                break;

        }
    }
}
