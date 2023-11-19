package com.example.footmatch

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.footmatch.modelo.Arbitro
import com.example.footmatch.modelo.Partido
import com.example.footmatch.ui.AlineacionesFragment
import com.example.footmatch.ui.ArbitrosFragment
import com.example.footmatch.ui.EstadisticasFragment
import com.example.footmatch.ui.EventosFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.squareup.picasso.Picasso

class MostrarPartido : AppCompatActivity() {
    private var partido: Partido? = null
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_match)

        // Obtener datos del intent
        val intentMatch = intent
        partido = intentMatch.getParcelableExtra(MainRecycler.PARTIDO_SELECCIONADO)

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
        when (partido?.estadoPartido) {
            "NO_EMPEZADO" -> estado?.setBackgroundColor(Color.parseColor("#CCCCCC"))
            "EN_JUEGO" -> estado?.setBackgroundColor(Color.parseColor("#FFFF00"))
            else -> estado?.setBackgroundColor(Color.parseColor("#555555"))
        }
        
        // Cargar datos del partido en las vistas
        mostrarDatos(partido)
    }

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->

            /* Cuando se selecciona uno de los botones / ítems*/
            if (partido == null) return@OnNavigationItemSelectedListener false
            val itemId = item.itemId

            /* Según el caso, crearemos un Fragmento u otro */if (itemId == R.id.navigation_stats) {
            /* Haciendo uso del FactoryMethod pasándole todos los parámetros necesarios */

            /* Argumento solamente necesita.... El argumento de la película */
            val estadisticasFragment = EstadisticasFragment.newInstance(
                partido!!.equipoLocal, partido!!.equipoVisitante, partido!!.estadisticasPartidoE1,
                partido!!.estadisticasPartidoE2, partido!!.estadisticasE1, partido!!.estadisticasE2
            )

            /* ¿Qué estaremos haciendo aquí? */supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, estadisticasFragment).commit()
            return@OnNavigationItemSelectedListener true
        }
            if (itemId == R.id.navigation_events) {
                if (partido!!.eventos.size > 0) {
                    val eventosFragment = EventosFragment.newInstance(partido!!.eventos)

                    /* ¿Qué estaremos haciendo aquí? */supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, eventosFragment).commit()
                } else {
                    // cargar no_disponible
                }
                return@OnNavigationItemSelectedListener true
            }
            if (itemId == R.id.navigation_referees) {
                if (partido!!.arbitros.size > 0) {
                    val arbitrosFragment =
                        ArbitrosFragment.newInstance(partido!!.arbitros as ArrayList<Arbitro?>)
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, arbitrosFragment).commit()
                } else {
                    // cargar no_disponible
                }
                return@OnNavigationItemSelectedListener true
            }
            if (itemId == R.id.navigation_alineations) {
                val alineacionesFragment = AlineacionesFragment.newInstance(
                    partido!!.equipoLocal, partido!!.equipoVisitante
                )
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, alineacionesFragment).commit()
                return@OnNavigationItemSelectedListener true
            }
            throw IllegalStateException("Unexpected value: " + item.itemId)
        }

    // Cargar los datos del partido en las vistas
    private fun mostrarDatos(partido: Partido?) {
        if (partido != null) {
            // Actualizar componentes con valores del partido específico
            textView!!.text = partido.nombreLiga + " " + partido.jornada
            textView2!!.text = partido.minutoJuego
            nombreEquipo1!!.text = partido.equipoLocal.nombre
            if (partido.estadoPartido == "NO_EMPEZADO") {
                resultadoPartido!!.text = partido.hora
            } else {
                resultadoPartido!!.text = partido.resultado
            }
            fechaPartido!!.text = partido.fecha
            nombreEquipo2!!.text = partido.equipoVisitante.nombre
            estadio!!.text = partido.estadio
            estadoPartido!!.text = partido.estado
            Picasso.get()
                .load(partido.urlLiga).into(imagenLiga)
            Picasso.get()
                .load(partido.equipoLocal.urlImagenEscudo).into(imagenEquipo1)
            Picasso.get()
                .load(partido.equipoVisitante.urlImagenEscudo).into(imagenEquipo2)
            val estadisticasFragment = EstadisticasFragment.newInstance(
                partido.equipoLocal, partido.equipoVisitante, partido.estadisticasPartidoE1,
                partido.estadisticasPartidoE2, partido.estadisticasE1, partido.estadisticasE2
            )

            /* ¿Qué estaremos haciendo aquí? */supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, estadisticasFragment).commit()
        }
    }
}