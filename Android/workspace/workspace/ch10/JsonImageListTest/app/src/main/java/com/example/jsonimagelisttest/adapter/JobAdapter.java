package com.example.jsonimagelisttest.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jsonimagelisttest.R;
import com.example.jsonimagelisttest.model.Job;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;

public class JobAdapter extends ArrayAdapter<Job> {
    Activity activity;
    int resource;
    ImageLoader imageLoader;
    DisplayImageOptions options;

    public JobAdapter(Context context, int resource,  List<Job> objects) {
        super(context, resource, objects);
        activity = (Activity) context;
        this.resource = resource;
        imageLoaderInit();
    }

    private void imageLoaderInit() {
        imageLoader = imageLoader.getInstance();
        if (!imageLoader.isInited()){
            ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(activity);
            imageLoader.init(configuration);
        }
        DisplayImageOptions.Builder builder = new DisplayImageOptions.Builder();
        builder.showImageOnLoading(R.drawable.ic_stub);                             //  다운로드 할 동안 보여줄 그림
        builder.showImageForEmptyUri(R.drawable.ic_empty);                          //  이미지가 지정되지 않은 경우
        builder.showImageOnFail(R.drawable.ic_error);                               //  다운로드 실패시 보여줄 그림
        //  한번 다운받은 파일을 메모리에 보관할 지 여부
        builder.cacheInMemory(true);
        //  한번 다운받은 파일을 Disk에 보관할 지 여부
        builder.cacheOnDisk(true);
        //  Exif 정보를 유지할 지 여부
        builder.considerExifParams(true);
        options = builder.build();
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        if (convertView == null){
            convertView = activity.getLayoutInflater().inflate(resource,null);
        }
        Job item = getItem(position);
        if(item != null){
            ImageView imageView = convertView.findViewById(R.id.imageView);
            TextView textView1 = convertView.findViewById(R.id.textView1);
            TextView textView2 = convertView.findViewById(R.id.textView2);

            imageLoader.displayImage(item.getImg(),imageView,options);
            textView1.setText(item.getSubject());
            textView2.setText(item.getContent());
        }
        return convertView;
    }
}
