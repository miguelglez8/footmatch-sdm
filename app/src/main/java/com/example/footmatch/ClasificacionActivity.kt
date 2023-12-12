package com.example.footmatch

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.footmatch.modelo.pojos.clasificacion.StandingsResult
import com.example.footmatch.util.api.RetrofitClient
import com.example.footmatch.util.images.SvgLoader.Companion.loadUrl
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ClasificacionActivity : AppCompatActivity() {
    var liga: String? = null
    var clasificacion: StandingsResult? = null
    var clasificacionView: RecyclerView? = null
    var cAdapter : ClasificacionAdapter? = null
    private lateinit var navView : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clasificacion)

        val clasificacionIntent = intent

        liga = clasificacionIntent.getStringExtra(MainRecycler.LIGA_CREADA)

        clasificacionView = findViewById<View>(R.id.recyclerClasificacion) as RecyclerView

        clasificacionView!!.setHasFixedSize(true)

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(applicationContext)

        clasificacionView!!.layoutManager = layoutManager
        //Hago una llamada a la API, con el codigo de la liga para recuperar los datos
        cargarClasificacion()
        navView = findViewById(R.id.bottomNavigationView)
        cargarMenu()
    }

    private fun cargarMenu() {
        navView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    //val intent = Intent(this@ClasificacionActivity, MainRecycler::class.java)
                    //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                    //startActivity(intent)
                    // De igual forma al pulsa el boton de inicio, volvemos a la activity previa
                    // sin tener que hacer todas las llamadas a la API de nuevo
                    finish() // Cierra la instancia actual de la actividad
                }
            }
            true
        }
    }

    private fun cargarClasificacion() {
        val apiService = RetrofitClient.makeClient()
        lifecycleScope.launch(Dispatchers.IO){
            clasificacion = apiService.getStandingsFromLeague(liga!!)
            withContext(Dispatchers.Main)
            {
                val logoLiga = findViewById<View>(R.id.logoLiga) as ImageView
                val logoBandera = findViewById<View>(R.id.logoBandera) as ImageView
                val nombreLiga = findViewById<View>(R.id.nombreLiga) as TextView
                nombreLiga.text = clasificacion!!.competition.name
                if (clasificacion!!.competition.emblem == null) {
                    // cargar imagen visitante por defecto
                    logoLiga.load(R.string.teamDefaultLogo.toString())
                }else{
                    val isSvg = clasificacion!!.competition.emblem.endsWith("svg",ignoreCase = true)
                    if (isSvg){
                        logoLiga.loadUrl(clasificacion!!.competition.emblem)
                    }else{
                        logoLiga.load(clasificacion!!.competition.emblem)
                    }
                }
                if (clasificacion!!.area.flag == null) {
                    // cargar imagen visitante por defecto
                    logoBandera.load(R.string.teamDefaultLogo.toString())
                }else{
                    val isSvg = clasificacion!!.area.flag.endsWith("svg",ignoreCase = true)
                    if (isSvg){
                        logoBandera.loadUrl(clasificacion!!.area.flag)
                    }else{
                        logoBandera.load(clasificacion!!.area.flag)
                    }
                }
                // Notificamos al adapter
                cAdapter = ClasificacionAdapter(clasificacion!!) {
                   mostrarEquipo(it)
                }
                clasificacionView!!.adapter = cAdapter
            }
        }
    }

    private fun mostrarEquipo(id:String){
        val intent = Intent(this,PlantillaActivity::class.java)
        intent.putExtra(EQUIPO_SELECCIONADO,id)
        startActivity(intent)
    }

    companion object {
        // identificador de intent
        const val EQUIPO_SELECCIONADO = "equipo_seleccionado"

    }
}