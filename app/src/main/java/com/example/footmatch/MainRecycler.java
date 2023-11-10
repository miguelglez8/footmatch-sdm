package com.example.footmatch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.example.footmatch.modelo.Equipo;
import com.example.footmatch.modelo.Liga;
import com.example.footmatch.modelo.Partido;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainRecycler extends AppCompatActivity {

    // identificador de intent
    public static final String PARTIDO_SELECCIONADO = "partido_seleccionado";

    public static final String PARTIDO_CREADO = "partido_creado";
    public static final String LIGA_CREADA = "liga_creada";

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

        cargarPartidos();


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
                        cargarPartido(partido);
                    }
                });
        listaPartidosView.setAdapter(lpAdapter);

        /*
        Añado a cada boton un onClick para llamar a la nueva activity con la clasificacion
         */
        ImageButton laLiga = (ImageButton)findViewById(R.id.ligaEASports) ;
        laLiga.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                cargarClasificacion("LL");
            }
        });
        ImageButton premier = (ImageButton)findViewById(R.id.ligaPremier) ;
        premier.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                cargarClasificacion("LP");
            }
        });
        ImageButton bundes = (ImageButton)findViewById(R.id.ligaBundesliga) ;
        bundes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                cargarClasificacion("LB");
            }
        });
        ImageButton serieA = (ImageButton)findViewById(R.id.ligaSerieA) ;
        serieA.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                cargarClasificacion("LS");
            }
        });
    }
    private void cargarPartidos() {

        Partido partido;
        listaPartidos = new ArrayList<Partido>();
        InputStream file = null;
        InputStreamReader reader = null;
        BufferedReader bufferedReader = null;

        try {
            file = getAssets().open("lista_partidos_url_utf8.csv");
            reader = new InputStreamReader(file);
            bufferedReader = new BufferedReader(reader);

            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(";");

                if (data != null && data.length == 7) {
                    String fechaFormateada = formateaFecha(data[3]);
                    partido = new Partido(new Equipo(data[0],data[5],0),new Equipo(data[1],data[6],0),
                            data[2],fechaFormateada,data[4]);

                    Log.d("cargarPartidos", partido.toString());
                    listaPartidos.add(partido);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private String formateaFecha(String date) {
        String fechaEnFormatoString = "2023-10-22T20:30:00Z";
        String result = "";
        try {
            @SuppressLint("SimpleDateFormat") SimpleDateFormat formatoEntrada = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            Date fecha = formatoEntrada.parse(fechaEnFormatoString);

            @SuppressLint("SimpleDateFormat") SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
            @SuppressLint("SimpleDateFormat") SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");

            assert fecha != null;
            String fechaFormateada = formatoFecha.format(fecha);
            String horaFormateada = formatoHora.format(fecha);

            result = fechaFormateada + " " + horaFormateada;

        } catch (ParseException e) {
            System.err.println("Error al analizar la fecha.");
        }
        return result;
    }

    public List<Equipo> cargarEquiposParaClasificacion(String liga){
        Equipo equipo;
        List<Equipo> equiposLiga = new ArrayList<Equipo>();
        InputStream file = null;
        InputStreamReader reader = null;
        BufferedReader bufferedReader = null;

        try {
            switch (liga){
                case "LL": {
                    file = getAssets().open("lista_clasificacion_laliga_url_utf8.csv");
                    break;
                }
                case "LP": {
                    file = getAssets().open("lista_clasificacion_premier_url_utf8.csv");
                    break;
                }
                case "LB": {
                    file = getAssets().open("lista_clasificacion_bundes_url_utf8.csv");
                    break;
                }
                case "LS": {
                    file = getAssets().open("lista_clasificacion_seriea_url_utf8.csv");
                    break;
                }

            }
            reader = new InputStreamReader(file);
            bufferedReader = new BufferedReader(reader);

            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(";");

                if (data != null && data.length == 3) {
                    equipo = new Equipo(data[0],data[1],Integer.parseInt(data[2]));
                    equiposLiga.add(equipo);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return equiposLiga;
    }

    public void cargarClasificacion(String liga){
        int idLogo = R.drawable.liga_easports;
        String nombreLiga = "Liga EASports";
        switch (liga){
            case "LL": {
                idLogo = R.drawable.liga_easports;
                nombreLiga = "Liga EASports";
                break;
            }
            case "LP": {
                idLogo = R.drawable.liga_premier;
                nombreLiga = "Premier League";
                break;
            }
            case "LB": {
                idLogo = R.drawable.liga_bundesliga;
                nombreLiga = "Bundesliga";
                break;
            }
            case "LS": {
                idLogo = R.drawable.liga_seriea;
                nombreLiga = "Serie A";
                break;
            }


        }

        Liga ligaSeleccionada = new Liga(cargarEquiposParaClasificacion(liga), nombreLiga, idLogo);
        Intent ligaIntent = new Intent(MainRecycler.this, ClasificacionActivity.class);
        ligaIntent.putExtra(LIGA_CREADA, ligaSeleccionada);
        startActivity(ligaIntent);
    }

    private void cargarPartido(Partido partido) {
        Intent partidoIntent = new Intent(MainRecycler.this, MostrarPartido.class);
        partidoIntent.putExtra(PARTIDO_SELECCIONADO, partido);
        startActivity(partidoIntent);
    }

}