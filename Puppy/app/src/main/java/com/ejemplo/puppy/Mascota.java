package com.ejemplo.puppy;

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
}
