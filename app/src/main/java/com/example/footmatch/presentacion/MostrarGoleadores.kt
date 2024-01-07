package com.example.footmatch.presentacion

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.footmatch.R
import com.example.footmatch.datos.modelos.goleadores.Scorer
import com.example.footmatch.datos.api.ApiLimitExceededException
import com.example.footmatch.datos.api.RetrofitClient
import com.example.footmatch.datos.images.SvgLoader.Companion.loadUrl
import com.example.footmatch.presentacion.adapters.ListaTopAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MostrarGoleadores : AppCompatActivity()  {
    // Modelo datos
    var listaScorers: RecyclerView? = null
    var listaAssists: RecyclerView? = null
    var listaPenaltis: RecyclerView? = null
    private lateinit var listaScorerAdapter: ListaTopAdapter
    private lateinit var listaAssistAdapter: ListaTopAdapter
    private lateinit var listaPenaltyAdapter: ListaTopAdapter
    private var imageViewAtras: ImageView? = null
    private var headerImageView: ImageView? = null
    private var imageView1_1: ImageView? = null
    private var imageView2_1: ImageView? = null
    private var imageView3_1: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goleadores)

        // Obtener datos del intent
        val intentMatch = intent

        val code = intentMatch.getStringExtra(ClasificacionActivity.LIGA_SELCCIONADA).toString()

        imageViewAtras = findViewById(R.id.atras)
        headerImageView = findViewById(R.id.headerImageView)
        imageView1_1 = findViewById(R.id.imageView1_1)
        imageView2_1 = findViewById(R.id.imageView2_1)
        imageView3_1 = findViewById(R.id.imageView3_1)

        // Recuperamos referencia y configuramos recyclerView con la lista de partidos
        listaScorers = findViewById<View>(R.id.recyclerViewPartidos1) as RecyclerView

        listaAssists = findViewById<View>(R.id.recyclerViewPartidos2) as RecyclerView

        listaPenaltis = findViewById<View>(R.id.recyclerViewPartidos3) as RecyclerView

        cargarScorers(code)
    }

    /*
    Carga todos los partidos entre las dos fechas que se le pasan por parametro
     */
    private fun cargarScorers(code: String) {
        // Llamada a la API empleando corrutinas de Kotlin
        val apiService = RetrofitClient.makeClient()

        lifecycleScope.launch(Dispatchers.IO) {
            try {
                val competition = apiService.getScorers(code)
                val scorers = competition.scorers

                val scorersOrderByGoals = orderByGoals(scorers)
                val scorersFilteredGoals = filterZeroStats(scorersOrderByGoals)

                val scorersOrderByAssists = orderByAssists(scorers)
                val scorersFilteredAssists = filterZeroAssists(scorersOrderByAssists)

                val scorersOrderByPenaltyGoals = orderByPenaltyGoals(scorers)
                val scorersFilteredPenalties = filterZeroPenalties(scorersOrderByPenaltyGoals)

                // Cambiamos al hilo principal para actualizar los datos
                withContext(Dispatchers.Main) {
                    // Actualizamos la lista de goleadores
                    listaScorerAdapter = ListaTopAdapter(
                        scorersFilteredGoals,
                        "Goles"
                    )
                    setUpRecyclerView(listaScorers, listaScorerAdapter!!)

                    // Actualizamos la lista de asistencias
                    listaAssistAdapter = ListaTopAdapter(
                        scorersFilteredAssists,
                        "Asistencias"
                    )
                    setUpRecyclerView(listaAssists, listaAssistAdapter!!)

                    // Actualizamos la lista de penaltis
                    listaPenaltyAdapter = ListaTopAdapter(
                        scorersFilteredPenalties,
                        "Penaltis"
                    )
                    setUpRecyclerView(listaPenaltis, listaPenaltyAdapter!!)

                    val isSvg = competition!!.competition.emblem.endsWith("svg", ignoreCase = true)
                    // Si es svg procedemos a cargarlo con coil
                    if (isSvg) {
                        headerImageView?.loadUrl(competition!!.competition.emblem)
                    } else {
                        // cargamos la imagen png con coil
                        headerImageView?.load(competition!!.competition.emblem)
                    }
                    imageViewAtras!!.load(R.drawable.atras)
                    imageViewAtras!!.setOnClickListener {
                        volverAtras()
                    }
                    imageView1_1!!.load(R.drawable.balon)
                    imageView2_1!!.load(R.drawable.bota)
                    imageView3_1!!.load(R.drawable.penalti)
                }
            } catch (e: ApiLimitExceededException) {
                // Si se supera el límite de peticiones, mostramos un toast con el mensaje de error
                // y deshabilitamos los elementos de la pantalla
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        this@MostrarGoleadores,
                        "Demasiadas requests a la API, espere " + e.timeToWait + " segundos",
                        Toast.LENGTH_LONG
                    ).show()
                }
            } catch (e: Exception) {
                Log.e("API Request", "Exception: ${e.message}", e)
            }
        }
    }

    private fun setUpRecyclerView(recyclerView: RecyclerView?, adapter: ListaTopAdapter) {
        // Configura el RecyclerView y su adaptador
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView!!.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    fun orderByGoals(scorers: List<Scorer>): List<Scorer> {
        return scorers.sortedWith(compareByDescending<Scorer> { it.goals }
            .thenByDescending { it.goals.toDouble() / it.playedMatches })
    }

    fun orderByAssists(scorers: List<Scorer>): List<Scorer> {
        return scorers.sortedWith(compareByDescending<Scorer> { it.assists }
            .thenByDescending { it.assists.toDouble() / it.playedMatches })
    }

    fun orderByPenaltyGoals(scorers: List<Scorer>): List<Scorer> {
        return scorers.sortedWith(compareByDescending<Scorer> { it.penalties }
            .thenByDescending { it.penalties.toDouble() / it.playedMatches })
    }

    fun filterZeroStats(scorers: List<Scorer>): List<Scorer> {
        return scorers.filter { it.goals > 0 }
    }

    fun filterZeroAssists(scorers: List<Scorer>): List<Scorer> {
        return scorers.filter { it.assists > 0 }
    }

    fun filterZeroPenalties(scorers: List<Scorer>): List<Scorer> {
        return scorers.filter { it.penalties > 0 }
    }


    fun volverAtras() {
        finish()
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