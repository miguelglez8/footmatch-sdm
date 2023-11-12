package com.example.footmatch;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footmatch.modelo.Jugador;
import com.example.footmatch.modelo.Partido;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListaJugadoresAdapter extends RecyclerView.Adapter<ListaJugadoresAdapter.JugadorViewHolder> {

    // Interfaz para manejar el evento click sobre un elemento
    public interface OnItemClickListener {
        void onItemClick(Jugador item);
    }

    private List<Jugador> listaJugadores;
    private final OnItemClickListener listener;

    public ListaJugadoresAdapter(List<Jugador> listaJugadores, OnItemClickListener listener) {
        this.listaJugadores = listaJugadores;
        this.listener = listener;
    }

    /* Indicamos el layout a "inflar" para usar en la vista
     */
    @NonNull
    @Override
    public JugadorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Creamos la vista con el layout para un elemento
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_jugador, parent, false);
        return new JugadorViewHolder(itemView);
    }


    /** Asocia el contenido a los componentes de la vista,
     * concretamente con nuestro PartidoViewHolder que recibimos como parámetro
     */
    @Override
    public void onBindViewHolder(@NonNull JugadorViewHolder holder, int position) {
        // Extrae de la lista el elemento indicado por posición
        Jugador jugador= listaJugadores.get(position);
        Log.i("Lista","Visualiza elemento: "+jugador);
        // llama al método de nuestro holder para asignar valores a los componentes
        // además, pasamos el listener del evento onClick
        holder.bindUser(jugador, listener);
    }

    @Override
    public int getItemCount() {
        return listaJugadores.size();
    }

    /*Clase interna que define los compoonentes de la vista*/

    public static class JugadorViewHolder extends RecyclerView.ViewHolder{

        private TextView dorsal;

        private TextView jugador;

        private TextView posicion;

        public JugadorViewHolder(View itemView) {
            super(itemView);
            dorsal = (TextView) itemView.findViewById(R.id.textDorsal);
            posicion = (TextView) itemView.findViewById(R.id.textPosicion);
            jugador = (TextView) itemView.findViewById(R.id.textNombreJugador);
        }

        // asignar valores a los componentes
        public void bindUser(final Jugador jugador, final OnItemClickListener listener) {
            // cargar nombre equipo local
            this.dorsal.setText(jugador.getDorsal());
            // cargar nombre equipo visitante
            this.posicion.setText(jugador.getPosicion());
            // cargar resultado
            this.jugador.setText(jugador.getNombre());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    // De momento no hacemos nada al pulsar sobre un partido
                }
            });
        }
    }

}
