package com.gangofseven.labs.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class VisualizarCuotas extends AppCompatActivity {
    private ListView listaCuotas;
    private CuotaAdapter adapter;
    private Contexto contexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_cuotas);
        contexto = (Contexto) getApplicationContext();

        listaCuotas = (ListView) findViewById(R.id.lCuotas);

        List<Cuota> cuotasList = Cuota.findWithQuery(Cuota.class, "Select * from Cuota where prestamo_id = ?", String.valueOf(contexto.getId()));

        adapter = new CuotaAdapter(contexto.getApplicationContext(), cuotasList);
        listaCuotas.setAdapter(adapter);



    }
}
