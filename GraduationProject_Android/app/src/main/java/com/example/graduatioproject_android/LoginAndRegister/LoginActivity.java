package com.example.graduatioproject_android.LoginAndRegister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.graduatioproject_android.R;
import com.example.graduatioproject_android.tools.FragmentManager;
import com.example.graduatioproject_android.tools.JSONTOOL;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Call;

import static com.example.graduatioproject_android.tools.GlobalVariable.FRAGMENTSELECT;
import static com.example.graduatioproject_android.tools.GlobalVariable.MUSICNAME;
import static com.example.graduatioproject_android.tools.GlobalVariable.SERVERIP;
import static com.example.graduatioproject_android.tools.GlobalVariable.THEMENAME;
import static com.example.graduatioproject_android.tools.GlobalVariable.USERNAME;
import static com.example.graduatioproject_android.tools.GlobalVariable.NICKNAME;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEt;
    private EditText passwordEt;
    private Button loginBtn;
    private TextView registerTv;
    private MyListener myListener;

    private long mPressedTime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setStatusBarColor(0xff0091A4);

        usernameEt=(EditText)findViewById(R.id.usernameET);
        passwordEt=(EditText)findViewById(R.id.passwordET);
        loginBtn=(Button)findViewById(R.id.loginBtn);
        registerTv=(TextView)findViewById(R.id.registerTV);
        myListener=new MyListener();

        loginBtn.setOnClickListener(myListener);
        registerTv.setOnClickListener(myListener);
    }

    /**
     * 按钮事件监听
     * */
    private class MyListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case(R.id.loginBtn):

//                    Toast.makeText(LoginActivity.this, "登陆成功！", Toast.LENGTH_SHORT).show();
//                    Intent jumpIntent=new Intent(LoginActivity.this, FragmentManager.class);
//                    FRAGMENTSELECT=0;
//                    startActivity(jumpIntent);

                    OkHttpUtils.post()
                            .url("http://"+SERVERIP+":8080/graduationproject/android/login")
                            . addParams("username", String.valueOf(usernameEt.getText()))
                            . addParams("password", String.valueOf(passwordEt.getText()))
                            .build()
                            .execute(new StringCallback() {
                                @Override
                                public void onError(Call call, Exception e) {
                                    Toast.makeText(LoginActivity.this, "服务器错误，请检查网络连接！", Toast.LENGTH_SHORT).show();
                                }
                                @Override
                                public void onResponse(Call call, String s) {
                                    List<HashMap<String,String>> map = JSONTOOL.analyze_some_json("["+s+"]");
                                    if(map.get(0).get("state").equals("0")){
                                        Toast.makeText(LoginActivity.this, "用户名或密码错误，请重新输入！", Toast.LENGTH_SHORT).show();
                                        usernameEt.setText("");
                                        passwordEt.setText("");
                                    }else if(map.get(0).get("state").equals("1")){
                                        USERNAME=map.get(0).get("username");
                                        NICKNAME=map.get(0).get("nickname");
                                        getUsersSet();
                                        FRAGMENTSELECT=0;
//                                        Toast.makeText(LoginActivity.this, "登陆成功！", Toast.LENGTH_SHORT).show();
//                                        Intent jumpIntent1=new Intent(LoginActivity.this, FragmentManager.class);
//                                        startActivity(jumpIntent1);
                                    }
                                }
                            });
                    break;
                case(R.id.registerTV):
                    Intent jumpIntent2=new Intent(LoginActivity.this, RegisterActivity.class);
                    startActivity(jumpIntent2);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * 获取用户设置
     * */
    private void getUsersSet(){
        OkHttpUtils.post()
                .url("http://"+SERVERIP+":8080/graduationproject/android/getusersset")
                . addParams("username", USERNAME)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e) {
                        Toast.makeText(LoginActivity.this, "服务器错误，请检查网络连接！", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onResponse(Call call, String s) {
                        List<HashMap<String,String>> map = JSONTOOL.analyze_some_json("["+s+"]");
                        List<HashMap<String,String>> mapResult = JSONTOOL.analyze_some_json("["+map.get(0).get("result")+"]");
                        MUSICNAME=mapResult.get(0).get("voice");
                        THEMENAME=mapResult.get(0).get("theme");


                        /**
                         * 确保进入时加载正确的主题
                         * */
                        Toast.makeText(LoginActivity.this, "登陆成功！", Toast.LENGTH_SHORT).show();
                        Intent jumpIntent1=new Intent(LoginActivity.this, FragmentManager.class);
                        startActivity(jumpIntent1);
                    }
                });
    }

    /**
     * 双击退出
     * */
    @Override
    public void onBackPressed() {
        long mNowTime = System.currentTimeMillis();
        if((mNowTime - mPressedTime) > 2000){
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            mPressedTime = mNowTime;
        }
        else{
            this.finish();
            System.exit(0);
        }
    }
}
