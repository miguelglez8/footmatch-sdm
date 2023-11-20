package com.example.footmatch

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.footmatch.modelo.pojos.clasificacion.StandingsResult
import com.example.footmatch.util.api.RetrofitClient
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ClasificacionActivity : AppCompatActivity() {
    var liga: String? = null
    var clasificacion: StandingsResult? = null
    var clasificacionView: RecyclerView? = null
    var lpAdapter : ClasificacionAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clasificacion)

        val clasificacionIntent = intent

        liga = clasificacionIntent.getStringExtra(MainRecycler.LIGA_CREADA)

        //Hago una llamada a la API, con el codigo de la liga para recuperar los datos

        clasificacionView = findViewById<View>(R.id.recyclerClasificacion) as RecyclerView

        clasificacionView!!.setHasFixedSize(true)

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(applicationContext)

        clasificacionView!!.layoutManager = layoutManager

        cargarClasificacion()


    }

    private fun cargarClasificacion() {
        val apiService = RetrofitClient.makeClient()
        lifecycleScope.launch(Dispatchers.IO){
            clasificacion = apiService.getStandingsFromLeague(liga!!)
            withContext(Dispatchers.Main)
            {
                val logoLiga = findViewById<View>(R.id.logoLiga) as ImageView

                val nombreLiga = findViewById<View>(R.id.nombreLiga) as TextView
                nombreLiga.text = clasificacion!!.competition.name
                Picasso.get()
                    .load(clasificacion!!.competition.emblem).into(logoLiga)
                // Notificamos al adapter
                lpAdapter = ClasificacionAdapter(clasificacion!!) {
                    /*clickonItem(partido);*/
                }
                clasificacionView!!.adapter = lpAdapter
            }
        }
    }
}