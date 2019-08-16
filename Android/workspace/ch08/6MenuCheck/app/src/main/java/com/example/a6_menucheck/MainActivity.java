package com.example.a6_menucheck;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //  객체 선언
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  객체 초기화
        button = findViewById(R.id.button);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d("[INFO]","onCreateOptionsMenu 호출");
        getMenuInflater().inflate(R.menu.menucheck, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        Log.d("[INFO]","onPrepareOptionsMenu 호출");
        if (button.getTextSize() == 60){
            menu.findItem(R.id.bigFont).setChecked(true);
        } else {
            menu.findItem(R.id.bigFont).setChecked(false);
        }

        int color = button.getTextColors().getDefaultColor();
        if (color == Color.RED){
            menu.findItem(R.id.red).setChecked(true);
        }
        if (color == Color.GREEN){
            menu.findItem(R.id.green).setChecked(true);
        }
        if (color == Color.BLUE){
            menu.findItem(R.id.blue).setChecked(true);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.bigFont:
                if (item.isChecked()){
                    button.setTextSize(TypedValue.COMPLEX_UNIT_PX,30);
                } else {
                    button.setTextSize(TypedValue.COMPLEX_UNIT_PX,60);
                }
                return true;
            case R.id.red:
                button.setTextColor(Color.RED);
                return true;
            case R.id.green:
                button.setTextColor(Color.GREEN);
                return true;
            case R.id.blue:
                button.setTextColor(Color.BLUE);
                return true;
        }
        return false;
    }
}
