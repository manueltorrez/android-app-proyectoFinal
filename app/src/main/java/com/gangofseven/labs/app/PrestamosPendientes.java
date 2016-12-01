package com.gangofseven.labs.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class PrestamosPendientes extends AppCompatActivity {

    private ListView listaPrestamistas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prestamos_pendientes);
        listaPrestamistas= (ListView) findViewById(R.id.lPrestamistas);

        List<Prestamo> prestamosList = Prestamo.listAll(Prestamo.class);
        //List<Prestamo> prestamosList= new ArrayList<Prestamo>();

        PrestamoAdapter adapter = new PrestamoAdapter(getApplicationContext(), prestamosList);
        listaPrestamistas.setAdapter(adapter);


    }
}
