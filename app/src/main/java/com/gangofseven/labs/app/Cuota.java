package com.gangofseven.labs.app;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

import java.util.Date;

/**
 * Created by isi4 on 21/11/2016.
 */
@Table
public class Cuota extends SugarRecord{
    private Long id;
    private float monto;
    private Date fecha;

    //Definiendo la relación
    private Prestamo prestamo;

    public Cuota() {
    }

    public Cuota(float monto, Date fecha) {
        this.monto = monto;
        this.fecha = fecha;
    }

    @Override
    public Long getId() {
        return id;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
