package com.ejemplo.puppy.vistafragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ejemplo.puppy.Mascota;
import com.ejemplo.puppy.R;
import com.ejemplo.puppy.adapters.MascotaAdaptador;
import com.ejemplo.puppy.database.BaseDatos;
import com.ejemplo.puppy.database.ConstructorMascotas;
import com.ejemplo.puppy.presentador.IRVFragmentListadoPresenter;
import com.ejemplo.puppy.presentador.RVFragmentListadoPresenter;

import java.util.ArrayList;


public class FragmentListado extends Fragment implements IRVFragmentListadoView{
    //Atributos:
    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private Context context;
    private IRVFragmentListadoPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_listado, container, false);
        listaMascotas = (RecyclerView)v.findViewById(R.id.rvMascotas);
        presenter =new RVFragmentListadoPresenter(this, getContext());
        //LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        //llm.setOrientation(LinearLayoutManager.VERTICAL);
        //listaMascotas.setLayoutManager(llm);
        //inicializarListaMascotas();
        //inicializarAdaptador();
        return v;
    }

    /*public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);

    }*/

    /*public void inicializarListaMascotas(){
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota("Napo", R.drawable.puppy1, R.mipmap.dog_bone, 0, R.mipmap.dog_bone_de_conteo));
        mascotas.add(new Mascota("Buda", R.drawable.puppy2, R.mipmap.dog_bone, 0, R.mipmap.dog_bone_de_conteo));
        mascotas.add(new Mascota("Penny", R.drawable.puppy3, R.mipmap.dog_bone, 0, R.mipmap.dog_bone_de_conteo));
        mascotas.add(new Mascota("Bunda", R.drawable.puppy4, R.mipmap.dog_bone, 0, R.mipmap.dog_bone_de_conteo));
        mascotas.add(new Mascota("Chiquita", R.drawable.puppy5, R.mipmap.dog_bone, 0, R.mipmap.dog_bone_de_conteo));
        BaseDatos db = new BaseDatos(context);
        ConstructorMascotas constructorMascotas = new ConstructorMascotas(context);
        constructorMascotas.insertarMascotas(db);
        constructorMascotas.obtenerMascotas(db);
    }*/

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}