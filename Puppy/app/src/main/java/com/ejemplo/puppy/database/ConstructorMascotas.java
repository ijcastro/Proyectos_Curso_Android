package com.ejemplo.puppy.database;

import android.content.ContentValues;
import android.content.Context;

import com.ejemplo.puppy.Mascota;
import com.ejemplo.puppy.R;

import java.util.ArrayList;

public class ConstructorMascotas {
    private static final int LIKE = 1;
    //Atributos:
    private Context context;

    //Constructor:
    public ConstructorMascotas(Context context){
        this.context = context;
    }

    public void insertarMascotas(BaseDatos db){
        /*mascotas.add(new Mascota("Napo", R.drawable.puppy1, R.mipmap.dog_bone, 0, R.mipmap.dog_bone_de_conteo));
        mascotas.add(new Mascota("Buda", R.drawable.puppy2, R.mipmap.dog_bone, 0, R.mipmap.dog_bone_de_conteo));
        mascotas.add(new Mascota("Penny", R.drawable.puppy3, R.mipmap.dog_bone, 0, R.mipmap.dog_bone_de_conteo));
        mascotas.add(new Mascota("Bunda", R.drawable.puppy4, R.mipmap.dog_bone, 0, R.mipmap.dog_bone_de_conteo));
        mascotas.add(new Mascota("Chiquita", R.drawable.puppy5, R.mipmap.dog_bone, 0, R.mipmap.dog_bone_de_conteo));*/
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constantes.TABLA_MASCOTAS_NOMBRE, "Napo");
        contentValues.put(Constantes.TABLA_MASCOTAS_IMAGEN, R.drawable.puppy1);
        contentValues.put(Constantes.TABLA_MASCOTAS_BTNLIKES, R.mipmap.dog_bone);
        contentValues.put(Constantes.TABLA_MASCOTAS_CANTLIKES, 0);
        contentValues.put(Constantes.TABLA_MASCOTAS_CANTLIKES, R.mipmap.dog_bone_de_conteo);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(Constantes.TABLA_MASCOTAS_NOMBRE, "Buda");
        contentValues.put(Constantes.TABLA_MASCOTAS_IMAGEN, R.drawable.puppy2);
        contentValues.put(Constantes.TABLA_MASCOTAS_BTNLIKES, R.mipmap.dog_bone);
        contentValues.put(Constantes.TABLA_MASCOTAS_CANTLIKES, 0);
        contentValues.put(Constantes.TABLA_MASCOTAS_CANTLIKES, R.mipmap.dog_bone_de_conteo);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(Constantes.TABLA_MASCOTAS_NOMBRE, "Penny");
        contentValues.put(Constantes.TABLA_MASCOTAS_IMAGEN, R.drawable.puppy3);
        contentValues.put(Constantes.TABLA_MASCOTAS_BTNLIKES, R.mipmap.dog_bone);
        contentValues.put(Constantes.TABLA_MASCOTAS_CANTLIKES, 0);
        contentValues.put(Constantes.TABLA_MASCOTAS_CANTLIKES, R.mipmap.dog_bone_de_conteo);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(Constantes.TABLA_MASCOTAS_NOMBRE, "Bunda");
        contentValues.put(Constantes.TABLA_MASCOTAS_IMAGEN, R.drawable.puppy4);
        contentValues.put(Constantes.TABLA_MASCOTAS_BTNLIKES, R.mipmap.dog_bone);
        contentValues.put(Constantes.TABLA_MASCOTAS_CANTLIKES, 0);
        contentValues.put(Constantes.TABLA_MASCOTAS_CANTLIKES, R.mipmap.dog_bone_de_conteo);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(Constantes.TABLA_MASCOTAS_NOMBRE, "Chiquita");
        contentValues.put(Constantes.TABLA_MASCOTAS_IMAGEN, R.drawable.puppy5);
        contentValues.put(Constantes.TABLA_MASCOTAS_BTNLIKES, R.mipmap.dog_bone);
        contentValues.put(Constantes.TABLA_MASCOTAS_CANTLIKES, 0);
        contentValues.put(Constantes.TABLA_MASCOTAS_CANTLIKES, R.mipmap.dog_bone_de_conteo);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(Constantes.TABLA_MASCOTAS_NOMBRE, "Lassie");
        contentValues.put(Constantes.TABLA_MASCOTAS_IMAGEN, R.drawable.puppy6);
        contentValues.put(Constantes.TABLA_MASCOTAS_BTNLIKES, R.mipmap.dog_bone);
        contentValues.put(Constantes.TABLA_MASCOTAS_CANTLIKES, 0);
        contentValues.put(Constantes.TABLA_MASCOTAS_CANTLIKES, R.mipmap.dog_bone_de_conteo);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(Constantes.TABLA_MASCOTAS_NOMBRE, "Loli");
        contentValues.put(Constantes.TABLA_MASCOTAS_IMAGEN, R.drawable.puppy7);
        contentValues.put(Constantes.TABLA_MASCOTAS_BTNLIKES, R.mipmap.dog_bone);
        contentValues.put(Constantes.TABLA_MASCOTAS_CANTLIKES, 0);
        contentValues.put(Constantes.TABLA_MASCOTAS_CANTLIKES, R.mipmap.dog_bone_de_conteo);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(Constantes.TABLA_MASCOTAS_NOMBRE, "Ginny");
        contentValues.put(Constantes.TABLA_MASCOTAS_IMAGEN, R.drawable.puppy8);
        contentValues.put(Constantes.TABLA_MASCOTAS_BTNLIKES, R.mipmap.dog_bone);
        contentValues.put(Constantes.TABLA_MASCOTAS_CANTLIKES, 0);
        contentValues.put(Constantes.TABLA_MASCOTAS_CANTLIKES, R.mipmap.dog_bone_de_conteo);
        db.insertarMascota(contentValues);

    }

    public void insertarLikesMascotas(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constantes.TABLA_MASCOTAS_LIKES_MASCOTA, mascota.getId());
        contentValues.put(Constantes.TABLA_MASCOTAS_LIKES_CANTLIKES, LIKE);
        db.insertarMascotaLikes(contentValues);
    }

    public ArrayList<Mascota> obtenerMascotas(){
        BaseDatos db = new BaseDatos(context);
        insertarMascotas(db);
        return db.obtenerListaMascotas();
    }

    public void insertarMascotasFavoritas(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constantes.TABLA_MASCOTAS_FAV_NOMBRE, mascota.getNombreMascota());
        contentValues.put(Constantes.TABLA_MASCOTAS_FAV_IMAGEN, mascota.getImagenMascota());
        contentValues.put(Constantes.TABLA_MASCOTAS_FAV_FOTOLIKES, mascota.getFotoLikes());
        contentValues.put(Constantes.TABLA_MASCOTAS_FAV_CANTLIKES, mascota.getCantLikes());
        db.insertarMascotaFav(contentValues);
    }

    public ArrayList<Mascota> obtenerMascotasFav(){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerListaMascotasFav();
    }
}
