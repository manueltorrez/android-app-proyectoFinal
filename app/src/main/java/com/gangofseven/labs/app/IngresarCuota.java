package com.gangofseven.labs.app;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class IngresarCuota extends AppCompatActivity {

    private DatePickerDialog.OnDateSetListener onDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar_cuota);
        Button cuota = (Button) findViewById(R.id.bAgregarCuota);

        setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                Toast.makeText(IngresarCuota.this,"La fecha seleccionada es: "+view.getDayOfMonth()+
                        " de "+view.getMonth()+" de "+view.getYear(),Toast.LENGTH_LONG)
                        .show();
            }
        });

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        final DatePickerDialog pickerDialog = new DatePickerDialog(this, null, year, month, day);
        pickerDialog.setCancelable(true);

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
        cuota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickerDialog.show();
            }
        });

    }

    public DatePickerDialog.OnDateSetListener getOnDateSetListener() {
        return onDateSetListener;
    }

    public void setOnDateSetListener(DatePickerDialog.OnDateSetListener onDateSetListener) {
        this.onDateSetListener = onDateSetListener;
    }
}
