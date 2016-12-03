package com.gangofseven.labs.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class VisualizarCuotas extends AppCompatActivity {
    private ListView listaCuotas;
    private CuotaAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_cuotas);

        listaCuotas=(ListView) findViewById(R.id.lCuotas);

        List<Cuota> cuotasList = Cuota.listAll(Cuota.class);

        adapter = new CuotaAdapter(getApplicationContext(), 0, cuotasList);
        listaCuotas.setAdapter(adapter);



    }
}
