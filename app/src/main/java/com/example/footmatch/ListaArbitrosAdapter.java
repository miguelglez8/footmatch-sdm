package com.example.footmatch;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListaArbitrosAdapter extends RecyclerView.Adapter<ListaArbitrosAdapter.ArbitroViewHolder> {
    public interface OnItemClickListener {
        void onItemClick(String item);
    }

    private List<String> listaArbitros;
    private List<String> otraLista; // Nueva lista de cadenas
    private OnItemClickListener listener;

    public ListaArbitrosAdapter(List<String> listaArbitros, List<String> otraLista, OnItemClickListener listener) {
        this.listaArbitros = listaArbitros;
        this.otraLista = otraLista;
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return listaArbitros.size();
    }

    public static class ArbitroViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewNombreArbitro;
        private TextView textViewOtroDato; // Nuevo TextView

        public ArbitroViewHolder(View itemView) {
            super(itemView);
            textViewNombreArbitro = itemView.findViewById(R.id.textNombreArbitro); // Asegúrate de que el ID sea el correcto.
            textViewOtroDato = itemView.findViewById(R.id.otroTextView); // Asegúrate de que el ID sea el correcto.
        }

        public void bindArbitro(@NonNull final String nombreArbitro, final String otroDato, final OnItemClickListener listener) {
            textViewNombreArbitro.setText(nombreArbitro);
            textViewOtroDato.setText(otroDato);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(nombreArbitro);
                }
            });
        }
    }

    @NonNull
    @Override
    public ArbitroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_arbitro, parent, false); // Asegúrate de que el diseño tenga los TextViews con los IDs correctos.
        return new ArbitroViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ArbitroViewHolder holder, int position) {
        String nombreArbitro = listaArbitros.get(position);
        String otroDato = otraLista.get(position); // Obtener el dato de la otra lista
        holder.bindArbitro(nombreArbitro, otroDato, listener);
    }
}
