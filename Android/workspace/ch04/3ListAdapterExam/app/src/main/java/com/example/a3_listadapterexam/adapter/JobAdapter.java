package com.example.a3_listadapterexam.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a3_listadapterexam.R;
import com.example.a3_listadapterexam.model.Job;

import java.util.List;

public class JobAdapter extends ArrayAdapter<Job> {
    Activity activity;      // 화면을 관리하는 객체에 대한 참조 객체 선언
    int resource;           // 한줄 모양을 담당하기 위한 Layout XML파일을 의미하는 리소스 아이디값

    /**
     * MainActivity로부터 전달받는다.
     * @param context       : Activity 객체
     * @param resource      : list_item.xml 파일의 id
     * @param objects       : List 객체
     */
    public JobAdapter(Context context, int resource,  List<Job> objects) {
        super(context, resource, objects);      // 절대 지우면 안됨
        activity = (Activity) context;
        this.resource = resource;
    }

    /**
     * ListView에 의해 호출되는 메소드
     * List에 저장된 한 줄 데이터(자바빈즈)를 꺼내서, 레이아웃에 맵핑한 후,
     * ListView에게 리턴해 준다.
     * @param position          : List 클래스의 몇번째 항목인 지를 의미하는 인덱스값
     * @param convertView       : 앞서 전달받았던 레이아웃 객체, 최초 호출시에는 null이지만
     *                              이후 호출될 때마다 이전에 리턴받았던 View를 이 파라미터를 통해서 되돌려준다.
     * @param parent            : ListView
     * @return View             : 한 줄의 모양을 정의한 레이아웃에 자바빈즈값을 맵핑하여 리턴
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        System.out.println("position = " + position);
       //   ListView에게 되돌려 받은 레이아웃 객체
        View itemView = convertView;
        // 최초 호출시에는 null이므로, 생성자의 파라미터로 전달받은 xml 파일의 아이디값을
        // 사용하며 레이아웃을 생성한다.
        if (itemView == null){
            //  1. 1줄화면 객체 만들기
            //  list_item.xml에 설정된 대로 클래스를 만들어서,
            //  전체를 View 클래스로 리턴
            itemView = activity.getLayoutInflater().inflate(resource, null);
        }
        //  2. 전달받은 List로 부터 데이터를 하나 꺼낸다.
        Job item = getItem(position);
        //  3. 데이터가 존재한다면, itemView에 포함된 컴포넌트들에게 데이터를 출력한다.
        //  itemView = 컴포넌트 클래스(화면을 꾸며주는 클래스) + 데이터
        if (item != null){
            ImageView imageView = itemView.findViewById(R.id.imageView);
            TextView textView1 = itemView.findViewById(R.id.textView1);
            TextView textView2 = itemView.findViewById(R.id.textView2);

            imageView.setImageResource(item.getImage());
            textView1.setText(item.getTtitle());
            textView2.setText(item.getDescription());
        }
        //  4. 1줄화면을 되돌려줌
        return  itemView;
    }
}
