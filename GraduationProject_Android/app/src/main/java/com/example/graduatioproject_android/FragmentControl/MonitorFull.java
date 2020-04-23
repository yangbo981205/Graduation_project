package com.example.graduatioproject_android.FragmentControl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.graduatioproject_android.R;
import com.example.graduatioproject_android.tools.VideoViewController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import static com.example.graduatioproject_android.tools.GlobalVariable.SERVERIP;

public class MonitorFull extends AppCompatActivity {

    private VideoView videoMonitorFull=null;
    private VideoViewController videoViewController;
    private TextView monitorTimeFull=null;
    private TextView monitorPlayFull=null;
    private TextView monitorSmall=null;
    private MyListener myListener;
    private long mPressedTime = 0;
    private Boolean STATE =false;
    private String url="rtsp://"+SERVERIP+":8554/test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor_full);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        videoMonitorFull=(VideoView)findViewById(R.id.videoMonitorFull);
        monitorTimeFull=(TextView) findViewById(R.id.monitorTimeFull);
        monitorPlayFull=(TextView) findViewById(R.id.monitorPlayFull);
        monitorSmall=(TextView) findViewById(R.id.monitorSmall);
        myListener=new MyListener();

        monitorPlayFull.setOnClickListener(myListener);
        monitorSmall.setOnClickListener(myListener);


        Timer timer=new Timer();
        timer.schedule(new TimerTask(){
            @Override
            public void run() {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                monitorTimeFull.setText(dateFormat.format(new Date()));
            }
        }, 0,1000);

        videoViewController=new VideoViewController(MonitorFull.this, videoMonitorFull);
        videoViewController.start(url);
    }

    /**
     * 按钮事件监听
     * */
    private class MyListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case(R.id.monitorPlayFull):
                    if(STATE==false){
                        monitorPlayFull.setSelected(true);
                        videoMonitorFull.pause();
                        STATE=true;
                    }else{
                        monitorPlayFull.setSelected(false);
                        videoMonitorFull.stopPlayback();
                        videoViewController.start(url);
                        STATE=false;
                    }
                    break;
                case(R.id.monitorSmall):
                    videoMonitorFull.stopPlayback();
                    Intent jumpIntent_return=new Intent(MonitorFull.this, MonitorControlActivity.class);
                    startActivity(jumpIntent_return);
                    finish();
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * 全屏状态双击退出
     * */
    @Override
    public void onBackPressed() {
        long mNowTime = System.currentTimeMillis();
        if((mNowTime - mPressedTime) > 2000){
            Toast.makeText(this, "再按一次退出全屏模式", Toast.LENGTH_SHORT).show();
            mPressedTime = mNowTime;
        }
        else{
            videoMonitorFull.stopPlayback();
            this.finish();
        }
    }
}
