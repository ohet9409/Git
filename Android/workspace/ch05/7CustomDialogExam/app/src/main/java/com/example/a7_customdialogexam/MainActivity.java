package com.example.a7_customdialogexam;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                showLoginDialog();
                break;
        }
    }
    //  로그인 다이얼로그 창을 표시
    private void showLoginDialog() {
        //  dialog.xml 파일에 설정된대로 클래스 객체화하기
        final View loginView = getLayoutInflater().inflate(R.layout.dialog,null);
        //  AlertDialog 객체 설정
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("로그인");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setCancelable(false);
        // AlertDialog에 메시지 대신, XML 레이아웃을 포함시킨다.
        builder.setView(loginView);
        //  "OK" 버튼 추가
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText editText1 = loginView.findViewById(R.id.editText1);
                EditText editText2 = loginView.findViewById(R.id.editText2);
                String id = editText1.getText().toString().trim();
                String pw = editText2.getText().toString().trim();
                String result = "아이디 : " + id + " / 비밀번호 : " + pw;

                Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
            }
        });
        //  "CANCEL" 버튼 추가
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"CANCEL",Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
