package com.example.ernesto.remembrall;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.ernesto.remembrall.R.layout.ventana_principal;

/**
 * Created by edgar on 18/05/16.
 */
public class Ventana_principal extends AppCompatActivity{

    Toast toast1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ventana_principal);

        final Button boton1 = (Button) findViewById(R.id.boton_hacia_consulta);

        boton1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
               lanzar();

            }

        });
        final Button boton2 = (Button) findViewById(R.id.boton_hacia_nuevo_prestamo);

        boton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                lanzar2();

            }

        });


    }
    public void lanzar() {
        //Crear un nuevo intent
        Intent intent = new Intent(this, HandlerConsulta.class);
        //Iniciar actividad
        startActivity(intent);
    }
    public void lanzar2() {
        //Crear un nuevo intent
        Intent intent = new Intent(this, Borrow.class);
        //Iniciar actividad
        startActivity(intent);
    }
    public void finish() {
        System.exit(0);
    }

}

