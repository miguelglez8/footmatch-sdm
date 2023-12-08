package com.example.footmatch

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load


import com.example.footmatch.ListaPartidosAdapter.PartidoViewHolder
import com.example.footmatch.modelo.BuscadorId
import com.example.footmatch.modelo.pojos.partido.Match
// Importamos la clase SvgLoader
import com.example.footmatch.util.images.SvgLoader.Companion.loadUrl
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

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
        private val estado:TextView

        init {
            logoLocal = itemView.findViewById<View>(R.id.equipoLocalImageView) as ImageView
            nombreLocal = itemView.findViewById<View>(R.id.equipoLocalNombreTextView) as TextView
            logoVisitante = itemView.findViewById<View>(R.id.equipoVisitanteImageView) as ImageView
            nombreVisitante =
                itemView.findViewById<View>(R.id.equipoVisitanteNombreTextView) as TextView
            resultadoLocal = itemView.findViewById<View>(R.id.localTextView) as TextView
            resultadoVisitante = itemView.findViewById<View>(R.id.visitanteTextView) as TextView
            fecha = itemView.findViewById<View>(R.id.fechaTextView) as TextView
            estado = itemView.findViewById<View>(R.id.estadoTextView) as TextView
        }

        // asignar valores a los componentes
        fun bindUser(match: Match, listener: (Match) -> Unit) {
            // Si no encontramos el escudo del equipo local, ponemos uno por defecto
            if (match.homeTeam.crest == null) {
                // cargar imagen local por defecto
                logoLocal.load(R.string.teamDefaultLogo.toString())
            }else{
                // Comprobamos si se trata de un png o svg
                val isSvg = match.homeTeam.crest.endsWith("svg",ignoreCase = true)
                // Si es svg procedemos a cargarlo con coil
                if (isSvg){
                   logoLocal.loadUrl(match.homeTeam.crest)
                }else{
                    // cargamos la imagen png con coil
                   logoLocal.load(match.homeTeam.crest)
                }
            }
            if (match.awayTeam.crest == null) {
                // cargar imagen visitante por defecto
                logoVisitante.load(R.string.teamDefaultLogo.toString())
            }else{
                val isSvg = match.awayTeam.crest.endsWith("svg",ignoreCase = true)
                if (isSvg){
                    logoVisitante.loadUrl(match.awayTeam.crest)
                }else{
                    logoVisitante.load(match.awayTeam.crest)
                }
            }


            // cargar nombre equipo local
            nombreLocal.text = match.homeTeam.shortName
            // cargar nombre equipo visitante
            nombreVisitante.text = match.awayTeam.shortName
            // cargar resultado
            if (match.score.winner != null) {
                resultadoLocal.text = match.score.fullTime.home.toString() + " "
                resultadoVisitante.text = " " + match.score.fullTime.away.toString()
            } else {
                resultadoLocal.text = ""
                resultadoVisitante.text = ""
            }
            // cargar fecha partido
            fecha.text = formatDate(match.utcDate)

            // cargar estado del partido
            // si el estado es IN_PLAY, el partido está en juego
            // si el estado es FINISHED, el partido ha finalizado
            // en cualquier otro caso el partido está programado
            when (match.status){
                "IN_PLAY", "LIVE", "PAUSED" -> {
                    estado.text = "EN JUEGO"
                    estado.setBackgroundColor(Color.parseColor("#006400"))
                }
                "FINISHED" -> {
                    estado.text = "FINALIZADO"
                    estado.setBackgroundColor(Color.parseColor("#F80000"))
                }
                else -> {
                    if (match.score.winner != null) {
                        estado.text = "APLAZADO"
                        estado.setBackgroundColor(Color.parseColor("#E2BA1F"))
                    } else {
                        estado.text = "PROGRAMADO"
                        estado.setBackgroundColor(Color.parseColor("#9B9B9B"))
                    }
                }
            }

            itemView.setOnClickListener {
                mostrarPartido(match)
            }

        }
        private fun mostrarPartido(match: Match) {
            // Verificar que el contexto sea el esperado
            val contexto: Context = itemView.context

            // Crear el intent para iniciar la actividad MostrarPartido
            val partidoIntent = Intent(contexto, MostrarPartido::class.java)

            // Pasar los datos necesarios a través de Intent
            partidoIntent.putExtra(MainRecycler.PARTIDO_SELECCIONADO, BuscadorId(match.id, match.utcDate,
                match.homeTeam.id, match.awayTeam.id))

            // Iniciar la actividad
            contexto.startActivity(partidoIntent)
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
        private fun formatDate(utcDate: String): String? {
            // Formato de entrada: "yyyy-MM-ddTHH:mm:ss"
            val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())

            // Formato de salida: "dd-MM-yyyy HH:mm"
            val outputFormat = SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.getDefault())

            try {
                val date = inputFormat.parse(utcDate)

                val calendar = Calendar.getInstance()
                date?.let { calendar.time = it }
                calendar.add(Calendar.HOUR_OF_DAY, 1)

                return date?.let { outputFormat.format(calendar.time) }
            } catch (e: ParseException) {
                e.printStackTrace()
                // Manejar la excepción según tus necesidades
                return "Formato de fecha no válido"
            }
        }
    }
}