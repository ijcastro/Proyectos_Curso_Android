package com.ejemplo.puppy.presentador;

import com.ejemplo.puppy.Mascota;
import com.ejemplo.puppy.adapters.MascotaAdaptador;

import java.util.ArrayList;

public interface IRVFragmentListadoPresenter {

    public void obtenerMascotasBaseDatos();

    public void mostrarMascotasRV();
}
