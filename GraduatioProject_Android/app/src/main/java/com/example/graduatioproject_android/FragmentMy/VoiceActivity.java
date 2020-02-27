package com.example.graduatioproject_android.FragmentMy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.graduatioproject_android.R;
import com.example.graduatioproject_android.tools.MusicPlayer;

import org.w3c.dom.Text;

import static com.example.graduatioproject_android.tools.GlobalVariable.MUSICNAME;
import static com.example.graduatioproject_android.tools.MusicPlayer.mediaPlayer;

public class VoiceActivity extends AppCompatActivity {

    private LinearLayout music1LL=null;
    private LinearLayout music2LL=null;
    private LinearLayout music3LL=null;
    private LinearLayout music4LL=null;
    private LinearLayout music5LL=null;
    private LinearLayout music6LL=null;
    private LinearLayout music7LL=null;
    private LinearLayout music8LL=null;
    private RadioButton noMusicRB=null;
    private RadioButton music1RB=null;
    private RadioButton music2RB=null;
    private RadioButton music3RB=null;
    private RadioButton music4RB=null;
    private RadioButton music5RB=null;
    private RadioButton music6RB=null;
    private RadioButton music7RB=null;
    private RadioButton music8RB=null;
    private TextView exitVoiceIV=null;

    private MyListener myListener;
    private MusicPlayer music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice);
        getWindow().setStatusBarColor(0xff4f4f4f);

        music1LL=(LinearLayout)findViewById(R.id.music1LL);
        music2LL=(LinearLayout)findViewById(R.id.music2LL);
        music3LL=(LinearLayout)findViewById(R.id.music3LL);
        music4LL=(LinearLayout)findViewById(R.id.music4LL);
        music5LL=(LinearLayout)findViewById(R.id.music5LL);
        music6LL=(LinearLayout)findViewById(R.id.music6LL);
        music7LL=(LinearLayout)findViewById(R.id.music7LL);
        music8LL=(LinearLayout)findViewById(R.id.music8LL);
        noMusicRB=(RadioButton)findViewById(R.id.noMusicRB);
        music1RB=(RadioButton)findViewById(R.id.music1RB);
        music2RB=(RadioButton)findViewById(R.id.music2RB);
        music3RB=(RadioButton)findViewById(R.id.music3RB);
        music4RB=(RadioButton)findViewById(R.id.music4RB);
        music5RB=(RadioButton)findViewById(R.id.music5RB);
        music6RB=(RadioButton)findViewById(R.id.music6RB);
        music7RB=(RadioButton)findViewById(R.id.music7RB);
        music8RB=(RadioButton)findViewById(R.id.music8RB);
        exitVoiceIV=(TextView) findViewById(R.id.exitVoiceIV);

        music=new MusicPlayer();
        myListener=new MyListener();

        music1LL.setOnClickListener(myListener);
        music2LL.setOnClickListener(myListener);
        music3LL.setOnClickListener(myListener);
        music4LL.setOnClickListener(myListener);
        music5LL.setOnClickListener(myListener);
        music6LL.setOnClickListener(myListener);
        music7LL.setOnClickListener(myListener);
        music8LL.setOnClickListener(myListener);
        noMusicRB.setOnClickListener(myListener);
        music1RB.setOnClickListener(myListener);
        music2RB.setOnClickListener(myListener);
        music3RB.setOnClickListener(myListener);
        music4RB.setOnClickListener(myListener);
        music5RB.setOnClickListener(myListener);
        music6RB.setOnClickListener(myListener);
        music7RB.setOnClickListener(myListener);
        music8RB.setOnClickListener(myListener);
        exitVoiceIV.setOnClickListener(myListener);

    }


    private class MyListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case(R.id.exitVoiceIV):
                    finish();
                    break;
                case(R.id.music1LL):
                    if(mediaPlayer!=null && mediaPlayer.isPlaying())mediaPlayer.stop();
                    music.musicPlayer(VoiceActivity.this,"music_default.mp3");
                    break;
                case(R.id.music2LL):
                    if(mediaPlayer!=null && mediaPlayer.isPlaying())mediaPlayer.stop();
                    music.musicPlayer(VoiceActivity.this,"music_dddd.mp3");
                    break;
                case(R.id.music3LL):
                    if(mediaPlayer!=null && mediaPlayer.isPlaying())mediaPlayer.stop();
                    music.musicPlayer(VoiceActivity.this,"music_chezhan.mp3");
                    break;
                case(R.id.music4LL):
                    if(mediaPlayer!=null && mediaPlayer.isPlaying())mediaPlayer.stop();
                    music.musicPlayer(VoiceActivity.this,"music_dida.mp3");
                    break;
                case(R.id.music5LL):
                    if(mediaPlayer!=null && mediaPlayer.isPlaying())mediaPlayer.stop();
                    music.musicPlayer(VoiceActivity.this,"music_didi.mp3");
                    break;
                case(R.id.music6LL):
                    if(mediaPlayer!=null && mediaPlayer.isPlaying())mediaPlayer.stop();
                    music.musicPlayer(VoiceActivity.this,"music_guo.mp3");
                    break;
                case(R.id.music7LL):
                    if(mediaPlayer!=null && mediaPlayer.isPlaying())mediaPlayer.stop();
                    music.musicPlayer(VoiceActivity.this,"music_huanle.mp3");
                    break;
                case(R.id.music8LL):
                    if(mediaPlayer!=null && mediaPlayer.isPlaying())mediaPlayer.stop();
                    music.musicPlayer(VoiceActivity.this,"music_niaoming.mp3");
                    break;
                case(R.id.noMusicRB):
                    AlertDialog.Builder builder=new AlertDialog.Builder(VoiceActivity.this);
                    builder.setTitle("提示");
                    builder.setMessage("确定取消提示音吗？");
                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            MUSICNAME=null;
                        }
                    });
                    builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    builder.create().show();
                    break;
                case(R.id.music1RB):
                    AlertDialog.Builder builder1=new AlertDialog.Builder(VoiceActivity.this);
                    builder1.setTitle("提示");
                    builder1.setMessage("确定更改提示音吗？");
                    builder1.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            MUSICNAME="music_default.mp3";
                        }
                    });
                    builder1.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    builder1.create().show();
                    break;
                case(R.id.music2RB):
                    AlertDialog.Builder builder2=new AlertDialog.Builder(VoiceActivity.this);
                    builder2.setTitle("提示");
                    builder2.setMessage("确定更改提示音吗？");
                    builder2.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            MUSICNAME="music_dddd.mp3";
                        }
                    });
                    builder2.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    builder2.create().show();
                    break;
                case(R.id.music3RB):
                    AlertDialog.Builder builder3=new AlertDialog.Builder(VoiceActivity.this);
                    builder3.setTitle("提示");
                    builder3.setMessage("确定更改提示音吗？");
                    builder3.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            MUSICNAME="music_chezhan.mp3";
                        }
                    });
                    builder3.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    builder3.create().show();
                    break;
                case(R.id.music4RB):
                    AlertDialog.Builder builder4=new AlertDialog.Builder(VoiceActivity.this);
                    builder4.setTitle("提示");
                    builder4.setMessage("确定更改提示音吗？");
                    builder4.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            MUSICNAME="music_dida.mp3";
                        }
                    });
                    builder4.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    builder4.create().show();
                    break;
                case(R.id.music5RB):
                    AlertDialog.Builder builder5=new AlertDialog.Builder(VoiceActivity.this);
                    builder5.setTitle("提示");
                    builder5.setMessage("确定更改提示音吗？");
                    builder5.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            MUSICNAME="music_didi.mp3";
                        }
                    });
                    builder5.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    builder5.create().show();
                    break;
                case(R.id.music6RB):
                    AlertDialog.Builder builder6=new AlertDialog.Builder(VoiceActivity.this);
                    builder6.setTitle("提示");
                    builder6.setMessage("确定更改提示音吗？");
                    builder6.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            MUSICNAME="music_guo.mp3";
                        }
                    });
                    builder6.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    builder6.create().show();
                    break;
                case(R.id.music7RB):
                    AlertDialog.Builder builder7=new AlertDialog.Builder(VoiceActivity.this);
                    builder7.setTitle("提示");
                    builder7.setMessage("确定更改提示音吗？");
                    builder7.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            MUSICNAME="music_huanle.mp3";
                        }
                    });
                    builder7.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    builder7.create().show();
                    break;
                case(R.id.music8RB):
                    AlertDialog.Builder builder8=new AlertDialog.Builder(VoiceActivity.this);
                    builder8.setTitle("提示");
                    builder8.setMessage("确定更改提示音吗？");
                    builder8.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            MUSICNAME="music_niaoming.mp3";
                        }
                    });
                    builder8.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    builder8.create().show();
                    break;
                default:
                    break;
            }
        }
    }
}
