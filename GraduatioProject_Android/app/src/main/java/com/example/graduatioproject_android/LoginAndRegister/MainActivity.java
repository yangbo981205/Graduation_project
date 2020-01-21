package com.example.graduatioproject_android.LoginAndRegister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.graduatioproject_android.R;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private LinearLayout jumpLayout=null;
    private long DELAY = 3800;
    int flag=0;/**避免两种跳转方式冲突*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setStatusBarColor(0xffb8cab0);

        jumpLayout=(LinearLayout)findViewById(R.id.Jump);

        /**
         * 播放帧动画
         * */
        //获取背景，并将其强转成AnimationDrawable
        AnimationDrawable animationDrawable = (AnimationDrawable) jumpLayout.getBackground();
        //判断是否在运行
        if(!animationDrawable.isRunning()){
            //开启帧动画
            animationDrawable.start();
        }

        /**
         * 点击跳转
         * */
        jumpLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent JumpIntent=new Intent(MainActivity.this, LoginActivity.class);
                flag=1;
                startActivity(JumpIntent);
                finish();
            }
        });

        /**
         * 定时自动跳转
         * */
        final Intent AutoJumpIntent=new Intent(MainActivity.this, LoginActivity.class);
        Timer timer=new Timer();
        TimerTask tast=new TimerTask() {
            @Override
            public void run(){
                if(flag==0){
                    startActivity(AutoJumpIntent);
                    finish();
                }
            }
        };
        timer.schedule(tast,DELAY);
    }
}
