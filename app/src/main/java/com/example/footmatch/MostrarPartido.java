package com.example.footmatch;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.footmatch.modelo.Partido;
import com.example.footmatch.ui.AlineacionesFragment;
import com.example.footmatch.ui.ArbitrosFragment;
import com.example.footmatch.ui.EstadisticasFragment;
import com.example.footmatch.ui.EventosFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MostrarPartido extends AppCompatActivity {
    private Partido partido;
    TextView textView;
    ImageView imagenLiga, imagenEquipo1, imagenEquipo2;
    TextView nombreEquipo1, resultadoPartido, fechaPartido, nombreEquipo2, estadio;
    Button estadoPartido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_match);

        // Obtener datos del intent
        Intent intentMatch = getIntent();
        partido = intentMatch.getParcelableExtra(MainRecycler.PARTIDO_SELECCIONADO);

        // Inicializar vistas
        textView = findViewById(R.id.liga_jornada);
        imagenLiga = findViewById(R.id.imagenLiga);
        imagenEquipo1 = findViewById(R.id.imagenEquipo1);
        nombreEquipo1 = findViewById(R.id.nombreEquipo1);
        resultadoPartido = findViewById(R.id.resultadoPartido);
        fechaPartido = findViewById(R.id.fechaPartido);
        imagenEquipo2 = findViewById(R.id.imagenEquipo2);
        nombreEquipo2 = findViewById(R.id.nombreEquipo2);
        estadio = findViewById(R.id.estadio);
        estadoPartido = findViewById(R.id.estadoPartido);
        estadoPartido.setEnabled(false);

        // Cargar datos del partido en las vistas
        mostrarDatos(partido);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        /* Cuando se selecciona uno de los botones / ítems*/
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            if (partido == null)
                return false;

            int itemId = item.getItemId();

            /* Según el caso, crearemos un Fragmento u otro */
            if (itemId == R.id.navigation_estadisticas)
            {
                /* Haciendo uso del FactoryMethod pasándole todos los parámetros necesarios */

                /* Argumento solamente necesita.... El argumento de la película */

                EstadisticasFragment estadisticasFragment=EstadisticasFragment.newInstance
                        (partido.getEstadisticas());

                /* ¿Qué estaremos haciendo aquí? */
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, estadisticasFragment).commit();

                return true;
            }

            if (itemId == R.id.navigation_eventos)
            {
                EventosFragment eventosFragment=EventosFragment.newInstance
                        (pelicula.getEventos());

                /* ¿Qué estaremos haciendo aquí? */
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, eventosFragment).commit();

                return true;
            }

            if (itemId == R.id.navigation_arbitros)
            {
                ArbitrosFragment arbitrosFragment= ArbitrosFragment.newInstance
                        (partido.getArbitros());

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, arbitrosFragment).commit();

                return true;
            }

            if (itemId == R.id.navigation_alineaciones)
            {
                AlineacionesFragment alineacionesFragment= AlineacionesFragment.newInstance
                        (partido.getAlineaciones());

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, alineacionesFragment).commit();

                return true;
            }

            //Si no es nula y no entra... Algo falla.
            throw new IllegalStateException("Unexpected value: " + item.getItemId());
        };
    };

    // Cargar los datos del partido en las vistas
    public void mostrarDatos(Partido partido) {
        if (partido != null) {
            // Actualizar componentes con valores del partido específico
            textView.setText(partido.getNombreLiga());

            nombreEquipo1.setText(partido.getEquipoLocal().getNombre());
            resultadoPartido.setText(partido.getResultado());
            fechaPartido.setText(partido.getFecha());

            nombreEquipo2.setText(partido.getEquipoVisitante().getNombre());
            estadio.setText(partido.getEstadio());
            estadoPartido.setText(partido.getEstado());

            // cargar imgs equipos y liga
        }
    }
}
