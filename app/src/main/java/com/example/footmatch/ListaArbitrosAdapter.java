package com.example.footmatch;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footmatch.modelo.Arbitro;

import java.util.List;

public class ListaArbitrosAdapter extends RecyclerView.Adapter<ListaArbitrosAdapter.ArbitroViewHolder> {

    // Interfaz para manejar el evento click sobre un elemento
    public interface OnItemClickListener {
        void onItemClick(Arbitro item);
    }

    private List<Arbitro> listaArbitros;
    private final OnItemClickListener listener;

    public ListaArbitrosAdapter(List<Arbitro> listaArbitros, OnItemClickListener listener) {
        this.listaArbitros = listaArbitros;
        this.listener = listener;
    }

    /* Indicamos el layout a "inflar" para usar en la vista
     */
    @NonNull
    @Override
    public ArbitroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Creamos la vista con el layout para un elemento
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_arbitros, parent, false);
        return new ArbitroViewHolder(itemView);
    }


    /** Asocia el contenido a los componentes de la vista,
     * concretamente con nuestro PeliculaViewHolder que recibimos como parámetro
     */
    @Override
    public void onBindViewHolder(@NonNull ArbitroViewHolder holder, int position) {
        // Extrae de la lista el elemento indicado por posición
        Arbitro arbitro= listaArbitros.get(position);
        Log.i("Lista","Visualiza elemento: "+arbitro);
        // llama al método de nuestro holder para asignar valores a los componentes
        // además, pasamos el listener del evento onClick
        holder.bindUser(arbitro, listener);
    }

    @Override
    public int getItemCount() {
        return listaArbitros.size();
    }

    /*Clase interna que define los compoonentes de la vista*/

    public static class ArbitroViewHolder extends RecyclerView.ViewHolder{

        private TextView funcion;
        private TextView arbitro;

        public ArbitroViewHolder(View itemView) {
            super(itemView);

            funcion = (TextView)itemView.findViewById(R.id.tvFunction);
            arbitro = (TextView)itemView.findViewById(R.id.tvArbitroName);
        }

        // asignar valores a los componentes
        public void bindUser(final Arbitro arbitro, final OnItemClickListener listener) {
            this.funcion.setText(arbitro.getCargo());

            this.arbitro.setText(arbitro.getNombre());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    Log.i("Hola", "Hola");
                    listener.onItemClick(arbitro);
                }
            });
        }
    }

}
