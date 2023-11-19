package com.example.footmatch

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.footmatch.ClasificacionAdapter.ClasificacionViewHolder
import com.example.footmatch.modelo.Equipo
import com.example.footmatch.modelo.pojos.clasificacion.StandingsResult
import com.example.footmatch.modelo.pojos.clasificacion.Table
import com.squareup.picasso.Picasso

class ClasificacionAdapter(var equipos: StandingsResult, //Se utilizará mas adelante para ir a la pantalla de equipos
                           private val listener: () -> Unit) : RecyclerView.Adapter<ClasificacionViewHolder>() {
    fun update(clasificacion: StandingsResult) {}
    interface OnItemClickListener {
        fun onItemClick(item: Equipo?)
    }

    override fun getItemCount(): Int {
        return equipos.standings.size
    }

    class ClasificacionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val escudo: ImageView
        private val nombreEquipo: TextView
        private val puntosEquipo: TextView

        init {
            escudo = itemView.findViewById<View>(R.id.imagenEquipo) as ImageView
            nombreEquipo = itemView.findViewById<View>(R.id.equipoLiga) as TextView
            puntosEquipo = itemView.findViewById<View>(R.id.puntosEquipo) as TextView
        }

        // asignar valores a los componentes
        fun bindUser(equipo: Table, listener: () -> Unit) {
            nombreEquipo.text = equipo.team.name
            puntosEquipo.text = equipo.points.toString()
            Picasso.get()
                   .load(equipo.team.crest).into(escudo)
            itemView.setOnClickListener {
                // Metodo para accerder a la plantilla desde clasificacion
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClasificacionViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.linear_clasification_equipo, parent, false)
        return ClasificacionViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ClasificacionViewHolder, position: Int) {
        val equipo: Table = equipos.standings.get(0).table.get(position)
        holder.bindUser(equipo, listener)
    }
}