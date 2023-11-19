package com.example.footmatch

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.footmatch.ListaArbitrosAdapter.ArbitroViewHolder
import com.example.footmatch.modelo.pojos.Referee

class ListaArbitrosAdapter(
    private val listaArbitros: List<Referee>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<ArbitroViewHolder>() {
    // Interfaz para manejar el evento click sobre un elemento
    interface OnItemClickListener {
        fun onItemClick(item: Referee?)
    }

    /* Indicamos el layout a "inflar" para usar en la vista
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArbitroViewHolder {
        // Creamos la vista con el layout para un elemento
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_arbitros, parent, false)
        return ArbitroViewHolder(itemView)
    }

    /** Asocia el contenido a los componentes de la vista,
     * concretamente con nuestro PeliculaViewHolder que recibimos como parámetro
     */
    override fun onBindViewHolder(holder: ArbitroViewHolder, position: Int) {
        // Extrae de la lista el elemento indicado por posición
        val arbitro = listaArbitros[position]
        Log.i("Lista", "Visualiza elemento: $arbitro")
        // llama al método de nuestro holder para asignar valores a los componentes
        // además, pasamos el listener del evento onClick
        holder.bindUser(arbitro, listener)
    }

    override fun getItemCount(): Int {
        return listaArbitros.size
    }

    /*Clase interna que define los compoonentes de la vista*/
    class ArbitroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val funcion: TextView
        private val arbitro: TextView

        init {
            funcion = itemView.findViewById<View>(R.id.tvFunction) as TextView
            arbitro = itemView.findViewById<View>(R.id.tvArbitroName) as TextView
        }

        // asignar valores a los componentes
        fun bindUser(arbitro: Referee, listener: OnItemClickListener) {
            this.funcion.text = arbitro.type
            this.arbitro.text = arbitro.name
            itemView.setOnClickListener {
                Log.i("Hola", "Hola")
                listener.onItemClick(arbitro)
            }
        }
    }
}