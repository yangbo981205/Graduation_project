package com.example.graduatioproject_android.FragmentOutdoor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.graduatioproject_android.FragmentMy.SetCEActivity;
import com.example.graduatioproject_android.R;
import com.example.graduatioproject_android.tools.JSONTOOL;
import com.example.graduatioproject_android.tools.MusicPlayer;
import com.example.graduatioproject_android.tools.SlideButton;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import okhttp3.Call;

import static android.graphics.Color.parseColor;
import static com.example.graduatioproject_android.tools.GlobalVariable.MUSICNAME;
import static com.example.graduatioproject_android.tools.GlobalVariable.SERVERIP;
import static com.example.graduatioproject_android.tools.GlobalVariable.THEMENAME;
import static com.example.graduatioproject_android.tools.GlobalVariable.USERNAME;

public class OutdoorActivity extends AppCompatActivity {

    private LinearLayout outdoorLL=null;
    private TextView countNode=null;
    private TextView usefulNode=null;
    private TextView stateNode1=null;
    private TextView stateNode2=null;
    private TextView stateNode3=null;
    private TextView stateNode4=null;
    private SlideButton slideNode1=null;
    private SlideButton slideNode2=null;
    private SlideButton slideNode3=null;
    private SlideButton slideNode4=null;
    private SlideButton.SlideButtonOnCheckedListener slideButtonOnCheckedListener1;
    private SlideButton.SlideButtonOnCheckedListener slideButtonOnCheckedListener2;
    private SlideButton.SlideButtonOnCheckedListener slideButtonOnCheckedListener3;
    private SlideButton.SlideButtonOnCheckedListener slideButtonOnCheckedListener4;
    private static int NodeCount=0;
    private static int connectCount=0;
    private long mPressedTime = 0;
    private MusicPlayer music;
    private List<String> nodeList=new ArrayList<>();
    private Boolean state1;
    private Boolean state2;
    private Boolean state3;
    private Boolean state4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outdoor);
        getWindow().setStatusBarColor(0xff4f4f4f);

        NodeCount=0;
        connectCount=0;
        Connect();

        outdoorLL=(LinearLayout) findViewById(R.id.outdoorLL);
        countNode=(TextView)findViewById(R.id.countNode);
        usefulNode=(TextView)findViewById(R.id.usefulNode);
        stateNode1=(TextView)findViewById(R.id.stateNode1);
        stateNode2=(TextView)findViewById(R.id.stateNode2);
        stateNode3=(TextView)findViewById(R.id.stateNode3);
        stateNode4=(TextView)findViewById(R.id.stateNode4);
        slideNode1=(SlideButton)findViewById(R.id.slideNode1);
        slideNode2=(SlideButton)findViewById(R.id.slideNode2);
        slideNode3=(SlideButton)findViewById(R.id.slideNode3);
        slideNode4=(SlideButton)findViewById(R.id.slideNode4);

        ThemeSet(THEMENAME);

        slideNode1.setSmallCircleModel(parseColor("#cccccc"), parseColor("#00000000"), parseColor("#26f219"), parseColor("#cccccc"));
        slideNode2.setSmallCircleModel(parseColor("#cccccc"), parseColor("#00000000"), parseColor("#26f219"), parseColor("#cccccc"));
        slideNode3.setSmallCircleModel(parseColor("#cccccc"), parseColor("#00000000"), parseColor("#26f219"), parseColor("#cccccc"));
        slideNode4.setSmallCircleModel(parseColor("#cccccc"), parseColor("#00000000"), parseColor("#26f219"), parseColor("#cccccc"));

        /**
         * 打开一个节点，则去服务器判断节点是否连接
         * */
        slideButtonOnCheckedListener1=new SlideButton.SlideButtonOnCheckedListener() {
            @Override
            public void onCheckedChangeListener(boolean isChecked) {
                final Timer timer=new Timer();
                final TimerTask timerTask=new TimerTask(){
                    @Override
                    public void run() {
                        if(state1==true){
                            String s=CheckNode("1DE25305004B1200");
                            stateNode1.setText(s);
                        }else{
                            timer.cancel();
                            timer.purge();
                        }
                    }
                };
                if(String.valueOf(isChecked).equals("true")){
                    state1=true;
                    NodeCount=NodeCount+1;
                    timer.schedule(timerTask, 0,5000);
                    countNode.setText(String.valueOf(NodeCount));
                }else{
                    state1=false;
                    NodeCount=NodeCount-1;
                    stateNode1.setText("");
                    countNode.setText(String.valueOf(NodeCount));
                }
            }
        };
        slideButtonOnCheckedListener2=new SlideButton.SlideButtonOnCheckedListener() {
            @Override
            public void onCheckedChangeListener(boolean isChecked) {
                final Timer timer=new Timer();
                final TimerTask timerTask=new TimerTask(){
                    @Override
                    public void run() {
                        if(state2==true){
                            String s=CheckNode("56DD5305004B1200");
                            stateNode2.setText(s);
                        }else{
                            timer.cancel();
                            timer.purge();
                        }
                    }
                };
                if(String.valueOf(isChecked).equals("true")){
                    state2=true;
                    NodeCount=NodeCount+1;
                    timer.schedule(timerTask, 0,5000);
                    countNode.setText(String.valueOf(NodeCount));
                }else{
                    state2=false;
                    NodeCount=NodeCount-1;
                    stateNode2.setText("");
                    countNode.setText(String.valueOf(NodeCount));
                }
            }
        };
        slideButtonOnCheckedListener3=new SlideButton.SlideButtonOnCheckedListener() {
            @Override
            public void onCheckedChangeListener(boolean isChecked) {
                final Timer timer=new Timer();
                final TimerTask timerTask=new TimerTask(){
                    @Override
                    public void run() {
                        if(state3==true){
                            String s=CheckNode("AD625305004B1200");
                            stateNode3.setText(s);
                        }else{
                            timer.cancel();
                            timer.purge();
                        }
                    }
                };
                if(String.valueOf(isChecked).equals("true")){
                    state3=true;
                    NodeCount=NodeCount+1;
                    timer.schedule(timerTask, 0,5000);
                    countNode.setText(String.valueOf(NodeCount));
                }else{
                    state3=false;
                    NodeCount=NodeCount-1;
                    stateNode3.setText("");
                    countNode.setText(String.valueOf(NodeCount));
                }
            }
        };
        slideButtonOnCheckedListener4=new SlideButton.SlideButtonOnCheckedListener() {
            @Override
            public void onCheckedChangeListener(boolean isChecked) {
                final Timer timer=new Timer();
                final TimerTask timerTask=new TimerTask(){
                    @Override
                    public void run() {
                        if(state4==true){
                            String s=CheckNode("DBDD5305004B1200");
                            stateNode4.setText(s);
                        }else{
                            timer.cancel();
                            timer.purge();
                        }
                    }
                };
                if(String.valueOf(isChecked).equals("true")){
                    state4=true;
                    NodeCount=NodeCount+1;
                    timer.schedule(timerTask, 0,5000);
                    countNode.setText(String.valueOf(NodeCount));
                }else{
                    state4=false;
                    NodeCount=NodeCount-1;
                    stateNode4.setText("");
                    countNode.setText(String.valueOf(NodeCount));
                }
            }
        };

        slideNode1.setOnCheckedListener(slideButtonOnCheckedListener1);
        slideNode2.setOnCheckedListener(slideButtonOnCheckedListener2);
        slideNode3.setOnCheckedListener(slideButtonOnCheckedListener3);
        slideNode4.setOnCheckedListener(slideButtonOnCheckedListener4);
    }

    /**
     * 连接服务器
     * */
    private void Connect(){

        OkHttpUtils.post()
                .url("http://"+SERVERIP+":8080/graduationproject/android/outdoor")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e) {
                        Toast.makeText(OutdoorActivity.this, "服务器错误，请检查网络连接！", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onResponse(Call call, String s) {
                        List<HashMap<String,String>> map = JSONTOOL.analyze_some_json("["+s+"]");
                        List<HashMap<String,String>> childMap = JSONTOOL.analyze_some_json(map.get(0).get("result"));
                        nodeList.clear();
                        for(int i=0;i<childMap.size();i++){
                            nodeList.add(childMap.get(i).get("macAddr"));
                        }
                        connectCount=nodeList.size();
                        usefulNode.setText(String.valueOf(connectCount-1));
                    }
                });
    }


    /**
     * 判断节点是否连接的方法：
     *      若连接，则显示正常
     *      若失联，则显示失联
     * */
    private String CheckNode(String MAC){
        music=new MusicPlayer();
        Connect();
        String str=null;
        boolean b = nodeList.contains(MAC);
        if(b==true){
            str="正常";
        }else{
            str="失联";
            music.musicPlayer(OutdoorActivity.this, MUSICNAME);
        }
        return str;
    }

    /**
     * 双击退出
     * */
    @Override
    public void onBackPressed() {
        long mNowTime = System.currentTimeMillis();
        if((mNowTime - mPressedTime) > 2000){
            Toast.makeText(this, "再按一次退出户外模式", Toast.LENGTH_SHORT).show();
            mPressedTime = mNowTime;
        }
        else{
            this.finish();
        }
    }



    public void ThemeSet(String ThemeName){
        if(ThemeName.equals("theme")){
            outdoorLL.setBackgroundResource(R.drawable.theme);
            outdoorLL.getBackground().setAlpha(100);
        }else if(ThemeName.equals("theme1")){
            outdoorLL.setBackgroundResource(R.drawable.theme1);
            outdoorLL.getBackground().setAlpha(100);
        }else if(ThemeName.equals("theme2")){
            outdoorLL.setBackgroundResource(R.drawable.theme2);
            outdoorLL.getBackground().setAlpha(100);
        }else if(ThemeName.equals("theme3")){
            outdoorLL.setBackgroundResource(R.drawable.theme3);
            outdoorLL.getBackground().setAlpha(100);
        }else if(ThemeName.equals("theme4")){
            outdoorLL.setBackgroundResource(R.drawable.theme4);
            outdoorLL.getBackground().setAlpha(100);
        }else if(ThemeName.equals("theme5")){
            outdoorLL.setBackgroundResource(R.drawable.theme5);
            outdoorLL.getBackground().setAlpha(100);
        }else if(ThemeName.equals("theme6")){
            outdoorLL.setBackgroundResource(R.drawable.theme6);
            outdoorLL.getBackground().setAlpha(100);
        }else if(ThemeName.equals("theme7")){
            outdoorLL.setBackgroundResource(R.drawable.theme7);
            outdoorLL.getBackground().setAlpha(100);
        }else if(ThemeName.equals("theme8")){
            outdoorLL.setBackgroundResource(R.drawable.theme8);
            outdoorLL.getBackground().setAlpha(100);
        }else if(ThemeName.equals("theme9")){
            outdoorLL.setBackgroundResource(R.drawable.theme9);
            outdoorLL.getBackground().setAlpha(100);
        }else if(ThemeName.equals("theme10")){
            outdoorLL.setBackgroundResource(R.drawable.theme10);
            outdoorLL.getBackground().setAlpha(100);
        }else if(ThemeName.equals("theme11")){
            outdoorLL.setBackgroundResource(R.drawable.theme11);
            outdoorLL.getBackground().setAlpha(100);
        }else if(ThemeName.equals("theme12")){
            outdoorLL.setBackgroundResource(R.drawable.theme12);
            outdoorLL.getBackground().setAlpha(100);
        }
    }
}
