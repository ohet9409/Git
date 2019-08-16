package com.example.practice2.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.practice2.R;
import com.example.practice2.model.Job;

import java.util.List;

public class JobAdapter extends PagerAdapter {
    private Activity activity;
    private List<Job> list;

    public JobAdapter(Activity activity, List<Job> list) {
        this.activity = activity;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    // adapter.add 를 사용할것이기 때문에
    public void add(Job job){
         list.add(job);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    // page_item.xml에 설정된 대로 화면만들고, 데이터 채우기
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        //  page_item.xml에 설정된 대로 화면만들고 (객체화)
        View itemView = activity.getLayoutInflater().inflate(R.layout.page_item,null);
        //  list에서 데이터 한개 꺼내기
        Job item = list.get(position);
        //  화면 결합 : 화면 + 데이터
        TextView textView1 = itemView.findViewById(R.id.textView1);
        TextView textView2 = itemView.findViewById(R.id.textView2);
        ImageView imageView = itemView.findViewById(R.id.imageView);

        textView1.setText(item.getTitle());
        textView2.setText(item.getDescription());
        imageView.setImageResource(item.getImage());

        container.addView(itemView, 0);
        return itemView;
    }

    //  화면 없애기
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
