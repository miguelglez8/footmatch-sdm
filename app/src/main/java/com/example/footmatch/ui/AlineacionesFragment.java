package com.example.footmatch.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footmatch.ListaArbitrosAdapter;
import com.example.footmatch.ListaJugadoresAdapter;
import com.example.footmatch.R;
import com.example.footmatch.modelo.Arbitro;
import com.example.footmatch.modelo.Equipo;
import com.example.footmatch.modelo.Jugador;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AlineacionesFragment extends Fragment {

    private static final String JUGADORES_EQUIPO1 = "Equipo1";
    private static final String JUGADORES_EQUIPO2 = "Equipo2";
    private Equipo jugadoresEquipo1;
    private Equipo jugadoresEquipo2;
    private RecyclerView recyclerViewJugadoresEquipo1;
    private RecyclerView recyclerViewJugadoresEquipo2;
    private TextView nombreEquipo1;
    private TextView nombreEquipo2;
    private TextView entrenadorEquipo1;
    private TextView entrenadorEquipo2;
    private TextView formacionEquipo1;
    private TextView formacionEquipo2;
    private ImageView imagenEquipo1;
    private ImageView imagenEquipo2;
    private ListaJugadoresAdapter adapterEquipo1;
    private ListaJugadoresAdapter adapterEquipo2;

    public AlineacionesFragment() {
        // Constructor vacío requerido por Android
    }

    public static AlineacionesFragment newInstance(Equipo e1, Equipo e2) {
        AlineacionesFragment fragment = new AlineacionesFragment();
        Bundle args = new Bundle();
        args.putParcelable(JUGADORES_EQUIPO1, e1);
        args.putParcelable(JUGADORES_EQUIPO2, e2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            jugadoresEquipo1 = getArguments().getParcelable(JUGADORES_EQUIPO1);
            jugadoresEquipo2 = getArguments().getParcelable(JUGADORES_EQUIPO2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_alineaciones, container, false);

        recyclerViewJugadoresEquipo1 = root.findViewById(R.id.recyclerViewJugadoresEquipo1);
        recyclerViewJugadoresEquipo2 = root.findViewById(R.id.recyclerViewJugadoresEquipo2);
        nombreEquipo1 = root.findViewById(R.id.nombreEquipo1);
        nombreEquipo2 = root.findViewById(R.id.nombreEquipo2);
        entrenadorEquipo1 = root.findViewById(R.id.entrenadorEquipo1);
        entrenadorEquipo2 = root.findViewById(R.id.entrenadorEquipo2);
        formacionEquipo1 = root.findViewById(R.id.formacionEquipo1);
        formacionEquipo2 = root.findViewById(R.id.formacionEquipo2);
        imagenEquipo1 = root.findViewById(R.id.imagenEquipo1);
        imagenEquipo2 = root.findViewById(R.id.imagenEquipo2);

        // Configura los RecyclerViews con los adaptadores
        if (jugadoresEquipo1.getPlantillaTitular().size()>0) {
            this.adapterEquipo1 = new ListaJugadoresAdapter(this.jugadoresEquipo1.getPlantillaTitular(), new ListaJugadoresAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(Jugador item) {
                    // Maneja el clic en un elemento de la lista si es necesario
                }
            });
            setUpRecyclerView(recyclerViewJugadoresEquipo1, adapterEquipo1);
        } else {
            // carga no_disponible
        }


        if (jugadoresEquipo2.getPlantillaTitular().size()>0) {
            this.adapterEquipo2 = new ListaJugadoresAdapter(this.jugadoresEquipo2.getPlantillaTitular(), new ListaJugadoresAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(Jugador item) {
                    // Maneja el clic en un elemento de la lista si es necesario
                }
            });
            setUpRecyclerView(recyclerViewJugadoresEquipo2, adapterEquipo2);
        } else {
            // carga no_disponible
        }

        cargarDatos();

        return root;
    }

    private void setUpRecyclerView(RecyclerView recyclerView, ListaJugadoresAdapter adapter) {
        // Configura el RecyclerView y su adaptador
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void cargarDatos() {
        // Aquí deberías cargar los datos reales de tus equipos
        nombreEquipo1.setText(jugadoresEquipo1.getNombre());
        nombreEquipo2.setText(jugadoresEquipo2.getNombre());
        entrenadorEquipo1.setText(jugadoresEquipo1.getEntrenador());
        entrenadorEquipo2.setText(jugadoresEquipo2.getEntrenador());
        formacionEquipo1.setText(jugadoresEquipo1.getFormacion());
        formacionEquipo2.setText(jugadoresEquipo2.getFormacion());

        Picasso.get().load(jugadoresEquipo1.getUrlImagenEscudo()).into(imagenEquipo1);
        Picasso.get().load(jugadoresEquipo2.getUrlImagenEscudo()).into(imagenEquipo2);
    }
}
