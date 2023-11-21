package com.example.footmatch

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.footmatch.ListaJugadoresAdapter.JugadorViewHolder
import com.example.footmatch.modelo.pojos.Squad

class ListaJugadoresAdapter(
    private val listaJugadores: List<Squad>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<JugadorViewHolder>() {
    // Interfaz para manejar el evento click sobre un elemento
    interface OnItemClickListener {
        fun onItemClick(item: Squad?)
    }

    /* Indicamos el layout a "inflar" para usar en la vista
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JugadorViewHolder {
        // Creamos la vista con el layout para un elemento
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_jugador, parent, false)
        return JugadorViewHolder(itemView)
    }

    /** Asocia el contenido a los componentes de la vista,
     * concretamente con nuestro PartidoViewHolder que recibimos como parámetro
     */
    override fun onBindViewHolder(holder: JugadorViewHolder, position: Int) {
        // Extrae de la lista el elemento indicado por posición
        val jugador = listaJugadores[position]
        Log.i("Lista", "Visualiza elemento: $jugador")
        // llama al método de nuestro holder para asignar valores a los componentes
        // además, pasamos el listener del evento onClick
        holder.bindUser(jugador, position, listener)
    }

    override fun getItemCount(): Int {
        return listaJugadores.size
    }

    /*Clase interna que define los compoonentes de la vista*/
    class JugadorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val pais: TextView
        private val jugador: TextView
        private val posicion: TextView

        init {
            pais = itemView.findViewById<View>(R.id.pais) as TextView
            posicion = itemView.findViewById<View>(R.id.posicionJugador) as TextView
            jugador = itemView.findViewById<View>(R.id.nombreJugador) as TextView
        }

        // asignar valores a los componentes
        fun bindUser(jugador: Squad, position: Int, listener: OnItemClickListener?) {
            // cargar nombre equipo local
            pais.text = jugador.nationality
            // cargar nombre equipo visitante
            posicion.text = jugador.position
            // cargar resultado
            val pos = position + 1
            this.jugador.text = pos.toString() + ". " + jugador.name + " (" + jugador.dateOfBirth + ")"
            itemView.setOnClickListener {
                // De momento no hacemos nada al pulsar sobre un partido
            }
        }
    }
}