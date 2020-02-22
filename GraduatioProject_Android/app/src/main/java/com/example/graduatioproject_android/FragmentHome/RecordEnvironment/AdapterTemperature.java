package com.example.graduatioproject_android.FragmentHome.RecordEnvironment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.graduatioproject_android.R;

import java.util.List;

public class AdapterTemperature extends BaseAdapter {

    private List<DataSet> temperature_data_list;
    private LayoutInflater inflater;
    private TextView temperature_id=null;
    private TextView temperature_time=null;
    private TextView temperature_data=null;

    public AdapterTemperature(List<DataSet> temperature_data_list, Context context){
        this.temperature_data_list=temperature_data_list;
        this.inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return temperature_data_list.size();
    }

    @Override
    public Object getItem(int position) {
        return temperature_data_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View view = inflater.inflate(R.layout.listview_record,null);
        DataSet temperatureData=(DataSet) getItem(position);

        temperature_id=(TextView)view.findViewById(R.id.ListView_id);
        temperature_time=(TextView)view.findViewById(R.id.ListView_time);
        temperature_data=(TextView)view.findViewById(R.id.ListView_data);

        temperature_id.setText(temperatureData.id);
        temperature_time.setText(temperatureData.time);
        temperature_data.setText(temperatureData.data);

        return view;
    }
}
