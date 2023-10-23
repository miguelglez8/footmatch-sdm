package com.example.footmatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.footmatch.modelo.Liga;

public class ClasificacionActivity extends AppCompatActivity {

    Liga liga ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clasificacion);

        Intent clasificacionIntent = getIntent();
        liga = clasificacionIntent.getParcelableExtra(MainRecycler.LIGA_CREADA);

    }
}