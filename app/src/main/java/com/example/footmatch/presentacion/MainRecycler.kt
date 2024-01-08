package com.example.footmatch.presentacion

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.footmatch.R
import com.example.footmatch.datos.modelos.partido.Match
import com.example.footmatch.presentacion.adapters.ListaPartidosAdapter
import com.example.footmatch.datos.api.ApiLimitExceededException
import com.example.footmatch.datos.api.RetrofitClient
import com.example.footmatch.datos.database.MatchEntity
import com.example.footmatch.datos.database.MatchesDatabase
import com.example.footmatch.datos.mappers.toMatch
import com.example.footmatch.datos.mappers.toMatchEntity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MainRecycler : AppCompatActivity()  {
    // Modelo datos
    var matchList: List<Match> = ArrayList()
    var listaPartidosView: RecyclerView? = null
    private lateinit var navView : BottomNavigationView
    private lateinit var navViewDates : BottomNavigationView
    private lateinit var listaPartidosAdapter: ListaPartidosAdapter

    // Referencia al swipe refresh layout
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    // Listener para la barra de navegacion de fechas
    @RequiresApi(Build.VERSION_CODES.O)
    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            val itemId = item.itemId
            // Segun el caso realizaremos una u otra llamada a la API
            if (itemId == R.id.navigation_yesterday) {
                cargarPartidosAyerBD()
                return@OnNavigationItemSelectedListener true
            } else if (itemId == R.id.navigation_today) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    val today = LocalDate.now()
                    val dateFrom = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                    val tomorrow = LocalDate.now().plusDays(1)
                    val dateTo = tomorrow.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                    cargarPartidosHoy(dateFrom, dateTo)
                } else {
                    throw IllegalStateException("Error al obtener la fecha de ayer por version API")
                }
                return@OnNavigationItemSelectedListener true
            } else if (itemId == R.id.navigation_all) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    cargarPartidosTodosBD()
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
        listaPartidosAdapter = ListaPartidosAdapter {}


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

        // Recuperamos el swipe refresh layout
        swipeRefreshLayout = findViewById(R.id.swiperefresh)
        // Recuperamos la barra de navegacion de fechas
        navViewDates = findViewById(R.id.nav_view_matches_dates)
        // Configuramos el listener para el swipe refresh layout
        swipeRefreshLayout.setOnRefreshListener {
            // Actualizamos los partidos del dia de hoy
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                // Si la pestaña seleccionada de la navView es la de hoy, actualizamos los de hoy
                when(navViewDates.selectedItemId) {
                    R.id.navigation_today -> {
                        val today = LocalDate.now()
                        val dateFrom = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                        val tomorrow = LocalDate.now().plusDays(1)
                        val dateTo = tomorrow.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                        cargarPartidosHoy(dateFrom, dateTo)
                    }
                }

            } else {
                throw IllegalStateException("Error al obtener la fecha de ayer por version API")
            }
            // Paramos la animacion del swipe refresh layout
            swipeRefreshLayout.isRefreshing = false
        }

        // Le establecemos el listener
        navViewDates.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        // Seleccionamos la opcion de hoy por defecto
        navViewDates.selectedItemId = R.id.navigation_today

        // Recuperamos la barra de navegacion inferior
        navView = findViewById(R.id.bottomNavigationView)
        // Dejamos seleccionado el boton de inicio
        navView.menu.findItem(R.id.nav_home).isEnabled = true
        // En esta pantalla no hacemos nada al pulsarlo
        // Añadimos el listener al boton actualizar
        navView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    // No hacemos nada
                    return@setOnNavigationItemSelectedListener true
                }

            }

            false
        }



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
    private fun cargarPartidosHoy(dateFrom: String, dateTo: String) {
        // Llamada a la API empleando corrutinas de kotlin
        val apiService = RetrofitClient.makeClient()

        lifecycleScope.launch(Dispatchers.IO) {
            try {
                val newMatchList = apiService.getMatchesBetweenDates(dateFrom, dateTo).matches

                // Cambiamos al hilo principal para actualizar los datos
                withContext(Dispatchers.Main)
                {
                    // Actualizamos la lista de partidos
                    matchList = newMatchList.toMutableList()
                    // Notificamos al adapter
                    listaPartidosAdapter.update(matchList)
                }
            } catch (e: ApiLimitExceededException) {
                //Log.e("API Request", "ApiLimitExceededException: ${e.message}", e)
                // Si se supera el limite de peticiones, mostramos un toast con el mensaje de error
                // y deshabilitamos los elementos de la pantalla
                withContext(Dispatchers.Main){
                    Toast.makeText(
                        this@MainRecycler,
                        "Demasiadas requests a la API, espere " + e.timeToWait + " segundos",
                        Toast.LENGTH_LONG
                    ).show()
                }
            } catch (e:Exception){
                Log.e("API Request", "Exception: ${e.message}", e)
            }

        }
    }

    /*
    Carga todos los partidos del dia anterior al actual
     */
    @RequiresApi(Build.VERSION_CODES.O)
    private fun cargarPartidosAyer() {
        // Llamada a la API empleando corrutinas de kotlin
        val apiService = RetrofitClient.makeClient()

        lifecycleScope.launch(Dispatchers.IO) {
            try {
                val dateFrom = LocalDate.now().minusDays(1)
                val dateTo = LocalDate.now()
                val newMatchList = apiService.getMatchesBetweenDates(
                    dateFrom.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                        dateTo.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))).matches

                lifecycleScope.launch(Dispatchers.IO){
                    Log.d("BD", "Añadiendo partidos a la bd")
                    // Los guardamos en bd
                    val matchesDB: MatchesDatabase = MatchesDatabase.getDatabase(this@MainRecycler)
                    newMatchList.forEach {
                        matchesDB.matchesDao().add(it.toMatchEntity())
                    }
                }


                // Cambiamos al hilo principal para actualizar los datos
                withContext(Dispatchers.Main)
                {
                    // Actualizamos la lista de partidos
                    matchList = newMatchList.toMutableList()
                    // Notificamos al adapter
                    listaPartidosAdapter.update(matchList)
                }
            } catch (e: ApiLimitExceededException) {
                //Log.e("API Request", "ApiLimitExceededException: ${e.message}", e)
                // Si se supera el limite de peticiones, mostramos un toast con el mensaje de error
                // y deshabilitamos los elementos de la pantalla
                withContext(Dispatchers.Main){
                    Toast.makeText(
                        this@MainRecycler,
                        "Demasiadas requests a la API, espere " + e.timeToWait + " segundos",
                        Toast.LENGTH_LONG
                    ).show()
                }
            } catch (e:Exception){
                Log.e("API Request", "Exception: ${e.message}", e)
            }

        }
    }

    /*
    Carga todos los partidos a partir del dia siguiente al actual
     */
    @RequiresApi(Build.VERSION_CODES.O)
    private fun cargarPartidosTodos() {
        // Llamada a la API empleando corrutinas de kotlin
        val apiService = RetrofitClient.makeClient()

        lifecycleScope.launch(Dispatchers.IO) {
            try {
                val dateFrom = LocalDate.now().plusDays(1)
                val endPeriod = LocalDate.now().plusDays(10)
                val dateTo = endPeriod.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                val newMatchList = apiService.getMatchesBetweenDates(
                    dateFrom.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                    dateTo.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))).matches

                lifecycleScope.launch(Dispatchers.IO){
                    Log.d("BD", "Añadiendo partidos a la bd")
                    // Los guardamos en bd
                    val matchesDB: MatchesDatabase = MatchesDatabase.getDatabase(this@MainRecycler)
                    newMatchList.forEach {
                        matchesDB.matchesDao().add(it.toMatchEntity())
                    }
                }


                // Cambiamos al hilo principal para actualizar los datos
                withContext(Dispatchers.Main)
                {
                    // Actualizamos la lista de partidos
                    matchList = newMatchList.toMutableList()
                    // Notificamos al adapter
                    listaPartidosAdapter.update(matchList)
                }
            } catch (e: ApiLimitExceededException) {
                //Log.e("API Request", "ApiLimitExceededException: ${e.message}", e)
                // Si se supera el limite de peticiones, mostramos un toast con el mensaje de error
                // y deshabilitamos los elementos de la pantalla
                withContext(Dispatchers.Main){
                    Toast.makeText(
                        this@MainRecycler,
                        "Demasiadas requests a la API, espere " + e.timeToWait + " segundos",
                        Toast.LENGTH_LONG
                    ).show()
                }
            } catch (e:Exception){
                Log.e("API Request", "Exception: ${e.message}", e)
            }

        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun cargarPartidosAyerBD(){
        // Llamada a la bd empleando corrutinas de kotlin
        val matchesDB: MatchesDatabase = MatchesDatabase.getDatabase(this)
        lifecycleScope.launch(Dispatchers.IO){

            val date = LocalDate.now().minusDays(1).atTime(0,0)
            val matchesFromDatabase : List<MatchEntity> = matchesDB.matchesDao().
            findByDate(date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))

            if (matchesFromDatabase.isEmpty()){
                Log.d("BD", "No hay partidos en la bd")
                // No hay partidos en la bd, los cargamos de la API
                cargarPartidosAyer()


            } else {
                Log.d("BD", "Hay partidos en la bd")
                // Hay partidos en la bd, los cargamos
                withContext(Dispatchers.Main)
                {
                    // Actualizamos la lista de partidos
                    matchList = matchesFromDatabase.map { it.toMatch() }
                    // Notificamos al adapter
                    listaPartidosAdapter.update(matchList)
                }
            }
        }

    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun cargarPartidosTodosBD(){
        // Llamada a la bd empleando corrutinas de kotlin
        val matchesDB: MatchesDatabase = MatchesDatabase.getDatabase(this)
        lifecycleScope.launch(Dispatchers.IO){

            val date = LocalDate.now().plusDays(1)
            val matchesFromDatabase : List<MatchEntity> = matchesDB.matchesDao().
            findAfterDate(date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))

            if (matchesFromDatabase.isEmpty()){
                Log.d("BD", "No hay partidos en la bd")
                // No hay partidos en la bd, los cargamos de la API
                cargarPartidosTodos()


            } else {
                Log.d("BD", "Hay partidos en la bd")
                // Hay partidos en la bd, los cargamos
                withContext(Dispatchers.Main)
                {
                    // Actualizamos la lista de partidos
                    matchList = matchesFromDatabase.map { it.toMatch() }
                    // Notificamos al adapter
                    listaPartidosAdapter.update(matchList)
                }
            }
        }

    }




    fun cargarClasificacion(liga: String?) {
        var idLogo = R.drawable.liga_easports
        var nombreLiga = "Liga EASports"
        var code = ""
        when (liga) {
            "LL" -> {
                idLogo = R.drawable.liga_easports
                nombreLiga = "Liga EASports"
                code = "PD"
            }

            "LP" -> {
                idLogo = R.drawable.liga_premier
                nombreLiga = "Premier League"
                code = "PL"
            }

            "LB" -> {
                idLogo = R.drawable.liga_bundesliga
                nombreLiga = "Bundesliga"
                code = "BL1"
            }

            "LS" -> {
                idLogo = R.drawable.liga_seriea
                nombreLiga = "Serie A"
                code = "SA"
            }
        }

        val ligaIntent = Intent(this@MainRecycler, ClasificacionActivity::class.java)
        ligaIntent.putExtra(LIGA_CREADA, code)
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