package com.example.a1_fileioexam;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a1_fileioexam.helper.FileHelper;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // 객체 선언
    EditText editText;
    Button button1, button2;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 객체 초기화
        editText = findViewById(R.id.editText);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        textView2 = findViewById(R.id.textView2);

        //  이벤트 설정
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        // 퍼미션 체크
        permissionCheck();
    }

    private void permissionCheck() {
        // 쓰기만 허락받으면 읽기도 자동으로 허락받아진다.
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {


            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);

            }
        }
    }

    @Override
    public void onClick(View v) {
        // 저장하거나 읽어올 파일의 경로 (스마트폰의 첫 폴더 위치)
        File dir = Environment.getExternalStorageDirectory();
        String filePath = dir.getAbsolutePath() + "/mymemo.txt";
        String encType = "utf-8";
        String content = "";
        switch (v.getId()){
            case R.id.button1:      // 저장하기
                content = editText.getText().toString().trim();
                // 저장
                boolean result = FileHelper.getInstance().writeSpring(filePath, content, encType);
                String msg = "";
                if (result) msg = "저장 성공";
                else    msg = "저장 실패";
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
                break;

            case R.id.button2:      // 읽어오기
                content = FileHelper.getInstance().readString(filePath, encType);
                textView2.setText(content);
                break;
        }
    }
}
