package com.gangofseven.labs.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;
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

        listaCuotas.setLongClickable(true);
        listaCuotas.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);

        listaCuotas.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {

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
                inflater.inflate(R.menu.menu_cuotas, menu);
                menu.findItem(R.id.action_delete).setTitle("Eliminar");
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
                                Cuota selectedList = adapter.getItem(selected.keyAt(i));

                                for(Cuota c : Cuota.find(
                                        Cuota.class,"id = ?",String.valueOf(
                                                selectedList.getId()))){
                                    c.delete();
                                }

                                selectedList.delete();
                                adapter.remove(selectedList);
                            }
                        }
                        if(adapter.getCount() == 0)
//                            toggleList(OFF);
                            mode.finish();
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
}
