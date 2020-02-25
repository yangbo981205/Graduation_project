package com.example.graduatioproject_android.LoginAndRegister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.graduatioproject_android.R;
import com.example.graduatioproject_android.tools.FragmentManager;

import static com.example.graduatioproject_android.tools.GlobalVariable.FRAGMENTSELECT;

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
                    Intent jumpIntent1=new Intent(LoginActivity.this, FragmentManager.class);
                    FRAGMENTSELECT=0;
                    startActivity(jumpIntent1);
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
