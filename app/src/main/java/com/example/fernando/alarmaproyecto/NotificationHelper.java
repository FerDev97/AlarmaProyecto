package com.example.fernando.alarmaproyecto;

import android.annotation.TargetApi;
import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

/**
 * Created by FERNANDO on 6/7/2018.
 */

public class NotificationHelper extends ContextWrapper {
    public static final String channelID="channel1";
    public static final String channelName="channel 1";

    private NotificationManager notificationManager;

    public NotificationHelper(Context base) {
        super(base);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
            crear();
    }



    @TargetApi(Build.VERSION_CODES.O)
    private void crear() {
        NotificationChannel chanel=new NotificationChannel(channelID, channelName, NotificationManager.IMPORTANCE_DEFAULT);
        chanel.enableLights(true);
        chanel.setLightColor(R.color.colorPrimary);
        chanel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getManager().createNotificationChannel(chanel);
    }

    public NotificationManager getManager() {
        if(notificationManager==null) {
            notificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        }

        return notificationManager;
    }

    public NotificationCompat.Builder getChannelNotification(String titulo, String descripcion) {
        return new NotificationCompat.Builder(getApplicationContext(), channelID)
                .setContentTitle(titulo)
                .setContentText(descripcion)
                .setSmallIcon(R.drawable.ic_check_circle_black_24dp);
    }


}
