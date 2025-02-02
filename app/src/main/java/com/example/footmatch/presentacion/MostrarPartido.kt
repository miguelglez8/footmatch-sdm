package com.example.footmatch.presentacion

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import coil.load
import com.example.footmatch.R
import com.example.footmatch.datos.modelos.BuscadorId
import com.example.footmatch.datos.modelos.partido.Aggregates
import com.example.footmatch.datos.modelos.partido.MatchToShow
import com.example.footmatch.datos.modelos.partido.Referee
import com.example.footmatch.datos.modelos.partido.TeamX
import com.example.footmatch.presentacion.partido.AlineacionesFragment
import com.example.footmatch.presentacion.partido.ArbitrosFragment
import com.example.footmatch.presentacion.partido.EstadisticasFragment
import com.example.footmatch.datos.api.ApiLimitExceededException
import com.example.footmatch.datos.api.RetrofitClient
import com.example.footmatch.datos.images.SvgLoader.Companion.loadUrl
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MostrarPartido : AppCompatActivity() {
    private lateinit var navView : BottomNavigationView
    private var partido: MatchToShow? = null
    private var stats: Aggregates? = null
    private var local: TeamX? = null
    private var away: TeamX? = null
    private var buscadorId: BuscadorId? = null
    private var id: Int? = null
    private var localId: Int? = null
    private var awayId: Int? = null
    private var fecha: List<String>? = null
    private var jornada: TextView? = null
    private var minute: TextView? = null
    private var imagenLiga: ImageView? = null
    private var imagenEquipo1: ImageView? = null
    private var imagenEquipo2: ImageView? = null
    private var nombreEquipo1: TextView? = null
    private var resultadoPartido: TextView? = null
    private var fechaPartido: TextView? = null
    private var nombreEquipo2: TextView? = null
    private var estadio: TextView? = null
    private var estadoPartido: Button? = null
    //var database: MatchDB? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_match)

        // Inicializar vistas
        jornada = findViewById(R.id.liga_jornada)
        minute = findViewById(R.id.minutoPartido)
        imagenLiga = findViewById(R.id.imagenLiga)
        imagenEquipo1 = findViewById(R.id.imagenEquipo1)
        nombreEquipo1 = findViewById(R.id.nombreEquipo1)
        resultadoPartido = findViewById(R.id.resultadoPartido)
        fechaPartido = findViewById(R.id.fechaPartido)
        imagenEquipo2 = findViewById(R.id.imagenEquipo2)
        nombreEquipo2 = findViewById(R.id.nombreEquipo2)
        estadio = findViewById(R.id.estadio)
        estadoPartido = findViewById(R.id.estadoPartido)
        navView = findViewById(R.id.nav_view)

        // Obtener datos del intent
        val intentMatch = intent

        buscadorId = intentMatch.getParcelableExtra(MainRecycler.PARTIDO_SELECCIONADO)

        fecha = buscadorId!!.utcDate.split("T")
        id = buscadorId!!.id
        localId = buscadorId!!.localId
        awayId = buscadorId!!.awayId

        // Cargar datos del partido en las vistas
        cargarMenu()
        navView = findViewById(R.id.bottomNavigationView)
        cargarMenu2()
        searchMatch(this.id!!)
    }

    private fun cargarMenu2() {
        navView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    //val intent = Intent(this@MostrarPartido, MainRecycler::class.java)
                    //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                    //startActivity(intent)
                    // Al comentar lo de arriba me ahorro volver a hacer la llamada a la API
                    // del mainrecycler
                    finish() // Cierra la instancia actual de la actividad
                }
            }
            true
        }
    }

    private fun cargarMenu() {
        navView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_stats -> {
                    if (partido != null && stats != null) {
                        val estadisticasFragment = EstadisticasFragment.newInstance(
                            partido!!.homeTeam, partido!!.awayTeam, stats
                        )
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, estadisticasFragment).commit()
                    } else {
                        // Handle the case when partido or stats is null
                        Log.e("MostrarPartido", "partido or stats is null")
                    }
                }
                R.id.navigation_alineations -> {
                    if (local != null && away != null && partido != null) {
                        val alineacionesFragment = AlineacionesFragment.newInstance(
                            local!!, away!!, partido!!
                        )
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, alineacionesFragment).commit()
                    } else {
                        // Handle the case when local, away, or partido is null
                        Log.e("MostrarPartido", "local, away, or partido is null")
                    }
                }
                R.id.navigation_referees -> {
                    if (partido != null) {
                        if (partido!!.referees.isNotEmpty()) {
                            val arbitrosFragment =
                                ArbitrosFragment.newInstance(partido!!.referees as ArrayList<Referee?>)
                            supportFragmentManager.beginTransaction()
                                .replace(R.id.fragment_container, arbitrosFragment).commit()
                        } else {
                            // Inflar el layout y agregarlo al contenedor
                            val inflater = LayoutInflater.from(applicationContext)
                            val miLayout =
                                inflater.inflate(R.layout.item_no_disponible, null) as RelativeLayout

                            // Obtener el contenedor por su ID
                            val contenedor = findViewById<FrameLayout>(R.id.fragment_container)
                            contenedor.removeAllViews()

                            // Agregar el layout inflado al contenedor
                            contenedor.addView(miLayout)
                        }
                    } else {
                        // Handle the case when partido is null
                        Log.e("MostrarPartido", "partido is null")
                    }
                }
            }
            true
        }
    }

    private fun searchMatch(id: Int) {
        // Llamada a la API empleando corrutinas de Kotlin
        val apiService = RetrofitClient.makeClient()
        // Iniciar ambas llamadas a la API de manera simultánea
        Log.d("Busca el partido", "Inicio de la búsqueda del partido por ID: $id")
        lifecycleScope.launch (Dispatchers.IO) {
                try {
                    coroutineScope {
                        val tarea1 = async(Dispatchers.IO) { partido = apiService.getMatch(id) }
                        val tarea2 =
                            async(Dispatchers.IO) { stats = apiService.getMatchStats(id).aggregates }
                        val tarea3 = async(Dispatchers.IO) { local = apiService.getTeam(localId!!) }
                        val tarea4 = async(Dispatchers.IO) { away = apiService.getTeam(awayId!!) }

                        tarea1.await()
                        tarea2.await()
                        tarea3.await()
                        tarea4.await()

                        if (stats != null)
                            partido?.aggregates = stats!!

                        partido?.homeTeam?.trainer = local?.coach!!.name
                        partido?.awayTeam?.trainer = away?.coach!!.name

                        withContext(Dispatchers.Main) {
                            mostrarDatos()
                        }
                    }
                } catch (e: ApiLimitExceededException) {
                    // Si se supera el límite de peticiones, mostramos un toast con el mensaje de error
                    // y deshabilitamos los elementos de la pantalla
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            this@MostrarPartido,
                            "Demasiadas requests a la API, espere " + e.timeToWait + " segundos",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                } catch (e: Exception) {
                    Log.e("API Request", "Exception: ${e.message}", e)
                }
        }
    }

    // Cargar los datos del partido en las vistas
    private fun mostrarDatos() {
        if (partido != null) {
            if (partido?.status == "FINISHED")
                estadoPartido?.text="FINALIZADO"
            else if (partido?.status == "TIMED" && partido!!.score.winner != null)
                estadoPartido?.text="APLAZADO"
            else if (partido?.status == "POSTPONED" && partido!!.score.winner == null)
                estadoPartido?.text="CANCELADO"
            else if (partido?.status == "IN_PLAY" || partido?.status == "PAUSED"
                || partido?.status == "LIVE")
                estadoPartido?.text="EN JUEGO"
            else
                estadoPartido?.text="PROGRAMADO"
            when (partido?.status){
                "IN_PLAY", "LIVE", "PAUSED" -> {
                    estadoPartido?.setBackgroundColor(Color.parseColor("#006400"))
                }
                "FINISHED" -> {
                    estadoPartido?.setBackgroundColor(Color.parseColor("#F80000"))
                }
                "POSTPONED" -> {
                    if (partido!!.score.winner == null) {
                        estadoPartido?.setBackgroundColor(Color.parseColor("#E2BA1F"))
                    }
                }
                else -> {
                    if (partido!!.score.winner != null) {
                        estadoPartido?.setBackgroundColor(Color.parseColor("#E2BA1F"))
                    } else {
                        estadoPartido?.setBackgroundColor(Color.parseColor("#9B9B9B"))
                    }

                }
            }
            jornada!!.text = partido!!.competition.name + ". Jornada Nº " + partido!!.season.currentMatchday
            if (partido!!.status.equals("FINISHED"))
                minute!!.text = "90'"
            else if (partido?.status == "IN_PLAY" || partido?.status == "PAUSED"
                || partido?.status == "LIVE")
                minute!!.text = "EN DIRECTO"
            else if (partido?.status == "TIMED" && partido!!.score.winner != null)
                minute!!.text = partido!!.minute.toString() + "'" + " (aplazado)"
            else if (partido?.status == "POSTPONED" && partido!!.score.winner == null)
                minute!!.text = partido!!.minute.toString() + "'" + " (cancelado)"
            else
                minute!!.text = partido!!.minute.toString() + "'"
            nombreEquipo1!!.text = partido!!.homeTeam.shortName
            if (partido!!.status.equals("FINISHED") || partido!!.status.equals("IN_PLAY") || partido!!.status.equals("LIVE")
                || partido!!.status.equals("PAUSED")) {
                resultadoPartido!!.text = partido!!.score.fullTime.home.toString() + " - " + partido!!.score.fullTime.away.toString()
            } else {
                val fechaString = fecha?.get(1)?.substring(0, fecha?.get(1)!!.length - 4) ?: ""
                val inputFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
                val outputFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
                try {
                    // Parse the date string
                    val date = inputFormat.parse(fechaString)

                    // Add one hour to the parsed date
                    val calendar = Calendar.getInstance()
                    date?.let { calendar.time = it }
                    calendar.add(Calendar.HOUR_OF_DAY, 1)

                    // Format the updated date
                    val updatedDateString = outputFormat.format(calendar.time)

                    resultadoPartido!!.text = updatedDateString
                    // Set the result to your TextView
                    if (partido?.status == "TIMED" && partido!!.score.winner != null) {
                        resultadoPartido?.text = resultadoPartido?.text.toString() + " (" + partido!!.score.fullTime.home.toString() + " - " + partido!!.score.fullTime.away.toString() + ")"
                    }
                } catch (e: ParseException) {
                    e.printStackTrace()
                    resultadoPartido!!.text = "Formato de fecha no válido"
                }
            }
            if (fecha != null){
                fechaPartido!!.text = formatDate(fecha?.get(0)!!)
            }else{
                fechaPartido!!.text = "Fecha no disponible"
            }
            //fechaPartido!!.text = fecha?.get(0) ?: ""
            nombreEquipo2!!.text = partido!!.awayTeam.shortName
            if (partido!!.venue == null)
                estadio!!.text = "Estadio: No disponible"
            else
                estadio!!.text = "Estadio: " + partido!!.venue

            if (partido!!.competition.emblem == null) {
                // cargar imagen local por defecto
                imagenLiga?.load(R.string.teamDefaultLogo.toString())
            } else {
                // Comprobamos si se trata de un png o svg
                val isSvg = partido!!.competition.emblem.endsWith("svg",ignoreCase = true)
                // Si es svg procedemos a cargarlo con coil
                if (isSvg){
                    imagenLiga?.loadUrl(partido!!.competition.emblem)
                }else{
                    // cargamos la imagen png con coil
                    imagenLiga?.load(partido!!.competition.emblem)
                }
            }
            if (partido!!.homeTeam.crest == null) {
                // cargar imagen local por defecto
                imagenEquipo1?.load(R.string.teamDefaultLogo.toString())
            } else {
                // Comprobamos si se trata de un png o svg
                val isSvg = partido!!.homeTeam.crest.endsWith("svg",ignoreCase = true)
                // Si es svg procedemos a cargarlo con coil
                if (isSvg){
                    imagenEquipo1?.loadUrl(partido!!.homeTeam.crest)
                }else{
                    // cargamos la imagen png con coil
                    imagenEquipo1?.load(partido!!.homeTeam.crest)
                }
            }
            if (partido!!.awayTeam.crest == null) {
                // cargar imagen local por defecto
                imagenEquipo2?.load(R.string.teamDefaultLogo.toString())
            } else {
                // Comprobamos si se trata de un png o svg
                val isSvg = partido!!.awayTeam.crest.endsWith("svg",ignoreCase = true)
                // Si es svg procedemos a cargarlo con coil
                if (isSvg){
                    imagenEquipo2?.loadUrl(partido!!.awayTeam.crest)
                }else{
                    // cargamos la imagen png con coil
                    imagenEquipo2?.load(partido!!.awayTeam.crest)
                }
            }

            // llama a las activities oportunas
            imagenEquipo1!!.setOnClickListener { // Lógica o método que deseas ejecutar al hacer clic en la imagen
                mostrarEquipo(partido!!.homeTeam.id.toString())
            }
            imagenEquipo2!!.setOnClickListener { // Lógica o método que deseas ejecutar al hacer clic en la imagen
                mostrarEquipo(partido!!.awayTeam.id.toString())
            }
            imagenLiga!!.setOnClickListener {
                cargarClasificacion(partido!!.competition.code)
            }

            /* Haciendo uso del FactoryMethod pasándole todos los parámetros necesarios */

            val estadisticasFragment = EstadisticasFragment.newInstance(
                partido!!.homeTeam, partido!!.awayTeam, stats
            )

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, estadisticasFragment).commit()
        }
    }

    private fun mostrarEquipo(id:String){
        val intent = Intent(this, PlantillaActivity::class.java)
        intent.putExtra(ClasificacionActivity.EQUIPO_SELECCIONADO,id)
        startActivity(intent)
    }

    fun cargarClasificacion(code: String?) {
        val ligaIntent = Intent(this@MostrarPartido, ClasificacionActivity::class.java)
        ligaIntent.putExtra(MainRecycler.LIGA_CREADA, code)
        if (code=="CL")
            ligaIntent.putExtra(MainRecycler.PARTIDO_SELECCIONADO, partido!!.homeTeam.id.toString())
        startActivity(ligaIntent)
    }

    private fun formatDate(utcDate: String): String? {
        // Formato de entrada: "yyyy-MM-ddTHH:mm:ss"
        val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

        // Formato de salida: "dd-MM-yyyy"
        val outputFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())

        try {
            // Parse the date string
            val date = inputFormat.parse(utcDate)

            // Format the updated date
            return date?.let { outputFormat.format(it) }
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return "Problemas al parsear la fecha"
    }
}