package com.ejemplo.miscontactos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder>{
    //Atributos
    ArrayList<Contacto> contactos;

    //Constructor:
    public ContactoAdaptador(ArrayList<Contacto> contactos){
        this.contactos = contactos;
    }

    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto, parent, false);
        return null;
    }

    @Override
    public void onBindViewHolder(ContactoViewHolder holder, int position) {
        Contacto contacto = contactos.get(position);
        holder.ivFotoContacto.setImageResource(contacto.getFoto());
        holder.tvNombreContacto2.setText(contacto.getNombre());
        holder.tvTelefonoContacto2.setText(contacto.getTelefono());
    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder {
        //Atributos:
        private ImageView ivFotoContacto;
        private TextView tvNombreContacto2;
        private TextView tvTelefonoContacto2;

        public ContactoViewHolder(View itemView) {
            super(itemView);
            ivFotoContacto = (ImageView) itemView.findViewById(R.id.ivFotoContacto);
            tvNombreContacto2 = (TextView) itemView.findViewById(R.id.tvNombreContacto2);
            tvTelefonoContacto2 = (TextView) itemView.findViewById(R.id.tvTelefonoContacto2);



        }
    }




}
