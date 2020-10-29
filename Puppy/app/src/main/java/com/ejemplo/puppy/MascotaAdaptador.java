package com.ejemplo.puppy;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{
    //Atributos:
    ArrayList<Mascota> mascotas;
    Activity activity;

    //Constructor:
    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.ivMascotaContacto.setImageResource(mascota.getImagenMascota());
        holder.tvNombreMascota.setText(mascota.getNombreMascota());
        holder.ivConteoLike.setImageResource(mascota.getFotoLikes());
        holder.etRaiting.setText(mascota.getCantLikes());
        holder.ibLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a " + mascota.getNombreMascota() + "!", Toast.LENGTH_SHORT).show();
            }
        });


    }


    /*public int calcularLikes(){
            int aux = 0;
            if(holder.ibLike.isActivated() == true){
                aux =+ 1;
            }
            return aux;
        }*/

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        //Atributos:
        private ImageView ivMascotaContacto;
        private ImageButton ibLike;
        private TextView tvNombreMascota;
        private EditText etRaiting;
        private ImageView ivConteoLike;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            ivMascotaContacto = (ImageView) itemView.findViewById(R.id.ivMascotaContacto);
            ibLike = (ImageButton) itemView.findViewById(R.id.ibLike);
            tvNombreMascota = (TextView) itemView.findViewById(R.id.tvNombreMascota);
            etRaiting = (EditText) itemView.findViewById(R.id.etRaiting);
            ivConteoLike = (ImageView) itemView.findViewById(R.id.ivConteoLike);
        }
    }

}
