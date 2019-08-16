package com.example.a1_optionmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "onCreate",Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Toast.makeText(this, "onCreateOptionsMenu",Toast.LENGTH_SHORT).show();
        /*
        public abstract android.view.MenuItem add(int groupId,
                                          int itemId,
                                          int order,
                                          CharSequence title)
         */
        MenuItem item = menu.add(0,1,0,"짜장");
        item.setIcon(R.mipmap.ic_launcher);
        item.setAlphabeticShortcut('a');    // 단축키 설정

        menu.add(0,2,0,"짬뽕").setIcon(R.mipmap.ic_launcher);

        SubMenu etc = menu.addSubMenu("기타");
        etc.add(0,3,0,"우동");
        etc.add(0,4,0,"만두");

        return true;    // 메뉴바를 보여주기 위해 true를 리턴함
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:     // 짜장
                Toast.makeText(this, "짜장은 맛있엉!!",Toast.LENGTH_SHORT).show();
                return true;

            case 2:     // 짬뽕
                Toast.makeText(this, "짬뽕은 얼큰행!!",Toast.LENGTH_SHORT).show();
                return true;

            case 3:     // 우동
                Toast.makeText(this, "우동은 깔끔행!!",Toast.LENGTH_SHORT).show();
                return true;
            case 4:     // 만두
                Toast.makeText(this, "만두는 바싹행!!",Toast.LENGTH_SHORT).show();
                return true;
        }
        return false;  
    }
}
