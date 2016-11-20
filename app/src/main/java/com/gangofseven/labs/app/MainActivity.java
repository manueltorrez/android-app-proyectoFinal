package com.gangofseven.labs.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{

    Button agregar, pendiente, historial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initSendAnotherActivity();

    }

    private void initSendAnotherActivity(){

        agregar = (Button) findViewById(R.id.bAgregar);
        pendiente = (Button) findViewById(R.id.bPendientes);
        historial = (Button) findViewById(R.id.bHistorial);

        agregar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent a = new Intent (MainActivity.this, AgregarPrestamos.class);
                startActivity(a);
            }
            });

        pendiente.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent p = new Intent (MainActivity.this, PrestamosPendientes.class);
                startActivity(p);
            }
        });

        historial.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent h = new Intent (MainActivity.this, HistorialPrestamos.class);
                startActivity(h);
            }
        });

    }


}
