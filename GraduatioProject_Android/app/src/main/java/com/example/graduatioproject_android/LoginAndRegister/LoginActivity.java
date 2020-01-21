package com.example.graduatioproject_android.LoginAndRegister;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.graduatioproject_android.R;

public class LoginActivity extends AppCompatActivity {

    private long mPressedTime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setStatusBarColor(0xff0091A4);

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
