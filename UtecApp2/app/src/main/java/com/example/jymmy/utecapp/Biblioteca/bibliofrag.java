package com.example.jymmy.utecapp.Biblioteca;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.jymmy.utecapp.Bottom.estadocuentaFrag;
import com.example.jymmy.utecapp.Bottom.notifrag;
import com.example.jymmy.utecapp.Bottom.pagoFrag;
import com.example.jymmy.utecapp.Navegador;
import com.example.jymmy.utecapp.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link bibliofrag.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link bibliofrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class bibliofrag extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public bibliofrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment bibliofrag.
     */
    // TODO: Rename and change types and number of parameters
    public static bibliofrag newInstance(String param1, String param2) {
        bibliofrag fragment = new bibliofrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    //codigo necesario para rellenar el borde
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //DEBE agregarse para que el fragmet rellene toda la panatlla
        View container_parent = (View)view.getParent();
        container_parent.setPadding(0,0,0,0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View viewroot=inflater.inflate(R.layout.fragment_bibliofrag, container, false);

        Button web =(Button)viewroot.findViewById(R.id.webBtn);
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                biblioweb web = new biblioweb();
                //En lugar de usar el getSupportFragmentManager usar getFragmentManager
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction()
                        .setCustomAnimations(R.anim.anim_slide_in_from_left,R.anim.anim_slide_out_from_left)
                        .replace(R.id.contenido,web, web.getTag()).commit();
            }
        });

        /*
        FloatingActionButton fab = (FloatingActionButton) viewroot.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent tn = new Intent(getActivity(),Navegador.class);

                startActivity(tn);

            }
        });*/


        //-------------------Barra Inferior---------------------------
        BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
                = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.noti:
                        notifrag notificacion = new notifrag();
                        FragmentManager manager = getFragmentManager();
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
                        FragmentManager manager4 = getFragmentManager();
                        manager4.beginTransaction()
                                .setCustomAnimations(R.anim.anim_slide_in_from_left,R.anim.anim_slide_out_from_left)
                                .replace(R.id.contenido, estado, estado.getTag()).commit();
                        return true;
                    case R.id.pago:
                        pagoFrag pago = new pagoFrag();
                        FragmentManager manager5 = getFragmentManager();
                        manager5.beginTransaction()
                                .setCustomAnimations(R.anim.anim_slide_in_from_left,R.anim.anim_slide_out_from_left)
                                .replace(R.id.contenido, pago, pago.getTag()).commit();
                        return true;
                }
                return false;
            }

        };


        BottomNavigationView navigation = (BottomNavigationView) getActivity().findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //-------------------Barra Inferior---------------------------



        //Setear titulo
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("   Sistema Bibliotecario");
        ((AppCompatActivity)getActivity()).getSupportActionBar().setIcon(R.mipmap.libro);

        return viewroot;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
       /* if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
