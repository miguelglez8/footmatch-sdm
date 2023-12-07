package com.example.footmatch

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.footmatch.ClasificacionAdapter.ClasificacionViewHolder
import com.example.footmatch.modelo.pojos.clasificacion.StandingsResult
import com.example.footmatch.modelo.pojos.clasificacion.Table
import com.example.footmatch.util.images.SvgLoader.Companion.loadUrl

class ClasificacionAdapter(
    var equipos: StandingsResult, //Se utilizará mas adelante para ir a la pantalla de equipos
    val onItemSelected: (String) -> Unit
) : RecyclerView.Adapter<ClasificacionViewHolder>() {

    override fun getItemCount(): Int {
        return equipos.standings[0].table.size
    }

    class ClasificacionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val nombreEquipo: ImageView
        private val puntosEquipo: TextView
        private val posicion: TextView
        private val golesAFavor: TextView
        private val golesEnContra: TextView
        private val diferenciaGoles: TextView
        private val ganados: TextView
        private val empatados: TextView
        private val perdidos: TextView

        init {
            ganados = itemView.findViewById<View>(R.id.partidosGanados) as TextView
            perdidos = itemView.findViewById<View>(R.id.partidosPerdidos) as TextView
            empatados = itemView.findViewById<View>(R.id.partidosEmpatados) as TextView
            nombreEquipo = itemView.findViewById<View>(R.id.logoEquipo) as ImageView
            puntosEquipo = itemView.findViewById<View>(R.id.puntosEquipo) as TextView
            posicion = itemView.findViewById<View>(R.id.posClasificacion) as TextView
            golesAFavor = itemView.findViewById<View>(R.id.golesFavor) as TextView
            golesEnContra = itemView.findViewById<View>(R.id.golesContra) as TextView
            diferenciaGoles = itemView.findViewById<View>(R.id.diferenciaGoles) as TextView
        }

        // asignar valores a los componentes
        fun bindUser(equipo: Table, onItemSelected: (String) -> Unit) {
            if (equipo.team.crest == null) {
                // cargar imagen visitante por defecto
                nombreEquipo.load(R.string.teamDefaultLogo.toString())
            }else{
                val isSvg = equipo.team.crest.endsWith("svg",ignoreCase = true)
                if (isSvg){
                    nombreEquipo.loadUrl(equipo.team.crest)
                }else{
                    nombreEquipo.load(equipo.team.crest)
                }
            }
            puntosEquipo.text = equipo.points.toString()
            posicion.text = equipo.position.toString()
            golesAFavor.text = equipo.goalsFor.toString()
            golesEnContra.text = equipo.goalsAgainst.toString()
            diferenciaGoles.text= equipo.goalDifference.toString()
            ganados.text = equipo.won.toString()
            perdidos.text = equipo.lost.toString()
            empatados.text = equipo.draw.toString()

            itemView.setOnClickListener {
                onItemSelected(equipo.team.id.toString())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClasificacionViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.linear_clasification_equipo, parent, false)
        return ClasificacionViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ClasificacionViewHolder, position: Int) {
        val equipo: Table = equipos.standings[0].table[position]
        holder.bindUser(equipo, onItemSelected)
    }


}