package com.example.aarshil.onactivityforresult;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ServiceActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnStart,btnStop,btntime,btnnotification;
    EditText edtTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        btnStart = (Button)findViewById(R.id.btn_start);
        btnStart.setOnClickListener(this);
        btnStop = (Button)findViewById(R.id.btn_stop);
        btnStop.setOnClickListener(this);
        edtTime = (EditText)findViewById(R.id.edt_time);
        edtTime.setOnClickListener(this);
        btntime = (Button)findViewById(R.id.btn_time);
        btntime.setOnClickListener(this);
        btnnotification = (Button)findViewById(R.id.btn_notification);
        btnnotification.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btn_start:

                startService(new Intent(ServiceActivity.this, MyService.class));
                break;

            case R.id.btn_stop:
                stopService(new Intent(ServiceActivity.this,MyService.class));
                break;
            case R.id.btn_time:
                int time = Integer.parseInt(edtTime.getText().toString());

                Intent intent = new Intent(ServiceActivity.this,Broadcast.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(ServiceActivity.this,
                        123,intent,PendingIntent.FLAG_ONE_SHOT);

                AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP,
                        System.currentTimeMillis()+(time*100),pendingIntent);

                break;

            case R.id.btn_notification:
                NotificationChannel chan = null;
                if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.O){
                   chan = new NotificationChannel("channel id","channel name",NotificationManager.IMPORTANCE_HIGH);
                    Intent i1 = new Intent(ServiceActivity.this,ServiceActivity.class);
                    PendingIntent pendingIntent1 = PendingIntent.getActivity(this,123,i1,PendingIntent.FLAG_CANCEL_CURRENT);
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"channel id");
                    builder.setPriority(Notification.PRIORITY_HIGH);
                    builder.setChannelId("channel id");

                    builder.setContentText("Hi...");
                    builder.setContentTitle("WhatsApp");
                    builder.setSmallIcon(R.mipmap.ic_launcher);
                    builder.setContentIntent(pendingIntent1);

                    NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                    notificationManager.createNotificationChannel(chan);
                    notificationManager.notify(123,builder.build());

                }
                break;

        }
    }
}

