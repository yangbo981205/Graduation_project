package com.example.graduatioproject_android.FragmentHome.RecordEnvironment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.graduatioproject_android.R;

import java.util.List;

public class AdapterHumidity extends BaseAdapter {

    private List<DataSet> humidity_data_list;
    private LayoutInflater inflater;
    private TextView humidity_id=null;
    private TextView humidity_time=null;
    private TextView humidity_data=null;

    public AdapterHumidity(List<DataSet> humidity_data_list, Context context){
        this.humidity_data_list=humidity_data_list;
        this.inflater=LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return humidity_data_list.size();
    }

    @Override
    public Object getItem(int position) {
        return humidity_data_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View view = inflater.inflate(R.layout.listview_record,null);
        DataSet temperatureData=(DataSet) getItem(position);

        humidity_id=(TextView)view.findViewById(R.id.ListView_id);
        humidity_time=(TextView)view.findViewById(R.id.ListView_time);
        humidity_data=(TextView)view.findViewById(R.id.ListView_data);

        humidity_id.setText(temperatureData.id);
        humidity_time.setText(temperatureData.time);
        humidity_data.setText(temperatureData.data);

        return view;
    }
}
