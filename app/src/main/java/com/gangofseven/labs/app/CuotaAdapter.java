package com.gangofseven.labs.app;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by jlou trill on 12/1/2016.
 */

public class CuotaAdapter extends ArrayAdapter<Cuota> {

    List<Cuota> cuotas;
    private SparseBooleanArray mSelectedItemsIds;

    public CuotaAdapter(Context context, List<Cuota> objects) {
        super(context, 0, objects);
        this.cuotas = objects;
        mSelectedItemsIds = new SparseBooleanArray();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.cuota_adapter, parent, false);
        }

        TextView monto = (TextView) convertView.findViewById(R.id.tvMonto);
        TextView fecha = (TextView) convertView.findViewById(R.id.tvFecha);

        Cuota cuota = cuotas.get(position);

        monto.setText("Monto: "+String.valueOf(cuota.getMonto()));

        String fechaS = new SimpleDateFormat("dd-MM-yyyy").format(cuota.getFecha());

        fecha.setText("Fecha cuota: "+fechaS);

        return convertView;
    }

    public void toggleSelection(int position) {
        selectView(position, !mSelectedItemsIds.get(position));
    }

    public void removeSelection() {
        mSelectedItemsIds = new SparseBooleanArray();
        notifyDataSetChanged();
    }

    public void selectView(int position, boolean value) {
        if (value)
            mSelectedItemsIds.put(position, value);
        else
            mSelectedItemsIds.delete(position);

        notifyDataSetChanged();
    }

    public SparseBooleanArray getmSelectedItemsIds() {
        return mSelectedItemsIds;
    }
}
