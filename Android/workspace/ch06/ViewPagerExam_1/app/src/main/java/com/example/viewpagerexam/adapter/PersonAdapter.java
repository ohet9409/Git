package com.example.viewpagerexam.adapter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.viewpagerexam.R;
import com.example.viewpagerexam.model.Person;

import java.util.List;

public class PersonAdapter extends PagerAdapter {
    Activity activity;
    List<Person> list;

    public PersonAdapter(Activity activity, List<Person> list) {
        this.activity = activity;
        this.list = list;
    }
    // 페이지 갯수 리턴
    @Override
    public int getCount() {
        System.out.println("[TEST] getCount() 호출");
        return list.size();
    }
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        System.out.println("[TEST] isViewFromObject() 호출");
        return view.equals(object);
    }
    // 뷰페이저가 만들어졌을 때 호출됨
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        System.out.println("[TEST] instantiateItem() 호출, position = " + position);
        View itemvView = activity.getLayoutInflater().inflate(R.layout.page_item, null);
        final Person person = list.get(position);

        ImageView imageView = itemvView.findViewById(R.id.imageView);
        TextView textView = itemvView.findViewById(R.id.textView);
        Button button = itemvView.findViewById(R.id.button);

        imageView.setImageResource(person.getImage());
        textView.setText(person.getName());

        // 익명 클래스로 이벤트 처리 (버튼을 클릭할 경우)
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + person.getPhone()));
                activity.startActivity(intent);
            }
        });

        // 컨테이너에 추가
        container.addView(itemvView, 0);
        return itemvView;
    }
    // 페이지 삭제
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        System.out.println("[TEST] destroyItem() 호출");
        container.removeView((View) object);
    }
}









