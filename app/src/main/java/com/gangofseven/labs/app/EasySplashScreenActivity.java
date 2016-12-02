package com.gangofseven.labs.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;

public class EasySplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View easySplashScreenView = new EasySplashScreen(this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(3000)
                .withBackgroundResource(R.color.color_Splash)
                /*.withHeaderText("Préstamo Seguro")*/
                .withFooterText("Gang of Seven Labs Copyright 2016")
                .withBeforeLogoText("Préstamo Seguro App")
                .withLogo(R.drawable.money2)
                /*.withAfterLogoText("Ver más detalles")*/
                .create();

        setContentView(easySplashScreenView);

    }
}
