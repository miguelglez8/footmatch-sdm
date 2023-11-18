package com.example.footmatch.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footmatch.ListaEventosAdapter;
import com.example.footmatch.R;
import com.example.footmatch.modelo.eventos.Evento;

import java.util.List;

public class EventosFragment extends Fragment {

    private static final String EVENTOS = "Eventos";
    private List<Evento> listaEventos;
    private RecyclerView recyclerViewGoles;
    private RecyclerView recyclerViewTarjetas;
    private RecyclerView recyclerViewCambios;

    private ListaEventosAdapter adapterGoles;
    private ListaEventosAdapter adapterTarjetas;
    private ListaEventosAdapter adapterCambios;

    public EventosFragment() {
        // Constructor vacío requerido por Android
    }

    public static EventosFragment newInstance(List<Evento> listaEventos) {
        EventosFragment fragment = new EventosFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(EVENTOS, new java.util.ArrayList<>(listaEventos));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            listaEventos = getArguments().getParcelableArrayList(EVENTOS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_eventos, container, false);

        recyclerViewGoles = root.findViewById(R.id.recyclerViewGoles);
        recyclerViewTarjetas = root.findViewById(R.id.recyclerViewTarjetas);
        recyclerViewCambios = root.findViewById(R.id.recyclerViewOtros);

        // Configura los RecyclerViews con los adaptadores
        // Configura los RecyclerViews con los adaptadores
        this.adapterGoles = new ListaEventosAdapter(listaEventos, new ListaEventosAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Evento item) {
                // Maneja el clic en un elemento de la lista si es necesario
            }
        });
        setUpRecyclerView(recyclerViewGoles, adapterGoles);
        // Configura los RecyclerViews con los adaptadores
        this.adapterTarjetas = new ListaEventosAdapter(listaEventos, new ListaEventosAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Evento item) {
                // Maneja el clic en un elemento de la lista si es necesario
            }
        });
        setUpRecyclerView(recyclerViewTarjetas, adapterTarjetas);
        // Configura los RecyclerViews con los adaptadores
        this.adapterCambios = new ListaEventosAdapter(listaEventos, new ListaEventosAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Evento item) {
                // Maneja el clic en un elemento de la lista si es necesario
            }
        });
        setUpRecyclerView(recyclerViewCambios, adapterCambios);

        return root;
    }

    private void setUpRecyclerView(RecyclerView recyclerView, ListaEventosAdapter adapter) {
        // Configura el RecyclerView y su adaptador
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

}
