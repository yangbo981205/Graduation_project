package com.example.graduatioproject_android.tools;

import android.app.ProgressDialog;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoViewController {

    private ProgressDialog loadingDialog; // loading
    private VideoView videoView;
    private Context context;

    public VideoViewController(Context contxt, VideoView mVideoView) {
        videoView = mVideoView;
        context = contxt;
    }

    public void start(String videoUrl) {

        loadingDialog = new ProgressDialog(context);
        loadingDialog.setMessage("Loading...");
        loadingDialog.show();
        //loadingDialog.setCancelable(false);

        final MediaController controll = new MediaController(context);
        controll.setMediaPlayer(videoView);
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                loadingDialog.dismiss();
            }
        });
        videoView.releasePointerCapture();
        videoView.setVideoURI(Uri.parse(videoUrl));
        videoView.start();
    }
}
