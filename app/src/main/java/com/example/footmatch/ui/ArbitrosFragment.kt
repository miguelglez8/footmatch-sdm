package com.example.footmatch.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.footmatch.ListaArbitrosAdapter
import com.example.footmatch.R
import com.example.footmatch.modelo.pojos.Referee

//Vamos a heredar de la clase Fragment
class ArbitrosFragment : Fragment() {
    /*
        Aquí están disponibles ya los datos necesarios.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            lista = requireArguments().getSerializable(ARBITROS) as ArrayList<Referee>?
        }
    }

    /* Al crear la vista, cargamos los valores necesarios */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_arbitros, container, false)

        // Obten el RecyclerView del diseño del fragmento
        val recyclerView = root.findViewById<RecyclerView>(R.id.reciclerViewArbitros)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager

        // Crea una instancia del adaptador y pásale la lista de intérpretes y un listener si es necesario
        val adapter =
            ListaArbitrosAdapter(lista!!, object : ListaArbitrosAdapter.OnItemClickListener {
                override fun onItemClick(item: Referee?) {
                    // Maneja el clic en un elemento de la lista si es necesario
                }
            })

        // Configura el adaptador en el RecyclerView
        recyclerView.adapter = adapter
        return root
    }

    companion object {
        /* Las variables que utilizaremos */
        private const val ARBITROS = "Arbitros"
        private var lista: ArrayList<Referee>? = null

        /*

        Esto es un FactoryMethod.
        Los datos están siendo enviados ANTES del onCreate.
        El Bundle permanece cuando se tiene que recrear.
     */
        fun newInstance(lista: ArrayList<Referee?>): ArbitrosFragment {
            val fragment = ArbitrosFragment()
            val args = Bundle()
            //Esto no tiene mucha ciencia -> Clave, valor.
            args.putSerializable(ARBITROS, lista)
            fragment.arguments = args
            return fragment
        }
    }
}
