package com.example.a3_menuonclick;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option,menu);
        return true;
    }

    //  onOptionsItemSelectec() 메소드 대신 사용
    public void onMenuClick(MenuItem item){
        switch (item.getItemId()){
            case R.id.about:
                Toast.makeText(this, "onClick 속성으로 메뉴 이벤트 처리", Toast.LENGTH_SHORT).show();
                break;
            case R.id.help:
                Toast.makeText(this, "도움말 입니다.", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
