package com.example.fernando.alarmaproyecto;

import android.app.DatePickerDialog;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

public class EventoDiaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento_dia);

        calendario();
    }

    private void calendario() {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // +1 porque enero es cero
                String d = "" + day, m = "" + (month + 1);
                if (day < 10) d = "0" + day;
                if ((month + 1) < 10) m = "0" + (month + 1);

                Toast.makeText(getBaseContext(), "Eventos para hoy", Toast.LENGTH_SHORT).show();
            }
        });
        newFragment.show(getFragmentManager(), "datePicker");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.opciones, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.atras:
                finish();
                return true;
            case R.id.mas_opciones:
                Toast.makeText(getBaseContext(), "Escoja otra fecha.", Toast.LENGTH_LONG).show();
                calendario();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
