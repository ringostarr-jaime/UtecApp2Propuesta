package com.example.jymmy.utecapp.Bottom;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.jymmy.utecapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link estadocuentaFrag.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link estadocuentaFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class estadocuentaFrag extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public estadocuentaFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment estadocuentaFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static estadocuentaFrag newInstance(String param1, String param2) {
        estadocuentaFrag fragment = new estadocuentaFrag();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

View viewroot=inflater.inflate(R.layout.fragment_estadocuenta, container, false);

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
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("   Estado de Cuenta");
        ((AppCompatActivity)getActivity()).getSupportActionBar().setIcon(R.drawable.cuentadinero);

//--------------------CUOTAS y CHECKBOX----------------------------------------------------
        int mat=1,p1=1,s2=0,t3=0,c4=0,q5=0,s6=0;
        TextView ct1,ct2,ct3,ct4,ct5,ct6,matricula;

        ct1=(TextView)viewroot.findViewById(R.id.primeraTv);
        ct2=(TextView)viewroot.findViewById(R.id.segundaTv);
        ct3=(TextView)viewroot.findViewById(R.id.terceraTv);
        ct4=(TextView)viewroot.findViewById(R.id.cuartaTv);
        ct5=(TextView)viewroot.findViewById(R.id.quintaTv);
        ct6=(TextView)viewroot.findViewById(R.id.sextaTv);
        matricula=(TextView)viewroot.findViewById(R.id.cicloTv);

        CheckBox ch1,ch2,ch3,ch4,ch5,ch6,ch7;
        ch1=(CheckBox)viewroot.findViewById(R.id.primeraChk);
        ch2=(CheckBox)viewroot.findViewById(R.id.segundaChk);
        ch3=(CheckBox)viewroot.findViewById(R.id.terceraChk);
        ch4=(CheckBox)viewroot.findViewById(R.id.cuartaChk);
        ch5=(CheckBox)viewroot.findViewById(R.id.quintaChk);
        ch6=(CheckBox)viewroot.findViewById(R.id.sextaChk);
        ch7=(CheckBox)viewroot.findViewById(R.id.matriculaChk);

/*
        if (mat==1)
        {
            ch7.setChecked(true);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                ch7.setButtonTintMode(PorterDuff.Mode.DST_IN);
            }

        }
*/



//--------------------CUOTAS y CHECKBOX----------------------------------------------------

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
        /*if (context instanceof OnFragmentInteractionListener) {
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
