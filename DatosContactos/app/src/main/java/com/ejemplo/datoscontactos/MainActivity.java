package com.ejemplo.datoscontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatePicker fecha = (DatePicker)findViewById(R.id.dpFecha);
        String fechaNac = "Nacimiento: " + fecha.getDayOfMonth() + "/" + ((fecha.getMonth())+1) + "/" + fecha.getYear();

        EditText nombre = (EditText)findViewById(R.id.tiNombreCompleto);
        EditText telefono = (EditText)findViewById(R.id.tiTelefono);
        EditText email = (EditText)findViewById(R.id.tiEmail);
        EditText descripcion = (EditText)findViewById(R.id.tiDescripcionContacto);

        Button siguiente = (Button)findViewById(R.id.btnSiguiente);
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ConfirmacionDatos.class);
                intent.putExtra("fecha", fechaNac);
                intent.putExtra("nombre", nombre.getText().toString());
                intent.putExtra("telefono", telefono.getText().toString());
                intent.putExtra("email", email.getText().toString());
                intent.putExtra("descripcion", descripcion.getText().toString());
                startActivity(intent);
                finish();
            }
        });

        Bundle parametros = getIntent().getExtras();
        String nombreBack = parametros.getString("nombre");
        String telefonoBack = parametros.getString("telefono");
        String emailBack = parametros.getString("email");
        String descripcionBack = parametros.getString("descripcion");

        nombre.setText(nombreBack);
        telefono.setText(telefonoBack);
        email.setText(emailBack);
        descripcion.setText(descripcionBack);

    }



}