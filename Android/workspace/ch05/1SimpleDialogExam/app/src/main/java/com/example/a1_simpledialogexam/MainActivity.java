package com.example.a1_simpledialogexam;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

//  1. 리스너 설정
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //  2. 객체 선언
    Button button1, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  3. 객체 초기화
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        //  4. 이벤트 설정
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                showAlertDialog();
                break;
            case R.id.button2:
                showConfirmDialog();
                break;
            case R.id.button3:
                showListtDialog();
                break;
        }
    }
    //  기본 알림창을 화면에 표시한다.
    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // 제목 설정
        builder.setTitle("알림");
        // 내용 설정
        builder.setMessage("알림 대화상자 입니다.");
        // 아이콘 이미지 설정
        builder.setIcon(R.mipmap.ic_launcher);
        // 하드웨어 BackKey가 눌렸을 때, 창이 닫히지 않도록 설정
        builder.setCancelable(false);
        // 확인 버튼의 추가 및 이벤트 설정
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"확인을 눌렀습니다.",Toast.LENGTH_SHORT).show();
            }
        });
        // 설정한 정보로 Dialog 생성
        AlertDialog dialog = builder.create();
        // Dialog를 화면에 표시
        dialog.show();

    }

    private void showConfirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("확인");
        builder.setMessage("확인 대화상자 입니다.");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setCancelable(false);
        // 긍정 버튼 추가 및 이벤트 설정(왼쪽 위치)
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "OK를 눌렀습니다.",Toast.LENGTH_SHORT).show();
            }
        });
        // 부정 버튼 추가 및 이벤트 설정(오른쪽 위치)
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"CANCEL을 눌렀습니다.", Toast.LENGTH_SHORT).show();
            }
        });
        // 중립 버튼 추가 및 이벤트 설정(왼쪽 끝 위치)
        builder.setNeutralButton("보류", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"보류를 눌렀습니다.", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    //  목록 선택창을 화면에 표시
    /*
        ListDialog는 팝업창에 긍정버튼 대신, 리스트를 포함하는 형태,
        리스트 자체가 긍정의 의미를 하므로, 별도의 확인버튼은 필요없다.
        setCancelable(false)를 설정하면, 취소버튼을 포함시켜야만 선택항목 없이 창을 닫을 수 있기 때문에,
        부정의 의미를 갖는 버튼만 포함한 상태로 다이얼로그를 준비한다.
        주의!!
        setMessage(String) 메소드는 사용하면 안된다.
        사용할 경우, 리스트가 표시되지 않는다.
     */
    private void showListtDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("확인");
       // builder.setMessage("TEST");
       // builder.setIcon(R.mipmap.ic_launcher);
        builder.setIcon(android.R.drawable.star_big_on);
        builder.setCancelable(false);
        // 리스트에 출력할 문자열 배열
        final String[] items = {"축구", "배구", "농구"};
        // 리스트 : 긍정버튼의 역할
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, items[which] + "가 눌렸습니다.", Toast.LENGTH_LONG).show();
            }
        });
        // 분정의 의미를 갖는 버튼
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"CANCEL을 눌렀습니다." ,Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
