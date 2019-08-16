package com.example.a6_cleartopexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class Join2Activity extends AppCompatActivity implements View.OnClickListener {
    CheckBox checkBox1, checkBox2, checkBox3;
    Button button;
    String id, pw;
    String hobby = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join2);
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        button = findViewById(R.id.button);


        id = getIntent().getStringExtra("id");
        pw = getIntent().getStringExtra("pw");


        button.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button:
                if (checkBox1.isChecked()) {
                    hobby += checkBox1.getText().toString() + ", ";
                }
                if (checkBox2.isChecked()) {
                    hobby += checkBox2.getText().toString() + ", ";
                }
                if (checkBox3.isChecked()) {
                    hobby += checkBox3.getText().toString() + ", ";
                }
                //  끝에 콤마 없애기
                if (!hobby.equals("")) {
                    hobby = hobby.substring(0, hobby.lastIndexOf(","));
                }
                Intent intent = new Intent(this, Join3Activity.class);
                intent.putExtra("pw", pw);
                intent.putExtra("id", id);
                intent.putExtra("hobby", hobby);
                Toast.makeText(this, "아이디 : " + id + " 비밀번호 : " + pw + "취미 : " + hobby, Toast.LENGTH_SHORT).show();

                startActivity(intent);
                finish();

                break;
        }
    }
}
