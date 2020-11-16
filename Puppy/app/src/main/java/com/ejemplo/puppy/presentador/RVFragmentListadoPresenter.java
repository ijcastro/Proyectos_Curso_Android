package com.ejemplo.puppy.presentador;

import android.content.Context;

import com.ejemplo.puppy.Mascota;
import com.ejemplo.puppy.database.ConstructorMascotas;
import com.ejemplo.puppy.vistafragments.IRVFragmentListadoView;

import java.util.ArrayList;

public class RVFragmentListadoPresenter implements IRVFragmentListadoPresenter{
    //Atributos:
    private IRVFragmentListadoView irvFragmentListadoView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    //Constructor:
    public RVFragmentListadoPresenter(IRVFragmentListadoView irvFragmentListadoView, Context context){
        this.irvFragmentListadoView = irvFragmentListadoView;
        this.context = context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerMascotas();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        irvFragmentListadoView.inicializarAdaptadorRV(irvFragmentListadoView.crearAdaptador(mascotas));
        irvFragmentListadoView.generarLinearLayoutVertical();
    }
}
