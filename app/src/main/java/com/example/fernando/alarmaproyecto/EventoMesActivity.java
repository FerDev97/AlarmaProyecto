package com.example.fernando.alarmaproyecto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class EventoMesActivity extends AppCompatActivity {

    ArrayList<String> lista;
    Spinner meses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento_mes);
        lista=new ArrayList<>();
        meses=(Spinner)findViewById(R.id.meses);
        llenar();

        meses.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.acciones, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.atras:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void llenar() {
        lista=new ArrayList<>();
        lista.add("A la misma hora");
        lista.add("30 minutos antes");
        lista.add("1 hora antes");
        lista.add("Personalizado");

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        meses.setAdapter(adapter);
    }
}
