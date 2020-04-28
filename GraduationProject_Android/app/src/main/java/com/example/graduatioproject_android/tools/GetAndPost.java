package com.example.graduatioproject_android.tools;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;

import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

public class GetAndPost {
    private static final int GET=1;
    private static final int POST=2;
    private OkHttpServices okHttpServices=new OkHttpServices();

    /**
     * GET获取数据
     * */
    public void getData(final String url,final List<String> list){

        @SuppressLint("HandlerLeak") final Handler handler=new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                switch (msg.what){
                    case GET:
                        list.clear();
                        list.add(String.valueOf(msg.obj));
                        break;
                    default:
                        break;
                }
            }
        };

        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    String result = okHttpServices.getUrl(url);
                    Message msg=Message.obtain();
                    msg.what=GET;
                    msg.obj=result;
                    handler.sendMessage(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }


    /**
     * POST获取数据
     * */
    public void postData(final String url, final List<String> list, final String jsonString){

        @SuppressLint("HandlerLeak") final Handler handler=new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                switch (msg.what){
                    case POST:
                        list.clear();
                        list.add(String.valueOf(msg.obj));
                        break;
                    default:
                        break;
                }
            }
        };

        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    String result = okHttpServices.postUrl(url,jsonString);
                    Message msg=Message.obtain();
                    msg.what=POST;
                    msg.obj=result;
                    handler.sendMessage(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }

    /**
     * 使用okhttputils的GET获取数据
     * */



}
