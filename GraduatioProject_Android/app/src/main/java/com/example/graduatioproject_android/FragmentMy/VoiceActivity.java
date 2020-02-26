package com.example.graduatioproject_android.FragmentMy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.graduatioproject_android.R;
import com.example.graduatioproject_android.tools.MusicPlayer;

import static com.example.graduatioproject_android.tools.MusicPlayer.mediaPlayer;

public class VoiceActivity extends AppCompatActivity {

    private Button shengyin=null;
    private Button shengyin1=null;
    private MusicPlayer music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice);
        getWindow().setStatusBarColor(0xff4f4f4f);

        shengyin=(Button)findViewById(R.id.shengyin);
        shengyin1=(Button)findViewById(R.id.shengyin1);
        music=new MusicPlayer();

        shengyin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s="star.mp3";
                if(mediaPlayer!=null && mediaPlayer.isPlaying())mediaPlayer.stop();
                music.musicPlayer(VoiceActivity.this,s);
            }
        });
        shengyin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s="music1.mp3";
                if(mediaPlayer!=null && mediaPlayer.isPlaying())mediaPlayer.stop();
                music.musicPlayer(VoiceActivity.this,s);
            }
        });
    }
}
