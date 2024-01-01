package com.example.footmatch.presentacion.partido

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.footmatch.R
import com.example.footmatch.datos.modelos.partido.Aggregates
import com.example.footmatch.datos.modelos.partido.AwayTeamX
import com.example.footmatch.datos.modelos.partido.HomeTeamX

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
            stats = requireArguments().getSerializable(STATS) as? Aggregates
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

        // Asignar valores
        team1.text = equipo1!!.shortName
        team2.text = equipo2!!.shortName

        if (stats != null) {
            // Acceder a las propiedades de stats de manera segura
            if (stats!!.homeTeam != null && stats!!.awayTeam != null) {
                nvictorias1.text = stats!!.homeTeam.wins.toString()
                nvictorias2.text = stats!!.awayTeam.wins.toString()
                nempates1.text = stats!!.homeTeam.draws.toString()
                nempates2.text = stats!!.awayTeam.draws.toString()
                nderrotas1.text = stats!!.homeTeam.losses.toString()
                nderrotas2.text = stats!!.awayTeam.losses.toString()
            }
        } else {
            nvictorias1.text = "0"
            nvictorias2.text = "0"
            nempates1.text = "0"
            nempates2.text = "0"
            nderrotas1.text = "0"
            nderrotas2.text = "0"
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