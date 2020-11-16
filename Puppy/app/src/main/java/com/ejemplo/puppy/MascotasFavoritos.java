package com.ejemplo.puppy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ejemplo.puppy.adapters.MascotaAdaptador;
import com.ejemplo.puppy.database.ConstructorMascotas;

import java.util.ArrayList;

public class MascotasFavoritos extends AppCompatActivity {
    //Atributos:
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotasFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritos);

        Toolbar miActionBar = (Toolbar)findViewById(R.id.miActionBarSinIB);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotasFav = (RecyclerView)findViewById(R.id.rvMascotasFav);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotasFav.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<>();
        //mascotas.add(new Mascota("Napo", R.drawable.puppy1, R.mipmap.dog_bone, R.id.tvRaiting, R.mipmap.dog_bone_de_conteo));
        //mascotas.add(new Mascota("Buda", R.drawable.puppy2, R.mipmap.dog_bone, R.id.tvRaiting, R.mipmap.dog_bone_de_conteo));
        //mascotas.add(new Mascota("Penny", R.drawable.puppy3, R.mipmap.dog_bone, R.id.tvRaiting, R.mipmap.dog_bone_de_conteo));
        //mascotas.add(new Mascota("Bunda", R.drawable.puppy4, R.mipmap.dog_bone, R.id.tvRaiting, R.mipmap.dog_bone_de_conteo));
        //mascotas.add(new Mascota("Chiquita", R.drawable.puppy5, R.mipmap.dog_bone, R.id.tvRaiting, R.mipmap.dog_bone_de_conteo));
        ConstructorMascotas constructorMascotas = new ConstructorMascotas(this);
        mascotas = constructorMascotas.obtenerMascotasFav();

    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotasFav.setAdapter(adaptador);

    }

}