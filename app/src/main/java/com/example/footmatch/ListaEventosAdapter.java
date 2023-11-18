package com.example.footmatch;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footmatch.modelo.eventos.Evento;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListaEventosAdapter extends RecyclerView.Adapter<ListaEventosAdapter.EventoViewHolder> {

    private static final int TIPO_LOCAL = 0;
    private static final int TIPO_VISITANTE = 1;

    // Interfaz para manejar el evento click sobre un elemento
    public interface OnItemClickListener {
        void onItemClick(Evento item);
    }

    private List<Evento> listaEventos;
    private final OnItemClickListener listener;

    public ListaEventosAdapter(List<Evento> listaEventos, OnItemClickListener listener) {
        this.listaEventos = listaEventos;
        this.listener = listener;
    }

    @Override
    public int getItemViewType(int position) {
        // Devuelve el tipo de vista en función de si es local o no
        if (listaEventos.get(position).isLocal()) {
            return TIPO_LOCAL;
        } else {
            return TIPO_VISITANTE;
        }
    }

    /* Indicamos el layout a "inflar" para usar en la vista */
    @NonNull
    @Override
    public EventoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Creamos la vista con el layout para un elemento
        // se debe de añadir la de local o la de visitante
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case TIPO_LOCAL:
                View tipoAView = inflater.inflate(R.layout.item_evento_local, parent, false);
                return new EventoViewHolder(tipoAView);
            case TIPO_VISITANTE:
                View tipoBView = inflater.inflate(R.layout.item_evento_visitante, parent, false);
                return new EventoViewHolder(tipoBView);
            default:
                return null;
        }
    }

    /** Asocia el contenido a los componentes de la vista,
     * concretamente con nuestro EventoViewHolder que recibimos como parámetro
     */
    @Override
    public void onBindViewHolder(@NonNull EventoViewHolder holder, int position) {
        // Extrae de la lista el elemento indicado por posición
        Evento evento = listaEventos.get(position);
        Log.i("Lista", "Visualiza elemento: " + evento);
        // llama al método de nuestro holder para asignar valores a los componentes
        // además, pasamos el listener del evento onClick
        holder.bindEvento(evento, listener);
    }

    @Override
    public int getItemCount() {
        return listaEventos.size();
    }

    /* Clase interna que define los componentes de la vista */

    public static class EventoViewHolder extends RecyclerView.ViewHolder {

        private TextView primerFactor;
        private TextView segundoFactor;
        private ImageView icono1;
        private ImageView icono2;
        private TextView minutoEvento;

        public EventoViewHolder(View itemView) {
            super(itemView);

            primerFactor = itemView.findViewById(R.id.primer_factor);
            segundoFactor = itemView.findViewById(R.id.segundo_factor);
            icono1 = itemView.findViewById(R.id.icono1);
            icono2 = itemView.findViewById(R.id.icono2);
            minutoEvento = itemView.findViewById(R.id.minuto_evento);
        }

        // Asignar valores a los componentes
        public void bindEvento(final Evento evento, final OnItemClickListener listener) {
            primerFactor.setText(evento.getPrimerFactor());
            segundoFactor.setText(evento.getSegundoFactor());
            minutoEvento.setText(evento.getMinuto());

            Picasso.get().load(evento.getPrimerUrl()).into(icono1);
            Picasso.get().load(evento.getSegundoUrl()).into(icono2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("Evento", "Click en evento");
                    listener.onItemClick(evento);
                }
            });
        }
    }
}
