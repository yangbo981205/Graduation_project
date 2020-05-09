package com.example.graduatioproject_android.FragmentHome.RealtimeEnvironment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.graduatioproject_android.LoginAndRegister.LoginActivity;
import com.example.graduatioproject_android.R;
import com.example.graduatioproject_android.tools.JSONTOOL;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import okhttp3.Call;

import static com.example.graduatioproject_android.tools.GlobalVariable.SERVERIP;
import static com.example.graduatioproject_android.tools.GlobalVariable.environmentMap;

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
    private String temperature;
    private String progressBarTemperature;
    private String humidity;
    private String progressBarHumidity;
    private String smokescope;


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

        Temperature_F.setVisibility(View.INVISIBLE);

        Timer timer=new Timer();
        timer.schedule(new TimerTask(){
            @Override
            public void run() {
                getData();

            }
        }, 0,10000);

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
            Temperature_Text.setText(temperature+"℃");
            Progress_T.setProgress(Integer.parseInt(progressBarTemperature)+25);
            Temperature_F.setVisibility(View.INVISIBLE);
        }else{
            Temperature_F.setVisibility(View.VISIBLE);
            String setData=String.valueOf(Integer.parseInt(progressBarTemperature)*1.8+32);
            if(setData.length()>6){setData=setData.substring(0,5);}
            Temperature_Text.setText(setData+"℉");
            Progress_T.setProgress((int) (((Integer.parseInt(progressBarTemperature)+5)*1.8+32)/2));
            Temperature_C.setVisibility(View.INVISIBLE);
        }
    }


    /**
     * 从服务器获取数据
     * */
    private void getData(){
        OkHttpUtils.post()
                .url("http://"+SERVERIP+":8080/graduationproject/android/environment")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e) {
                        Toast.makeText(getActivity(), "服务器错误，请检查网络连接！", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(Call call, String s) {
                        environmentMap= JSONTOOL.analyze_some_json("["+s+"]");
                        List<HashMap<String,String>> map = JSONTOOL.analyze_some_json(environmentMap.get(0).get("result"));
                        temperature=map.get(0).get("temperature");
                        humidity=map.get(0).get("humidity");
                        smokescope=map.get(0).get("smokescope");

                        SmokeScope.setText(smokescope+"ppm");

                        progressBarTemperature=temperature.substring(0,temperature.indexOf("."));
                        progressBarHumidity=humidity.substring(0,humidity.indexOf("."));
                        Humidity_Text.setText(humidity+"%");
                        TemperatureSet(SETVISIBLE);
                        Progress_H.setProgress(Integer.parseInt(progressBarHumidity)+5);
                    }
                });
    }

}
