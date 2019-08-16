package com.example.a2_singlechoicedialogexam;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button, button2;
    // 팝업창에 표시될 문자열 목록
    String[] items = {"선택항목1", "선택항목2", "선택항목3"};
    //  선택 상태를 관리하기 위한 전역변수
    int checkedItem = 0;    //  SingleChoice 용
    boolean[] checkedItems = {false,false,false};   // MultiChoice용

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button.setOnClickListener(this);

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                showSingleChoiceDialog();
                break;
            case R.id.button2:
                showMultiChoiceDialog();
                break;
        }
    }
    // 체크박스를 포함한 리스트 다이얼로그 표시
    private void showMultiChoiceDialog(){
        // 이전 선택값을 임시로 백업한다.
        final boolean[] temp = new boolean[checkedItems.length];
        System.arraycopy(checkedItems, 0,temp,0 , checkedItems.length);
        //for (int i=0; i<checkedItems.length; i++){    //  와 동일 동작
        //    temp[i] = checkedItems[i];
        //}
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("확인");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setCancelable(false);
        //  체크박스를 포함한 리스트의 등록과 이벤트 처리
        //  setMultiChoiceItems(문자열 배열, boolean 배열, 이벤트)
        builder.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                //  상태 유지를 위한 전역변수에 사용자가 선택한 상태 반영
                checkedItems[which] = isChecked;
            }
        });
        //  OK 버튼 추가
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 체크 박스의 결과를 출력할 문자열
                String result = "";
                for (int i=0; i<checkedItems.length; i++){
                    if (checkedItems[i]){
                        result += items[i] + " ";
                    }
                }
                Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
            }
        });
        //  CANCEL 버튼 추가
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //  백업한 값을 복원시킴
                System.arraycopy(temp, 0, checkedItems, 0, temp.length);
            }
        });
        //  설정한 정보로 창을 생성
        AlertDialog dialog = builder.create();
        //  창을 화면에 표시
        dialog.show();
    }
    // 라디오 버튼을 포함한 리스트 다이얼로그 표시
    private void showSingleChoiceDialog() {
        // 이전 선택값을 임시로 백업한다.
        final int temp = checkedItem;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("확인");
        builder.setIcon(android.R.drawable.star_on);
        builder.setCancelable(false);
        // items : 목록으로 출력될 문자열 배열
        // checkedItem : 라이오버튼 선택 번호 => 이전 상태값 저장
        builder.setSingleChoiceItems(items, checkedItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,items[which]+"가 눌렸습니다.", Toast.LENGTH_SHORT).show();
                // checkedItem에 사용자가 선택한 값을 저장
                checkedItem = which;
            }
        });
        // "OK" 버튼 추가
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, items[checkedItem], Toast.LENGTH_SHORT).show();
            }
        });
        // "CANCEL" 버튼 추가
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 백업한 값을 되돌려 놓는다.
                checkedItem = temp;
            }
        });
        // 설정한 정보로 창을 생성
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
