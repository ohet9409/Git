package com.example.miniboard3.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.miniboard3.R;
import com.example.miniboard3.model.Community;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;

import static com.example.miniboard3.R.drawable.ic_stub;

public class CommunityAdapter extends ArrayAdapter<Community> {
    Activity activity;
    int resource;
    ImageLoader imageLoader;
    DisplayImageOptions options;

    public CommunityAdapter(Context context, int resource, List<Community> objects) {
        super(context, resource, objects);
        activity = (Activity) context;
        this.resource = resource;
        ImageLoaderInit();

    }

    private void ImageLoaderInit() {
        //  이미지로더 초기화
        imageLoader = ImageLoader.getInstance();
        //  초기화되지 않을 경우
        if (!imageLoader.isInited()){
            ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(activity);
            imageLoader.init(configuration);
        }
        //  다운로드시 옵션 설정
        DisplayImageOptions.Builder builder = new DisplayImageOptions.Builder();
        builder.showImageOnLoading(ic_stub);
        builder.showImageForEmptyUri(R.drawable.ic_empty);
        builder.showImageOnFail(R.drawable.ic_error);
        options = builder.build();
    }


    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = activity.getLayoutInflater().inflate(resource,null);
        }
        Community item = getItem(position);
        if (item != null){
            ImageView imageView = convertView.findViewById(R.id.imageView);
            TextView textView1 = convertView.findViewById(R.id.textView1);
            TextView textView2 = convertView.findViewById(R.id.textView2);

            imageLoader.displayImage(item.getFilename(), imageView, options);
            textView1.setText(item.getSubject());
            textView2.setText(item.getUser_name()+"/" + item.getEdit_date());
        }
        return convertView;
    }
}
