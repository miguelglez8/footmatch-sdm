package com.example.footmatch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.footmatch.modelo.Partido;
import com.example.footmatch.util.Conexion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainRecycler extends AppCompatActivity {

    // identificador de intent
    public static final String PARTIDO_SELECCIONADO = "partido_seleccionado";

    public static final String PARTIDO_CREADO = "partido_creado";

    // identificador de activity
    private static final int GESTION_ACTIVITY = 1;

    // Modelo datos
    List<Partido> listaPartidos;
    Partido partido;
    RecyclerView listaPartidosView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_recycler);

        //Rellenar lista de partidos

        //cargarPartidos();
        listaPartidos = new ArrayList<Partido>();

        // Recuperamos referencia y configuramos recyclerView con la lista de partidos
        listaPartidosView = (RecyclerView)findViewById(R.id.recyclerView);
        listaPartidosView.setHasFixedSize(true);

        /* Un RecyclerView necesita un Layout Manager para manejar el posicionamiento de los
           elementos en cada línea. Se podría definir un LayoutManager propio extendendiendo la clase
           RecyclerView.LayoutManager. Sin embargo, en la mayoría de los casos, simplemente se usa
           una de las subclases LayoutManager predefinidas: LinearLayoutManager, GridLayoutManager,
           StaggeredGridLayoutManager*/
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        listaPartidosView.setLayoutManager(layoutManager);

        // Pasamos la lista de partidos al RecyclerView con el ListaPartidosAdapter
        // Instanciamos el adapter con los datos de la petición y lo asignamos a RecyclerView
        // Generar el adaptador, le pasamos la lista de partidos
        // y el manejador para el evento click sobre un elemento
        ListaPartidosAdapter lpAdapter = new ListaPartidosAdapter(listaPartidos,
                new ListaPartidosAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(Partido partido) {
                        /*clickonItem(partido);*/
                    }
                });
        listaPartidosView.setAdapter(lpAdapter);
    }

}