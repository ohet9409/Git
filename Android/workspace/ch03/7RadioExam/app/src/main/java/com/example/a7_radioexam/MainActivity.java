package com.example.a7_radioexam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

//  1. 리스너 상속
public class MainActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    //  2. 사용할 객체 선언
    RadioGroup radioGroup;
    TextView textView2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 3. 객체 초기화
        radioGroup = findViewById(R.id.radioGroup);
        textView2 = findViewById(R.id.textView2);
        button = findViewById(R.id.button);
        // 4. 이벤트 설정
        radioGroup.setOnCheckedChangeListener(this);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                // 선택된 라디오 버튼의 ID값 얻기
                int checkedId = radioGroup.getCheckedRadioButtonId();
                // 획득한 ID값으로 라디오버튼 객체 할당
                RadioButton radioButton = findViewById(checkedId);
                // 문자열 얻기
                String text = radioButton.getText().toString();

                Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (group.getId()){
            case R.id.radioGroup :
                RadioButton radioButton = findViewById(checkedId);
                textView2.setText(radioButton.getText().toString());
                break;
        }
    }
}
