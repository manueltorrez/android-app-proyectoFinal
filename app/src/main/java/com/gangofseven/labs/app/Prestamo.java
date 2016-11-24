package com.gangofseven.labs.app;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

import java.util.Date;

/**
 * Created by jlou trill on 11/19/2016.
 */

@Table
public class Prestamo extends SugarRecord{
    private Long id;
    private String titulo;
    private String nombrePrestamista;
    private float monto;
    private float interes;
    private Date fechaPrestamo;
    private Date fechaPago;

    public Prestamo(String titulo, String nombrePrestamista, float monto, float interes, Date fechaPrestamo, Date fechaPago) {
        this.titulo = titulo;
        this.nombrePrestamista = nombrePrestamista;
        this.monto = monto;
        this.interes = interes;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaPago = fechaPago;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombrePrestamista() {
        return nombrePrestamista;
    }

    public void setNombrePrestamista(String nombrePrestamista) {
        this.nombrePrestamista = nombrePrestamista;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public float getInteres() {
        return interes;
    }

    public void setInteres(float interes) {
        this.interes = interes;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }
}
