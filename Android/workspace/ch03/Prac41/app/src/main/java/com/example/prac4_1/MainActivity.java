package com.example.prac4_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

// 1. 리스너 설정
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //  2. 객체 선언
    TextView textView;
    Button button0, button1, button2, button3, button4;
    Button button5, button6, button7, button8, button9;
    Button buttonAdd, buttonSub, buttonMul, buttonDiv, buttonTog;
    Button buttonDot, buttonEql, buttonC;

    // 계산 처리용 변수
    String input="";            // 입력값 저장
    boolean positive = true;    // 음수, 양수 판단용
    double num1=0, num2=0, result=0;
    String op = "";             // 연산자 저장

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 객체 초기화
        textView = findViewById(R.id.textView);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonMul = findViewById(R.id.buttonMul);
        buttonDiv = findViewById(R.id.buttonDiv);
        buttonSub = findViewById(R.id.buttonSub);
        buttonTog = findViewById(R.id.buttonTog);
        buttonDot = findViewById(R.id.buttonDot);
        buttonEql = findViewById(R.id.buttonEql);
        buttonC = findViewById(R.id.buttonC);
        // 4. 이벤트 설정
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8 .setOnClickListener(this);
        button9 .setOnClickListener(this);
        buttonAdd.setOnClickListener(this);
        buttonMul.setOnClickListener(this);
        buttonDiv .setOnClickListener(this);
        buttonSub.setOnClickListener(this);
        buttonTog .setOnClickListener(this);
        buttonDot.setOnClickListener(this);
        buttonEql.setOnClickListener(this);
        buttonC.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button0:
                input += "0";

                break;
            case R.id.button1:
                input += "1";

                break;
            case R.id.button2:
                input += "2";

                break;
            case R.id.button3:
                input += "3";

                break;
            case R.id.button4:
                input += "4";

                break;
            case R.id.button5:
                input += "5";

                break;
            case R.id.button6:
                input += "6";

                break;
            case R.id.button7:
                input += "7";

                break;
            case R.id.button8:
                input += "8";

                break;
            case R.id.button9:
                input += "9";

                break;
            case R.id.buttonDiv:
            case R.id.buttonMul:
            case R.id.buttonSub:
            case R.id.buttonAdd:
                if (input.equals("")){
                    Toast.makeText(this,"입력된 값이 없습니다.",Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    num1 = Double.parseDouble(input);
                    input = ""; // 초기화
                }
                switch (v.getId()){
                    case R.id.buttonAdd: op="+"; break;
                    case R.id.buttonSub: op="-"; break;
                    case R.id.buttonMul: op="*"; break;
                    case R.id.buttonDiv: op="/"; break;
                }
                break;
            case R.id.buttonTog:
                if (positive){  // 양수이면 음수로
                    positive = false;
                    input = "-" + input;
                } else {    // 음수이면 양수로
                    positive = true;
                    input = input.substring(1); // - 부분을 잘라냄
                }
                break;
            case R.id.buttonDot:
                input += ".";
                break;
            case R.id.buttonEql:
                if (input.equals("")){
                    Toast.makeText(this,"입력된 값이 없습니다.",Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    num2 = Double.parseDouble(input);
                    switch (op) {
                        case "+":
                            result = num1 + num2;
                            break;
                        case "-":
                            result = num1 - num2;
                            break;
                        case "/":
                            result = num1 / num2;
                            break;
                        case "*":
                            result = num1 * num2;
                            break;
                    }

                }
                textView.setText(String.valueOf(result));
                // 모든 변수 초기화
                input = "";
                num1 = num2 = result=0;
                positive = true;
                return;
            case R.id.buttonC :
                // 모든 변수 초기화
                input = "";
                num1 = num2 = result=0;
                positive = true;
                textView.setText("0");
                return;
        }
        textView.setText(input);
    }
}
