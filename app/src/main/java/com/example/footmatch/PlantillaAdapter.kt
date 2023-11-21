package com.example.footmatch

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.footmatch.modelo.pojos.plantilla.Squad

class PlantillaAdapter (
    var jugadores : List<Squad>
) : RecyclerView.Adapter<PlantillaAdapter.PlantillaViewHolder>() {


    class PlantillaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val dataJugador: TextView
        private val dataPosicionJugador: TextView
        private val dataNacionalidadJugador : TextView
        private val dataNacimientoJugador : TextView
        init {
            dataJugador = itemView.findViewById<View>(R.id.dataJugador) as TextView
            dataPosicionJugador = itemView.findViewById<View>(R.id.dataPosicionJugador) as TextView
            dataNacionalidadJugador = itemView.findViewById<View>(R.id.dataNacionalidadJugador) as TextView
            dataNacimientoJugador = itemView.findViewById<View>(R.id.dataNacimientoJugador) as TextView
        }

        fun bindUser(jugador: Squad) {
            dataJugador.text = jugador.name
            dataPosicionJugador.text = jugador.position
            dataNacionalidadJugador.text = jugador.nationality
            dataNacimientoJugador.text = jugador.dateOfBirth
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantillaViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.linear_jugador_equipo, parent,false)
        return PlantillaViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return jugadores.size
    }

    override fun onBindViewHolder(holder: PlantillaViewHolder, position: Int) {
        holder.bindUser(jugadores[position])
    }


}