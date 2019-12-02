package com.example.aarshil.onactivityforresult;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;

public class Broadcast extends BroadcastReceiver {

    MediaPlayer mediaPlayer;

    @Override
    public void onReceive(Context context, Intent intent) {

    mediaPlayer = MediaPlayer.create(context,R.raw.audio);
    mediaPlayer.start();

    }
}
