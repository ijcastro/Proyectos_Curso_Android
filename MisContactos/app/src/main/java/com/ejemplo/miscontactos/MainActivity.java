package com.ejemplo.miscontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Atributos:
    ArrayList<Contacto> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactos = new ArrayList<>();

        contactos.add(new Contacto("Anahi Salgado", "77779999", "anahi@gmail.com"));
        contactos.add(new Contacto("Pedro Sanchez", "88882222", "pedro@gmail.com"));
        contactos.add(new Contacto("Mireya Martinez", "33331111", "mireya@gmail.com"));
        contactos.add(new Contacto("Juan Lopez", "44442222", "juan@gmail.com"));

        ArrayList<String> nombres = new ArrayList<>();

        for (Contacto x:contactos) {
            nombres.add(x.getNombre());
        }

        ListView lvContactos = (ListView) findViewById(R.id.lvContactos);
        lvContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombres));

        lvContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.pnombre), contactos.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono), contactos.get(position).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail), contactos.get(position).getEmail());
                startActivity(intent);
                finish();
            }
        });


    }
}