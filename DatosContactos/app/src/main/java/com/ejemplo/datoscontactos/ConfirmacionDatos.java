package com.ejemplo.datoscontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmacionDatos extends AppCompatActivity {
    //Atributos:
    private TextView tvConfNombre;
    private TextView tvConfFecha;
    private TextView tvConfTelefono;
    private TextView tvConfEmail;
    private TextView tvConfDescripcion;
    Button btnEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion_datos);

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString("nombre");
        String fecha = parametros.getString("fecha");
        String telefono = parametros.getString("telefono");
        String email = parametros.getString("email");
        String descripcion = parametros.getString("descripcion");

        tvConfNombre = (TextView)findViewById(R.id.tvConfNombre);
        tvConfFecha = (TextView)findViewById(R.id.tvConfFecha);
        tvConfTelefono = (TextView)findViewById(R.id.tvConfTel);
        tvConfEmail = (TextView)findViewById(R.id.tvConfEmail);
        tvConfDescripcion = (TextView)findViewById(R.id.tvConfDescripcion);

        tvConfNombre.setText(nombre);
        tvConfFecha.setText(fecha);
        tvConfTelefono.setText(telefono);
        tvConfEmail.setText(email);
        tvConfDescripcion.setText(descripcion);

        btnEditar = (Button)findViewById(R.id.btnEditar);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ConfirmacionDatos.this, MainActivity.class);
                i.putExtra("nombre", tvConfNombre.getText().toString());
                i.putExtra("telefono", tvConfTelefono.getText().toString());
                i.putExtra("email", tvConfEmail.getText().toString());
                i.putExtra("descripcion", tvConfDescripcion.getText().toString());
                startActivity(i);
                finish();
            }
        });

    }



}