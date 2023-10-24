package com.example.footmatch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.footmatch.modelo.Liga;
import com.example.footmatch.modelo.Partido;
import com.squareup.picasso.Picasso;

public class ClasificacionActivity extends AppCompatActivity {

    Liga liga ;
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
        Picasso.get()
                .load(liga.getUrlLogoLiga()).into(logoLiga);

        clasificacionView = (RecyclerView)findViewById(R.id.recyclerClasificacion);
        clasificacionView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        clasificacionView.setLayoutManager(layoutManager);

        ClasificacionAdapter lpAdapter = new ClasificacionAdapter(liga.getEquipos(),
                new ClasificacionAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(Partido partido) {
                        /*clickonItem(partido);*/
                    }
                });
        clasificacionView.setAdapter(lpAdapter);
    }
}