package com.example.ernesto.remembrall;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.ernesto.remembrall.R.layout.login;

public class MainActivity extends AppCompatActivity {
    EditText txtContraseña;
    EditText txtUsuario;

    BdHandler bd = new BdHandler(this);

    Button btnSend;
    Toast toast1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(login);
        txtUsuario = (EditText) findViewById(R.id.cb1);
        txtContraseña = (EditText) findViewById(R.id.cb2);
        final Button boton1 = (Button) findViewById(R.id.button);

        boton1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (txtUsuario.getText().toString().equals("")
                        && txtContraseña.getText().toString().equals("")
                        ) {
                    toast1 = Toast.makeText(getApplicationContext(), "no se pudo ingresar", Toast.LENGTH_SHORT);
                    toast1.show();
                }
                else{lanzar();}

            }

        });

    }
    public void lanzar() {
        //Crear un nuevo intent
        Intent intent = new Intent(this,Ventana_principal.class);
        //Iniciar actividad
        startActivity(intent);
    }
}
