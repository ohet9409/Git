package com.example.practice2.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.practice2.R;
import com.example.practice2.model.Image;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;

public class ImageAdapter extends ArrayAdapter<Image> {
    // 객체 선언
    Activity activity;
    int resource;
    ImageLoader imageLoader;
    DisplayImageOptions options;

    public ImageAdapter(Context context, int resource, List<Image> objects) {
        super(context, resource, objects);
        activity = (Activity) context;
        this.resource = resource;
        imageLoaderInit();
    }

    private void imageLoaderInit() {
        // 이미지 로드 초기화
        imageLoader = ImageLoader.getInstance();
        if(!imageLoader.isInited()){
            ImageLoaderConfiguration configuration =
                    ImageLoaderConfiguration.createDefault(activity);
            imageLoader.init(configuration);
        }
        // 옵션 생성
        DisplayImageOptions.Builder builder = new DisplayImageOptions.Builder();
        builder.showImageOnLoading(R.drawable.ic_stub);
        builder.showImageForEmptyUri(R.drawable.ic_empty);
        builder.showImageOnFail(R.drawable.ic_error);
        builder.cacheInMemory(true);
        builder.cacheOnDisk(true);
        builder.considerExifParams(true);
        options = builder.build();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = activity.getLayoutInflater().inflate(resource, null);
        }
        Image item = getItem(position);
        if (item != null) {
            ImageView imageView = convertView.findViewById(R.id.imageView);
            TextView textView1 = convertView.findViewById(R.id.textView1);
            TextView textView2 = convertView.findViewById(R.id.textView2);

            imageLoader.displayImage(item.getThumbnail_url(), imageView, options);
            textView1.setText(item.getDisplay_sitename());
            textView2.setText(item.getWidth() + "x" + item.getHeight());
        }
        return convertView;
    }
}
