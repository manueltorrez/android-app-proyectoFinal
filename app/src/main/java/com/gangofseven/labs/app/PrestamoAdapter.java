package com.gangofseven.labs.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by isi4 on 30/11/2016.
 */

public class PrestamoAdapter extends ArrayAdapter<Prestamo> {

    List<Prestamo> prestamos;

    public PrestamoAdapter(Context context, List<Prestamo> objects) {
        super(context, 0, objects);
        this.prestamos = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.prestamos_pendientes_adapter, parent, false);
        }

        TextView titulo = (TextView) convertView.findViewById(R.id.tvTitulo);
        TextView nombre = (TextView) convertView.findViewById(R.id.tvNombre);
        TextView monto = (TextView) convertView.findViewById(R.id.tvMonto);
        TextView interes = (TextView) convertView.findViewById(R.id.tvInteres);
        TextView fechaPrestamo= (TextView) convertView.findViewById(R.id.tvFechaPres);
        TextView fechaPago= (TextView) convertView.findViewById(R.id.tvFechaPago);

        Prestamo prestamo = prestamos.get(position);

        titulo.setText(prestamo.getTitulo());
        nombre.setText(prestamo.getNombrePrestamista());
        monto.setText(String.valueOf(prestamo.getMonto()));
        interes.setText((int) prestamo.getInteres());

        String fechaPre= new SimpleDateFormat("dd-MM-yyyy").format(prestamo.getFechaPrestamo());
        String fechaPag= new SimpleDateFormat("dd-MM-yyyy").format(prestamo.getFechaPago());

        fechaPrestamo.setText(fechaPre);
        fechaPago.setText(fechaPag);


        return convertView;
    }

}
