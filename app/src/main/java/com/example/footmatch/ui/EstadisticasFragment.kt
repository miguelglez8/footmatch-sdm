package com.example.footmatch.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.footmatch.R
import com.example.footmatch.modelo.pojos.partido.Aggregates
import com.example.footmatch.modelo.pojos.partido.AwayTeamX
import com.example.footmatch.modelo.pojos.partido.HomeTeamX

//Vamos a heredar de la clase Fragment
class EstadisticasFragment : Fragment() {
    private var equipo1: HomeTeamX? = null
    private var equipo2: AwayTeamX? = null
    private var stats: Aggregates? = null

    /*
        Aquí están disponibles ya los datos necesarios.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            equipo1 = requireArguments().getSerializable(EQUIPO1) as HomeTeamX?
            equipo2 = requireArguments().getSerializable(EQUIPO2) as AwayTeamX
            stats = requireArguments().getSerializable(STATS) as Aggregates
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Mostramos el fragmento en el contenedor
        val root = inflater.inflate(R.layout.fragment_estadisticas, container, false)
        val team1 = root.findViewById<TextView>(R.id.team1)
        val team2 = root.findViewById<TextView>(R.id.team2)
        val nvictorias1 = root.findViewById<TextView>(R.id.nvictorias1)
        val nvictorias2 = root.findViewById<TextView>(R.id.nvictorias2)
        val nempates1 = root.findViewById<TextView>(R.id.nempates1)
        val nempates2 = root.findViewById<TextView>(R.id.nempates2)
        val nderrotas1 = root.findViewById<TextView>(R.id.nderrotas1)
        val nderrotas2 = root.findViewById<TextView>(R.id.nderrotas2)

        // estadísticas del partido
        val corners1 = root.findViewById<TextView>(R.id.corners1)
        val corners2 = root.findViewById<TextView>(R.id.corners2)
        val goalKicks1 = root.findViewById<TextView>(R.id.goalKicks1)
        val goalKicks2 = root.findViewById<TextView>(R.id.goalKicks2)
        val offsides1 = root.findViewById<TextView>(R.id.offsides1)
        val offsides2 = root.findViewById<TextView>(R.id.offsides2)
        val fouls1 = root.findViewById<TextView>(R.id.fouls1)
        val fouls2 = root.findViewById<TextView>(R.id.fouls2)
        val ballPossession1 = root.findViewById<TextView>(R.id.ballPossession1)
        val ballPossession2 = root.findViewById<TextView>(R.id.ballPossession2)
        val saves1 = root.findViewById<TextView>(R.id.saves1)
        val saves2 = root.findViewById<TextView>(R.id.saves2)
        val throwIns1 = root.findViewById<TextView>(R.id.throwIns1)
        val throwIns2 = root.findViewById<TextView>(R.id.throwIns2)
        val shots1 = root.findViewById<TextView>(R.id.shots1)
        val shots2 = root.findViewById<TextView>(R.id.shots2)
        val shotsOnGoal1 = root.findViewById<TextView>(R.id.shotsOnGoal1)
        val shotsOnGoal2 = root.findViewById<TextView>(R.id.shotsOnGoal2)
        val yellowCards1 = root.findViewById<TextView>(R.id.yellowCards1)
        val yellowCards2 = root.findViewById<TextView>(R.id.yellowCards2)
        val redCards1 = root.findViewById<TextView>(R.id.redCards1)
        val redCards2 = root.findViewById<TextView>(R.id.redCards2)

        // Asignar valores
        team1.text = equipo1!!.shortName
        team2.text = equipo2!!.shortName

        if (stats!!.homeTeam != null && stats!!.awayTeam != null) {
            nvictorias1.setText(stats!!.homeTeam.wins.toString())
            nvictorias2.setText(stats!!.awayTeam.wins.toString())
            nempates1.setText(stats!!.homeTeam.draws.toString())
            nempates2.setText(stats!!.awayTeam.draws.toString())
            nderrotas1.setText(stats!!.homeTeam.losses.toString())
            nderrotas2.setText(stats!!.awayTeam.losses.toString())
        }

        if (equipo1!!.statistics != null && equipo2!!.statistics != null) {
            corners1.text = equipo1!!.statistics.cornerKicks.toString()
            corners2.text = equipo2!!.statistics.cornerKicks.toString()
            goalKicks1.text = equipo1!!.statistics.goalKicks.toString()
            goalKicks2.text = equipo2!!.statistics.goalKicks.toString()
            offsides1.text = equipo1!!.statistics.offsides.toString()
            offsides2.text = equipo2!!.statistics.offsides.toString()
            fouls1.text = equipo1!!.statistics.fouls.toString()
            fouls2.text = equipo2!!.statistics.fouls.toString()
            ballPossession1.text = equipo1!!.statistics.ballPossession.toString()
            ballPossession2.text = equipo2!!.statistics.ballPossession.toString()
            saves1.text = equipo1!!.statistics.saves.toString()
            saves2.text = equipo2!!.statistics.saves.toString()
            throwIns1.text = equipo1!!.statistics.throwIns.toString()
            throwIns2.text = equipo2!!.statistics.throwIns.toString()
            shots1.text = equipo1!!.statistics.shots.toString()
            shots2.text = equipo2!!.statistics.shots.toString()
            shotsOnGoal1.text = equipo1!!.statistics.shotsOnGoal.toString()
            shotsOnGoal2.text = equipo2!!.statistics.shotsOnGoal.toString()
            yellowCards1.text = equipo1!!.statistics.yellowCards.toString()
            yellowCards2.text = equipo2!!.statistics.yellowCards.toString()
            redCards1.text = equipo1!!.statistics.redCards.toString()
            redCards2.text = equipo2!!.statistics.redCards.toString()
        } else {
            val linearLayoutEstadisticas =
                root.findViewById<LinearLayout>(R.id.linear_layout_estadisticas)

            // Hide the LinearLayout (you can adjust this based on your requirements)
            linearLayoutEstadisticas.visibility = View.GONE
        }
        return root
    }

    companion object {
        /* Las variables que utilizaremos */
        private const val EQUIPO1 = "Equipo_local"
        private const val EQUIPO2 = "Equipo_visitante"
        private const val STATS = "Stats_equipos"

        /*
        Esto es un FactoryMethod.
        Los datos están siendo enviados ANTES del onCreate.
        El Bundle permanece cuando se tiene que recrear.
     */
        fun newInstance(
            e1: HomeTeamX, e2: AwayTeamX, stats: Aggregates?
        ): EstadisticasFragment {
            val fragment = EstadisticasFragment()
            val args = Bundle()
            //Esto no tiene mucha ciencia -> Clave, valor.
            args.putSerializable(EQUIPO1, e1)
            args.putSerializable(EQUIPO2, e2)
            args.putSerializable(STATS, stats)
            fragment.arguments = args
            return fragment
        }
    }
}