package com.example.fernando.alarmaproyecto;

import android.content.Context;
import android.content.ContextWrapper;

/**
 * Created by FERNANDO on 6/7/2018.
 */

public class NotificationHelper extends ContextWrapper {
    public static final String titulo="titulo";
    public static final String mensaje="mensasje";

    public NotificationHelper(Context base) {
        super(base);
    }


}
