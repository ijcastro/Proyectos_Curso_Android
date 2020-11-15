package com.ejemplo.memoria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void guardarPreferencia(View v){
        SharedPreferences miPreferenciaCompartida = getSharedPreferences("MisDatosPersonales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = miPreferenciaCompartida.edit();
        EditText etNombre = (EditText)findViewById(R.id.etNombre);
        EditText etCorreo = (EditText)findViewById(R.id.etCorreo);
        String nombre = etNombre.getText().toString();
        String correo = etCorreo.getText().toString();

        editor.putString("nombre", nombre);
        editor.putString("correo", correo);

        editor.commit();

        Toast.makeText(this, "Se ha creado la preferencia compartida", Toast.LENGTH_SHORT).show();
        etNombre.setText("");
        etCorreo.setText("");
    }

    public void mostrarPreferencia(View v){
        SharedPreferences miPreferenciaCompartida = getSharedPreferences("MisDatosPersonales", Context.MODE_PRIVATE);
        String nombre = miPreferenciaCompartida.getString("nombre", "No existe esa variable");
        String correo = miPreferenciaCompartida.getString("correo", "No existe esa variable");
        TextView tvPreferenciaCompartida = (TextView)findViewById(R.id.tvPreferenciaCompartida);
        String preferencia = "Nombre: " + nombre + "\nCorreo: " + correo;
        tvPreferenciaCompartida.setText(preferencia);
    }

    public void generarArchivo(View V){

        EditText etNombre = (EditText)findViewById(R.id.etNombre);
        String nombre = etNombre.getText().toString();

        try{
            FileOutputStream outputStream = null;
            outputStream = openFileOutput("MiArchivo.txt", Context.MODE_PRIVATE);
            outputStream.write(nombre.getBytes());
            outputStream.close();
            Toast.makeText(this, "El archivo se ha creado", Toast.LENGTH_SHORT).show();
            etNombre.setText("");
        } catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this, "Hubo un error en la escritura del archivo", Toast.LENGTH_SHORT).show();
        }
    }
}