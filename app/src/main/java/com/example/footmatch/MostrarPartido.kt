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
import coil.load
import com.example.footmatch.modelo.BuscadorId
import com.example.footmatch.modelo.pojos.Aggregates
import com.example.footmatch.modelo.pojos.MatchToShow
import com.example.footmatch.modelo.pojos.Referee
import com.example.footmatch.modelo.pojos.TeamX
import com.example.footmatch.ui.AlineacionesFragment
import com.example.footmatch.ui.ArbitrosFragment
import com.example.footmatch.ui.EstadisticasFragment
import com.example.footmatch.util.api.RetrofitClient
import com.example.footmatch.util.images.SvgLoader.Companion.loadUrl
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MostrarPartido : AppCompatActivity() {
    private var partido: MatchToShow? = null
    private var stats: Aggregates? = null
    private var local: TeamX? = null
    private var away: TeamX? = null
    private var buscadorId: BuscadorId? = null
    private var id: Int? = null
    private var localId: Int? = null
    private var awayId: Int? = null
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
        this.localId = buscadorId!!.localId
        this.awayId = buscadorId!!.awayId

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
            val  tarea3= async(Dispatchers.IO){ local = apiService.getTeam(localId!!) }
            val  tarea4= async(Dispatchers.IO){ away = apiService.getTeam(awayId!!) }

            tarea1.await()
            tarea2.await()
            tarea3.await()
            tarea4.await()

            partido?.aggregates = stats!!
            partido?.homeTeam?.trainer = local?.coach!!.name
            partido?.awayTeam?.trainer = away?.coach!!.name

            /*if (database!!.matchDAO().getMatchById(partido!!.id) != null) {
                partido = database!!.matchDAO().getMatchById(partido!!.id) as MatchToShow
            } else {
                database?.matchDAO()?.add(partido!!)
            }*/

            withContext(Dispatchers.Main) {
                mostrarDatos(partido, stats, local!!, away!!)

                val mOnNavigationItemSelectedListener =
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
                        if (itemId == R.id.navigation_alineations) {
                            val alineacionesFragment = AlineacionesFragment.newInstance(
                                local!!, away!!, partido!!
                            )
                            supportFragmentManager.beginTransaction()
                                .replace(R.id.fragment_container, alineacionesFragment).commit()
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
                                val inflater = LayoutInflater.from(applicationContext)
                                val miLayout = inflater.inflate(R.layout.item_no_disponible, null) as RelativeLayout

                                // Obtener el contenedor por su ID
                                val contenedor = findViewById<FrameLayout>(R.id.fragment_container)

                                // Agregar el layout inflado al contenedor
                                contenedor.addView(miLayout)
                            }
                            return@OnNavigationItemSelectedListener true
                        }
                        throw IllegalStateException("Unexpected value: " + item.itemId)
                    }
            }
        }
    }

    // Cargar los datos del partido en las vistas
    private fun mostrarDatos(
        partido: MatchToShow?,
        stats: Aggregates?,
        local: TeamX,
        away: TeamX
    ) {
        if (partido != null) {
            if (partido?.status == "FINISHED") estadoPartido?.text="FINALIZADO" else if (partido?.status == "TIMED") estadoPartido?.text="PROGRAMADO" else  estadoPartido?.text="EN JUEGO"
            estadoPartido!!.setBackgroundColor(Color.parseColor("#006400"))
            textView!!.text = partido.competition.name + ". Jornada Nº " + partido.season.currentMatchday
            if (partido.status.equals("FINISHED"))
                textView2!!.text = "90'"
            else
                textView2!!.text = partido.minute.toString() + "'"
            nombreEquipo1!!.text = partido.homeTeam.shortName
            if (partido.status.equals("FINISHED") || partido.status.equals("LIVE")) {
                resultadoPartido!!.text = partido.score.fullTime.home.toString() + " - " + partido.score.fullTime.away.toString()
            } else {
                resultadoPartido!!.text = fecha?.get(1)?.substring(0, fecha?.get(1)!!.length - 4) ?: ""
            }
            fechaPartido!!.text = fecha?.get(0) ?: ""
            nombreEquipo2!!.text = partido.awayTeam.shortName
            if (partido.venue == null)
                estadio!!.text = "Estadio: No disponible"
            else
                estadio!!.text = "Estadio: " + partido.venue

            if (partido.competition.emblem == null) {
                // cargar imagen local por defecto
                imagenLiga?.load(R.drawable.escudo_por_defecto)
            } else {
                // Comprobamos si se trata de un png o svg
                val isSvg = partido.competition.emblem.endsWith("svg",ignoreCase = true)
                // Si es svg procedemos a cargarlo con coil
                if (isSvg){
                    imagenLiga?.loadUrl(partido.competition.emblem)
                }else{
                    // cargamos la imagen png con coil
                    imagenLiga?.load(partido.competition.emblem)
                }
            }
            if (partido.homeTeam.crest == null) {
                // cargar imagen local por defecto
                imagenEquipo1?.load(R.string.teamDefaultLogo.toString())
            } else {
                // Comprobamos si se trata de un png o svg
                val isSvg = partido.homeTeam.crest.endsWith("svg",ignoreCase = true)
                // Si es svg procedemos a cargarlo con coil
                if (isSvg){
                    imagenEquipo1?.loadUrl(partido.homeTeam.crest)
                }else{
                    // cargamos la imagen png con coil
                    imagenEquipo1?.load(partido.homeTeam.crest)
                }
            }
            if (partido.awayTeam.crest == null) {
                // cargar imagen local por defecto
                imagenEquipo2?.load(R.string.teamDefaultLogo.toString())
            } else {
                // Comprobamos si se trata de un png o svg
                val isSvg = partido.awayTeam.crest.endsWith("svg",ignoreCase = true)
                // Si es svg procedemos a cargarlo con coil
                if (isSvg){
                    imagenEquipo2?.loadUrl(partido.awayTeam.crest)
                }else{
                    // cargamos la imagen png con coil
                    imagenEquipo2?.load(partido.awayTeam.crest)
                }
            }

            val estadisticasFragment = EstadisticasFragment.newInstance(
                partido!!.homeTeam, partido!!.awayTeam, stats
            )

            /* ¿Qué estaremos haciendo aquí? */supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, estadisticasFragment).commit()
        }
    }
}