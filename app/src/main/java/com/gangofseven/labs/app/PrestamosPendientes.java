package com.gangofseven.labs.app;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class PrestamosPendientes extends AppCompatActivity {

    private ListView listaPrestamistas;
    private PrestamoAdapter adapter;
    private Contexto contexto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prestamos_pendientes);
        contexto = (Contexto) getApplicationContext();
        listaPrestamistas= (ListView) findViewById(R.id.lPrestamistas);

        List<Prestamo> prestamosList = Prestamo.listAll(Prestamo.class);
        //List<Prestamo> prestamosList= new ArrayList<Prestamo>();

        adapter = new PrestamoAdapter(getApplicationContext(), prestamosList);
        listaPrestamistas.setAdapter(adapter);

        listaPrestamistas.setLongClickable(true);
        listaPrestamistas.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listaPrestamistas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Prestamo p = adapter.getItem(i);
                contexto.setId(p.getId());
            }
        });
        listaPrestamistas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        listaPrestamistas.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {

            private MenuItem mMenuItemEdit;
            private int nr = 0;

            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                if (checked) {
                    nr++;
                    adapter.toggleSelection(position);

                } else {
                    nr--;
                    adapter.toggleSelection(position);
                }
                mode.setTitle( nr + "seleccionado");
//                selectedListIndex = position;
                if(nr == 1){
                    mMenuItemEdit.setVisible(true);
                } else{
                    mMenuItemEdit.setVisible(true);
                }
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                nr = 0;
                MenuInflater inflater = getMenuInflater();
                inflater.inflate(R.menu.menu_prestamos, menu);
                menu.findItem(R.id.action_delete).setTitle("Eliminar");
                menu.findItem(R.id.action_add_quota).setTitle("Agregar cuota");
                menu.findItem(R.id.action_view_quota).setTitle("Ver cuotas");
                mMenuItemEdit =  menu.findItem(R.id.action_delete);
                mMenuItemEdit.setVisible(false);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_delete:
                        SparseBooleanArray selected = adapter.getmSelectedItemsIds();
                        for(int i = selected.size()-1;i>=0;i--){
                            if(selected.valueAt(i)){
                                Prestamo selectedList = adapter.getItem(selected.keyAt(i));
                                for(Prestamo g : Prestamo.find(
                                        Prestamo.class,"id = ?",String.valueOf(
                                                selectedList.getId()))){
                                   g.delete();
                                }
                                selectedList.delete();
                                adapter.remove(selectedList);
                            }
                        }
                        if(adapter.getCount() == 0)
//                            toggleList(OFF);
                            mode.finish();
                        return true;

                    case R.id.action_add_quota:
                        addQuota();
                        return true;
                    case R.id.action_view_quota:
                        Intent a = new Intent(PrestamosPendientes.this, VisualizarCuotas.class);
                        startActivity(a);
                        return true;
                    default:
                        return false;
                }

            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });



    }

    public void addQuota(){
        Intent a = new Intent(PrestamosPendientes.this, IngresarCuota.class);
        startActivity(a);
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
