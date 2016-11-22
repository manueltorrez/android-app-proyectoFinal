package com.gangofseven.labs.app;

import java.util.Date;

/**
 * Created by isi4 on 21/11/2016.
 */

public class Cuota {
    private float monto;
    private Date fecha;

    public Cuota(float monto, Date fecha) {
        this.monto = monto;
        this.fecha = fecha;
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
