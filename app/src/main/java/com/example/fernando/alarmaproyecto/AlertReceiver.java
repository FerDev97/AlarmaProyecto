package com.example.fernando.alarmaproyecto;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.widget.SimpleAdapter;
import android.widget.Toast;

/**
 * Created by FERNANDO on 6/7/2018.
 */

public class AlertReceiver extends BroadcastReceiver {
    public static String titulo, descripcion;


    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("Ya es hora.");

        Toast.makeText(context,"ya es hora!",Toast.LENGTH_SHORT).show();
        //ahora va a vibrar
        Vibrator vibrator=(Vibrator)context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(1500);
        Intent intent2=new Intent(context,PruebaActivity.class);
        context.startActivity(intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }
}
