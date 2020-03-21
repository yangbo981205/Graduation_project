package com.example.graduatioproject_android.FragmentHome.RecordEnvironment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.graduatioproject_android.R;

import java.util.List;

public class AdapterSmog extends BaseAdapter {

    private List<DataSet> smog_data_list;
    private LayoutInflater inflater;
    private TextView smog_id=null;
    private TextView smog_time=null;
    private TextView smog_data=null;

    public AdapterSmog(List<DataSet> smog_data_list, Context context){
        this.smog_data_list=smog_data_list;
        this.inflater=LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return smog_data_list.size();
    }

    @Override
    public Object getItem(int position) {
        return smog_data_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View view = inflater.inflate(R.layout.listview_record,null);
        DataSet temperatureData=(DataSet) getItem(position);

        smog_id=(TextView)view.findViewById(R.id.ListView_id);
        smog_time=(TextView)view.findViewById(R.id.ListView_time);
        smog_data=(TextView)view.findViewById(R.id.ListView_data);

        smog_id.setText(temperatureData.id);
        smog_time.setText(temperatureData.time);
        smog_data.setText(temperatureData.data);
        return view;
    }
}
