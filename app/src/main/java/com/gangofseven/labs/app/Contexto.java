package com.gangofseven.labs.app;

import com.orm.SugarApp;

/**
 * Created by isi4 on 02/12/2016.
 */

public class Contexto extends SugarApp {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
