package com.example.a5_popupmenutest;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener, View.OnClickListener {
    //  객체 선언
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  객체 초기화
        button = findViewById(R.id.button);
        //  이벤트 설정
        button.setOnClickListener(this);
        button.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this,"버튼 눌림",Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onLongClick(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        Menu menu = popupMenu.getMenu();
        popupMenu.getMenuInflater().inflate(R.menu.popupmenu,menu);

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.back_red:
                        button.setBackgroundColor(Color.RED);
                        return true;
                    case R.id.back_green:
                        button.setBackgroundColor(Color.GREEN);
                        return true;
                    case R.id.back_blue:
                        button.setBackgroundColor(Color.BLUE);
                        return true;
                    case R.id.text_black:
                        button.setTextColor(Color.BLACK);
                        return true;
                    case R.id.text_white:
                        button.setTextColor(Color.WHITE);
                        return true;
                    case R.id.text_gray:
                        button.setTextColor(Color.GRAY);
                        return true;
                }
                return false;
            }
        });
        return true;
    }
}
