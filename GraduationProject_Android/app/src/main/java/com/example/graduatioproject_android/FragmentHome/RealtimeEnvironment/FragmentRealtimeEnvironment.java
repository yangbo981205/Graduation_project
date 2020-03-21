package com.example.graduatioproject_android.FragmentHome.RealtimeEnvironment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.graduatioproject_android.R;

public class FragmentRealtimeEnvironment extends Fragment {

    private TextView SmokeScope=null;
    private LinearLayout Temperature_C=null;
    private LinearLayout Temperature_F=null;
    private TextView Temperature_Text=null;
    private TextView Humidity_Text=null;
    private TextView Change=null;
    private ProgressBar Progress_T=null;
    private ProgressBar Progress_H=null;
    private MyListener myListener=null;
    private Boolean SETVISIBLE=true;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_realtime_environment, null);

        SmokeScope=(TextView) view.findViewById(R.id.smoke_scope);
        Temperature_Text=(TextView) view.findViewById(R.id.temperature_text);
        Humidity_Text=(TextView) view.findViewById(R.id.humidity_text);
        Change=(TextView) view.findViewById(R.id.changeBtn);
        Progress_T=(ProgressBar) view.findViewById(R.id.progress_temperature);
        Progress_H=(ProgressBar) view.findViewById(R.id.progress_humidity);
        Temperature_C=(LinearLayout) view.findViewById(R.id.temperature_c);
        Temperature_F=(LinearLayout) view.findViewById(R.id.temperature_f);

        TemperatureSet(true);

        myListener=new MyListener();
        Change.setOnClickListener(myListener);

        return  view;
    }


    /**
     * 事件监听
     * */
    private class MyListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case(R.id.changeBtn):
                    if(SETVISIBLE==true){
                        SETVISIBLE=false;
                        TemperatureSet(SETVISIBLE);
                    }else{
                        SETVISIBLE=true;
                        TemperatureSet(SETVISIBLE);
                    }
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * 温度显示方法
     * */
    private void TemperatureSet(boolean b){
        if(b==true){
            Temperature_C.setVisibility(View.VISIBLE);
            Temperature_Text.setText("----℃");
            Temperature_F.setVisibility(View.INVISIBLE);
        }else{
            Temperature_F.setVisibility(View.VISIBLE);
            Temperature_Text.setText("----℉");
            Temperature_C.setVisibility(View.INVISIBLE);
        }
    }
}
