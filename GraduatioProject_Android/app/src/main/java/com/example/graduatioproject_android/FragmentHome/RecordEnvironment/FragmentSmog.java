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

public class FragmentSmog extends Fragment {

    private ListView SmogListView=null;
    List<DataSet> smogList=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_smog, null);

        SmogListView=(ListView)view.findViewById(R.id.smog_ListView);

        smogList.clear();
        DataSet dataSet=new DataSet("1","smog","smog");
        DataSet dataSet1=new DataSet("2","smog1","smog1");
        smogList.add(dataSet);
        smogList.add(dataSet1);

        AdapterSmog adapterSmog=new AdapterSmog(smogList,getContext());
        SmogListView.setAdapter(adapterSmog);

        return  view;
    }
}
