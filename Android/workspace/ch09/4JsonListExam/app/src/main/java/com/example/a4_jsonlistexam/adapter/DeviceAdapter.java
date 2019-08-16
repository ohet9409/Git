package com.example.a4_jsonlistexam.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.a4_jsonlistexam.R;
import com.example.a4_jsonlistexam.model.Device;

import java.util.List;

public class DeviceAdapter extends ArrayAdapter<Device> {
    Activity activity;  // MainActivity 객체 : Inflater를 얻어오기 위해서
    int resource;       // R.layout.list_item.xml의 아이디 저장

    public DeviceAdapter(Context context, int resource, List<Device> objects) {
        super(context, resource, objects);
        activity = (Activity) context;
        this.resource = resource;
    }

    /**
     * ListView에 의해서 호출되는 메소드
     * List안에 저장된 데이터 중에서, 한줄에 대한 Beans를 추출하여 레이아웃에 맵핑한 후,
     * ListView에게 리턴한다.
     * @param position      : 리스트의 몇번째 항목인 지를 의미하는 인덱스 값
     * @param convertView   : 앞서 전달받았던 레이아웃 객체
     *                         최초 호출시에는 null이지만, 이후 호출될때마다 이전에 리턴받았던
     *                         View를 이 파라미터를 통해서 되돌려 준다.
     * @param parent        : ListView (사용안함)
     * @return View         : 한줄의 모양을 정의한 레이아웃에 Beans 데이터를 맵핑하여 리턴
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 최초 호출시에는 null 이므로, 생성자의 파라미터로 전달받은 리소스 아이디값을 사용하여
        // 레이아웃을 Inflater 객체를 통해서 생성한다.
        if(convertView == null) {
            convertView = activity.getLayoutInflater().inflate(resource, null);
        }
        // 전달받은 List에서 데이터를 하나 꺼낸다.
        Device item = getItem(position);
        // 데이터가 존재하면, 레이아웃 객체에 포함된 컴포넌트들에게 데이터를 세팅한다.
        if(item != null) {
            TextView textView1 = convertView.findViewById(R.id.textView1);
            TextView textView2 = convertView.findViewById(R.id.textView2);

            textView1.setText(item.getName());
            textView2.setText(item.getType());
        }
        return convertView;
    }
}







