package com.ejemplo.miscontactos.vistafragment;

import com.ejemplo.miscontactos.Contacto;
import com.ejemplo.miscontactos.adapters.ContactoAdaptador;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos);

    public void inicializarAdaptadorRV(ContactoAdaptador adaptador);
}
