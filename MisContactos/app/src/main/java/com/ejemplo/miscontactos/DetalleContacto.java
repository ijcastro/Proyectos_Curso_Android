package com.ejemplo.miscontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {
    //Atributos:
    private TextView tvNombreContacto;
    private TextView tvTelefonoContacto;
    private TextView tvEmailContacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        Bundle parametros = getIntent().getExtras();
        String name = parametros.getString(getResources().getString(R.string.pnombre));
        String telefono = parametros.getString(getResources().getString(R.string.ptelefono));
        String email = parametros.getString(getResources().getString(R.string.pemail));

        tvNombreContacto = (TextView) findViewById(R.id.tvNombreContacto);
        tvTelefonoContacto = (TextView) findViewById(R.id.tvTelefonoContacto);
        tvEmailContacto = (TextView) findViewById(R.id.tvEmailContacto);

        tvNombreContacto.setText(name);
        tvTelefonoContacto.setText(telefono);
        tvEmailContacto.setText(email);
    }

    public void llamar(View v){
        String telefono = tvTelefonoContacto.getText().toString();
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + telefono)));
    }

    public void enviarEmail(View v){
        String email = tvEmailContacto.getText().toString();
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, email);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Email"));
    }

    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
}