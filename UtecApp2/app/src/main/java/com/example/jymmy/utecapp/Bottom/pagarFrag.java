package com.example.jymmy.utecapp.Bottom;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jymmy.utecapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link pagarFrag.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link pagarFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class pagarFrag extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public pagarFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment pagarFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static pagarFrag newInstance(String param1, String param2) {
        pagarFrag fragment = new pagarFrag();
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

        View viewroot=inflater.inflate(R.layout.fragment_pagar, container, false);

//-----------------------Spinner-----------------------------------
        //--------apartir de un textview como layaout
      final  String [] cuotas ={" 1ª Cuota "," 2ª Cuota "," 3ª Cuota "," 4ª Cuota "," 5ª Cuota "," 6ª Cuota "};
        Spinner spinner = (Spinner)viewroot.findViewById(R.id.cuotaSp);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),R.layout.spinner_cuotas,cuotas);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position>0)
                {
                    Toast.makeText(getActivity(),"Usted seleciono "+cuotas[position],Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //-----------------------Spinner-----------------------------------


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


//-----------------DIALOG IMAGENES DE LOS BANCOS-----------------------------------
         ImageView imageView=(ImageView) viewroot.findViewById(R.id.img);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               alertSingleChoiceItems();

            }
        });

//-----------------DIALOG IMAGENES DE LOS BANCOS-----------------------------------

        //Setear titulo
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("   Pago En Linea");
        ((AppCompatActivity)getActivity()).getSupportActionBar().setIcon(R.drawable.tarjeta);

        return viewroot;
    }




    public void alertSingleChoiceItems(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // Set the dialog title
        builder.setTitle("Eliga un banco")

                // specify the list array, the items to be selected by default (null for none),
                // and the listener through which to receive call backs when items are selected
                // again, R.array.choices were set in the resources res/values/strings.xml
                .setSingleChoiceItems(R.array.bancos, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        //Toast.makeText(getActivity(),"Ustede seleciono: " + arg1,Toast.LENGTH_LONG).show();

                    }

                })

                // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // user clicked OK, so save the mSelectedItems results somewhere
                        // or return them to the component that opened the dialog

                        int selectedPosition = ((AlertDialog)dialog).getListView().getCheckedItemPosition();
                       // Toast.makeText(getActivity(),"selectedPosition: " + selectedPosition,Toast.LENGTH_LONG).show();

                        ImageView imageView=(ImageView) getActivity().findViewById(R.id.img);
                        if(selectedPosition==0)
                        {
                            imageView.setImageResource(R.mipmap.agricola);
                        }else
                        {
                            if(selectedPosition==1)
                            {
                                imageView.setImageResource(R.mipmap.scotiabank);
                            }else
                            {
                                if(selectedPosition==2)
                                {
                                    imageView.setImageResource(R.mipmap.promerica);
                                }else
                                {
                                    if(selectedPosition==3)
                                    {
                                        imageView.setImageResource(R.mipmap.davivienda);
                                    }else
                                    {

                                    }
                                }
                            }
                        }

                    }
                })

                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // removes the dialog from the screen

                    }

                })


                .show();

    }



    //------------------------------Dialogo con texto---------------------------------------------


    /*
    public void alertSingleChoiceItems(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // Set the dialog title
        builder.setTitle("Eliga un banco")

                // specify the list array, the items to be selected by default (null for none),
                // and the listener through which to receive call backs when items are selected
                // again, R.array.choices were set in the resources res/values/strings.xml
                .setSingleChoiceItems(R.array.bancos, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        //Toast.makeText(getActivity(),"Ustede seleciono: " + arg1,Toast.LENGTH_LONG).show();

                    }

                })

                // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // user clicked OK, so save the mSelectedItems results somewhere
                        // or return them to the component that opened the dialog

                        int selectedPosition = ((AlertDialog)dialog).getListView().getCheckedItemPosition();
                       // Toast.makeText(getActivity(),"selectedPosition: " + selectedPosition,Toast.LENGTH_LONG).show();

                        TextView textView=(TextView)getActivity().findViewById(R.id.alerta);
                        if(selectedPosition==0)
                        {
                            textView.setText("Banco Agricola");
                        }else
                        {
                            if(selectedPosition==1)
                            {
                                textView.setText("Scotiabank ");
                            }else
                            {
                                if(selectedPosition==2)
                                {
                                    textView.setText("Banco Promerica");
                                }else
                                {
                                    if(selectedPosition==3)
                                    {
                                        textView.setText("Davivienda");
                                    }else
                                    {

                                    }
                                }
                            }
                        }

                    }
                })

                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // removes the dialog from the screen

                    }

                })


                .show();

    }


    */
    //----------------------------------------------------------------------------------



    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
      /*  if (context instanceof OnFragmentInteractionListener) {
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
