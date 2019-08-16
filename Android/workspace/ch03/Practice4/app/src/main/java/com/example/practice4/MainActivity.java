package com.example.practice4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView;
    Button button1, button2, button3, button4,
            button5, button6, button7, button8,
            button9, button0, buttonPlus, buttonDiv,
            buttonMul, buttonMinus, button21, button22,
            button;
    double num1 = 0.0, num2 = 0.0;
    double result = 0.0;
    String op = null;
    String input = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button21 = findViewById(R.id.button21);
        button22 = findViewById(R.id.button22);
        buttonDiv = findViewById(R.id.buttonDiv);
        buttonMul = findViewById(R.id.buttonMul);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonPlus = findViewById(R.id.buttonPlus);
        button0 = findViewById(R.id.button0);
        textView = findViewById(R.id.textView);

        button.setOnClickListener(this);
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button21.setOnClickListener(this);
        button22.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonMul.setOnClickListener(this);
        buttonDiv.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button0:
                input += "0";
                textView.setText(input);
                break;
            case R.id.button1:
                input += "1";
                textView.setText(input);
                break;
            case R.id.button2:
                input += "2";
                textView.setText(input);
                break;
            case R.id.button3:
                input += "3";
                textView.setText(input);
                break;
            case R.id.button4:
                input += "4";
                textView.setText(input);
                break;
            case R.id.button5:
                input += "5";
                textView.setText(input);
                break;
            case R.id.button6:
                input += "6";
                textView.setText(input);
                break;
            case R.id.button7:
                input += "7";
                textView.setText(input);
                break;
            case R.id.button8:
                input += "8";
                textView.setText(input);
                break;
            case R.id.button9:
                input += "9";
                textView.setText(input);
                break;
            case R.id.buttonDiv:
                num1 = Double.parseDouble(input);
                op = " / ";
                textView.setText(input + op);
                input="";
                break;
            case R.id.buttonPlus:
                num1 = Double.parseDouble(input);
                op = " + ";
                textView.setText(num1 + op);
                input="";
                break;
            case R.id.buttonMinus:
                num1 = Double.parseDouble(input);
                op = " - ";
                textView.setText(num1 + op);
                input="";
                break;
            case R.id.buttonMul:
                num1 = Double.parseDouble(input);
                op = " * ";
                textView.setText(num1 + op);
                input="";
                break;
            case R.id.button:
                num2 = Double.parseDouble(input);
                op = " = ";
                switch (op){
                    case "+":
                        result = num1 + num2;
                        textView.setText( num1 + " + " + num2 + " = " +result);
                        input="0";
                        break;
                }


                break;
        }
    }
}
