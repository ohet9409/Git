package com.example.basic1exam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // 화면을 꾸미는 클래스 선언
    LinearLayout linearLayout;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        setContentView(linearLayout);
    }
    private void init(){
        linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        textView = new TextView(this);
        textView.setText("Hello Android!!");
        textView.setTextSize(30);
        linearLayout.addView(textView);

        // 컴포넌트 : 화면을 꾸며주는 클래스
        // LinearLayout.LayoutParams : 컴포넌트들의 가로, 세로 길이를 지정하는 클래스
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                // 가로
                ViewGroup.LayoutParams.MATCH_PARENT,
                // 세로
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        button = new Button(this);
        button.setText("확인");
        button.setTextSize(30);
        button.setLayoutParams(params);
        linearLayout.addView(button);
    }
}
