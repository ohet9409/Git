package com.example.a2_optionmenuxml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // 타이틀바에 메뉴 추가 : 리턴값 true : 메뉴 표시, false : 메뉴 표시 안됨
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.jjajang:
                Toast.makeText(this,"짜장은 맛있엉", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.jjambbong:
                Toast.makeText(this,"짬뽕은 얼큰행", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.udong:
                Toast.makeText(this,"우동은 깔끔행", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mando:
                Toast.makeText(this,"만두는 바싹행", Toast.LENGTH_SHORT).show();
                return true;

        }
        return false;
    }
}
