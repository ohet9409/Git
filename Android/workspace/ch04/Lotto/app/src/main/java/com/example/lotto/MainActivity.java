package com.example.lotto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView1, textView2;
    EditText editText;
    Button button;
    int [] number = new int[6];
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

       button.setOnClickListener(this);

    }
    // 구매횟수 만큼 로또번호 만들기
    public void ran(){
        for (int i=0; i < number.length ; i++){
            number[i] = (int) ((Math.random()*45)+1);
            for (int j=0; j<i; j++){
                if (number[i] == number[j]){
                    i--;
                    break;
                }
            }
        }

    }
    // 로또번호 1세트 오름차순 정렬
    public void array(){
        int temp;
        for (int i =0 ; i<number.length; i++){
            for (int j=0; j<i; j++){
                if (number[i] < number[j]){
                    temp = number[i];
                    number[i] = number[j];
                    number[j] = temp;
                }
            }
        }
    }
    @Override
    public void onClick(View v) {

        String num = editText.getText().toString().trim();
        String result = "";
        System.out.println(num);
        if (!num.equals("") && Integer.parseInt(num) <= 10) {
            for (int j = 0; j < Integer.parseInt(num); j++) {
                ran();
                array();
                for (int i = 0; i < number.length; i++) {
                    result += String.valueOf(number[i]) + " ";
                }
                result += "\n\n";
            }

            textView2.setText(result);
        }

        if(num.equals("")){
            Toast.makeText(this, "구매횟수 입력바람", Toast.LENGTH_SHORT).show();
        } else if (Integer.parseInt(num) > 10  ){
            Toast.makeText(this, "10 이하 정수 입력", Toast.LENGTH_SHORT).show();
        }
    }

}
