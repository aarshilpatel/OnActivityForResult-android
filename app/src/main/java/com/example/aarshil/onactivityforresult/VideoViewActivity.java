package com.example.aarshil.onactivityforresult;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.VideoView;

public class VideoViewActivity extends AppCompatActivity {

VideoView videoView;
ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);

        videoView= (VideoView)findViewById(R.id.video);
        MediaController mediaController = new MediaController(VideoViewActivity.this);
       String path = "android.resource://"+ getPackageName()+"/"+R.raw.dolbycanyon;

       videoView.setVideoPath(path);
       videoView.requestFocus();
       videoView.setMediaController(mediaController);
       videoView.start();

       toggleButton = (ToggleButton)findViewById(R.id.togglebtn);
       toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

               if (b){
                   Toast.makeText(VideoViewActivity.this, "Switch on", Toast.LENGTH_SHORT).show();
               }
               else{
                   Toast.makeText(VideoViewActivity.this, "Switch off", Toast.LENGTH_SHORT).show();

               }

           }
       });
    }
}
