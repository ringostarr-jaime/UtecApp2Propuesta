package com.example.jymmy.utecapp.Inicio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jymmy.utecapp.Navegador;
import com.example.jymmy.utecapp.R;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

import static android.R.attr.password;

public class Login extends AppCompatActivity {

    EditText crn,psw;
    Button ins;
    String susuario,spassword;
    TextView rcp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        crn=(EditText)findViewById(R.id.usuarioEdt);
        psw=(EditText)findViewById(R.id.passEdt);
        ins=(Button)findViewById(R.id.ingresarbtn);
        rcp=(TextView)findViewById(R.id.recuperarTv);



        rcp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tn = new Intent(getApplicationContext(),Navegador.class);
                startActivity(tn);
            }
        });


        ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // obtengo el valor de los campos digitados por el usuario y los convierto en texto
                susuario=crn.getText().toString();
                spassword=psw.getText().toString();
                //utilizo el metodo textutils para verificar que los campos no esten vacios
                if (TextUtils.isEmpty(susuario)){
                    //metodo para hacer foco en el campo vacio
                    crn.requestFocus();
                    crn.setError("Ingrese su numero de carnet");

                }
                else
                {
                    if(TextUtils.isEmpty(spassword))
                    {
                        psw.requestFocus();
                        psw.setError("Ingrese su contraseña");

                    }else
                    {

                        Thread th = new Thread(){
                            String res;
                            @Override
                            public void run() {
                                String NAMESPACE="http://logap.org/";
                                String URL="http://192.168.1.4/loAndroid/logos.asmx";
                                String METHOD_NAME="ingresar";
                                String SOAP_ACTION="http://logap.org/ingresar";
                                SoapObject request = new SoapObject(NAMESPACE,METHOD_NAME);
                                request.addProperty("nom",susuario);
                                request.addProperty("pass",spassword);
                                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                                envelope.dotNet=true;
                                envelope.setOutputSoapObject(request);
                                HttpTransportSE transporte = new HttpTransportSE(URL);
                                try {
                                    transporte.call(SOAP_ACTION,envelope);
                                    SoapPrimitive resultado_xml= (SoapPrimitive) envelope.getResponse();
                                    res=resultado_xml.toString();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                } catch (XmlPullParserException e) {
                                    e.printStackTrace();
                                }
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        // Toast.makeText(getApplicationContext(),res,Toast.LENGTH_LONG).show();
                                        //si los datos son correctos
                                        if(res.equals("s")) {
                                            //Declaro la intencion
                                            Intent obj = new Intent(getApplicationContext(), Navegador.class);
                                            //inicion la actividad
                                            startActivity(obj);
                                        }else {
                                            Toast.makeText(getApplicationContext(),"El usuario no existe",Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });

                            }
                        };
                        th.start();
                    }

                }
            }
        });
    }
}
