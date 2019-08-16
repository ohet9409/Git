package com.example.a5_nohistory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                finish();   //  현재 Activity 종료
                            //  History stack에는 SecondActivity 정보는 저장되어 있지 않음.
                            //  따라서, 화면은 MainActivity로 되돌아 간다.
                break;
        }
    }
}
