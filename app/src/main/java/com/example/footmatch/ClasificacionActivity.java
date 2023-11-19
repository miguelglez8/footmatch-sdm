package com.example.footmatch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.footmatch.modelo.Equipo;
import com.example.footmatch.modelo.Liga;
import com.example.footmatch.modelo.Partido;


import java.util.List;

public class ClasificacionActivity extends AppCompatActivity {

    Liga liga;
    List<Equipo> equipos;
    RecyclerView clasificacionView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clasificacion);

        Intent clasificacionIntent = getIntent();
        liga = clasificacionIntent.getParcelableExtra(MainRecycler.LIGA_CREADA);

        ImageView logoLiga = (ImageView)findViewById(R.id.logoLiga);
        TextView nombreLiga = (TextView)findViewById(R.id.nombreLiga);

        nombreLiga.setText(liga.getName());
        logoLiga.setImageResource(liga.getIdLogoLiga());
        equipos = liga.getEquipos();

        clasificacionView = (RecyclerView)findViewById(R.id.recyclerClasificacion);
        clasificacionView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        clasificacionView.setLayoutManager(layoutManager);

        ClasificacionAdapter lpAdapter = new ClasificacionAdapter(equipos,
                new ClasificacionAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(Equipo equipo) {
                        /*clickonItem(partido);*/
                    }
                });
        clasificacionView.setAdapter(lpAdapter);
    }
}