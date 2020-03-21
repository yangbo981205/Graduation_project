package com.example.graduatioproject_android.FragmentControl;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.graduatioproject_android.R;

import org.w3c.dom.Text;

public class FragmentControl extends Fragment {

    private TextView lightControl=null;
    private TextView doorControl=null;
    private TextView windControl=null;
    private TextView alarmControl=null;
    private TextView voiceControl=null;
    private TextView monitorControl=null;
    private MyListener myListener;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_control, null);

        lightControl=(TextView)view.findViewById(R.id.lightControl);
        doorControl=(TextView)view.findViewById(R.id.doorControl);
        windControl=(TextView)view.findViewById(R.id.windControl);
        alarmControl=(TextView)view.findViewById(R.id.alarmControl);
        voiceControl=(TextView)view.findViewById(R.id.voiceControl);
        monitorControl=(TextView)view.findViewById(R.id.monitorControl);
        myListener=new MyListener();

        lightControl.setOnClickListener(myListener);
        doorControl.setOnClickListener(myListener);
        windControl.setOnClickListener(myListener);
        alarmControl.setOnClickListener(myListener);
        voiceControl.setOnClickListener(myListener);
        monitorControl.setOnClickListener(myListener);
        return  view;
    }

    private class MyListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case(R.id.lightControl):
                    if(lightControl.isSelected()==false)lightControl.setSelected(true);
                    else lightControl.setSelected(false);
                    break;
                case(R.id.doorControl):
                    if(doorControl.isSelected()==false)doorControl.setSelected(true);
                    else doorControl.setSelected(false);
                    break;
                case(R.id.windControl):
                    if(windControl.isSelected()==false)windControl.setSelected(true);
                    else windControl.setSelected(false);
                    break;
                case(R.id.alarmControl):
                    if(alarmControl.isSelected()==false)alarmControl.setSelected(true);
                    else alarmControl.setSelected(false);
                    break;
                case(R.id.voiceControl):
                    Intent jumpIntent_voice=new Intent(getActivity(), VoiceControlActivity.class);
                    startActivity(jumpIntent_voice);
                    break;
                case(R.id.monitorControl):
                    Intent jumpIntent_monitor=new Intent(getActivity(), MonitorControlActivity.class);
                    startActivity(jumpIntent_monitor);
                    break;
                default:
                    break;
            }
        }
    }
}
