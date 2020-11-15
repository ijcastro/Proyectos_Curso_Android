package com.ejemplo.miscontactos.vistafragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ejemplo.miscontactos.Contacto;
import com.ejemplo.miscontactos.R;
import com.ejemplo.miscontactos.adapters.ContactoAdaptador;
import com.ejemplo.miscontactos.presentador.IRecyclerViewFragmentPresenter;
import com.ejemplo.miscontactos.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView {
    //Atributos:
    private ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;
    private IRecyclerViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        listaContactos = (RecyclerView)v.findViewById(R.id.rvContactos);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        //LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        //llm.setOrientation(LinearLayoutManager.VERTICAL);
        //listaContactos.setLayoutManager(llm);

        //inicializarListaContactos();
        //inicializarAdaptador();
        return v;
    }

    /*public void inicializarListaContactos(){
        contactos = new ArrayList<>();
        contactos.add(new Contacto("Anahi Salgado", "77779999", "anahi@gmail.com", R.drawable.contacto1, 4));
        contactos.add(new Contacto("Pedro Sanchez", "88882222", "pedro@gmail.com", R.drawable.contacto2, 5));
        contactos.add(new Contacto("Mireya Martinez", "33331111", "mireya@gmail.com", R.drawable.contacto3, 6));
        contactos.add(new Contacto("Juan Lopez", "44442222", "juan@gmail.com", R.drawable.contacto4, 7));
    }*/

    //public void inicializarAdaptador(){
    //    ContactoAdaptador adaptador = new ContactoAdaptador(contactos, getActivity());
    //    listaContactos.setAdapter(adaptador);
    //
    //}

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaContactos.setLayoutManager(llm);
    }

    @Override
    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos) {
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(ContactoAdaptador adaptador) {
        listaContactos.setAdapter(adaptador);
    }
}
