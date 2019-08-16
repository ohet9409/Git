package com.example.a2_senderexam;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//  1. 리스너 설정
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //  변수 선언
    EditText editText1, editText2;
    Button button;
    String phoneNo, message;
    //  android.telephony.SmsManager : 문자 메시지 관리 클래스
    SmsManager sms;
    //  눌림 상태 확인 : 여러번 전송되는 것 방지용
    // 눌리면 : true, 아니면 : false
    boolean pressCheck = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 객체 초기화
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        button = findViewById(R.id.button);
        sms = SmsManager.getDefault();

        // 이벤트 설정
        button.setOnClickListener(this);

        //  퍼미션 체크를 먼저 해야한다.
        permissionCheck();

    }
    // 권한 체크
    private void permissionCheck() {
        //  checkSelfPermission : 권한 보유 여부를 확인
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED){
            //  shouldShowRequestPermissionRationale : 사용자가 설명이 필요할 수도 있는 상황을 찾도록 Android에서는 유틸리티 메서드인
            //  shouldShowRequestPermissionRationale()을 제공합니다.
            //  이전에 앱이 이 권한을 요청했고 사용자가 요청을 거부한 경우,
            // 이 메서드는 true를 반환합니다.
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.SEND_SMS)){

            } else {
                // 실제로 권한을 요청하는 동작
                // 여러분의 앱에 필요한 권한이 아직 없는 경우, 앱은 requestPermissions() 메서드 중 하나를 호출하여 적절한 권한을 요청해야 합니다.
                ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.SEND_SMS}, 100);
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                phoneNo = editText1.getText().toString().trim();
                message = editText2.getText().toString().trim();
                break;
        }
    }
    //  HW key를 눌렀을 때, 자동 호출
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_VOLUME_DOWN:      // 볼륨 다운 키
                if (phoneNo.equals("") || message.equals("")){
                    Toast.makeText(this, "전화번호나 메시지가 설정되지 않았습니다.",Toast.LENGTH_SHORT).show();
                    return false;
                }
                if (pressCheck == false){
                    //  문자 발송하기
                    sms.sendTextMessage(phoneNo, null, message, null,null);
                    // 딱 한번만 문자발송을 하기 위해서, 눌림상태를 저장
                    pressCheck = true;
                }
                return true;
            case KeyEvent.KEYCODE_BACK:             //  뒤로가기 키
                finish();
                break;
        }
        return false;
    }

    //  HW key를 뗐을 때, 자동 호출
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        pressCheck = false;
        return true;
    }
}
