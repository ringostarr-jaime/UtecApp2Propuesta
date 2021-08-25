package com.example.jymmy.utecapp.Inicio;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.example.jymmy.utecapp.Inicio.Login;
import com.example.jymmy.utecapp.R;

import java.util.Timer;
import java.util.TimerTask;


public class Splash extends AppCompatActivity {

    //Splash_screen pantalla de carga
    private static final long SPLASH_SCREEN_DELAY = 1000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //Seteamos orientacion
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        // Ocultamos barra de titulo
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //---------------------------SPLASH_SCREEN--------------------------------------------------

        setContentView(R.layout.activity_splash);

        //Inicio el metodo task para que se ejecute lo que tengo, pasado un tiempo X
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // Comienza la otra actividad
                Intent tn = new Intent(getApplicationContext(),Login.class);
                startActivity(tn);
                //Lo quitamos de la cola de actividades
                finish();
            }
        };
        // Simulate a long loading process on application startup.
        Timer timer = new Timer();
        //Un timer en el cual ejecuto un metodo pasado un tiempo el tiempo esta representado en la variable splash
        timer.schedule(task, SPLASH_SCREEN_DELAY);
        //---------------------------SPLASH_SCREEN--------------------------------------------------

    }
}
