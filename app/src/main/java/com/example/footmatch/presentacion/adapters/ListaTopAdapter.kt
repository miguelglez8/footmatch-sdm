package com.example.footmatch.presentacion.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.footmatch.R
import com.example.footmatch.datos.modelos.goleadores.Scorer
import com.example.footmatch.datos.images.SvgLoader.Companion.loadUrl
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class ListaTopAdapter(
    private var scorerList: List<Scorer> = emptyList(),
    private val param: String = "Goles"
) : RecyclerView.Adapter<ListaTopAdapter.ScorerViewHolder>() {

    class ScorerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val playerName: TextView
        private val teamName: TextView
        private val teamLogo: ImageView
        private val icono: ImageView
        private val goalsCount: TextView
        private val matchesPlayed: TextView

        init {
            icono = itemView.findViewById(R.id.newImageView)
            playerName = itemView.findViewById(R.id.playerNameTextView)
            teamName = itemView.findViewById(R.id.teamNameTextView)
            teamLogo = itemView.findViewById(R.id.teamLogoImageView)
            goalsCount = itemView.findViewById(R.id.goalsCountTextView)
            matchesPlayed = itemView.findViewById(R.id.matchesPlayedTextView)
        }

        fun bindScorer(scorer: Scorer, param: String) {
            playerName.text = scorer.player.name
            teamName.text = scorer.team.shortName

            if (scorer.team.crest == null) {
                // cargar imagen visitante por defecto
                teamLogo.load(R.string.teamDefaultLogo.toString())
            } else {
                val isSvg = scorer.team.crest.endsWith("svg", ignoreCase = true)
                if (isSvg) {
                    teamLogo.loadUrl(scorer.team.crest)
                } else {
                    teamLogo.load(scorer.team.crest)
                }
            }

            if (param == "Goles") {
                goalsCount.text = "$param: ${scorer.goals} (${
                    (scorer.goals.toDouble() / scorer.playedMatches).format(2)
                })"
            } else if (param == "Asistencias") {
                goalsCount.text = "$param: ${scorer.assists}"
            } else {
                goalsCount.text = "$param: ${scorer.penalties}"
            }
            matchesPlayed.text = scorer.playedMatches.toString() + " partidos"

            itemView.setOnClickListener {

            }
        }

        fun calcularEdad(fechaNacimiento: String): Int {
            try {
                val formato = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                val fechaNac: Date = formato.parse(fechaNacimiento)!!

                val calendarNac = Calendar.getInstance()
                val calendarHoy = Calendar.getInstance()

                calendarNac.time = fechaNac
                val edad = calendarHoy.get(Calendar.YEAR) - calendarNac.get(Calendar.YEAR)

                if (calendarHoy.get(Calendar.DAY_OF_YEAR) < calendarNac.get(Calendar.DAY_OF_YEAR)) {
                    return edad - 1
                } else {
                    return edad
                }
            } catch (e: Exception) {
                e.printStackTrace()
                return -1 // Manejar la excepción según tus necesidades
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun update(scorerList: List<Scorer>) {
        this.scorerList = scorerList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScorerViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.linear_scorer_liga, parent, false)
        return ScorerViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ScorerViewHolder, position: Int) {
        val scorer = scorerList[position]
        val param = param
        holder.bindScorer(scorer, param)
    }

    override fun getItemCount(): Int {
        return scorerList.size
    }
}

private fun Double.format(i: Int): String = "%.${i}f".format(this)