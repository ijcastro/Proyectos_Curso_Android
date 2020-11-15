package com.ejemplo.miscontactos.db;

import android.content.ContentValues;
import android.content.Context;

import com.ejemplo.miscontactos.Contacto;
import com.ejemplo.miscontactos.R;

import java.util.ArrayList;

public class ConstructorContactos {
    private static final int LIKE = 1;
    //Atributos:
    private Context context;

    //Constructor:
    public ConstructorContactos(Context context){
        this.context = context;
    }

    public ArrayList<Contacto> obtenerDatos(){
            /*ArrayList<Contacto> contactos = new ArrayList<>();
            contactos.add(new Contacto("Anahi Salgado", "77779999", "anahi@gmail.com", R.drawable.contacto4, 4));
            contactos.add(new Contacto("Pedro Sanchez", "88882222", "pedro@gmail.com", R.drawable.contacto2, 5));
            contactos.add(new Contacto("Mireya Martinez", "33331111", "mireya@gmail.com", R.drawable.contacto3, 6));
            contactos.add(new Contacto("Juan Lopez", "44442222", "juan@gmail.com", R.drawable.contacto1, 7));
            return contactos;*/

        BaseDatos db = new BaseDatos(context);
        insertarTresContactos(db);
        return db.obtenerTodosLosContactos();
    }

    public void insertarTresContactos(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Anahi Salgado");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "77779999");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "anahi@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.contacto4);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Mireya Martinez");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "33331111");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "mireya@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.contacto3);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Juan Lopez");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "44442222");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "juan@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.contacto1);
        db.insertarContacto(contentValues);
    }

    public void darLikeContacto(Contacto contacto){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO, contacto.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_NUMERO_LIKES, LIKE);
        db.insertarLikeContacto(contentValues);
    }

    public int obtenerLikesContacto(Contacto contacto){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesContacto(contacto);
    }
}
