package com.example.footmatch

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.footmatch.modelo.pojos.plantilla.SquadResult
import com.example.footmatch.util.api.RetrofitClient
import com.example.footmatch.util.images.SvgLoader.Companion.loadUrl
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Locale


class PlantillaActivity : AppCompatActivity() {
    var equipo : String = ""
    var plantilla : SquadResult? = null
    var plantillaView : RecyclerView? = null
    var pAdapter : PlantillaAdapter? = null
    private lateinit var navView : BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plantilla)

        val equipoIntent = intent
        val id = equipoIntent.getStringExtra(ClasificacionActivity.EQUIPO_SELECCIONADO).toString()

        plantillaView = findViewById<View>(R.id.recyclerPlantilla) as RecyclerView
        plantillaView!!.setHasFixedSize(true)

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(applicationContext)
        plantillaView!!.layoutManager = layoutManager
        cargarDatosClub(id)
        navView = findViewById(R.id.bottomNavigationView)
        cargarMenu()
    }

    private fun cargarMenu() {
        navView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    // TODO MARCOS
                    val intent = Intent(this@PlantillaActivity, MainRecycler::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                    finish() // Cierra la instancia actual de la actividad
                }
            }
            true
        }
    }
    private fun cargarDatosClub(id: String) {
        val apiService = RetrofitClient.makeClient()
        lifecycleScope.launch(Dispatchers.IO){
            plantilla = apiService.getSquadFromId(id)
            withContext(Dispatchers.Main)
            {
                //Datos del equipo
                val nombreEquipo = findViewById<View>(R.id.nombreEquipo) as TextView
                val fundadoEn = findViewById<View>(R.id.dataFundado) as TextView
                val direccion = findViewById<View>(R.id.dataDireccion) as TextView
                val escudoEquipo = findViewById<View>(R.id.escudoEquipo) as ImageView
                val escudoBandera = findViewById<View>(R.id.escudoEquipo2) as ImageView
                val escudoCompeticion = findViewById<View>(R.id.escudoCompeticion) as ImageView
                val escudoCompeticion2 = findViewById<View>(R.id.escudoCompeticion2) as ImageView
                val estadio = findViewById<View>(R.id.dataEstadioP) as TextView

                if (plantilla!!.crest == null) {
                    // cargar imagen visitante por defecto
                    escudoEquipo.load(R.string.teamDefaultLogo.toString())
                }else{
                    val isSvg = plantilla!!.crest.endsWith("svg",ignoreCase = true)
                    if (isSvg){
                        escudoEquipo.loadUrl(plantilla!!.crest)
                    }else{
                        escudoEquipo.load(plantilla!!.crest)
                    }
                }
                if (plantilla!!.area.flag == null) {
                    // cargar imagen visitante por defecto
                    escudoBandera.load(R.string.teamDefaultLogo.toString())
                }else{
                    val isSvg = plantilla!!.area.flag.endsWith("svg",ignoreCase = true)
                    if (isSvg){
                        escudoBandera.loadUrl(plantilla!!.area.flag)
                    }else{
                        escudoBandera.load(plantilla!!.area.flag)
                    }
                }
                if (plantilla!!.runningCompetitions.isNotEmpty()) {
                    val isSvg = plantilla!!.runningCompetitions[0].emblem.endsWith("svg",ignoreCase = true)
                    if (isSvg){
                        escudoCompeticion.loadUrl(plantilla!!.runningCompetitions[0].emblem)
                    }else{
                        escudoCompeticion.load(plantilla!!.runningCompetitions[0].emblem)
                    }
                    if (plantilla!!.runningCompetitions.size >= 2) {
                        if (plantilla!!.runningCompetitions[1].emblem != null) {
                            val isSvg = plantilla!!.runningCompetitions[1].emblem.endsWith("svg",ignoreCase = true)
                            if (isSvg){
                                escudoCompeticion2.loadUrl(plantilla!!.runningCompetitions[1].emblem)
                            }else{
                                escudoCompeticion2.load(plantilla!!.runningCompetitions[1].emblem)
                            }
                        }
                    }
                }
                if (plantilla!!.address==null)
                    direccion.text = "No disponible"
                else
                    direccion.text = plantilla!!.address.split(",")[0]

                nombreEquipo.text = plantilla!!.name
                estadio.text = plantilla!!.venue
                // Establece un ClickListener al TextView
                if (plantilla!!.website != null) {
                    nombreEquipo.setOnClickListener { // Define la URL que deseas abrir
                        val url = plantilla!!.website

                        // Crea un Intent con la acción ACTION_VIEW y la URI correspondiente
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))

                        // Inicia la actividad del navegador web
                        startActivity(intent)
                    }
                }

                fundadoEn.text = plantilla!!.founded.toString()
                //Cargar el entrenador
                val entrenadorNombre = findViewById<View>(R.id.dataEntrenador) as TextView
                entrenadorNombre.text = plantilla!!.coach.name
                val nacionalidadEntrenador = findViewById<View>(R.id.dataNacionalidadEntrenador) as TextView
                nacionalidadEntrenador.text = plantilla!!.coach.nationality
                val nacimientoEntrenador = findViewById<View>(R.id.dataNacimientoEntrenador)as TextView
                nacimientoEntrenador.text = formatDate(plantilla!!.coach.dateOfBirth)
                val jugadores = plantilla!!.squad
                //Cargar jugadores en el mainRecycler
                pAdapter = PlantillaAdapter(jugadores)
                plantillaView!!.adapter = pAdapter
            }
        }
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