package com.example.a4_datepickerdialogexam;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.a4_datepickerdialogexam.helper.DateTimeHelper;

import java.time.Month;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //  변수 선언
    Button button, button2;
    //  상태 유지를 위한 전역변수
    int YEAR =0, MONTH=0, DAY=0;
    int HOUR=0, MINUTE=0, SECOND=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  변수 초기화
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        //  Dialog에 출력하기 위해 현재 시스템 날짜를 구하여 전역변수에 미리 셋팅
        int[] date = DateTimeHelper.getInstance().getDate();
        YEAR =date[0];
        MONTH =date[1];
        DAY =date[2];

        //  Dialog에 출력하기 위해 현재 시스템 시간를 구하여 전역변수에 미리 셋팅
        int[] time = DateTimeHelper.getInstance().getTime();
        HOUR =time[0];
        MINUTE =time[1];

        //  이벤트 설정
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                showDatePickerDialog();
                break;
            case R.id.button2:
                showTimePickerDialog();
                break;
        }
    }
    // 시간 선택 창을 표시한다.
    private void showTimePickerDialog() {
        // 원본 데이터를 백업
        final int temp_hh = HOUR;
        final int temp_mi = MINUTE;
        // TimePickerDialog 객체 생성
        // TimePickerDialog(Context, 이벤트 핸들러, 시, 분, 24시간제 사용여부)
        // 24시간제 사용여부 : true - 24시간제, false - 12시간제 (표시할 경우)
        TimePickerDialog dialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                HOUR = hourOfDay;
                MINUTE = minute;
                button2.setText(HOUR+"시 " + MINUTE+"분");
            }
        }, HOUR, MINUTE, false);
        // 사용자가 Back키나 "취소"를 눌렀을 때, 동작하는 이벤트 정의
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                // 백업해 두었던 값을 복원시킴 : 버전따라 좀 다르기 때문에,
                // 이번 버전에서는 필요없음
                HOUR = temp_hh;
                MINUTE = temp_mi;

                Toast.makeText(getApplicationContext(),"취소",Toast.LENGTH_SHORT).show();
            }
        });
        dialog.setTitle("시간 선택");
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setMessage("약속시간을 선택하세요");
        // back키를 눌러도 뒤로 가지 않게 설정
        dialog.setCancelable(false);
        dialog.show();
    }

    //  날짜 선택 창을 표시한다.
    private void showDatePickerDialog() {
        //  원본 데이터 백업
        final int temp_yy = YEAR;
        final int temp_mm = MONTH;
        final int temp_dd = DAY;

        // DatePickerDialog 객체 생성
        // DatePickerDialog(Context, 이벤트 핸들러, 년, 월, 일)
        //Context에 getApplicationContext()을 사용하면 에러 발생
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            //  dialog에서 사용자가 날짜를 선택하고, "확인" 버튼을 누르면 동작하는 이벤트
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                //  사용자가 선택한 값을 전역변수에 저장
                YEAR = year;
                MONTH = month+1;
                DAY = dayOfMonth;
                button.setText(YEAR+"년 "+MONTH+"월 "+DAY+"일");
            }
        }, YEAR, MONTH-1, DAY);
        // 사용자가 Back키나 "취소"를 눌렀을 때, 동작하는 이벤트 정의
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                // 백업해 두었던 값을 복원시킴 : 버전따라 좀 다르기 때문에,
                // 이번 버전에서는 필요없음
                YEAR = temp_yy;
                MONTH = temp_mm;
                DAY = temp_dd;
                Toast.makeText(getApplicationContext(),"취소",Toast.LENGTH_SHORT).show();
            }
        });
        dialog.setTitle("날짜 선택");
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setMessage("생일을 선택하세요");
        // back키를 눌러도 뒤로 가지 않게 설정
        dialog.setCancelable(false);
        dialog.show();
    }
}
