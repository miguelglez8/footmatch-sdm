package com.example.footmatch.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footmatch.ListaArbitrosAdapter;
import com.example.footmatch.R;
import com.example.footmatch.modelo.Arbitro;

import java.util.ArrayList;

//Vamos a heredar de la clase Fragment
public class ArbitrosFragment extends Fragment {

    /* Las variables que utilizaremos */
    private static final String ARBITROS="Arbitros";
    private static ArrayList<Arbitro> lista;

    /*

        Esto es un FactoryMethod.
        Los datos están siendo enviados ANTES del onCreate.
        El Bundle permanece cuando se tiene que recrear.
     */
    public static ArbitrosFragment newInstance(ArrayList<Arbitro> lista) {
        ArbitrosFragment fragment = new ArbitrosFragment();
        Bundle args = new Bundle();
        //Esto no tiene mucha ciencia -> Clave, valor.
        args.putParcelableArrayList(ARBITROS, lista);
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
            lista = getArguments().getParcelableArrayList(ARBITROS);
        }
    }

    /* Al crear la vista, cargamos los valores necesarios */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_arbitros, container, false);

        // Obten el RecyclerView del diseño del fragmento
        RecyclerView recyclerView = root.findViewById(R.id.reciclerViewArbitros);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        // Crea una instancia del adaptador y pásale la lista de intérpretes y un listener si es necesario
        ListaArbitrosAdapter adapter = new ListaArbitrosAdapter(lista, new ListaArbitrosAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Arbitro item) {
                // Maneja el clic en un elemento de la lista si es necesario
            }
        });

        // Configura el adaptador en el RecyclerView
        recyclerView.setAdapter(adapter);

        return root;
    }
}