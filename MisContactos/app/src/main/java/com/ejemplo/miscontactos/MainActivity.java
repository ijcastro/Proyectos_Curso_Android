package com.ejemplo.miscontactos;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
    private RecyclerView listaContactos;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar)findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        listaContactos = (RecyclerView)findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaContactos.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptador();

        /*ArrayList<String> nombres = new ArrayList<>();
        for (Contacto x:contactos) {
            nombres.add(x.getNombre());
        }*/

        /*ListView lvContactos = (ListView) findViewById(R.id.lvContactos);
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
        });*/



    }

    public void inicializarListaContactos(){
        contactos = new ArrayList<>();
        contactos.add(new Contacto("Anahi Salgado", "77779999", "anahi@gmail.com", R.drawable.contacto1));
        contactos.add(new Contacto("Pedro Sanchez", "88882222", "pedro@gmail.com", R.drawable.contacto2));
        contactos.add(new Contacto("Mireya Martinez", "33331111", "mireya@gmail.com", R.drawable.contacto3));
        contactos.add(new Contacto("Juan Lopez", "44442222", "juan@gmail.com", R.drawable.contacto4));
    }

    public void inicializarAdaptador(){
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos, this);
        listaContactos.setAdapter(adaptador);

    }
}