package com.example.minority.androidlistviewactivity;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;

public class MainActivity extends Activity {
    private NotificationManager notif;
    private int notifID = 100;
    private int numMsg = 0;
    private Button btnStart;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_utama);

        Button btnEnter  = (Button) findViewById(R.id.btnenter);
        Button btnAbout  = (Button) findViewById(R.id.about);
        Button btnExit   = (Button) findViewById(R.id.exit);

        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNotif();
                Intent nextscreen = new Intent(getApplicationContext(), allListItem.class);
                startActivity(nextscreen);
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextscreen = new Intent(getApplicationContext(), about.class);
                startActivity(nextscreen);
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelNotif();
                finish();
            }
        });
    }


    protected void displayNotif(){
        Log.i("Start", "Notifikasi");
        NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(this);
        nBuilder.setContentTitle("IMDb");
        nBuilder.setContentText("IMDb Movie Review Berjalan ");
        nBuilder.setTicker("New Message ALert");

        nBuilder.setSmallIcon(R.drawable.abc_btn_radio_material);

        nBuilder.setNumber(++numMsg);
        Intent resIntent = new Intent(this, allListItem.class);
        android.support.v4.app.TaskStackBuilder sBuilder = android.support.v4.app.TaskStackBuilder.create(this);

        sBuilder.addNextIntent(resIntent);
        sBuilder.addParentStack(allListItem.class);
        PendingIntent resPendingIntent = sBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        nBuilder.setContentIntent(resPendingIntent);
        notif = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notif.notify(notifID, nBuilder.build());
    }

    void cancelNotif(){
        Log.i("Cancel","Notifikasi Update");
        notif.cancel(notifID);

    }
}
