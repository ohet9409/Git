package com.example.practice3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText1, editText2;
    RadioGroup radioGroup;
    CheckBox checkBox1, checkBox2, checkBox3;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        radioGroup = findViewById(R.id.radioGroup);
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        button = findViewById(R.id.button);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                // toString() : 문자열화 해주는 메소드
                String name = editText1.getText().toString().trim();
                // Toast.makeText(this,editText1.getText(),Toast.LENGTH_SHORT).show();
                int age = 0;
                String age_str = editText2.getText().toString().trim();
                editText2.getText().toString().trim();
                int checkedId = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = findViewById(checkedId);
                String gen = radioButton.getText().toString();
                String msg = "";
                if (name.equals("")) {
                    Toast.makeText(this, "이름을 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;     //  onClick(View v) 함수를 빠져나감
                } else if (!age_str.equals("")) {
                    age = Integer.parseInt(age_str);


                } else if (age_str.equals("")){
                    Toast.makeText(this, "나이를 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (checkBox1.isChecked()) {
                    msg += checkBox1.getText().toString() + " ";
                }
                if (checkBox2.isChecked()) {
                    msg += checkBox2.getText().toString() + " ";
                }
                if (checkBox3.isChecked()) {
                    msg += checkBox3.getText().toString() + " ";
                }
                Toast.makeText(this, " 이름 : " + name + " \n 나이 : " + age + "\n 성별 : " + gen + "\n 취미 : " + msg, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}



