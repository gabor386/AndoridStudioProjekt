package com.example.rma.model;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.rma.R;

import java.util.Random;

public class NotificationBroadcast extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle=intent.getExtras();
        String m1=bundle.getString("HomeTeam");
        String m2=bundle.getString("AwayTeam");
        String message=m1+" vs "+m2;
        NotificationCompat.Builder builder=new NotificationCompat.Builder(context,"idChannel")
                .setSmallIcon(R.drawable.ic_stat_name)
                .setContentTitle("The match has started")
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) {
            Intent serviceIntent = new Intent(".com.example.rma.model.NotificationService");
            context.startService(serviceIntent);
        }


        NotificationManagerCompat notificationManagerCompat=NotificationManagerCompat.from(context);
        Random random = new Random();
        int m = random.nextInt(9999 - 1000) + 1000;
        notificationManagerCompat.notify(m,builder.build());
    }
}
