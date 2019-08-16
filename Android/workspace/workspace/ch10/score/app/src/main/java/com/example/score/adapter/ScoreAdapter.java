package com.example.score.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.score.R;
import com.example.score.model.Score;

import java.util.List;

public class ScoreAdapter extends ArrayAdapter<Score> {
    Activity activity;
    int resource;

    public ScoreAdapter( Context context, int resource,  List<Score> objects) {
        super(context, resource, objects);
        activity = (Activity) context;
        this.resource = resource;
    }


    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = activity.getLayoutInflater().inflate(resource,null);
        }
        Score item = getItem(position);
        if (item != null){
            TextView textView1 = convertView.findViewById(R.id.textView1);
            TextView textView2 = convertView.findViewById(R.id.textView2);
            Log.e("[ERROR]","test2" + item.getAvg());
            textView1.setText("학번 : " +item.getStudNo() + " /  이름 : " + item.getName());
            textView2.setText("국어: " + item.getKor() + " 영어: " + item.getEng() + " 수학: " +item.getMat()+" 총점: " + item.getTot()+" 평균: " +item.getAvg());
        }
        return convertView;
    }
}
