package com.example.jymmy.utecapp;

import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.support.v4.app.Fragment;
import android.app.ActionBar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;


public class preferencias extends PreferenceActivity {

    //PararFragments
/*
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //DEBE agregarse para que el fragmet rellene toda la panatlla
        View container_parent = (View)view.getParent();
        container_parent.setPadding(0,0,0,0);
    }*/



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_preferencias);
        addPreferencesFromResource(R.xml.notificaciones);

        // Cambiamos el contenido de la Activity por nuestro propio fragment.


//Setear titulo
        /*
       ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("   Notificaciones");
        ((AppCompatActivity)getActivity()).getSupportActionBar().setIcon(R.mipmap.notificacion);
        */
    }
}
