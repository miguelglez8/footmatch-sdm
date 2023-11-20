package com.example.footmatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.footmatch.R

class PlantillaActivity : AppCompatActivity() {
    var equipo : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plantilla)

        val equipoIntent = intent
        equipo = equipoIntent.getStringExtra(ClasificacionActivity.EQUIPO_SELECCIONADO).toString()

    }
}