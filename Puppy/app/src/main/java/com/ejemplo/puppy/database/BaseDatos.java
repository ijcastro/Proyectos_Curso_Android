package com.ejemplo.puppy.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.ejemplo.puppy.Mascota;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {
    //Atributos:
    private Context context;

    public BaseDatos(@Nullable Context context) {
        super(context, Constantes.DATABASE_NAME, null, Constantes.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascotas = "CREATE TABLE " + Constantes.TABLA_MASCOTAS + "(" +
                Constantes.TABLA_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Constantes.TABLA_MASCOTAS_NOMBRE + " TEXT, " +
                Constantes.TABLA_MASCOTAS_IMAGEN + " INTEGER, " +
                Constantes.TABLA_MASCOTAS_BTNLIKES + " INTEGER, " +
                Constantes.TABLA_MASCOTAS_CANTLIKES + " INTEGER, " +
                Constantes.TABLA_MASCOTAS_FOTOLIKES + " INTEGER" + ")";

        String queryCrearTablaMascotasFav = "CREATE TABLE " + Constantes.TABLA_MASCOTAS_FAV + "(" +
                Constantes.TABLA_MASCOTAS_FAV_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Constantes.TABLA_MASCOTAS_FAV_NOMBRE + " TEXT, " +
                Constantes.TABLA_MASCOTAS_FAV_IMAGEN + " INTEGER, " +
                Constantes.TABLA_MASCOTAS_FAV_CANTLIKES + " INTEGER, " +
                Constantes.TABLA_MASCOTAS_FAV_FOTOLIKES + " INTEGER, " +
                "FOREIGN KEY (" + Constantes.TABLA_MASCOTAS_FAV_ID + ") " + "REFERENCES " + Constantes.TABLA_MASCOTAS +
                "(" + Constantes.TABLA_MASCOTAS_ID + ")" + ")";

        db.execSQL(queryCrearTablaMascotas);
        db.execSQL(queryCrearTablaMascotasFav);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Constantes.TABLA_MASCOTAS);
        db.execSQL("DROP TABLE IF EXISTS " + Constantes.TABLA_MASCOTAS_FAV);
        onCreate(db);
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(Constantes.TABLA_MASCOTAS, null, contentValues);
        db.close();
    }

    public void insertarMascotaFav(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(Constantes.TABLA_MASCOTAS_FAV, null, contentValues);
        db.close();
    }

    public ArrayList<Mascota> obtenerListaMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + Constantes.TABLA_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota nuevaMascota = new Mascota();
            nuevaMascota.setId(registros.getInt(0));
            nuevaMascota.setNombreMascota(registros.getString(1));
            nuevaMascota.setImagenMascota(registros.getInt(2));
            nuevaMascota.setBotonLike(registros.getInt(3));
            nuevaMascota.setCantLikes(registros.getInt(4));
            nuevaMascota.setFotoLikes(registros.getInt(5));
            mascotas.add(nuevaMascota);
        }
        db.close();
        return mascotas;
    }
}
