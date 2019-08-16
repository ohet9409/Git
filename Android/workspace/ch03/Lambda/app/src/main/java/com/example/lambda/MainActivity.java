package com.example.lambda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

interface  Calcurate {
    int operation(int a, int b);
}

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
        Calcurate calcurate = new Calcurate(){

            @Override
            public int operation(int a, int b) {
                return a+b;
            }
        };
        Toast.makeText(this,String.valueOf(calcurate.operation(100,200)), Toast.LENGTH_SHORT).show();

        // 람다 표현식 사용1        매개변수            리턴 값
         Calcurate calcurate11 = (int a, int b) -> {return a+b; };
        Toast.makeText(this,String.valueOf(calcurate11.operation(200,200)), Toast.LENGTH_SHORT).show();
        // 람다 표현식 사용1-1        매개변수            리턴 값
        Calcurate calcurate11_1 = (a,  b) -> {return a+b; };
        Toast.makeText(this,String.valueOf(calcurate11.operation(200,200)), Toast.LENGTH_SHORT).show();

        // 람다 표현식 사용 2
         Calcurate calcurate2 = (int a, int b) -> a+b;
        Toast.makeText(this,String.valueOf(calcurate2.operation(300,200)), Toast.LENGTH_SHORT).show();

        // 람다 표현식 사용 3
         Calcurate calcurate3 = (a, b) -> a + b;
        Toast.makeText(this,String.valueOf(calcurate3.operation(400,200)), Toast.LENGTH_SHORT).show();

        // 람다 표현식 사용 4
        // Toast.makeText(this,String.valueOf((Calcurate)(a, b) -> {return a+b;}).operation(300,200))
    }
}
