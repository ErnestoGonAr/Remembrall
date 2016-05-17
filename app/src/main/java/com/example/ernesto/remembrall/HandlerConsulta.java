package com.example.ernesto.remembrall;

/**
 * Created by edgar on 17/05/16.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.*;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.lang.*;

import android.content.Intent;

import static com.example.ernesto.remembrall.R.layout.solicita_consulta;

public class HandlerConsulta extends AppCompatActivity {
    EditText txtPersona;
    EditText txtFecha;
    EditText txtArticulo;
    Button btnSend;
    Toast toast1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(solicita_consulta);
        txtPersona = (EditText) findViewById(R.id.edit_Persona);
        txtFecha = (EditText) findViewById(R.id.edit_Fecha);
        txtArticulo = (EditText) findViewById(R.id.edit_nombreArt);
        final Button boton1 = (Button) findViewById(R.id.boton_consultar);

        boton1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (txtPersona.getText().toString().equals("")
                        && txtArticulo.getText().toString().equals("")
                        && txtFecha.getText().toString().equals("")) {
                    toast1 = Toast.makeText(getApplicationContext(), "no se pudo consultar", Toast.LENGTH_SHORT);
                    toast1.show();
                }
                else{lanzar();}

            }

        });


    }
    public void lanzar() {
        //Crear un nuevo intent
        Intent intent = new Intent(this, vistaconsulta.class);
        //Iniciar actividad
        startActivity(intent);
    }
    public void finish() {
        System.exit(0);
    }

}
