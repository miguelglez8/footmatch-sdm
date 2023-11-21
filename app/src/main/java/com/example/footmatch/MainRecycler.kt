package com.example.footmatch

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.footmatch.modelo.Equipo
import com.example.footmatch.modelo.Liga
import com.example.footmatch.modelo.pojos.Match
import com.example.footmatch.util.api.RetrofitClient
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MainRecycler : AppCompatActivity() {
    // Modelo datos
    var matchList: List<Match> = ArrayList()
    var listaPartidosView: RecyclerView? = null
    private lateinit var listaPartidosAdapter: ListaPartidosAdapter

    private fun mostrarPartido(match:Match){

    }

    // Listener para la barra de navegacion de fechas
    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            val itemId = item.itemId
            // Segun el caso realizaremos una u otra llamada a la API
            if (itemId == R.id.navigation_yesterday) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    val yesterday = LocalDate.now().minusDays(1)
                    val dateFrom = yesterday.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                    val today = LocalDate.now()
                    val dateTo = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                    cargarPartidos(dateFrom, dateTo)
                } else {
                    throw IllegalStateException("Error al obtener la fecha de ayer por version API")
                }
                return@OnNavigationItemSelectedListener true
            } else if (itemId == R.id.navigation_today) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    val today = LocalDate.now()
                    val dateFrom = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                    val tomorrow = LocalDate.now().plusDays(7)
                    val dateTo = tomorrow.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                    cargarPartidos(dateFrom, dateTo)
                } else {
                    throw IllegalStateException("Error al obtener la fecha de ayer por version API")
                }
                return@OnNavigationItemSelectedListener true
            } else if (itemId == R.id.navigation_all) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    val today = LocalDate.now()
                    val dateFrom = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                    // la fecha de fin seran 10 dias mas que es lo que admite la API
                    val endPeriod = LocalDate.now().plusDays(10)
                    val dateTo = endPeriod.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                    cargarPartidos(dateFrom, dateTo)
                } else {
                    throw IllegalStateException("Error al obtener la fecha de ayer por version API")
                }
                return@OnNavigationItemSelectedListener true
            }
            throw IllegalStateException("Unexpected value: " + item.itemId)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_recycler)

        // Pasamos la lista de partidos al RecyclerView con el ListaPartidosAdapter
        // Instanciamos el adapter con los datos de la petición y lo asignamos a RecyclerView
        // Generar el adaptador, le pasamos la lista de partidos
        // y el manejador para el evento click sobre un elemento
        listaPartidosAdapter = ListaPartidosAdapter {mostrarPartido(it)}


        // Recuperamos referencia y configuramos recyclerView con la lista de partidos
        listaPartidosView = findViewById<View>(R.id.recyclerViewPartidos) as RecyclerView
        listaPartidosView!!.setHasFixedSize(true)

        /* Un RecyclerView necesita un Layout Manager para manejar el posicionamiento de los
           elementos en cada línea. Se podría definir un LayoutManager propio extendendiendo la clase
           RecyclerView.LayoutManager. Sin embargo, en la mayoría de los casos, simplemente se usa
           una de las subclases LayoutManager predefinidas: LinearLayoutManager, GridLayoutManager,
           StaggeredGridLayoutManager*/
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(
            applicationContext
        )
        listaPartidosView!!.layoutManager = layoutManager
        listaPartidosView!!.adapter = listaPartidosAdapter

        // Recuperamos la barra de navegacion de fechas
        val dateSelection = findViewById<View>(R.id.nav_view_matches_dates) as BottomNavigationView
        // Le establecemos el listener
        dateSelection.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        // Seleccionamos la opcion de hoy por defecto
        dateSelection.selectedItemId = R.id.navigation_today



        /*
        Añado a cada boton un onClick para llamar a la nueva activity con la clasificacion
         */
        val laLiga = findViewById<View>(R.id.ligaEASports) as ImageButton
        laLiga.setOnClickListener { cargarClasificacion("LL") }
        val premier = findViewById<View>(R.id.ligaPremier) as ImageButton
        premier.setOnClickListener { cargarClasificacion("LP") }
        val bundes = findViewById<View>(R.id.ligaBundesliga) as ImageButton
        bundes.setOnClickListener { cargarClasificacion("LB") }
        val serieA = findViewById<View>(R.id.ligaSerieA) as ImageButton
        serieA.setOnClickListener { cargarClasificacion("LS") }
    }


    /*
    Carga todos los partidos entre las dos fechas que se le pasan por parametro
     */
    private fun cargarPartidos(dateFrom: String, dateTo: String) {
        // Llamada a la API empleando corrutinas de kotlin
        val apiService = RetrofitClient.makeClient()
        lifecycleScope.launch(Dispatchers.IO){
           val newMatchList = apiService.getMatchesBetweenDates(dateFrom, dateTo).matches
            Log.d("Carga partidos", "primero cargamos partidos")
            // Cambiamos al hilo principal para actualizar los datos
            withContext(Dispatchers.Main)
            {
                // Actualizamos la lista de partidos
                matchList = newMatchList.toMutableList()
                Log.d("Actualizamos partidos", "despues actualizamos partidos " + matchList.size)
                // Notificamos al adapter
                listaPartidosAdapter.update(matchList)
            }
        }

    }

    fun cargarEquiposParaClasificacion(liga: String?): List<Equipo> {
        var equipo: Equipo
        val equiposLiga: MutableList<Equipo> = ArrayList()
        var file: InputStream? = null
        var reader: InputStreamReader? = null
        var bufferedReader: BufferedReader? = null
        try {
            when (liga) {
                "LL" -> {
                    file = assets.open("lista_clasificacion_laliga_url_utf8.csv")
                }

                "LP" -> {
                    file = assets.open("lista_clasificacion_premier_url_utf8.csv")
                }

                "LB" -> {
                    file = assets.open("lista_clasificacion_bundes_url_utf8.csv")
                }

                "LS" -> {
                    file = assets.open("lista_clasificacion_seriea_url_utf8.csv")
                }
            }
            reader = InputStreamReader(file)
            bufferedReader = BufferedReader(reader)
            var line: String? = null
            while (bufferedReader.readLine().also { line = it } != null) {
                val data = line!!.split(";".toRegex()).dropLastWhile { it.isEmpty() }
                    .toTypedArray()
                if (data != null && data.size == 3) {
                    equipo = Equipo(data[0], data[1], data[2].toInt())
                    equiposLiga.add(equipo)
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
        return equiposLiga
    }

    fun cargarClasificacion(liga: String?) {
        var idLogo = R.drawable.liga_easports
        var nombreLiga = "Liga EASports"
        when (liga) {
            "LL" -> {
                idLogo = R.drawable.liga_easports
                nombreLiga = "Liga EASports"
            }

            "LP" -> {
                idLogo = R.drawable.liga_premier
                nombreLiga = "Premier League"
            }

            "LB" -> {
                idLogo = R.drawable.liga_bundesliga
                nombreLiga = "Bundesliga"
            }

            "LS" -> {
                idLogo = R.drawable.liga_seriea
                nombreLiga = "Serie A"
            }
        }
        val ligaSeleccionada = Liga(cargarEquiposParaClasificacion(liga), nombreLiga, idLogo)
        val ligaIntent = Intent(this@MainRecycler, ClasificacionActivity::class.java)
        ligaIntent.putExtra(LIGA_CREADA, ligaSeleccionada)
        startActivity(ligaIntent)
    }

    companion object {
        // identificador de intent
        const val PARTIDO_SELECCIONADO = "partido_seleccionado"
        const val PARTIDO_CREADO = "partido_creado"
        const val LIGA_CREADA = "liga_creada"

        // identificador de activity
        private const val GESTION_ACTIVITY = 1
    }
}