package com.example.fernando.alarmaproyecto;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AddEventoActivity extends AppCompatActivity {

    Spinner opciones, tiempos;
    EditText descripcion, cantidad;
    Switch todo_dia;
    ArrayList<String> lista, listaAux;
    Button agregar, cancelar;
    TextView hora_inicio, hora_fin, fecha_inicio, fecha_fin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_evento);
        opciones=(Spinner)findViewById(R.id.opciones);
        descripcion=(EditText)findViewById(R.id.descripcion);
        todo_dia=(Switch)findViewById(R.id.todo_dia);
        lista=new ArrayList<>();
        listaAux=new ArrayList<>();
        hora_inicio=(TextView)findViewById(R.id.hora_inicio);
        fecha_inicio=(TextView)findViewById(R.id.fecha_inicio);
        hora_fin=(TextView)findViewById(R.id.hora_fin);
        fecha_fin=(TextView)findViewById(R.id.fecha_fin);

        fecha_fin.setText("12/08/2018");
        fecha_inicio.setText("10/05/2018");
        hora_inicio.setText("12:00 am");
        hora_fin.setText("01:00 pm");

        todo_dia.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    SimpleDateFormat fecha=new SimpleDateFormat("dd/MM/yyyy");
                    Date d=new Date();
                    fecha_fin.setText(fecha.format(d));
                    fecha_inicio.setText(fecha.format(d));
                    hora_inicio.setText("12:00 am");
                    hora_fin.setText("12:00 am");
                }
                else {
                    fecha_fin.setText("12/08/2018");
                    fecha_inicio.setText("10/05/2018");
                    hora_inicio.setText("12:00 am");
                    hora_fin.setText("01:00 pm");
                }
            }
        });

        opciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==3) {
                    AlertDialog.Builder dialog=new AlertDialog.Builder(AddEventoActivity.this);
                    view=getLayoutInflater().inflate(R.layout.dialogo, null);
                    tiempos=(Spinner)view.findViewById(R.id.tiempos);
                    cantidad=(EditText)view.findViewById(R.id.cantidad);
                    agregar=(Button)view.findViewById(R.id.add);
                    cancelar=(Button)view.findViewById(R.id.cancel);
                    llenarTiempos();

                    agregar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(!cantidad.getText().toString().isEmpty() && !tiempos.getSelectedItem().toString().equals("Tiempo"))
                                agregarTiempo();
                        }
                    });
                    dialog.setView(view);
                    AlertDialog mDialogo=dialog.create();
                    mDialogo.show();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        llenar();
    }

    private void agregarTiempo() {
        Toast.makeText(getBaseContext(), "Funciona.",Toast.LENGTH_SHORT).show();
        finish();
    }

    private void llenar() {
        lista.add("A la misma hora");
        lista.add("30 minutos antes");
        lista.add("1 hora antes");
        lista.add("Personalizado");

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        opciones.setAdapter(adapter);
    }

    private void llenarTiempos() {
        listaAux.add("Tiempo");
        listaAux.add("Minuto(s)");
        listaAux.add("Hora(s)");
        listaAux.add("Dia(s)");


        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaAux);
        tiempos.setAdapter(adapter);
    }
}
