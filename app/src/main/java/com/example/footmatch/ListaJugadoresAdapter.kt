package com.example.footmatch

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.footmatch.ListaJugadoresAdapter.JugadorViewHolder
import com.example.footmatch.modelo.pojos.Lineup

class ListaJugadoresAdapter(
    private val listaJugadores: List<Lineup>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<JugadorViewHolder>() {
    // Interfaz para manejar el evento click sobre un elemento
    interface OnItemClickListener {
        fun onItemClick(item: Lineup?)
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
        holder.bindUser(jugador, listener)
    }

    override fun getItemCount(): Int {
        return listaJugadores.size
    }

    /*Clase interna que define los compoonentes de la vista*/
    class JugadorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val dorsal: TextView
        private val jugador: TextView
        private val posicion: TextView

        init {
            dorsal = itemView.findViewById<View>(R.id.textDorsal) as TextView
            posicion = itemView.findViewById<View>(R.id.textPosicion) as TextView
            jugador = itemView.findViewById<View>(R.id.textNombreJugador) as TextView
        }

        // asignar valores a los componentes
        fun bindUser(jugador: Lineup, listener: OnItemClickListener?) {
            // cargar nombre equipo local
            dorsal.text = jugador.shirtNumber.toString()
            // cargar nombre equipo visitante
            posicion.text = jugador.position
            // cargar resultado
            this.jugador.text = jugador.name
            itemView.setOnClickListener {
                // De momento no hacemos nada al pulsar sobre un partido
            }
        }
    }
}