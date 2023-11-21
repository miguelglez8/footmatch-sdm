package com.example.footmatch.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.footmatch.ListaJugadoresAdapter
import com.example.footmatch.R
import com.example.footmatch.modelo.pojos.AwayTeamX
import com.example.footmatch.modelo.pojos.HomeTeamX
import com.example.footmatch.modelo.pojos.Lineup
import com.example.footmatch.util.images.SvgLoader.Companion.loadUrl
import com.squareup.picasso.Picasso

class AlineacionesFragment : Fragment() {
    private var jugadoresEquipo1: HomeTeamX? = null
    private var jugadoresEquipo2: AwayTeamX? = null
    private var recyclerViewJugadoresEquipo1: RecyclerView? = null
    private var recyclerViewJugadoresEquipo2: RecyclerView? = null
    private var nombreEquipo1: TextView? = null
    private var nombreEquipo2: TextView? = null
    private var entrenadorEquipo1: TextView? = null
    private var entrenadorEquipo2: TextView? = null
    private var formacionEquipo1: TextView? = null
    private var formacionEquipo2: TextView? = null
    private var imagenEquipo1: ImageView? = null
    private var imagenEquipo2: ImageView? = null
    private var adapterEquipo1: ListaJugadoresAdapter? = null
    private var adapterEquipo2: ListaJugadoresAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            jugadoresEquipo1 = requireArguments().getSerializable(JUGADORES_EQUIPO1) as HomeTeamX?
            jugadoresEquipo2 = requireArguments().getSerializable(JUGADORES_EQUIPO2) as AwayTeamX?
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
        entrenadorEquipo1 = root.findViewById(R.id.entrenadorEquipo1)
        entrenadorEquipo2 = root.findViewById(R.id.entrenadorEquipo2)
        formacionEquipo1 = root.findViewById(R.id.formacionEquipo1)
        formacionEquipo2 = root.findViewById(R.id.formacionEquipo2)
        imagenEquipo1 = root.findViewById(R.id.imagenEquipo1)
        imagenEquipo2 = root.findViewById(R.id.imagenEquipo2)

        // Configura los RecyclerViews con los adaptadores
        if (jugadoresEquipo1!!.lineup != null && jugadoresEquipo1!!.lineup.isNotEmpty()) {
            adapterEquipo1 = ListaJugadoresAdapter(
                jugadoresEquipo1!!.lineup,
                object : ListaJugadoresAdapter.OnItemClickListener {
                    override fun onItemClick(item: Lineup?) {
                        // Maneja el clic en un elemento de la lista si es necesario
                    }
                })
            setUpRecyclerView(recyclerViewJugadoresEquipo1, adapterEquipo1!!)
        }
        if (jugadoresEquipo2!!.lineup != null && jugadoresEquipo2!!.lineup.isNotEmpty()) {
            adapterEquipo2 = ListaJugadoresAdapter(
                jugadoresEquipo2!!.lineup,
                object : ListaJugadoresAdapter.OnItemClickListener {
                    override fun onItemClick(item: Lineup?) {
                        // Maneja el clic en un elemento de la lista si es necesario
                    }
                })
            setUpRecyclerView(recyclerViewJugadoresEquipo2, adapterEquipo2!!)
        }
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
        if (jugadoresEquipo1!!.coach==null)
            entrenadorEquipo1!!.text = "Entrenador: No disponible"
        else
            entrenadorEquipo1!!.text = jugadoresEquipo1!!.coach!!.name

        if (jugadoresEquipo2!!.coach==null)
            entrenadorEquipo2!!.text = "Entrenador: No disponible"
        else
            entrenadorEquipo2!!.text = jugadoresEquipo2!!.coach!!.name

        if (jugadoresEquipo1!!.coach==null)
            formacionEquipo1!!.text = "Formación: No disponible"
        else
            formacionEquipo1!!.text = jugadoresEquipo1!!.formation

        if (jugadoresEquipo2!!.coach==null)
            formacionEquipo2!!.text = "Formación: No disponible"
        else
            formacionEquipo2!!.text = jugadoresEquipo2!!.formation

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
    }

    companion object {
        private const val JUGADORES_EQUIPO1 = "Equipo1"
        private const val JUGADORES_EQUIPO2 = "Equipo2"
        fun newInstance(e1: HomeTeamX, e2: AwayTeamX): AlineacionesFragment {
            val fragment = AlineacionesFragment()
            val args = Bundle()
            args.putSerializable(JUGADORES_EQUIPO1, e1)
            args.putSerializable(JUGADORES_EQUIPO2, e2)
            fragment.arguments = args
            return fragment
        }
    }
}