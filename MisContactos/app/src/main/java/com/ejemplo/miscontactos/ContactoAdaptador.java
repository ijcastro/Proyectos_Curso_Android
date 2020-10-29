package com.ejemplo.miscontactos;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder> {
    //Atributos:
    ArrayList<Contacto> contactos;
    Activity activity;

    //Método constructor
    public ContactoAdaptador(ArrayList<Contacto> contactos, Activity activity){
        this.contactos = contactos;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto, parent, false);
        return new ContactoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder contactoViewHolder, int position) {
        final Contacto contacto = contactos.get(position);
        contactoViewHolder.ivFotoContacto.setImageResource(contacto.getFoto());
        contactoViewHolder.tvNombreContacto2.setText(contacto.getNombre());
        contactoViewHolder.tvTelefonoContacto2.setText(contacto.getTelefono());

        contactoViewHolder.ivFotoContacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, contacto.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, DetalleContacto.class);
                intent.putExtra("nombre", contacto.getNombre());
                intent.putExtra("telefono", contacto.getTelefono());
                intent.putExtra("email", contacto.getEmail());
                activity.startActivity(intent);
            }
        });

        contactoViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a " + contacto.getNombre(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{
        //Atributos:
        private ImageView ivFotoContacto;
        private TextView tvNombreContacto2;
        private TextView tvTelefonoContacto2;
        private ImageButton btnLike;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFotoContacto = (ImageView) itemView.findViewById(R.id.ivFotoContacto);
            tvNombreContacto2 = (TextView) itemView.findViewById(R.id.tvNombreContacto2);
            tvTelefonoContacto2 = (TextView) itemView.findViewById(R.id.tvTelefonoContacto2);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);
        }
    }



}
