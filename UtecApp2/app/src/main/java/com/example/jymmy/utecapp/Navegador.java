package com.example.jymmy.utecapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.jymmy.utecapp.Biblioteca.bibliofrag;
import com.example.jymmy.utecapp.Bottom.estadocuentaFrag;
import com.example.jymmy.utecapp.Bottom.notifrag;
import com.example.jymmy.utecapp.Bottom.pagarFrag;
import com.example.jymmy.utecapp.Bottom.pagoFrag;
import com.example.jymmy.utecapp.Correo.correoUtec;
import com.example.jymmy.utecapp.Inicio.Login;
import com.example.jymmy.utecapp.Inicio.Inicio;


public class Navegador extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navegador);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//Inicia el primer fragment
        if(savedInstanceState == null)
        {
/*
            pantalla_inicio pantallaInicio = new pantalla_inicio();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .setCustomAnimations(R.anim.anim_slide_in_from_left,R.anim.anim_slide_out_from_left)
                    .replace(R.id.contenido, pantallaInicio, pantallaInicio.getTag()).commit();
                    */




/*
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
            Fragment f = new Inicio();
            transaction.add(R.id.contenido, f);
            transaction.commit();
            */

           android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
            Fragment f = new notifrag();
            transaction.add(R.id.contenido, f);
            transaction.commit();



        }

        //-------------------Barra Inferior---------------------------
        BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
                = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.noti:
                        notifrag notificacion = new notifrag();
                        FragmentManager manager = getSupportFragmentManager();
                        manager.beginTransaction()
                                .setCustomAnimations(R.anim.anim_slide_in_from_left,R.anim.anim_slide_out_from_left)
                                .replace(R.id.contenido, notificacion, notificacion.getTag()).commit();
                        return true;
                    case R.id.consulta:

                        //mTextMessage.setText(R.string.consultanota);
                        return true;
                    case R.id.expe:
                        //mTextMessage.setText(R.string.expe);
                        return true;
                    case R.id.cuenta:
                        estadocuentaFrag estado = new estadocuentaFrag();
                        FragmentManager manager4 = getSupportFragmentManager();
                        manager4.beginTransaction()
                                .setCustomAnimations(R.anim.anim_slide_in_from_left,R.anim.anim_slide_out_from_left)
                                .replace(R.id.contenido, estado, estado.getTag()).commit();
                        return true;
                    case R.id.pago:
                        pagoFrag pago = new pagoFrag();
                        FragmentManager manager5 = getSupportFragmentManager();
                        manager5.beginTransaction()
                                .setCustomAnimations(R.anim.anim_slide_in_from_left,R.anim.anim_slide_out_from_left)
                                .replace(R.id.contenido, pago, pago.getTag()).commit();
                        return true;
                }
                return false;
            }

        };


        BottomNavigationView navigation = (BottomNavigationView)findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //-------------------Barra Inferior---------------------------



        /*EJEMPLO DE SNACKBAR
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
        */

        //--------------------------------Drawer--------------------------------------------


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        //Deshabilita el icono de hamburguesa por defecto ya que se va a utilizar el drawer del lado izquierdo
        toggle.setDrawerIndicatorEnabled(false);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // ESTO SE UTILIZA PARA UTILIZAR EL TEXTVIEW DEL DRAWER
        String nom="Rodigo Diaz de vivar";
        String car="10-7410-2018";

        View hView = navigationView.getHeaderView(0);
        TextView nombre = (TextView) hView.findViewById(R.id.nombreTv);
        nombre.setText(nom);


        TextView carnet = (TextView) hView.findViewById(R.id.carnetTv);
        carnet.setText(car);
        //--------------------------------Drawer--------------------------------------------

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navegador, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                drawer.openDrawer(GravityCompat.START);
            }



            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.perfil) {


             perfilFrag perfil = new perfilFrag();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                   .setCustomAnimations(R.anim.anim_slide_in_from_left,R.anim.anim_slide_out_from_left)
                    .replace(R.id.contenido, perfil, perfil.getTag()).commit();


        } else if (id == R.id.notificaciones) {

/*
           android.app.FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            preferencias f=new preferencias();
            transaction.replace(R.id.contenido, f);
            transaction.commit();*/

/*
          preferencias noti = new preferencias();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .setCustomAnimations(R.anim.anim_slide_in_from_left,R.anim.anim_slide_out_from_left)
                    .replace(R.id.contenido,noti,noti.getTag()).commit();
*/

          /*  preferencias pre = new preferencias();
            android.app.FragmentManager manager = getFragmentManager();
            manager.beginTransaction()
                    .setCustomAnimations(R.animator.anim_slide_out_from_left,R.animator.anim_slide_in_from_left)
                    .replace(R.id.contenido,pre, pre.getTag()).commit();*/



Intent tn = new Intent(getApplicationContext(),preferencias.class);
            startActivity(tn);


        } else if (id == R.id.calendario) {


            calendarioFrag calendario = new calendarioFrag();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .setCustomAnimations(R.anim.anim_slide_in_from_left,R.anim.anim_slide_out_from_left)
                    .replace(R.id.contenido, calendario, calendario.getTag()).commit();



        } else if (id == R.id.bibliotecario) {

            bibliofrag biblio = new bibliofrag();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .setCustomAnimations(R.anim.anim_slide_in_from_left,R.anim.anim_slide_out_from_left)
                    .replace(R.id.contenido,biblio, biblio.getTag()).commit();

        } else if (id == R.id.contra) {

            contraFrag contra = new contraFrag();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .setCustomAnimations(R.anim.anim_slide_in_from_left,R.anim.anim_slide_out_from_left)
                    .replace(R.id.contenido,contra, contra.getTag()).commit();





        } else if (id == R.id.correo) {

           correoUtec correofrag = new correoUtec();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .setCustomAnimations(R.anim.anim_slide_in_from_left,R.anim.anim_slide_out_from_left)
                    .replace(R.id.contenido,correofrag, correofrag.getTag()).commit();




        } else if (id == R.id.power) {
            /*finish();
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);*/

            startActivity(new Intent(getBaseContext(), Login.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP));
            finish();


        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }





}
