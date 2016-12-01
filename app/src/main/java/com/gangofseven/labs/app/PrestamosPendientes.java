package com.gangofseven.labs.app;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_options_menu, menu);
        // Retrieve the SearchView and plug it into SearchManager
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        return true;
    }
}
