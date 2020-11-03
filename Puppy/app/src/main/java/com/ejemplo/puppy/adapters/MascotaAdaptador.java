package com.ejemplo.puppy.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ejemplo.puppy.Mascota;
import com.ejemplo.puppy.R;

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
        holder.ibLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a " + mascota.getNombreMascota() + "!", Toast.LENGTH_SHORT).show();
            }
        });
        holder.tvRaiting.setText(String.valueOf(mascota.contarLikes(holder.ibLike)));

    }




    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        //Atributos:
        private ImageView ivMascotaContacto;
        private ImageButton ibLike;
        private TextView tvNombreMascota;
        private TextView tvRaiting;
        private ImageView ivConteoLike;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            ivMascotaContacto = (ImageView) itemView.findViewById(R.id.ivMascotaContacto);
            ibLike = (ImageButton) itemView.findViewById(R.id.ibLike);
            tvNombreMascota = (TextView) itemView.findViewById(R.id.tvNombreMascota);
            tvRaiting = (TextView) itemView.findViewById(R.id.tvRaiting);
            ivConteoLike = (ImageView) itemView.findViewById(R.id.ivConteoLike);
        }
    }

}
