package com.example.footmatch.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.example.footmatch.modelo.Equipo;
import com.example.footmatch.modelo.Estadisticas;
import com.example.footmatch.modelo.EstadisticasPartido;
import com.example.footmatch.R;

//Vamos a heredar de la clase Fragment
public class EstadisticasFragment extends Fragment {

    /* Las variables que utilizaremos */
    private static final String EQUIPO1="Equipo_local";
    private static final String EQUIPO2="Equipo_visitante";
    private static final String ESTADISTICAS_1="Estadisticas_generales1";
    private static final String ESTADISTICAS_2="Estadisticas_generales2";
    private static final String ESTADISTICAS_RACHA1 = "Estadisticas_racha1";
    private static final String ESTADISTICAS_RACHA2 = "Estadisticas_racha2";
    private Equipo equipo1;
    private Equipo equipo2;
    private EstadisticasPartido stats1;
    private EstadisticasPartido stats2;
    private Estadisticas s1;
    private Estadisticas s2;

    /*
        Esto es un FactoryMethod.
        Los datos están siendo enviados ANTES del onCreate.
        El Bundle permanece cuando se tiene que recrear.
     */
    public static EstadisticasFragment newInstance(Equipo e1, Equipo e2, EstadisticasPartido s1, EstadisticasPartido s2,
                                                   Estadisticas ee1, Estadisticas ee2) {
        EstadisticasFragment fragment = new EstadisticasFragment();
        Bundle args = new Bundle();
        //Esto no tiene mucha ciencia -> Clave, valor.
        args.putParcelable(EQUIPO1, e1);
        args.putParcelable(EQUIPO2, e2);
        args.putParcelable(ESTADISTICAS_1, s1);
        args.putParcelable(ESTADISTICAS_2, s2);
        args.putParcelable(ESTADISTICAS_RACHA1, ee1);
        args.putParcelable(ESTADISTICAS_RACHA2, ee2);
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
            stats1 = getArguments().getParcelable(ESTADISTICAS_1);
            stats2 = getArguments().getParcelable(ESTADISTICAS_2);
            s1 = getArguments().getParcelable(ESTADISTICAS_RACHA1);
            s2 = getArguments().getParcelable(ESTADISTICAS_RACHA2);
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

        // estadísticas del partido
        TextView corners1 = root.findViewById(R.id.corners1);
        TextView corners2 = root.findViewById(R.id.corners2);

        TextView goalKicks1 = root.findViewById(R.id.goalKicks1);
        TextView goalKicks2 = root.findViewById(R.id.goalKicks2);

        TextView offsides1 = root.findViewById(R.id.offsides1);
        TextView offsides2 = root.findViewById(R.id.offsides2);

        TextView fouls1 = root.findViewById(R.id.fouls1);
        TextView fouls2 = root.findViewById(R.id.fouls2);

        TextView ballPossession1 = root.findViewById(R.id.ballPossession1);
        TextView ballPossession2 = root.findViewById(R.id.ballPossession2);

        TextView saves1 = root.findViewById(R.id.saves1);
        TextView saves2 = root.findViewById(R.id.saves2);

        TextView throwIns1 = root.findViewById(R.id.throwIns1);
        TextView throwIns2 = root.findViewById(R.id.throwIns2);

        TextView shots1 = root.findViewById(R.id.shots1);
        TextView shots2 = root.findViewById(R.id.shots2);

        TextView shotsOnGoal1 = root.findViewById(R.id.shotsOnGoal1);
        TextView shotsOnGoal2 = root.findViewById(R.id.shotsOnGoal2);

        TextView yellowCards1 = root.findViewById(R.id.yellowCards1);
        TextView yellowCards2 = root.findViewById(R.id.yellowCards2);

        TextView redCards1 = root.findViewById(R.id.redCards1);
        TextView redCards2 = root.findViewById(R.id.redCards2);

        // Asignar valores
        team1.setText(equipo1.getNombre());
        team2.setText(equipo2.getNombre());
        nvictorias1.setText(s1.getVictorias());
        nvictorias2.setText(s2.getVictorias());
        nempates1.setText(s1.getEmpates());
        nempates2.setText(s2.getEmpates());
        nderrotas1.setText(s1.getDerrotas());
        nderrotas2.setText(s2.getDerrotas());

        if (stats1.getEstadisticas().size()>0 && stats2.getEstadisticas().size()>0) {
            corners1.setText(stats1.getEstadisticas().get(0));
            corners2.setText(stats2.getEstadisticas().get(0));

            goalKicks1.setText(stats1.getEstadisticas().get(1));
            goalKicks2.setText(stats2.getEstadisticas().get(1));

            offsides1.setText(stats1.getEstadisticas().get(2));
            offsides2.setText(stats2.getEstadisticas().get(2));

            fouls1.setText(stats1.getEstadisticas().get(3));
            fouls2.setText(stats2.getEstadisticas().get(3));

            ballPossession1.setText(stats1.getEstadisticas().get(4));
            ballPossession2.setText(stats2.getEstadisticas().get(4));

            saves1.setText(stats1.getEstadisticas().get(5));
            saves2.setText(stats2.getEstadisticas().get(5));

            throwIns1.setText(stats1.getEstadisticas().get(6));
            throwIns2.setText(stats2.getEstadisticas().get(6));

            shots1.setText(stats1.getEstadisticas().get(7));
            shots2.setText(stats2.getEstadisticas().get(7));

            shotsOnGoal1.setText(stats1.getEstadisticas().get(8));
            shotsOnGoal2.setText(stats2.getEstadisticas().get(8));

            yellowCards1.setText(stats1.getEstadisticas().get(9));
            yellowCards2.setText(stats2.getEstadisticas().get(9));

            redCards1.setText(stats1.getEstadisticas().get(10));
            redCards2.setText(stats2.getEstadisticas().get(10));
        } else {
            LinearLayout linearLayoutEstadisticas = root.findViewById(R.id.linear_layout_estadisticas);

            // Hide the LinearLayout (you can adjust this based on your requirements)
            linearLayoutEstadisticas.setVisibility(View.GONE);
        }

        return root;
    }

}