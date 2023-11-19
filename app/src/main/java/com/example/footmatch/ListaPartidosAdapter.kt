package com.example.footmatch

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.footmatch.ListaPartidosAdapter.PartidoViewHolder
import com.example.footmatch.modelo.pojos.Match
import com.squareup.picasso.Picasso

class ListaPartidosAdapter(
    private var matchList: List<Match> = emptyList(),
    private val onItemSelected: (Match) -> Unit
) : RecyclerView.Adapter<PartidoViewHolder>() {


    /*Clase interna que define los compoonentes de la vista*/
    class PartidoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val logoLocal: ImageView
        private val nombreLocal: TextView
        private val logoVisitante: ImageView
        private val nombreVisitante: TextView
        private val resultadoLocal: TextView
        private val resultadoVisitante: TextView
        private val fecha: TextView

        init {
            logoLocal = itemView.findViewById<View>(R.id.equipoLocalImageView) as ImageView
            nombreLocal = itemView.findViewById<View>(R.id.equipoLocalNombreTextView) as TextView
            logoVisitante = itemView.findViewById<View>(R.id.equipoVisitanteImageView) as ImageView
            nombreVisitante =
                itemView.findViewById<View>(R.id.equipoVisitanteNombreTextView) as TextView
            resultadoLocal = itemView.findViewById<View>(R.id.localTextView) as TextView
            resultadoVisitante = itemView.findViewById<View>(R.id.visitanteTextView) as TextView
            fecha = itemView.findViewById<View>(R.id.fechaTextView) as TextView
        }

        // asignar valores a los componentes
        fun bindUser(match: Match, listener: (Match) -> Unit) {

            // cargar imagen local
            Picasso.get()
                .load(match.homeTeam.crest).into(logoVisitante)
            // cargar imagen visitante
            Picasso.get()
                .load(match.awayTeam.crest).into(logoVisitante)
            // cargar nombre equipo local
            nombreLocal.text = match.homeTeam.shortName
            // cargar nombre equipo visitante
            nombreVisitante.text = match.awayTeam.shortName
            // cargar resultado
            if (match.score.winner != null) {
                resultadoLocal.text = match.score.fullTime.home.toString()
                resultadoVisitante.text = match.score.fullTime.away.toString()
            } else {
                resultadoLocal.text = ""
                resultadoVisitante.text = ""
            }
            // cargar fecha partido
            fecha.text = formatDate(match.utcDate)
            itemView.setOnClickListener {
                // De momento no hacemos nada al pulsar sobre un partido
            }
        }
    }
   /*
   * Notificamos un cambio en la lista de partidos
    */
   @SuppressLint("NotifyDataSetChanged")
   fun update(listaPartidos:List<Match>){
        this.matchList = listaPartidos
       // Cambiamos la totalidad de la lista
       notifyDataSetChanged()
    }

    /* Indicamos el layout a "inflar" para usar en la vista
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartidoViewHolder {
        // Creamos la vista con el layout para un elemento
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.linea_recycler_view_partido, parent, false)
        return PartidoViewHolder(itemView)
    }

    /** Asocia el contenido a los componentes de la vista,
     * concretamente con nuestro PartidoViewHolder que recibimos como parámetro
     */
    override fun onBindViewHolder(holder: PartidoViewHolder, position: Int) {
        Log.d("onBindViewHolder", "Elemento en posicion $position se esta vinculando")
        // Extrae de la lista el elemento indicado por posición
        val match = matchList[position]
        Log.i("Lista", "Visualiza elemento: $match")
        // llama al método de nuestro holder para asignar valores a los componentes
        // además, pasamos el listener del evento onClick
        holder.bindUser(match, onItemSelected)
    }

    override fun getItemCount(): Int {
        return matchList.size
    }

    companion object {
        private fun formatDate(utcDate: String): String {
            val separated =
                utcDate.split("T".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            val date = separated[0]
            val hour = separated[1].substring(0, 5)
            return "$date $hour"
        }
    }
}