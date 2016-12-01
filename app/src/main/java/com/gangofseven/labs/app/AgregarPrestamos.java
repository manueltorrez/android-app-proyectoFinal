package com.gangofseven.labs.app;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class AgregarPrestamos extends AppCompatActivity {



    private DatePickerDialog.OnDateSetListener onDateSetListener;
    private DatePickerDialog.OnDateSetListener onDateSetListener2;
    private EditText titulo;
    private EditText nombrePres;
    private EditText monto;
    private EditText interes;
    private Calendar calendario;
    private Calendar calendario2;
    private Button guardar;
    private Button presta;
    private Button paga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_prestamos);

        titulo = (EditText) findViewById(R.id.eTitulo);
        nombrePres = (EditText) findViewById(R.id.eNombre);
        monto = (EditText) findViewById(R.id.eMonto);
        interes = (EditText) findViewById(R.id.eInteres);

        presta = (Button) findViewById(R.id.bFechaPre);
        paga = (Button) findViewById(R.id.bFechaPa);
        guardar = (Button) findViewById(R.id.button5);

        //Método para seleccionar fecha en un DatePicker
        ponerDatePicker();

        //Método para guardar un préstamo
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPrestamo();
            }
        });



    }

    public void addPrestamo(){
        Prestamo p = new Prestamo(titulo.getText().toString(), nombrePres.getText().toString(), Float.parseFloat(monto.getText().toString()), Float.parseFloat(interes.getText().toString()),calendario.getTime(), calendario2.getTime());
        p.save();
        Toast.makeText(AgregarPrestamos.this, "Registro guardado",Toast.LENGTH_SHORT).show();
    }

    public void ponerDatePicker(){
        setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                Toast.makeText(AgregarPrestamos.this,"La fecha seleccionada es: "+view.getDayOfMonth()+
                        " de "+view.getMonth()+" de "+view.getYear(),Toast.LENGTH_LONG)
                        .show();
                calendario = Calendar.getInstance();
                calendario.set(year, month, dayOfMonth);

            }
        });

        setOnDateSetListener2(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year2, int month2, int dayOfMonth2) {

                Toast.makeText(AgregarPrestamos.this,"La fecha seleccionada es: "+view.getDayOfMonth()+
                        " de "+view.getMonth()+" de "+view.getYear(),Toast.LENGTH_LONG)
                        .show();
                calendario2 = Calendar.getInstance();
                calendario2.set(year2, month2, dayOfMonth2);

            }
        });

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        final Calendar c2 = Calendar.getInstance();
        int year2 = c2.get(Calendar.YEAR);
        int month2 = c2.get(Calendar.MONTH);
        int day2 = c2.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        final DatePickerDialog pickerDialog = new DatePickerDialog(this, null, year, month, day);
        pickerDialog.setCancelable(true);

        final DatePickerDialog pickerDialog2 = new DatePickerDialog(this, null, year2, month2, day2);
        pickerDialog2.setCancelable(true);

        pickerDialog.setButton(DialogInterface.BUTTON_NEGATIVE, getString( android.R.string.cancel), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        pickerDialog.setButton(DialogInterface.BUTTON_POSITIVE, getString( android.R.string.ok), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                getOnDateSetListener().onDateSet(pickerDialog.getDatePicker(), pickerDialog.getDatePicker().getYear(), pickerDialog.getDatePicker().getMonth(), pickerDialog.getDatePicker().getDayOfMonth());

            }
        });
        presta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickerDialog.show();
            }
        });

        pickerDialog2.setButton(DialogInterface.BUTTON_NEGATIVE, getString( android.R.string.cancel), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        pickerDialog2.setButton(DialogInterface.BUTTON_POSITIVE, getString( android.R.string.ok), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                getOnDateSetListener2().onDateSet(pickerDialog2.getDatePicker(), pickerDialog2.getDatePicker().getYear(), pickerDialog2.getDatePicker().getMonth(), pickerDialog2.getDatePicker().getDayOfMonth());

            }
        });
        paga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickerDialog2.show();
            }
        });
    }

    public DatePickerDialog.OnDateSetListener getOnDateSetListener() {
        return onDateSetListener;
    }

    public DatePickerDialog.OnDateSetListener getOnDateSetListener2() {
        return onDateSetListener2;
    }

    public void setOnDateSetListener(DatePickerDialog.OnDateSetListener onDateSetListener) {
        this.onDateSetListener = onDateSetListener;
    }

    public void setOnDateSetListener2(DatePickerDialog.OnDateSetListener onDateSetListener2) {
        this.onDateSetListener2 = onDateSetListener2;
    }


}
