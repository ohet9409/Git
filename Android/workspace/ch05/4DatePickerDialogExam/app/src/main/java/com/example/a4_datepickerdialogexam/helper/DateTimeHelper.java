package com.example.a4_datepickerdialogexam.helper;


import java.util.Calendar;

public class DateTimeHelper {
    //  싱글톤 패턴 시작
    private static DateTimeHelper Instance = null;

    public static DateTimeHelper getInstance(){
        if (Instance == null){
            Instance = new DateTimeHelper();

        }
        return Instance;
    }
    private DateTimeHelper(){}
    //  싱글톤 패턴 끝
    /* 현재 날짜를 배열로 리턴*/
    public int[] getDate(){
        Calendar calendar = Calendar.getInstance();
        int yy = calendar.get(Calendar.YEAR);
        int mm = calendar.get(Calendar.MONTH)+1;
        int dd = calendar.get(Calendar.DAY_OF_MONTH);
        int[] result = {yy, mm, dd};
        return result;
    }
    /* 현재 시간을 배열로 리턴 */
    public  int[] getTime(){
        Calendar calendar = Calendar.getInstance();
        int hh = calendar.get(Calendar.HOUR_OF_DAY);
        int mi = calendar.get(Calendar.MINUTE);
        int ss = calendar.get(Calendar.SECOND);
        int[] result = {hh, mi, ss};
        return result;
    }
}
