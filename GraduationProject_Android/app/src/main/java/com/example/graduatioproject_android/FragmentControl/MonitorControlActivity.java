package com.example.graduatioproject_android.FragmentControl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.graduatioproject_android.R;
import com.example.graduatioproject_android.tools.FragmentManager;
import com.example.graduatioproject_android.tools.VideoViewController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import static com.example.graduatioproject_android.tools.GlobalVariable.SERVERIP;

public class MonitorControlActivity extends AppCompatActivity{

    private TextView exitMonitor=null;
    private VideoView videoMonitor=null;
    private VideoViewController videoViewController;
    private TextView monitorTime=null;
    private TextView monitorPlay=null;
    private TextView setMonitorFull=null;
    private MyListener myListener;
    private Boolean STATE =false;
    private String url="rtsp://"+SERVERIP+":8554/test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor_control);
        getWindow().setStatusBarColor(0xff4f4f4f);

        exitMonitor=(TextView)findViewById(R.id.exitMonitor);
        videoMonitor=(VideoView)findViewById(R.id.MonitorVideo);
        monitorTime=(TextView)findViewById(R.id.monitorTime);
        monitorPlay=(TextView)findViewById(R.id.monitorPlay);
        setMonitorFull=(TextView)findViewById(R.id.setMonitorFull);
        myListener=new MyListener();

        exitMonitor.setOnClickListener(myListener);
        monitorPlay.setOnClickListener(myListener);
        setMonitorFull.setOnClickListener(myListener);
        monitorPlay.setSelected(false);

        Timer timer=new Timer();
        timer.schedule(new TimerTask(){
            @Override
            public void run() {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                monitorTime.setText(dateFormat.format(new Date()));
            }
        }, 0,1000);

        videoViewController=new VideoViewController(MonitorControlActivity.this, videoMonitor);
        videoViewController.start(url);
    }

    /**
     * 按钮事件监听
     * */
    private class MyListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case(R.id.exitMonitor):
                    videoMonitor.stopPlayback();
                    Intent jumpIntent_monitor_return=new Intent(MonitorControlActivity.this, FragmentManager.class);
                    startActivity(jumpIntent_monitor_return);
                    finish();
                    break;
                case(R.id.monitorPlay):
                    if(STATE==false){
                        monitorPlay.setSelected(true);
                        videoMonitor.pause();
                        STATE=true;
                    }else{
                        monitorPlay.setSelected(false);
                        videoMonitor.stopPlayback();
                        videoViewController.start(url);
                        STATE=false;
                    }
                    break;
                case(R.id.setMonitorFull):
                    //Toast.makeText(getApplicationContext(),"1111111111111",Toast.LENGTH_LONG).show();
                    videoMonitor.stopPlayback();
                    Intent jumpIntent_monitor_full=new Intent(MonitorControlActivity.this, MonitorFull.class);
                    startActivity(jumpIntent_monitor_full);
                    finish();
                    break;
                default:
                    break;
            }
        }
    }


    /**
     * 兼容全面屏退出时操作
     * */
    @Override
    public void onBackPressed() {
        videoMonitor.stopPlayback();
        this.finish();
    }

}
