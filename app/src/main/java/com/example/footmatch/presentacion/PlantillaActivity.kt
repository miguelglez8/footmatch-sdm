package com.example.footmatch.presentacion

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import coil.load
import com.example.footmatch.datos.modelos.plantilla.SquadResult
import com.example.footmatch.datos.api.RetrofitClient
import com.example.footmatch.datos.images.SvgLoader.Companion.loadUrl
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Locale
import androidx.viewpager2.widget.ViewPager2
import com.example.footmatch.R
import com.example.footmatch.presentacion.adapters.PlantillaAdapter
import com.example.footmatch.datos.api.ApiLimitExceededException
import java.lang.Integer.min

class PlantillaActivity : AppCompatActivity() {
    private lateinit var dots: Array<ImageView?>
    var equipo : String = ""
    var plantilla : SquadResult? = null
    var pAdapter : PlantillaAdapter? = null
    private lateinit var navView : BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plantilla)

        val equipoIntent = intent
        val id = equipoIntent.getStringExtra(ClasificacionActivity.EQUIPO_SELECCIONADO).toString()

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
        lifecycleScope.launch(Dispatchers.IO) {
            try {
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
                    val escudoCompeticion2 =
                        findViewById<View>(R.id.escudoCompeticion2) as ImageView
                    val estadio = findViewById<View>(R.id.dataEstadioP) as TextView
                    val boton = findViewById<View>(R.id.button) as Button

                    if (plantilla!!.crest == null) {
                        // cargar imagen visitante por defecto
                        escudoEquipo.load(R.string.teamDefaultLogo.toString())
                    } else {
                        val isSvg = plantilla!!.crest.endsWith("svg", ignoreCase = true)
                        if (isSvg) {
                            escudoEquipo.loadUrl(plantilla!!.crest)
                        } else {
                            escudoEquipo.load(plantilla!!.crest)
                        }
                    }
                    if (plantilla!!.area.flag == null) {
                        // cargar imagen visitante por defecto
                        escudoBandera.load(R.string.teamDefaultLogo.toString())
                    } else {
                        val isSvg = plantilla!!.area.flag.endsWith("svg", ignoreCase = true)
                        if (isSvg) {
                            escudoBandera.loadUrl(plantilla!!.area.flag)
                        } else {
                            escudoBandera.load(plantilla!!.area.flag)
                        }
                    }
                    if (plantilla!!.runningCompetitions.isNotEmpty()) {
                        val isSvg = plantilla!!.runningCompetitions[0].emblem.endsWith(
                            "svg",
                            ignoreCase = true
                        )
                        if (isSvg) {
                            escudoCompeticion.loadUrl(plantilla!!.runningCompetitions[0].emblem)
                        } else {
                            escudoCompeticion.load(plantilla!!.runningCompetitions[0].emblem)
                        }
                        if (plantilla!!.runningCompetitions.size >= 2) {
                            if (plantilla!!.runningCompetitions[1].emblem != null) {
                                val isSvg = plantilla!!.runningCompetitions[1].emblem.endsWith(
                                    "svg",
                                    ignoreCase = true
                                )
                                if (isSvg) {
                                    escudoCompeticion2.loadUrl(plantilla!!.runningCompetitions[1].emblem)
                                } else {
                                    escudoCompeticion2.load(plantilla!!.runningCompetitions[1].emblem)
                                }
                            } else {
                                escudoCompeticion2.load(R.drawable.copa)
                            }
                        }
                    }
                    if (plantilla!!.address == null)
                        direccion.text = "No disponible"
                    else
                        direccion.text = plantilla!!.address.split(",")[0]

                    nombreEquipo.text = plantilla!!.name
                    estadio.text = plantilla!!.venue
                    if (plantilla!!.website != null) {
                        boton.setOnClickListener { // Define la URL que deseas abrir
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
                    val nacionalidadEntrenador =
                        findViewById<View>(R.id.dataNacionalidadEntrenador) as TextView
                    nacionalidadEntrenador.text = plantilla!!.coach.nationality
                    val nacimientoEntrenador =
                        findViewById<View>(R.id.dataNacimientoEntrenador) as TextView
                    nacimientoEntrenador.text = formatDate(plantilla!!.coach.dateOfBirth)

                    // carousel
                    val viewPager: ViewPager2 = findViewById(R.id.viewPager)
                    val dotsLayout: LinearLayout = findViewById(R.id.dotsLayout)
                    val playerAdapter = PlantillaAdapter(plantilla!!.squad)
                    viewPager.adapter = playerAdapter

                    // Add dots dynamically
                    val dotsCount = playerAdapter.itemCount
                    val maxVisibleDots = 5 // Set the maximum number of visible dots

                    val displayDotsCount = min(dotsCount, maxVisibleDots)
                    dots = arrayOfNulls<ImageView>(displayDotsCount)

                    for (i in 0 until displayDotsCount) {
                        dots[i] = ImageView(this@PlantillaActivity)
                        dots[i]?.setImageDrawable(
                            ContextCompat.getDrawable(
                                this@PlantillaActivity,
                                R.drawable.dot_indicator
                            )
                        )

                        val params = LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                        ).apply {
                            setMargins(8, 0, 8, 0)
                        }
                        dotsLayout.addView(dots[i], params)
                    }

                    // ViewPager2 Page Change Callback
                    viewPager.registerOnPageChangeCallback(object :
                        ViewPager2.OnPageChangeCallback() {
                        override fun onPageSelected(position: Int) {
                            super.onPageSelected(position)
                            updateDots(position, maxVisibleDots, dotsCount)
                        }
                    })
                }
            } catch (e: ApiLimitExceededException) {
                //Log.e("API Request", "ApiLimitExceededException: ${e.message}", e)
                // Si se supera el limite de peticiones, mostramos un toast con el mensaje de error
                // y deshabilitamos los elementos de la pantalla
                withContext(Dispatchers.Main){
                    Toast.makeText(
                        this@PlantillaActivity,
                        "Demasiadas requests a la API, espere " + e.timeToWait + " segundos",
                        Toast.LENGTH_LONG
                    ).show()
                }
            } catch (e:Exception){
                Log.e("API Request", "Exception: ${e.message}", e)
            }
        }
    }

    private fun updateDots(currentPosition: Int, maxVisibleDots: Int, dotsCount: Int) {
        val dif = dotsCount % maxVisibleDots
        for (i in dots.indices) {
            val isLastItem = currentPosition > dotsCount - maxVisibleDots
            if (i != currentPosition % maxVisibleDots) {
                dots[i]?.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.dot_inactive))
            } else if (isLastItem) {
                if (dif==4) {
                    dots[4]?.setImageDrawable(ContextCompat.getDrawable(this,
                        R.drawable.dot_transparent
                    ))
                    dots[i]?.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.dot_active))
                    if (i<=2) {
                        dots[i+1]?.setImageDrawable(ContextCompat.getDrawable(this,
                            R.drawable.dot_inactive
                        ))                    } else if (i==1) {
                    }
                } else if (dif==3) {
                    if (i>=3) {
                        dots[i]?.setImageDrawable(ContextCompat.getDrawable(this,
                            R.drawable.dot_active
                        ))
                    } else {
                        if (i==1) {
                            dots[1]?.setImageDrawable(ContextCompat.getDrawable(this,
                                R.drawable.dot_active
                            ))
                            dots[2]?.setImageDrawable(ContextCompat.getDrawable(this,
                                R.drawable.dot_inactive
                            ))
                        } else if (i==0) {
                            dots[0]?.setImageDrawable(ContextCompat.getDrawable(this,
                                R.drawable.dot_active
                            ))
                            dots[1]?.setImageDrawable(ContextCompat.getDrawable(this,
                                R.drawable.dot_inactive
                            ))
                        } else {
                            dots[2]?.setImageDrawable(ContextCompat.getDrawable(this,
                                R.drawable.dot_active
                            ))
                        }
                        dots[3]?.setImageDrawable(ContextCompat.getDrawable(this,
                            R.drawable.dot_transparent
                        ))
                        dots[4]?.setImageDrawable(ContextCompat.getDrawable(this,
                            R.drawable.dot_transparent
                        ))
                    }
                } else if (dif==2) {
                    if (i>=2) {
                        if (i == 3) {
                            dots[i]?.setImageDrawable(ContextCompat.getDrawable(this,
                                R.drawable.dot_active
                            ))
                            dots[i+1]?.setImageDrawable(ContextCompat.getDrawable(this,
                                R.drawable.dot_inactive
                            ))
                        } else if (i==4) {
                            dots[i]?.setImageDrawable(ContextCompat.getDrawable(this,
                                R.drawable.dot_active
                            ))
                            dots[i-1]?.setImageDrawable(ContextCompat.getDrawable(this,
                                R.drawable.dot_inactive
                            ))
                        }
                    } else {
                        dots[i]?.setImageDrawable(ContextCompat.getDrawable(this,
                            R.drawable.dot_active
                        ))
                        dots[2]?.setImageDrawable(ContextCompat.getDrawable(this,
                            R.drawable.dot_transparent
                        ))
                        dots[3]?.setImageDrawable(ContextCompat.getDrawable(this,
                            R.drawable.dot_transparent
                        ))
                        dots[4]?.setImageDrawable(ContextCompat.getDrawable(this,
                            R.drawable.dot_transparent
                        ))
                        if (i==0) {
                            dots[1]?.setImageDrawable(ContextCompat.getDrawable(this,
                                R.drawable.dot_inactive
                            ))
                        } else {
                            dots[0]?.setImageDrawable(ContextCompat.getDrawable(this,
                                R.drawable.dot_inactive
                            ))
                        }
                    }
                } else if (dif==1) {
                    if (i>=1) {
                        if (i==2) {
                            dots[3]?.setImageDrawable(ContextCompat.getDrawable(this,
                                R.drawable.dot_inactive
                            ))
                        } else if (i==3) {
                            dots[4]?.setImageDrawable(ContextCompat.getDrawable(this,
                                R.drawable.dot_inactive
                            ))
                        }
                        dots[i]?.setImageDrawable(ContextCompat.getDrawable(this,
                            R.drawable.dot_active
                        ))
                    } else {
                        dots[i]?.setImageDrawable(ContextCompat.getDrawable(this,
                            R.drawable.dot_active
                        ))
                        dots[1]?.setImageDrawable(ContextCompat.getDrawable(this,
                            R.drawable.dot_transparent
                        ))
                        dots[2]?.setImageDrawable(ContextCompat.getDrawable(this,
                            R.drawable.dot_transparent
                        ))
                        dots[3]?.setImageDrawable(ContextCompat.getDrawable(this,
                            R.drawable.dot_transparent
                        ))
                        dots[4]?.setImageDrawable(ContextCompat.getDrawable(this,
                            R.drawable.dot_transparent
                        ))
                    }
                } else if (dif==0) {
                    if (i==3) {
                        dots[4]?.setImageDrawable(ContextCompat.getDrawable(this,
                            R.drawable.dot_inactive
                        ))
                    } else if (i==2) {
                        dots[3]?.setImageDrawable(ContextCompat.getDrawable(this,
                            R.drawable.dot_inactive
                        ))
                    } else if (i==1) {
                        dots[2]?.setImageDrawable(ContextCompat.getDrawable(this,
                            R.drawable.dot_inactive
                        ))
                    }
                    dots[i]?.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.dot_active))
                }
                break
            } else {
                dots[i]?.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.dot_active))
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