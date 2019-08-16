package com.example.a6_cleartopexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1, button2;
    EditText editText1, editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                String id = editText1.getText().toString().trim();
                String pw = editText2.getText().toString().trim();
                String result = "아이디 : " + id + "\n비밀번호 : " + pw;
                Toast.makeText(this,result,Toast.LENGTH_SHORT).show();
                //Intent intent = new Intent(this,Join1Activity.class);
                //startActivity(intent);
                break;
            case R.id.button2:
                Intent intent = new Intent(this,Join1Activity.class);
                startActivity(intent);
                break;
        }
    }
}
