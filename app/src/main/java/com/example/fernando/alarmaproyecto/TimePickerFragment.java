package com.example.fernando.alarmaproyecto;

import android.app.*;
//import android.app.DialogFragment;
//import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import java.text.DateFormat;
import java.util.Calendar;

/**
 * Created by FERNANDO on 6/7/2018.
 */

public class TimePickerFragment extends DialogFragment {
    Calendar calendario=Calendar.getInstance();
    int hora= calendario.get(Calendar.HOUR_OF_DAY);
    int minuto= calendario.get(Calendar.MINUTE);

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new TimePickerDialog(getActivity(),(TimePickerDialog.OnTimeSetListener)getActivity(),hora,minuto, android.text.format.DateFormat.is24HourFormat(getActivity()));
    }
}
