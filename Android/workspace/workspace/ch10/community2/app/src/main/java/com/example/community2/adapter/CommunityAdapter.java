package com.example.community2.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.community2.R;
import com.example.community2.helper.PhotoHelper;
import com.example.community2.model.Community;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;

public class CommunityAdapter extends ArrayAdapter<Community> {
    Activity activity;
    int resource;
    ImageLoader imageLoader;
    DisplayImageOptions options;

    public CommunityAdapter( Context context, int resource,  List<Community> objects) {
        super(context, resource, objects);
        activity = (Activity) context;
        this.resource = resource;
        imageLoderInit();
    }

    private void imageLoderInit(){
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
        Community item = getItem(position);
        if (item != null){
            TextView textView1 = convertView.findViewById(R.id.textView1);
            TextView textView2 = convertView.findViewById(R.id.textView2);
            ImageView imageView = convertView.findViewById(R.id.imageView);

            textView1.setText(item.getSubject());
          //  Log.e("[info]",item.getSubject()+"");
            textView2.setText(item.getUser_name()+" / "+ item.getContent());
            imageLoader.displayImage(item.getFilename(),imageView,options);

           // Log.e("[info]",item.getFilename());

        }
        return convertView;
    }
}
