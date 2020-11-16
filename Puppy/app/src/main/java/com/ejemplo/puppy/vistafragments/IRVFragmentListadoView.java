package com.ejemplo.puppy.vistafragments;

import com.ejemplo.puppy.Mascota;
import com.ejemplo.puppy.adapters.MascotaAdaptador;

import java.util.ArrayList;

public interface IRVFragmentListadoView {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
