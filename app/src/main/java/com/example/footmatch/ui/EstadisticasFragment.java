package com.example.footmatch.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.favmovies.R;
import com.example.footmatch.ListaArbitrosAdapter;

import java.util.ArrayList;
import java.util.List;


//Vamos a heredar de la clase Fragment
public class EstadisticasFragment extends Fragment {

    /* Las variables que utilizaremos */
    private static final String ARBITROS="Árbitros";
    private static final String TITULO_ARBITROS="Título_Árbitros";

    private List<String> listaArbitros;
    private List<String> listaTitulosArbitros;


    /*

        Esto es un FactoryMethod.
        Los datos están siendo enviados ANTES del onCreate.
        El Bundle permanece cuando se tiene que recrear.
     */
    public static EstadisticasFragment newInstance(ArrayList<String> arbitros, ArrayList<String> titulosArbitros) {
        EstadisticasFragment fragment = new EstadisticasFragment();
        Bundle args = new Bundle();
        //Esto no tiene mucha ciencia -> Clave, valor.
        args.putStringArrayList(ARBITROS, arbitros);
        args.putStringArrayList(TITULO_ARBITROS, titulosArbitros);
        fragment.setArguments(args);
        return fragment;
    }

    /*
        Aquí están disponibles ya los datos necesarios.
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            listaArbitros = getArguments().getStringArrayList(ARBITROS);
            listaTitulosArbitros = getArguments().getStringArrayList(TITULO_ARBITROS);
        }
    }

    /* Al crear la vista, cargamos los valores necesarios */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_arbitros, container, false);

        // Obten el RecyclerView del diseño del fragmento
        RecyclerView recyclerView = root.findViewById(R.id.reciclerViewArbitros);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        // Crea una instancia del adaptador y pásale la lista de intérpretes y un listener si es necesario
        ListaArbitrosAdapter adapter = new ListaArbitrosAdapter(listaArbitros, listaTitulosArbitros, new ListaArbitrosAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String item) {
                // Maneja el clic en un elemento de la lista si es necesario
            }
        });

        // Configura el adaptador en el RecyclerView
        recyclerView.setAdapter(adapter);

        return root;
    }
}