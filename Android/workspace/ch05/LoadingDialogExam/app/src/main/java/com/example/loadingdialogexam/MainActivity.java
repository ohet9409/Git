package com.example.loadingdialogexam;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //  객체 선언
    Button button1, button2, button3;
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  객체 초기화
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        linearLayout = findViewById(R.id.linearLayout);

        //  화면설정(안 보이도록)
        linearLayout.setVisibility(View.GONE);

        //  이벤트 설정
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        linearLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                showLoadingDialog();
                break;
            case R.id.button2:
                showTransitionDialog();
                break;
            case R.id.button3:
                linearLayout.setVisibility(View.VISIBLE);
                break;
            case R.id.linearLayout:
                linearLayout.setVisibility(View.GONE);
                break;
        }
    }
    // 일반적인 로딩창 표시
    private void showLoadingDialog() {
        ProgressDialog dialog = new ProgressDialog(this);
        //  다이얼로그에 표시할 메시지
        dialog.setMessage("잠시만 기다려주세요...");
        //  다이얼로그가 닫힐 경우에 대한 이벤트 정의 (필요에 따라서 사용)
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                Toast.makeText(getApplicationContext(), "로딩이 취소됨...",Toast.LENGTH_SHORT ).show();
            }
        });
        // 다이얼로그 화면에 표시
        dialog.show();
    }
    // 아이폰 스타일의 투명한 로딩창 표시
    private void showTransitionDialog() {
        // 스타일 리소스를 적용한 Dialog 객체
        Dialog dialog = new Dialog(this,R.style.transDialog);
        //  기본값 흰색바탕에 프로그래스바 생성
        //Dialog dialog = new Dialog(this);
        // 프로그래스바 컴포넌트를 레이아웃없이 직접 생성
        ProgressBar progressBar = new ProgressBar(this);
        //  다이얼로그에 프로그래스바 추가
        //  가로, 세로 크기 지정
        dialog.addContentView(progressBar, new AbsListView.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                Toast.makeText(MainActivity.this, "로딩이 취소됨...",Toast.LENGTH_SHORT ).show();
            }
        });
        // 다이얼로그 화면에 표시
        dialog.show();
    }
}
