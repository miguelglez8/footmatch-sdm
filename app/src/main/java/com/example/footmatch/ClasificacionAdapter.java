package com.example.footmatch;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footmatch.modelo.Equipo;
import com.example.footmatch.modelo.Partido;


import java.util.List;


public class ClasificacionAdapter extends RecyclerView.Adapter<ClasificacionAdapter.ClasificacionViewHolder> {
    public interface OnItemClickListener {
        void onItemClick(Equipo item);
    }
    public List<Equipo> equipos;
    //Se utilizará mas adelante para ir a la pantalla de equipos
    private final OnItemClickListener listener;

    public ClasificacionAdapter(List<Equipo> equipos, OnItemClickListener listener){
        this.equipos = equipos;
        this.listener = listener;
    }



    @Override
    public int getItemCount() {
        return equipos.size();
    }


    public static class ClasificacionViewHolder extends RecyclerView.ViewHolder{

        private ImageView escudo;
        private TextView nombreEquipo;
        private  TextView puntosEquipo;

        public ClasificacionViewHolder(View itemView) {
            super(itemView);
            escudo = (ImageView)itemView.findViewById(R.id.imagenEquipo);
            nombreEquipo = (TextView) itemView.findViewById(R.id.equipoLiga);
            puntosEquipo = (TextView) itemView.findViewById(R.id.puntosEquipo);

        }

        // asignar valores a los componentes
        public void bindUser(@NonNull final Equipo equipo, final OnItemClickListener listener) {
            nombreEquipo.setText(equipo.getNombre());
            puntosEquipo.setText(String.valueOf(equipo.getPuntos()));
            //Picasso.get()
            //        .load(equipo.getUrlImagenEscudo()).into(escudo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    // Metodo para accerder a la plantilla desde clasificacion
                }
            });
        }
    }




    @NonNull
    @Override
    public ClasificacionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.linear_clasification_equipo, parent, false);
        return new ClasificacionViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ClasificacionViewHolder holder, int position) {
        Equipo equipo= equipos.get(position);
        holder.bindUser(equipo, listener);
    }


}
