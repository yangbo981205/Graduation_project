package com.example.graduatioproject_android.FragmentHome.RecordEnvironment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.graduatioproject_android.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentTemperature extends Fragment {

    private ListView TemperatureListView=null;
    List<DataSet> temperatureList=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_temperature, null);

        TemperatureListView=(ListView)view.findViewById(R.id.temperature_ListView);

        temperatureList.clear();
        DataSet dataSet=new DataSet("1","temperature","temperature");
        DataSet dataSet1=new DataSet("2","temperature1","temperature1");
        temperatureList.add(dataSet);
        temperatureList.add(dataSet1);

        AdapterTemperature adapterTemperature=new AdapterTemperature(temperatureList,getContext());
        TemperatureListView.setAdapter(adapterTemperature);
        return  view;
    }
}
