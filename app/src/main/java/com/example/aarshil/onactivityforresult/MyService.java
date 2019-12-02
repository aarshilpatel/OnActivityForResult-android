package com.example.aarshil.onactivityforresult;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class MyService extends Service {

    MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

       mediaPlayer= MediaPlayer.create(MyService.this, R.raw.audio);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        mediaPlayer.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
// same as onStart method, use either
        return super.onStartCommand(intent, flags, startId);
    }
}
