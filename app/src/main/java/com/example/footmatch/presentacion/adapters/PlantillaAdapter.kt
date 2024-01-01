package com.example.footmatch.presentacion.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.footmatch.R
import com.example.footmatch.datos.modelos.plantilla.Squad
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Locale

class PlantillaAdapter (
    var jugadores : List<Squad>
) : RecyclerView.Adapter<PlantillaAdapter.PlantillaViewHolder>() {


    class PlantillaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val dataJugador: TextView
        private val dataPosicionJugador: TextView
        private val dataNacionalidadJugador : TextView
        private val dataNacimientoJugador : TextView
        init {
            dataJugador = itemView.findViewById<View>(R.id.nombreJugador) as TextView
            dataPosicionJugador = itemView.findViewById<View>(R.id.posicionJugador) as TextView
            dataNacionalidadJugador = itemView.findViewById<View>(R.id.dataNacionalidadJugador) as TextView
            dataNacimientoJugador = itemView.findViewById<View>(R.id.dataNacimientoJugador) as TextView
        }

        fun bindUser(jugador: Squad) {
            dataJugador.text = jugador.name
            dataPosicionJugador.text = jugador.position
            dataNacionalidadJugador.text = jugador.nationality
            if (jugador.dateOfBirth==null)
                dataNacimientoJugador.text = "-"
            else
                dataNacimientoJugador.text = formatDate(jugador.dateOfBirth)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantillaViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.linear_jugador_equipo, parent,false)
        itemView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        return PlantillaViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return jugadores.size
    }

    override fun onBindViewHolder(holder: PlantillaViewHolder, position: Int) {
        holder.bindUser(jugadores[position])
    }

    companion object {
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


}