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

public class MascotaFavAdaptador extends RecyclerView.Adapter<MascotaFavAdaptador.MascotaViewHolder>{
    //Atributos:
    ArrayList<Mascota> mascotasFav = new ArrayList<>();
    Activity activity;

    //Constructor:
    public MascotaFavAdaptador(ArrayList<Mascota> mascotasFav, Activity activity){
        this.mascotasFav = mascotasFav;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota_fav, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder holder, int position) {
        Mascota mascota = mascotasFav.get(position);
        holder.ivMascotaContacto2.setImageResource(mascota.getImagenMascota());
        holder.ivConteoLike2.setImageResource(mascota.getFotoLikes());
        holder.tvRaiting2.setText(String.valueOf(mascota.getCantLikes()));

    }

    @Override
    public int getItemCount() {
        return mascotasFav.size();
    }


    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        //Atributos:
        private ImageView ivMascotaContacto2;
        private TextView tvRaiting2;
        private ImageView ivConteoLike2;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            ivMascotaContacto2 = (ImageView) itemView.findViewById(R.id.ivMascotaContacto2);
            tvRaiting2 = (TextView) itemView.findViewById(R.id.tvRaiting2);
            ivConteoLike2 = (ImageView) itemView.findViewById(R.id.ivConteoLike2);
        }
    }

}
