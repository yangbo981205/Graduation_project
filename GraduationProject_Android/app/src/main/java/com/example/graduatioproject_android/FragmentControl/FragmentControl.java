package com.example.graduatioproject_android.FragmentControl;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.graduatioproject_android.LoginAndRegister.LoginActivity;
import com.example.graduatioproject_android.R;
import com.example.graduatioproject_android.tools.JSONTOOL;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;

import okhttp3.Call;

import static com.example.graduatioproject_android.tools.GlobalVariable.FRAGMENTSELECT;
import static com.example.graduatioproject_android.tools.GlobalVariable.NICKNAME;
import static com.example.graduatioproject_android.tools.GlobalVariable.SERVERIP;
import static com.example.graduatioproject_android.tools.GlobalVariable.USERNAME;

public class FragmentControl extends Fragment {

    private TextView lightControl=null;
    private TextView doorControl=null;
    private TextView windControl=null;
    private TextView alarmControl=null;
    private TextView voiceControl=null;
    private TextView monitorControl=null;
    private MyListener myListener;
    private int controlMessage;

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
                    if(lightControl.isSelected()==false){
                        lightControl.setSelected(true);
                        ControlMessage();
                    }
                    else {
                        lightControl.setSelected(false);
                        ControlMessage();
                    }
                    break;
                case(R.id.doorControl):
                    if(doorControl.isSelected()==false){
                        doorControl.setSelected(true);
                        ControlMessage();
                    }
                    else{
                        doorControl.setSelected(false);
                        ControlMessage();
                    }
                    break;
                case(R.id.windControl):
                    if(windControl.isSelected()==false){
                        windControl.setSelected(true);
                        ControlMessage();
                    }
                    else {
                        windControl.setSelected(false);
                        ControlMessage();
                    }
                    break;
                case(R.id.alarmControl):
                    if(alarmControl.isSelected()==false){
                        alarmControl.setSelected(true);
                        ControlMessage();
                    }
                    else {
                        alarmControl.setSelected(false);
                        ControlMessage();
                    }
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


    /**
     * 向服务器传输控制信息方法
     * */
    private void ControlMessage(){
        controlMessage=0;

        if(lightControl.isSelected()==true){
            controlMessage=controlMessage+1;
        }
        if(doorControl.isSelected()==true){
            controlMessage=controlMessage+2;
        }
        if(windControl.isSelected()==true){
            controlMessage=controlMessage+4;
        }
        if(alarmControl.isSelected()==true){
            controlMessage=controlMessage+8;
        }

        OkHttpUtils.post()
                .url("http://"+SERVERIP+":8080/graduationproject/android/control")
                . addParams("controlMessage", String.valueOf(controlMessage))
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e) {
                        Toast.makeText(getActivity(), "服务器错误，请检查网络连接！", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onResponse(Call call, String s) {
                        Toast.makeText(getActivity(), "控制成功！", Toast.LENGTH_SHORT).show();
                    }
                });

    }

}
