package com.example.footmatch

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.footmatch.modelo.BuscadorId
import com.example.footmatch.modelo.pojos.Aggregates
import com.example.footmatch.modelo.pojos.MatchToShow
import com.example.footmatch.modelo.pojos.Referee
import com.example.footmatch.ui.AlineacionesFragment
import com.example.footmatch.ui.ArbitrosFragment
import com.example.footmatch.ui.EstadisticasFragment
import com.example.footmatch.ui.EventosFragment
import com.example.footmatch.util.api.RetrofitClient
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MostrarPartido : AppCompatActivity() {
    private var partido: MatchToShow? = null
    private var stats: Aggregates? = null
    private var buscadorId: BuscadorId? = null
    private var id: Int? = null
    private var fecha: List<String>? = null
    var textView: TextView? = null
    var textView2: TextView? = null
    var imagenLiga: ImageView? = null
    var imagenEquipo1: ImageView? = null
    var imagenEquipo2: ImageView? = null
    var nombreEquipo1: TextView? = null
    var resultadoPartido: TextView? = null
    var fechaPartido: TextView? = null
    var nombreEquipo2: TextView? = null
    var estadio: TextView? = null
    var estadoPartido: Button? = null
    //var database: MatchDB? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_match)

        // Obtener datos del intent
        val intentMatch = intent

        buscadorId = intentMatch.getParcelableExtra(MainRecycler.PARTIDO_SELECCIONADO)

        this.fecha = buscadorId!!.utcDate.split("T")
        this.id = buscadorId!!.id

        //database = MatchDB.getDB(applicationContext)

        // Inicializar vistas
        textView = findViewById(R.id.liga_jornada)
        textView2 = findViewById(R.id.minutoPartido)
        imagenLiga = findViewById(R.id.imagenLiga)
        imagenEquipo1 = findViewById(R.id.imagenEquipo1)
        nombreEquipo1 = findViewById(R.id.nombreEquipo1)
        resultadoPartido = findViewById(R.id.resultadoPartido)
        fechaPartido = findViewById(R.id.fechaPartido)
        imagenEquipo2 = findViewById(R.id.imagenEquipo2)
        nombreEquipo2 = findViewById(R.id.nombreEquipo2)
        estadio = findViewById(R.id.estadio)
        estadoPartido = findViewById(R.id.estadoPartido)
        val estado = estadoPartido // Almacenar el valor en una variable local
        if (estado != null) {
            estado.isEnabled = false
        }
        when (partido?.status) {
            "FINISHED" -> estado?.setBackgroundColor(Color.parseColor("#555555"))
            "LIVE" -> estado?.setBackgroundColor(Color.parseColor("#FFFF00"))
            "IN_PLAY" -> estado?.setBackgroundColor(Color.parseColor("#FFFF00"))
            "PAUSED" -> estado?.setBackgroundColor(Color.parseColor("#FFFF00"))
             else -> estado?.setBackgroundColor(Color.parseColor("#333333"))
        }
        
        // Cargar datos del partido en las vistas
        searchMatch(this.id!!)
    }

    private fun searchMatch(id: Int) {
        // Llamada a la API empleando corrutinas de Kotlin
        val apiService = RetrofitClient.makeClient()
        // Iniciar ambas llamadas a la API de manera simultánea
        Log.d("Busca el partido", "Inicio de la búsqueda del partido por ID: $id")
        lifecycleScope.launch (Dispatchers.IO) {
            val  tarea1= async(Dispatchers.IO){ partido = apiService.getMatch(id)}
            val  tarea2= async(Dispatchers.IO){ stats = apiService.getMatchStats(id).aggregates }
            tarea1.await()
            tarea2.await()

            partido?.aggregates = stats!!

            /*if (database!!.matchDAO().getMatchById(partido!!.id) != null) {
                partido = database!!.matchDAO().getMatchById(partido!!.id) as MatchToShow
            } else {
                database?.matchDAO()?.add(partido!!)
            }*/

            withContext(Dispatchers.Main) {
                mostrarDatos(partido, stats)
            }
        }
    }

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->

            /* Cuando se selecciona uno de los botones / ítems*/
            if (partido == null) return@OnNavigationItemSelectedListener false
            val itemId = item.itemId

            /* Según el caso, crearemos un Fragmento u otro */
            if (itemId == R.id.navigation_stats) {
                /* Haciendo uso del FactoryMethod pasándole todos los parámetros necesarios */
                /* Argumento solamente necesita.... El argumento de la película */
                val estadisticasFragment = EstadisticasFragment.newInstance(
                    partido!!.homeTeam, partido!!.awayTeam, stats
                )

                /* ¿Qué estaremos haciendo aquí? */supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, estadisticasFragment).commit()
                return@OnNavigationItemSelectedListener true
            }
            if (itemId == R.id.navigation_events) {
                if (partido!!.status.equals("LIVE") || partido!!.status.equals("PAUSED")
                    || partido!!.status.equals("IN_PLAY") || partido!!.status.equals("FINISHED")
                    || partido!!.status.equals("PAUSED")) {
                    val eventosFragment = EventosFragment.newInstance(partido!!.goals,
                        partido!!.penalties, partido!!.bookings, partido!!.substitutions,
                        partido!!.homeTeam.name)

                    /* ¿Qué estaremos haciendo aquí? */supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, eventosFragment).commit()
                } else {
                    // Inflar el layout y agregarlo al contenedor
                    val inflater = LayoutInflater.from(this)
                    val miLayout = inflater.inflate(R.layout.item_no_disponible, null) as RelativeLayout

                    // Obtener el contenedor por su ID
                    val contenedor = findViewById<FrameLayout>(R.id.fragment_container)

                    // Agregar el layout inflado al contenedor
                    contenedor.addView(miLayout)
                }
                return@OnNavigationItemSelectedListener true
            }
            if (itemId == R.id.navigation_referees) {
                if (partido!!.referees.isNotEmpty()) {
                    val arbitrosFragment =
                        ArbitrosFragment.newInstance(partido!!.referees as ArrayList<Referee?>)
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, arbitrosFragment).commit()
                } else {
                    // Inflar el layout y agregarlo al contenedor
                    val inflater = LayoutInflater.from(this)
                    val miLayout = inflater.inflate(R.layout.item_no_disponible, null) as RelativeLayout

                    // Obtener el contenedor por su ID
                    val contenedor = findViewById<FrameLayout>(R.id.fragment_container)

                    // Agregar el layout inflado al contenedor
                    contenedor.addView(miLayout)
                }
                return@OnNavigationItemSelectedListener true
            }
            if (itemId == R.id.navigation_alineations) {
                val alineacionesFragment = AlineacionesFragment.newInstance(
                    partido!!.homeTeam, partido!!.awayTeam
                )
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, alineacionesFragment).commit()
                return@OnNavigationItemSelectedListener true
            }
            throw IllegalStateException("Unexpected value: " + item.itemId)
        }

    // Cargar los datos del partido en las vistas
    private fun mostrarDatos(partido: MatchToShow?, stats: Aggregates?) {
        if (partido != null) {
            // Actualizar componentes con valores del partido específico
            textView!!.text = partido.competition.name + ". Jornada Nº " + partido.season.currentMatchday
            if (partido.status.equals("FINISHED"))
                textView2!!.text = "90'"
            else
                textView2!!.text = partido.minute.toString() + "'"
            nombreEquipo1!!.text = partido.homeTeam.shortName
            if (partido.status.equals("FINISHED") || partido.status.equals("LIVE")) {
                resultadoPartido!!.text = partido.score.fullTime.home.toString() + "-" + partido.score.fullTime.away.toString()
            } else {
                resultadoPartido!!.text = fecha?.get(1)?.substring(0, fecha?.get(1)!!.length - 4) ?: ""
            }
            fechaPartido!!.text = fecha?.get(0) ?: ""
            nombreEquipo2!!.text = partido.awayTeam.shortName
            estadio!!.text = "Estadio: " + partido.venue
            estadoPartido!!.text = partido.status
            if (partido.competition.emblem.isEmpty()) {
                Picasso.get()
                    .load(R.drawable.liga_defecto).into(imagenLiga)
            } else {
                Picasso.get()
                    .load(partido.competition.emblem).into(imagenLiga)
            }
            if (partido.homeTeam.crest.isEmpty()) {
                Picasso.get()
                    .load(R.drawable.escudo_por_defecto).into(imagenEquipo1)
            } else {
                Picasso.get()
                    .load(partido.homeTeam.crest).into(imagenEquipo1)
            }
            if (partido.awayTeam.crest.isEmpty()) {
                Picasso.get()
                    .load(R.drawable.escudo_por_defecto).into(imagenEquipo2)
            } else {
                Picasso.get()
                    .load(partido.awayTeam.crest).into(imagenEquipo2)
            }

            if (partido!!.status.equals("LIVE") || partido!!.status.equals("PAUSED")
                || partido!!.status.equals("IN_PLAY") || partido!!.status.equals("FINISHED")) {
                val eventosFragment = EventosFragment.newInstance(partido!!.goals,
                    partido!!.penalties, partido!!.bookings, partido!!.substitutions,
                    partido!!.homeTeam.name)

                /* ¿Qué estaremos haciendo aquí? */supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, eventosFragment).commit()
            } else {
                // Inflar el layout y agregarlo al contenedor
                val inflater = LayoutInflater.from(this)
                val miLayout = inflater.inflate(R.layout.item_no_disponible, null) as RelativeLayout

                // Obtener el contenedor por su ID
                val contenedor = findViewById<FrameLayout>(R.id.fragment_container)

                // Agregar el layout inflado al contenedor
                contenedor.addView(miLayout)
            }
        }
    }
}