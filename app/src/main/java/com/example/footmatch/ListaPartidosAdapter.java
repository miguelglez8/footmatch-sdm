package com.example.footmatch;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footmatch.modelo.Partido;
import com.example.footmatch.modelo.pojos.MatchResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListaPartidosAdapter extends RecyclerView.Adapter<ListaPartidosAdapter.PartidoViewHolder> {

    // Interfaz para manejar el evento click sobre un elemento
    public interface OnItemClickListener {
        void onItemClick(Partido item);
    }

    private List<MatchResponse> matchList;
    private final OnItemClickListener listener;

    public ListaPartidosAdapter(List<MatchResponse> matchList, OnItemClickListener listener) {
        this.matchList = matchList;
        this.listener = listener;
    }

    /*Clase interna que define los compoonentes de la vista*/

    public static class PartidoViewHolder extends RecyclerView.ViewHolder{

        private ImageView logoLocal;
        private TextView nombreLocal;

        private ImageView logoVisitante;
        private TextView nombreVisitante;

        private TextView resultado;

        private TextView fecha;

        public PartidoViewHolder(View itemView) {
            super(itemView);
            logoLocal = (ImageView) itemView.findViewById(R.id.imagenClasificacion);
            nombreLocal = (TextView) itemView.findViewById(R.id.equipoLocalNombreTextView);
            logoVisitante = (ImageView) itemView.findViewById(R.id.equipoVisitanteImageView);
            nombreVisitante = (TextView) itemView.findViewById(R.id.equipoVisitanteNombreTextView);
            resultado = (TextView) itemView.findViewById(R.id.resultadoTextView);
            fecha = (TextView) itemView.findViewById(R.id.fechaTextView);
        }

        // asignar valores a los componentes
        public void bindUser(final MatchResponse match, final OnItemClickListener listener) {

            // cargar imagen local
            Picasso.get()
                    .load(match.getHomeTeam().getFlag()).into(logoLocal);
            // cargar imagen visitante
            Picasso.get()
                    .load(match.getAwayTeam().getFlag()).into(logoVisitante);
            // cargar nombre equipo local
            nombreLocal.setText(match.getHomeTeam().getName());
            // cargar nombre equipo visitante
            nombreVisitante.setText(match.getAwayTeam().getName());
            // cargar resultado
            //resultado.setText(match.getScore().getFullTime());
            // cargar fecha partido
            fecha.setText(match.getUtcDate());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    // De momento no hacemos nada al pulsar sobre un partido
                }
            });
        }
    }
    /* Indicamos el layout a "inflar" para usar en la vista
     */
    @NonNull
    @Override
    public PartidoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Creamos la vista con el layout para un elemento
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.linea_recycler_view_partido, parent, false);
        return new PartidoViewHolder(itemView);
    }


    /** Asocia el contenido a los componentes de la vista,
     * concretamente con nuestro PartidoViewHolder que recibimos como parámetro
     */
    @Override
    public void onBindViewHolder(@NonNull PartidoViewHolder holder, int position) {
        // Extrae de la lista el elemento indicado por posición
        MatchResponse match= matchList.get(position);
        Log.i("Lista","Visualiza elemento: "+match);
        // llama al método de nuestro holder para asignar valores a los componentes
        // además, pasamos el listener del evento onClick
        holder.bindUser(match, listener);
    }

    @Override
    public int getItemCount() {
        return matchList.size();
    }



}
