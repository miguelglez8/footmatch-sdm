package com.example.footmatch.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.example.footmatch.modelo.Equipo;
import com.example.footmatch.modelo.EstadisticasPartido;
import com.example.footmatch.R;

//Vamos a heredar de la clase Fragment
public class EstadisticasFragment extends Fragment {

    /* Las variables que utilizaremos */
    private static final String EQUIPO1="Equipo_local";
    private static final String EQUIPO2="Equipo_visitante";

    private static final String ESTADISTICAS="Estadisticas_generales";

    private Equipo equipo1;
    private Equipo equipo2;
    private EstadisticasPartido stats;

    /*
        Esto es un FactoryMethod.
        Los datos están siendo enviados ANTES del onCreate.
        El Bundle permanece cuando se tiene que recrear.
     */
    public static EstadisticasFragment newInstance(Equipo e1, Equipo e2, EstadisticasPartido s) {
        EstadisticasFragment fragment = new EstadisticasFragment();
        Bundle args = new Bundle();
        //Esto no tiene mucha ciencia -> Clave, valor.
        args.putParcelable(EQUIPO1, e1);
        args.putParcelable(EQUIPO2, e2);
        args.putParcelable(ESTADISTICAS, s);
        fragment.setArguments(args);
        return fragment;
    }

    /*
        Aquí están disponibles ya los datos necesarios.
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            equipo1 = getArguments().getParcelable(EQUIPO1);
            equipo2 = getArguments().getParcelable(EQUIPO2);
            stats = getArguments().getParcelable(ESTADISTICAS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Mostramos el fragmento en el contenedor
        View root = inflater.inflate(R.layout.fragment_estadisticas, container, false);

        TextView team1 = root.findViewById(R.id.team1);
        TextView team2 = root.findViewById(R.id.team2);
        TextView nvictorias1 = root.findViewById(R.id.nvictorias1);
        TextView nvictorias2 = root.findViewById(R.id.nvictorias2);
        TextView nempates1 = root.findViewById(R.id.nempates1);
        TextView nempates2 = root.findViewById(R.id.nempates2);
        TextView nderrotas1 = root.findViewById(R.id.nderrotas1);
        TextView nderrotas2 = root.findViewById(R.id.nderrotas2);
        TextView valorGoles = root.findViewById(R.id.valorGoles);
        TextView valorTiros = root.findViewById(R.id.valorTiros);
        TextView valorPosesion = root.findViewById(R.id.valorPosesion);

        // Asignar valores
        team1.setText(equipo1.getNombre());
        team2.setText(equipo2.getNombre());
        nvictorias1.setText(equipo1.getEstadisticas().getVictorias());
        nvictorias2.setText(equipo2.getEstadisticas().getVictorias());
        nempates1.setText(equipo1.getEstadisticas().getEmpates());
        nempates2.setText(equipo2.getEstadisticas().getEmpates());
        nderrotas1.setText(equipo1.getEstadisticas().getDerrotas());
        nderrotas2.setText(equipo2.getEstadisticas().getDerrotas());

        if (stats.getEstadisticas().size()>0) {
            valorGoles.setText(stats.getEstadisticas().get(0));
            valorTiros.setText(stats.getEstadisticas().get(1));
            valorPosesion.setText(stats.getEstadisticas().get(2));
        } else {
            LinearLayout linearLayoutEstadisticas = root.findViewById(R.id.linear_layout_estadisticas);

            // Hide the LinearLayout (you can adjust this based on your requirements)
            linearLayoutEstadisticas.setVisibility(View.GONE);
        }

        return root;
    }

}