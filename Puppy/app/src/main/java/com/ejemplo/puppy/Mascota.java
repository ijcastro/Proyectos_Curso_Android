package com.ejemplo.puppy;

import android.view.View;

public class Mascota {
    //Atributos:
    private String nombreMascota;
    private int imagenMascota;
    private int botonLike;
    private int cantLikes;
    private int fotoLikes;


    public Mascota(String nombreMascota, int imagenMascota, int botonLike, int cantLikes, int fotoLikes){
        this.nombreMascota = nombreMascota;
        this.imagenMascota = imagenMascota;
        this.botonLike = botonLike;
        this.cantLikes = cantLikes;
        this.fotoLikes = fotoLikes;
    }

    public Mascota(int imagenMascota, int cantLikes, int fotoLikes){
        this.imagenMascota = imagenMascota;
        this.cantLikes = cantLikes;
        this.fotoLikes = fotoLikes;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public int getImagenMascota() {
        return imagenMascota;
    }

    public void setImagenMascota(int imagenMascota) {
        this.imagenMascota = imagenMascota;
    }

    public int getBotonLike() {
        return botonLike;
    }

    public void setBotonLike(int botonLike) {
        this.botonLike = botonLike;
    }

    public int getCantLikes() {
        return cantLikes;
    }

    public void setCantLikes(int cantLikes) {
        this.cantLikes = cantLikes;
    }

    public int getFotoLikes() {
        return fotoLikes;
    }

    public void setFotoLikes(int fotoLikes) {
        this.fotoLikes = fotoLikes;
    }

    public int contarLikes(View v){
        int aux = 0;
        if(v.callOnClick()){
            aux =+ 1;
        }
        return aux;
    }

}
