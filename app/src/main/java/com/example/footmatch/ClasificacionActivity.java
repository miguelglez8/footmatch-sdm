package com.example.footmatch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.footmatch.modelo.Liga;

public class ClasificacionActivity extends AppCompatActivity {

    Liga liga ;
    RecyclerView clasificacionView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clasificacion);

        Intent clasificacionIntent = getIntent();
        liga = clasificacionIntent.getParcelableExtra(MainRecycler.LIGA_CREADA);

        clasificacionView = (RecyclerView)findViewById(R.id.recyclerClasificacion);
        clasificacionView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        clasificacionView.setLayoutManager(layoutManager);


    }
}