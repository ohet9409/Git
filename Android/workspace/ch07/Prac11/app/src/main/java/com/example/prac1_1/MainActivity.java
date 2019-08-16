package com.example.prac1_1;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prac1_1.helper.ObjectInOut;
import com.example.prac1_1.model.Member;

import java.util.ArrayList;
import java.util.List;

//  리스너 설정
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //  객체 선언
    List<Member> list;
    Button buttonInput, buttonList, buttonWrite, buttonRead, buttonInput2, buttonBack2, buttonBack3;
    EditText editTextName, editTextEmail, editTextTel, editTextAddr;
    TextView textViewList;
    LinearLayout layoutMain, layoutInput, layoutOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  객체 초기화
        list= new ArrayList<>();
        buttonBack2 = findViewById(R.id.buttonBack2);
        buttonInput = findViewById(R.id.buttonInput);
        buttonList = findViewById(R.id.buttonList);
        buttonWrite = findViewById(R.id.buttonWrite);
        buttonRead = findViewById(R.id.buttonRead);
        buttonInput2 = findViewById(R.id.buttonInput2);
        buttonBack3 = findViewById(R.id.buttonBack3);
        editTextAddr = findViewById(R.id.editTextAddr);
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextTel = findViewById(R.id.editTextTel);
        textViewList = findViewById(R.id.textViewList);
        layoutInput = findViewById(R.id.layoutInput);
        layoutMain = findViewById(R.id.layoutMain);
        layoutOutput = findViewById(R.id.layoutOutput);

        //  이벤트 설정
        buttonBack2.setOnClickListener(this);
        buttonInput.setOnClickListener(this);
        buttonList.setOnClickListener(this);
        buttonWrite.setOnClickListener(this);
        buttonRead.setOnClickListener(this);
        buttonInput2.setOnClickListener(this);
        buttonBack3.setOnClickListener(this);

        // 화면 초기화
        layoutMain.setVisibility(View.VISIBLE);
        layoutInput.setVisibility(View.GONE);
        layoutOutput.setVisibility(View.GONE);

        // 퍼미션 체크
        permissionCheck();

        // textView 설정 (스크롤 기능)
       // textViewList.setMovementMethod(new ScrollingMovementMethod());
    }

    private void permissionCheck() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)){

            }else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
            }
        }
    }

    //  이벤트 처리
    @Override
    public void onClick(View v) {
        String fname = Environment.getExternalStorageDirectory().getAbsolutePath() + "/member.text";

        switch (v.getId()){
            case R.id.buttonInput:      //   입력화면 이동
                layoutMain.setVisibility(View.GONE);
                layoutInput.setVisibility(View.VISIBLE);
                layoutOutput.setVisibility(View.GONE);
                break;
            case R.id.buttonList:       //  목록보기화면 이동
                layoutMain.setVisibility(View.GONE);
                layoutInput.setVisibility(View.GONE);
                layoutOutput.setVisibility(View.VISIBLE);
                //
                String result1 ="";
                for (int i=0; i<list.size(); i++){
                    Member member = list.get(i);
                    result1 +=  member.toString() + "\n";
                }
                textViewList.setText(result1);
                break;
            case R.id.buttonWrite:      //  파일 저장
                boolean result = ObjectInOut.getInstance().write(fname,list);
                String msg = "";
                if (result){
                     msg = "저장 성공";
                } else {
                    msg = "저장 실패";
                }
                Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonRead:       //  파일 읽기
                list.clear();
                list = ObjectInOut.getInstance().read(fname);
                String msg1 = "";
                if (list.size() >0){
                    msg1 = "읽기 성공";
                } else {
                    msg1 = "읽기 실패";
                }
                Toast.makeText(this,msg1,Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonInput2:     //  입력값을 List에 저장
                String name = editTextName.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String phone = editTextTel.getText().toString().trim();
                String addr = editTextAddr.getText().toString().trim();
                list.add(new Member(name, email, phone, addr));
                break;
            case R.id.buttonBack2:      //  메인 화면 이동
                layoutMain.setVisibility(View.VISIBLE);
                layoutInput.setVisibility(View.GONE);
                layoutOutput.setVisibility(View.GONE);
                break;
            case R.id.buttonBack3:      //  메인 화면 이동
                layoutMain.setVisibility(View.VISIBLE);
                layoutInput.setVisibility(View.GONE);
                layoutOutput.setVisibility(View.GONE);
                break;
        }

    }
}
