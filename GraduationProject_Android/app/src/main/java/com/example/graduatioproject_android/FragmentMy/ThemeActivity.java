package com.example.graduatioproject_android.FragmentMy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.graduatioproject_android.R;
import com.example.graduatioproject_android.tools.FragmentManager;
import static com.example.graduatioproject_android.tools.GlobalVariable.THEMEPICTURE;

public class ThemeActivity extends AppCompatActivity {

    private TextView exitThemeTV=null;
    private TextView theme0=null;
    private TextView theme1=null;
    private TextView theme2=null;
    private TextView theme3=null;
    private TextView theme4=null;
    private TextView theme5=null;
    private TextView theme6=null;
    private TextView theme7=null;
    private TextView theme8=null;
    private TextView theme9=null;
    private TextView theme10=null;
    private TextView theme11=null;
    private MyListener myListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);
        getWindow().setStatusBarColor(0xff4f4f4f);

        exitThemeTV=(TextView)findViewById(R.id.exitThemeTV);
        theme0=(TextView)findViewById(R.id.theme0);
        theme1=(TextView)findViewById(R.id.theme1);
        theme2=(TextView)findViewById(R.id.theme2);
        theme3=(TextView)findViewById(R.id.theme3);
        theme4=(TextView)findViewById(R.id.theme4);
        theme5=(TextView)findViewById(R.id.theme5);
        theme6=(TextView)findViewById(R.id.theme6);
        theme7=(TextView)findViewById(R.id.theme7);
        theme8=(TextView)findViewById(R.id.theme8);
        theme9=(TextView)findViewById(R.id.theme9);
        theme10=(TextView)findViewById(R.id.theme10);
        theme11=(TextView)findViewById(R.id.theme11);

        myListener=new MyListener();
        exitThemeTV.setOnClickListener(myListener);
        theme0.setOnClickListener(myListener);
        theme1.setOnClickListener(myListener);
        theme2.setOnClickListener(myListener);
        theme3.setOnClickListener(myListener);
        theme4.setOnClickListener(myListener);
        theme5.setOnClickListener(myListener);
        theme6.setOnClickListener(myListener);
        theme7.setOnClickListener(myListener);
        theme8.setOnClickListener(myListener);
        theme9.setOnClickListener(myListener);
        theme10.setOnClickListener(myListener);
        theme11.setOnClickListener(myListener);
    }


    /**
     * 按钮设置监听，更改THEMEPICTURE值
     * */
    private class MyListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case(R.id.exitThemeTV):
                    Intent exit_jumpIntent=new Intent(ThemeActivity.this, FragmentManager.class);
                    startActivity(exit_jumpIntent);
                    finish();
                    break;
                case(R.id.theme0):
                    AlertDialog.Builder builder0=new AlertDialog.Builder(ThemeActivity.this);
                    builder0.setTitle("提示");
                    builder0.setMessage("确定更改主题为theme0吗？");
                    builder0.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            THEMEPICTURE=0;
                            Toast.makeText(ThemeActivity.this,"更换成功！",Toast.LENGTH_LONG).show();
                        }
                    });
                    builder0.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    builder0.create().show();
                    break;
                case(R.id.theme1):
                    AlertDialog.Builder builder1=new AlertDialog.Builder(ThemeActivity.this);
                    builder1.setTitle("提示");
                    builder1.setMessage("确定更改主题为theme1吗？");
                    builder1.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            THEMEPICTURE=1;
                            Toast.makeText(ThemeActivity.this,"更换成功！",Toast.LENGTH_LONG).show();
                        }
                    });
                    builder1.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    builder1.create().show();
                    break;
                case(R.id.theme2):
                    AlertDialog.Builder builder2=new AlertDialog.Builder(ThemeActivity.this);
                    builder2.setTitle("提示");
                    builder2.setMessage("确定更改主题为theme2吗？");
                    builder2.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            THEMEPICTURE=2;
                            Toast.makeText(ThemeActivity.this,"更换成功！",Toast.LENGTH_LONG).show();
                        }
                    });
                    builder2.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    builder2.create().show();
                    break;
                case(R.id.theme3):
                    AlertDialog.Builder builder3=new AlertDialog.Builder(ThemeActivity.this);
                    builder3.setTitle("提示");
                    builder3.setMessage("确定更改主题为theme3吗？");
                    builder3.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            THEMEPICTURE=3;
                            Toast.makeText(ThemeActivity.this,"更换成功！",Toast.LENGTH_LONG).show();
                        }
                    });
                    builder3.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    builder3.create().show();
                    break;
                case(R.id.theme4):
                    AlertDialog.Builder builder4=new AlertDialog.Builder(ThemeActivity.this);
                    builder4.setTitle("提示");
                    builder4.setMessage("确定更改主题为theme4吗？");
                    builder4.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            THEMEPICTURE=4;
                            Toast.makeText(ThemeActivity.this,"更换成功！",Toast.LENGTH_LONG).show();
                        }
                    });
                    builder4.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    builder4.create().show();
                    break;
                case(R.id.theme5):
                    AlertDialog.Builder builder5=new AlertDialog.Builder(ThemeActivity.this);
                    builder5.setTitle("提示");
                    builder5.setMessage("确定更改主题为theme5吗？");
                    builder5.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            THEMEPICTURE=5;
                            Toast.makeText(ThemeActivity.this,"更换成功！",Toast.LENGTH_LONG).show();
                        }
                    });
                    builder5.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    builder5.create().show();
                    break;
                case(R.id.theme6):
                    AlertDialog.Builder builder6=new AlertDialog.Builder(ThemeActivity.this);
                    builder6.setTitle("提示");
                    builder6.setMessage("确定更改主题为theme6吗？");
                    builder6.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            THEMEPICTURE=6;
                            Toast.makeText(ThemeActivity.this,"更换成功！",Toast.LENGTH_LONG).show();
                        }
                    });
                    builder6.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    builder6.create().show();
                    break;
                case(R.id.theme7):
                    AlertDialog.Builder builder7=new AlertDialog.Builder(ThemeActivity.this);
                    builder7.setTitle("提示");
                    builder7.setMessage("确定更改主题为theme7吗？");
                    builder7.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            THEMEPICTURE=7;
                            Toast.makeText(ThemeActivity.this,"更换成功！",Toast.LENGTH_LONG).show();
                        }
                    });
                    builder7.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    builder7.create().show();
                    break;
                case(R.id.theme8):
                    AlertDialog.Builder builder8=new AlertDialog.Builder(ThemeActivity.this);
                    builder8.setTitle("提示");
                    builder8.setMessage("确定更改主题为theme8吗？");
                    builder8.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            THEMEPICTURE=8;
                            Toast.makeText(ThemeActivity.this,"更换成功！",Toast.LENGTH_LONG).show();
                        }
                    });
                    builder8.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    builder8.create().show();
                    break;
                case(R.id.theme10):
                    AlertDialog.Builder builder10=new AlertDialog.Builder(ThemeActivity.this);
                    builder10.setTitle("提示");
                    builder10.setMessage("确定更改主题为theme10吗？");
                    builder10.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            THEMEPICTURE=10;
                            Toast.makeText(ThemeActivity.this,"更换成功！",Toast.LENGTH_LONG).show();
                        }
                    });
                    builder10.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    builder10.create().show();
                    break;
                case(R.id.theme11):
                    AlertDialog.Builder builder11=new AlertDialog.Builder(ThemeActivity.this);
                    builder11.setTitle("提示");
                    builder11.setMessage("确定更改主题为theme11吗？");
                    builder11.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            THEMEPICTURE=11;
                            Toast.makeText(ThemeActivity.this,"更换成功！",Toast.LENGTH_LONG).show();
                        }
                    });
                    builder11.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    builder11.create().show();
                    break;
                default:
                    break;
            }
        }
    }

}
