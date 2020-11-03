package com.ejemplo.puppy.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ejemplo.puppy.Mascota;
import com.ejemplo.puppy.R;
import com.ejemplo.puppy.adapters.MascotaFavAdaptador;

import java.util.ArrayList;


public class FragmentFavorito extends Fragment {
    //Atributos:
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotasFav;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_favorito, container, false);

        listaMascotasFav = (RecyclerView)v.findViewById(R.id.rvMascotasFav);

        GridLayoutManager glm;
        glm = new GridLayoutManager(getContext(), 3);
        listaMascotasFav.setLayoutManager(glm);
        iniciarMascotasFav();
        iniciarAdaptador();

        return v;
    }

    public void iniciarMascotasFav(){
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota(R.drawable.puppy2, 1, R.mipmap.dog_bone_de_conteo));
        mascotas.add(new Mascota(R.drawable.puppy2, 2, R.mipmap.dog_bone_de_conteo));
        mascotas.add(new Mascota(R.drawable.puppy2, 3, R.mipmap.dog_bone_de_conteo));
        mascotas.add(new Mascota(R.drawable.puppy2, 4, R.mipmap.dog_bone_de_conteo));
        mascotas.add(new Mascota(R.drawable.puppy2, 5, R.mipmap.dog_bone_de_conteo));
        mascotas.add(new Mascota(R.drawable.puppy2, 6, R.mipmap.dog_bone_de_conteo));
        mascotas.add(new Mascota(R.drawable.puppy2, 7, R.mipmap.dog_bone_de_conteo));
        mascotas.add(new Mascota(R.drawable.puppy2, 8, R.mipmap.dog_bone_de_conteo));

    }

    public void iniciarAdaptador(){
        MascotaFavAdaptador adapter = new MascotaFavAdaptador(mascotas, getActivity());
        listaMascotasFav.setAdapter(adapter);
    }
}