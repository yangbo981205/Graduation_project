package com.example.graduatioproject_android.FragmentMy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.graduatioproject_android.LoginAndRegister.LoginActivity;
import com.example.graduatioproject_android.R;
import com.example.graduatioproject_android.tools.FragmentManager;
import com.example.graduatioproject_android.tools.JSONTOOL;
import com.example.graduatioproject_android.tools.SlideButton;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

import okhttp3.Call;

import static android.graphics.Color.parseColor;
import static com.example.graduatioproject_android.tools.GlobalVariable.SERVERIP;
import static com.example.graduatioproject_android.tools.GlobalVariable.SRTCOMFORTABLRENVIRONMENT;
import static com.example.graduatioproject_android.tools.GlobalVariable.USERNAME;

public class SetCEActivity extends AppCompatActivity {

    private TextView maxTemNow=null;
    private TextView minTemNow=null;
    private TextView maxHumNow=null;
    private TextView minHumNow=null;
    private TextView maxTemTV=null;
    private TextView minTemTV=null;
    private TextView maxHumTV=null;
    private TextView minHumTV=null;
    private SeekBar maxTemSB=null;
    private SeekBar minTemSB=null;
    private SeekBar maxHumSB=null;
    private SeekBar minHumSB=null;
    private TextView exitCETV=null;
    private Button saveChangeBtn=null;
    private SlideButton slideButton=null;
    private SlideButton.SlideButtonOnCheckedListener slideButtonOnCheckedListener;
    private MyListener myListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_ce);
        getWindow().setStatusBarColor(0xff4f4f4f);

        maxTemNow=(TextView)findViewById(R.id.maxTemNow);
        minTemNow=(TextView)findViewById(R.id.minTemNow);
        maxHumNow=(TextView)findViewById(R.id.maxHumNow);
        minHumNow=(TextView)findViewById(R.id.minHumNow);
        maxTemTV=(TextView)findViewById(R.id.maxTemTV);
        minTemTV=(TextView)findViewById(R.id.minTemTV);
        maxHumTV=(TextView)findViewById(R.id.maxHumTV);
        minHumTV=(TextView)findViewById(R.id.minHumTV);
        maxTemSB=(SeekBar)findViewById(R.id.maxTemSB);
        minTemSB=(SeekBar)findViewById(R.id.minTemSB);
        maxHumSB=(SeekBar)findViewById(R.id.maxHumSB);
        minHumSB=(SeekBar)findViewById(R.id.minHumSB);
        exitCETV=(TextView)findViewById(R.id.exitCETV);
        saveChangeBtn=(Button)findViewById(R.id.saveChangeBtn);
        slideButton=(SlideButton)findViewById(R.id.slideButton);

        myListener=new MyListener();
        slideButton.setChecked(SRTCOMFORTABLRENVIRONMENT);
        slideButton.setSmallCircleModel(parseColor("#cccccc"), parseColor("#00000000"), parseColor("#26f219"), parseColor("#cccccc"));
        slideButtonOnCheckedListener=new SlideButton.SlideButtonOnCheckedListener() {
            @Override
            public void onCheckedChangeListener(boolean isChecked) {
                if(String.valueOf(isChecked).equals("true")){
                    SRTCOMFORTABLRENVIRONMENT=true;
                }else{
                    SRTCOMFORTABLRENVIRONMENT=false;
                }
            }
        };

        slideButton.setOnCheckedListener(slideButtonOnCheckedListener);
        exitCETV.setOnClickListener(myListener);
        saveChangeBtn.setOnClickListener(myListener);


        DataInit();
        bindViews();

    }


    /**
     * 按钮事件监听
     * */
    private class MyListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case (R.id.exitCETV):
                    Intent exit_jumpIntent=new Intent(SetCEActivity.this, FragmentManager.class);
                    startActivity(exit_jumpIntent);
                    finish();
                    break;
                case (R.id.saveChangeBtn):
                    if(maxTemSB.getProgress()>minTemSB.getProgress()&&maxHumSB.getProgress()>minHumSB.getProgress()){
                        OkHttpUtils.post()
                                .url("http://"+SERVERIP+":8080/graduationproject/android/saveenvironmentset")
                                . addParams("username", USERNAME)
                                . addParams("maxTem", String.valueOf(maxTemTV.getText()))
                                . addParams("minTem", String.valueOf(minTemTV.getText()))
                                . addParams("maxHum", String.valueOf(maxHumTV.getText()))
                                . addParams("minHum", String.valueOf(minHumTV.getText()))
                                .build()
                                .execute(new StringCallback() {
                                    @Override
                                    public void onError(Call call, Exception e) {
                                        Toast.makeText(SetCEActivity.this, "服务器错误，请检查网络连接！", Toast.LENGTH_SHORT).show();
                                    }
                                    @Override
                                    public void onResponse(Call call, String s) {
                                        List<HashMap<String,String>> map = JSONTOOL.analyze_some_json("["+s+"]");
                                        if(map.get(0).get("state").equals("1")){
                                            Toast.makeText(SetCEActivity.this, "更改成功！", Toast.LENGTH_SHORT).show();
                                            maxTemNow.setText(maxTemTV.getText());
                                            minTemNow.setText(minTemTV.getText());
                                            maxHumNow.setText(maxHumTV.getText());
                                            minHumNow.setText(minHumTV.getText());
                                        }
                                    }
                                });
                    }else{
                        Toast.makeText(SetCEActivity.this, "最大值需要大于最小值！", Toast.LENGTH_SHORT).show();
                    }
                    break;
                    default:
                        break;
            }
        }
    }

    /**
     * 进度条数值显示
     * */
    private void bindViews() {
        maxTemSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                maxTemTV.setText(TemChange(i)+"℃");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        minTemSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                minTemTV.setText(TemChange(i)+"℃");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        maxHumSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                maxHumTV.setText(String.valueOf(i)+"%");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        minHumSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                minHumTV.setText(String.valueOf(i)+"%");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    /**
     * 进度条数值转换
     * */
    private String TemChange(float f){
        float result;
        result= (float) (f/10*3.5);
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(result);
    }


    /**
     * 进入页面时设置数据
     * */
    private void DataInit() {
        OkHttpUtils.post()
                .url("http://"+SERVERIP+":8080/graduationproject/android/getcomfortableenvironment")
                . addParams("username", USERNAME)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e) {
                        Toast.makeText(SetCEActivity.this, "服务器错误，请检查网络连接！", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onResponse(Call call, String s) {
                        List<HashMap<String,String>> map = JSONTOOL.analyze_some_json("["+s+"]");
                        List<HashMap<String,String>> mapResult = JSONTOOL.analyze_some_json("["+map.get(0).get("result")+"]");
                        maxTemNow.setText(mapResult.get(0).get("max_temperature"));
                        minTemNow.setText(mapResult.get(0).get("min_temperature"));
                        maxHumNow.setText(mapResult.get(0).get("max_humidity"));
                        minHumNow.setText(mapResult.get(0).get("min_humidity"));
                    }
                });
    }

}
