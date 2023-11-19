package com.example.footmatch.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.footmatch.ListaEventosAdapter
import com.example.footmatch.R
import com.example.footmatch.modelo.eventos.Cambio
import com.example.footmatch.modelo.eventos.Color
import com.example.footmatch.modelo.eventos.Evento
import com.example.footmatch.modelo.eventos.Gol
import com.example.footmatch.modelo.eventos.Penalti
import com.example.footmatch.modelo.eventos.Tarjeta
import com.example.footmatch.modelo.pojos.Booking
import com.example.footmatch.modelo.pojos.Goal
import com.example.footmatch.modelo.pojos.Penalty
import com.example.footmatch.modelo.pojos.Substitution

class EventosFragment : Fragment() {
    private var goals: List<Goal>? = null
    private var penalties: List<Penalty>? = null
    private var bookings: List<Booking>? = null
    private var substitutions: List<Substitution>? = null
    private var local: String? = null
    private var recyclerViewGoles: RecyclerView? = null
    private var recyclerViewTarjetas: RecyclerView? = null
    private var recyclerViewCambios: RecyclerView? = null
    private var adapterGoles: ListaEventosAdapter? = null
    private var adapterTarjetas: ListaEventosAdapter? = null
    private var adapterCambios: ListaEventosAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            goals = requireArguments().getSerializable(GOALS) as List<Goal>
            penalties = requireArguments().getSerializable(PENALTIES) as List<Penalty>
            bookings = requireArguments().getSerializable(BOOKINGS) as List<Booking>
            substitutions = requireArguments().getSerializable(SUBSTITUTIONS) as List<Substitution>
            local = requireArguments().getString(LOCAL)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_eventos, container, false)
        recyclerViewGoles = root.findViewById(R.id.recyclerViewGoles)
        recyclerViewTarjetas = root.findViewById(R.id.recyclerViewTarjetas)
        recyclerViewCambios = root.findViewById(R.id.recyclerViewOtros)

        // Configura los RecyclerViews con los adaptadores
        val goles = mutableListOf<Evento>()
        // Recorrer la lista de substitutions y agregar elementos a la lista de Evento
        for (elem in goals!!) {
            var evento:Evento
            if (elem.type.toString().equals("REGULAR")) {
                evento = Gol(elem.scorer.name, elem.assist.name, elem.minute, elem.team.equals(local))
            } else {
                evento = Penalti(elem.scorer.name, elem.minute, elem.team.equals(local))
            }
            goles.add(evento)
        }
        adapterGoles =
            ListaEventosAdapter(goles!!, object : ListaEventosAdapter.OnItemClickListener {
                override fun onItemClick(item: Evento?) {
                    // Maneja el clic en un elemento de la lista si es necesario
                }
            })
        setUpRecyclerView(recyclerViewGoles, adapterGoles!!)
        // Configura los RecyclerViews con los adaptadores
        val tarjetas = mutableListOf<Evento>()
        // Recorrer la lista de substitutions y agregar elementos a la lista de Evento
        for (elem in bookings!!) {
            val evento = Tarjeta(elem.player.name, elem.minute, elem.team.equals(local),
                if (elem.card.toString().equals("YELLOW")) Color.AMARILLA else Color.ROJA
            )
            tarjetas.add(evento)
        }
        adapterTarjetas =
            ListaEventosAdapter(tarjetas!!, object : ListaEventosAdapter.OnItemClickListener {
                override fun onItemClick(item: Evento?) {
                    // Maneja el clic en un elemento de la lista si es necesario
                }
            })
        setUpRecyclerView(recyclerViewTarjetas, adapterTarjetas!!)
        // Configura los RecyclerViews con los adaptadores
        val cambios = mutableListOf<Evento>()
        // Recorrer la lista de substitutions y agregar elementos a la lista de Evento
        for (elem in substitutions!!) {
            val evento = Cambio(elem.playerOut.name, elem.playerIn.name, elem.minute, elem.team.equals(local))
            cambios.add(evento)
        }
        adapterCambios =
            ListaEventosAdapter(cambios, object : ListaEventosAdapter.OnItemClickListener {
                override fun onItemClick(item: Evento?) {
                    // Maneja el clic en un elemento de la lista si es necesario
                }
            })
        setUpRecyclerView(recyclerViewCambios, adapterCambios!!)
        return root
    }

    private fun setUpRecyclerView(recyclerView: RecyclerView?, adapter: ListaEventosAdapter) {
        // Configura el RecyclerView y su adaptador
        val layoutManager = LinearLayoutManager(context)
        recyclerView!!.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    companion object {
        private const val GOALS = "GOALS"
        private const val PENALTIES = "PENALTIES"
        private const val BOOKINGS = "BOOKINGS"
        private const val SUBSTITUTIONS = "SUBSTITUTIONS"
        private const val LOCAL = "LOCAL"

        fun newInstance(
            goals: List<Goal>,
            penalties: List<Penalty>,
            bookings: List<Booking>,
            substitutions: List<Substitution>,
            localTeam: String
        ): EventosFragment {
            val fragment = EventosFragment()
            val args = Bundle()
            args.putSerializable(GOALS, ArrayList(goals))
            args.putSerializable(PENALTIES, ArrayList(penalties))
            args.putSerializable(BOOKINGS, ArrayList(bookings))
            args.putSerializable(SUBSTITUTIONS, ArrayList(substitutions))
            args.putString(LOCAL, localTeam)
            fragment.arguments = args
            return fragment
        }

    }
}
