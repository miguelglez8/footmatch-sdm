package com.example.footmatch

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.footmatch.ListaEventosAdapter.EventoViewHolder
import com.example.footmatch.modelo.eventos.Evento
import com.squareup.picasso.Picasso

class ListaEventosAdapter(
    private val listaEventos: List<Evento>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<EventoViewHolder>() {
    // Interfaz para manejar el evento click sobre un elemento
    interface OnItemClickListener {
        fun onItemClick(item: Evento?)
    }

    override fun getItemViewType(position: Int): Int {
        // Devuelve el tipo de vista en función de si es local o no
        return if (listaEventos[position].isLocal) {
            TIPO_LOCAL
        } else {
            TIPO_VISITANTE
        }
    }

    /* Indicamos el layout a "inflar" para usar en la vista */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventoViewHolder {
        // Creamos la vista con el layout para un elemento
        // se debe de añadir la de local o la de visitante
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            TIPO_LOCAL -> {
                val tipoAView = inflater.inflate(R.layout.item_evento_local, parent, false)
                EventoViewHolder(tipoAView)
            }

            else -> {
                val tipoBView = inflater.inflate(R.layout.item_evento_visitante, parent, false)
                EventoViewHolder(tipoBView)
            }

        }
    }

    /** Asocia el contenido a los componentes de la vista,
     * concretamente con nuestro EventoViewHolder que recibimos como parámetro
     */
    override fun onBindViewHolder(holder: EventoViewHolder, position: Int) {
        // Extrae de la lista el elemento indicado por posición
        val evento = listaEventos[position]
        Log.i("Lista", "Visualiza elemento: $evento")
        // llama al método de nuestro holder para asignar valores a los componentes
        // además, pasamos el listener del evento onClick
        holder.bindEvento(evento, listener)
    }

    override fun getItemCount(): Int {
        return listaEventos.size
    }

    /* Clase interna que define los componentes de la vista */
    class EventoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val primerFactor: TextView
        private val segundoFactor: TextView
        private val icono1: ImageView
        private val icono2: ImageView
        private val minutoEvento: TextView

        init {
            primerFactor = itemView.findViewById(R.id.primer_factor)
            segundoFactor = itemView.findViewById(R.id.segundo_factor)
            icono1 = itemView.findViewById(R.id.icono1)
            icono2 = itemView.findViewById(R.id.icono2)
            minutoEvento = itemView.findViewById(R.id.minuto_evento)
        }

        // Asignar valores a los componentes
        fun bindEvento(evento: Evento, listener: OnItemClickListener) {
            primerFactor.text = evento.primerFactor
            segundoFactor.text = evento.segundoFactor
            minutoEvento.text = evento.minuto
            Picasso.get().load(evento.primerUrl).into(icono1)
            Picasso.get().load(evento.segundoUrl).into(icono2)
            itemView.setOnClickListener {
                Log.i("Evento", "Click en evento")
                listener.onItemClick(evento)
            }
        }
    }

    companion object {
        private const val TIPO_LOCAL = 0
        private const val TIPO_VISITANTE = 1
    }
}