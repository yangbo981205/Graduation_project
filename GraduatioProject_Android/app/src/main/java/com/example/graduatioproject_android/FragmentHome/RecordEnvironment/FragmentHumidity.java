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

public class FragmentHumidity extends Fragment {

    private ListView HumidityListView=null;
    List<DataSet> humidityList=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_humidity, null);

        HumidityListView=(ListView)view.findViewById(R.id.humidity_ListView);

        humidityList.clear();
        DataSet dataSet=new DataSet("1","humidity","humidity");
        DataSet dataSet1=new DataSet("2","humidity1","humidity1");
        humidityList.add(dataSet);
        humidityList.add(dataSet1);

        AdapterHumidity adapterHumidity=new AdapterHumidity(humidityList,getContext());
        HumidityListView.setAdapter(adapterHumidity);

        return  view;
    }
}
