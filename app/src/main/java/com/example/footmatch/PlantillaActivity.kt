package com.example.footmatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.footmatch.R
import com.example.footmatch.modelo.pojos.plantilla.SquadResult
import com.example.footmatch.util.api.RetrofitClient
import com.example.footmatch.util.images.SvgLoader.Companion.loadUrl
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PlantillaActivity : AppCompatActivity() {
    var equipo : String = ""
    var plantilla : SquadResult? = null
    var plantillaView : RecyclerView? = null
    var pAdapter : PlantillaAdapter? = null
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
                val escudoEquipo = findViewById<View>(R.id.escudoEquipo) as ImageView
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

                nombreEquipo.text = plantilla!!.shortName
                fundadoEn.text = plantilla!!.founded.toString()

                //Cargar el entrenador
                val entrenadorNombre = findViewById<View>(R.id.dataEntrenador) as TextView
                entrenadorNombre.text = plantilla!!.coach.name
                val nacionalidadEntrenador = findViewById<View>(R.id.dataNacionalidadEntrenador) as TextView
                nacionalidadEntrenador.text = plantilla!!.coach.nationality
                val nacimientoEntrenador = findViewById<View>(R.id.dataNacimientoEntrenador)as TextView
                nacimientoEntrenador.text = plantilla!!.coach.dateOfBirth
                val jugadores = plantilla!!.squad
                //Cargar jugadores en el mainRecycler
                pAdapter = PlantillaAdapter(jugadores)
                plantillaView!!.adapter = pAdapter
            }
        }
    }
}