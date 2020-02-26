package com.example.graduatioproject_android.tools;


import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;


import java.io.IOException;

public class MusicPlayer{

    public static MediaPlayer mediaPlayer=null;

    public void musicPlayer(Context context,String music) {
        mediaPlayer=new MediaPlayer();
        try {
            AssetFileDescriptor assetFileDescriptor=context.getAssets().openFd(music);
            mediaPlayer.reset();
            mediaPlayer.setDataSource(assetFileDescriptor.getFileDescriptor(),
                    assetFileDescriptor.getStartOffset(),
                    assetFileDescriptor.getLength());
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
