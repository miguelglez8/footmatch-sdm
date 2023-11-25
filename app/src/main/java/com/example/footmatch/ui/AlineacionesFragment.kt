package com.example.footmatch.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.footmatch.ListaJugadoresAdapter
import com.example.footmatch.R
import com.example.footmatch.modelo.pojos.partido.MatchToShow
import com.example.footmatch.modelo.pojos.partido.Squad
import com.example.footmatch.modelo.pojos.partido.TeamX
import com.example.footmatch.util.images.SvgLoader.Companion.loadUrl

class AlineacionesFragment : Fragment() {
    private var jugadoresEquipo1: TeamX? = null
    private var jugadoresEquipo2: TeamX? = null
    private var partido: MatchToShow? = null
    private var recyclerViewJugadoresEquipo1: RecyclerView? = null
    private var recyclerViewJugadoresEquipo2: RecyclerView? = null
    private var nombreEquipo1: TextView? = null
    private var nombreEquipo2: TextView? = null
    private var trainer1: TextView? = null
    private var trainer2: TextView? = null
    private var plantilla1: TextView? = null
    private var plantilla2: TextView? = null
    private var imagenEquipo1: ImageView? = null
    private var imagenEquipo2: ImageView? = null
    private var adapterEquipo1: ListaJugadoresAdapter? = null
    private var adapterEquipo2: ListaJugadoresAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            jugadoresEquipo1 = requireArguments().getSerializable(JUGADORES_EQUIPO1) as TeamX?
            jugadoresEquipo2 = requireArguments().getSerializable(JUGADORES_EQUIPO2) as TeamX?
            partido = requireArguments().getSerializable(PARTIDO) as MatchToShow
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_alineaciones, container, false)
        recyclerViewJugadoresEquipo1 = root.findViewById(R.id.recyclerViewJugadoresEquipo1)
        recyclerViewJugadoresEquipo2 = root.findViewById(R.id.recyclerViewJugadoresEquipo2)
        nombreEquipo1 = root.findViewById(R.id.nombreEquipo1)
        nombreEquipo2 = root.findViewById(R.id.nombreEquipo2)
        plantilla1 = root.findViewById(R.id.platilla1)
        plantilla2 = root.findViewById(R.id.platilla2)
        imagenEquipo1 = root.findViewById(R.id.imagenEquipo1)
        imagenEquipo2 = root.findViewById(R.id.imagenEquipo2)
        trainer1 = root.findViewById(R.id.trainer1)
        trainer2 = root.findViewById(R.id.trainer2)
        cargarDatos()
        return root
    }

    private fun setUpRecyclerView(recyclerView: RecyclerView?, adapter: ListaJugadoresAdapter) {
        // Configura el RecyclerView y su adaptador
        val layoutManager = LinearLayoutManager(context)
        recyclerView!!.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    private fun cargarDatos() {
        // Aquí deberías cargar los datos reales de tus equipos
        nombreEquipo1!!.text = jugadoresEquipo1!!.name
        nombreEquipo2!!.text = jugadoresEquipo2!!.name

        plantilla1?.text = "Plantilla del " + partido?.homeTeam?.name
        plantilla2?.text = "Plantilla del " +  partido?.awayTeam?.name

        trainer1?.text = "Entrenador: " + partido?.homeTeam?.trainer
        trainer2?.text = "Entrenador: " + partido?.awayTeam?.trainer

        if (jugadoresEquipo1!!.crest == null) {
            // cargar imagen local por defecto
            imagenEquipo1?.load(R.string.teamDefaultLogo.toString())
        } else {
            // Comprobamos si se trata de un png o svg
            val isSvg = jugadoresEquipo1!!.crest.endsWith("svg",ignoreCase = true)
            // Si es svg procedemos a cargarlo con coil
            if (isSvg){
                imagenEquipo1?.loadUrl(jugadoresEquipo1!!.crest)
            }else{
                // cargamos la imagen png con coil
                imagenEquipo1?.load(jugadoresEquipo1!!.crest)
            }
        }
        if (jugadoresEquipo2!!.crest == null) {
            // cargar imagen local por defecto
            imagenEquipo2?.load(R.string.teamDefaultLogo.toString())
        } else {
            // Comprobamos si se trata de un png o svg
            val isSvg = jugadoresEquipo2!!.crest.endsWith("svg",ignoreCase = true)
            // Si es svg procedemos a cargarlo con coil
            if (isSvg){
                imagenEquipo2?.loadUrl(jugadoresEquipo2!!.crest)
            }else{
                // cargamos la imagen png con coil
                imagenEquipo2?.load(jugadoresEquipo2!!.crest)
            }
        }
        // Configura los RecyclerViews con los adaptadores
        if (jugadoresEquipo1!!.squad != null && jugadoresEquipo1!!.squad.isNotEmpty()) {
            adapterEquipo1 = ListaJugadoresAdapter(
                jugadoresEquipo1!!.squad,
                object : ListaJugadoresAdapter.OnItemClickListener {
                    override fun onItemClick(item: Squad?) {
                        // Maneja el clic en un elemento de la lista si es necesario
                    }
                })
            setUpRecyclerView(recyclerViewJugadoresEquipo1, adapterEquipo1!!)
        }
        if (jugadoresEquipo2!!.squad != null && jugadoresEquipo2!!.squad.isNotEmpty()) {
            adapterEquipo2 = ListaJugadoresAdapter(
                jugadoresEquipo2!!.squad,
                object : ListaJugadoresAdapter.OnItemClickListener {
                    override fun onItemClick(item: Squad?) {
                        // Maneja el clic en un elemento de la lista si es necesario
                    }
                })
            setUpRecyclerView(recyclerViewJugadoresEquipo2, adapterEquipo2!!)
        }
    }

    companion object {
        private const val JUGADORES_EQUIPO1 = "Equipo1"
        private const val JUGADORES_EQUIPO2 = "Equipo2"
        private const val PARTIDO = "local"

        fun newInstance(
            e1: TeamX,
            e2: TeamX,
            match: MatchToShow,
        ): AlineacionesFragment {
            val fragment = AlineacionesFragment()
            val args = Bundle()
            args.putSerializable(JUGADORES_EQUIPO1, e1)
            args.putSerializable(JUGADORES_EQUIPO2, e2)
            args.putSerializable(PARTIDO, match)
            fragment.arguments = args
            return fragment
        }
    }
}