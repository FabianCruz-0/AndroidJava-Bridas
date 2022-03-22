package com.example.bridaje;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Ajustes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);

        //Cambia el color de la barra del título
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#006600"));
        actionBar.setBackgroundDrawable(colorDrawable);

        //Inicializar y asignar la variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        //Establecer inicio seleccionado
        bottomNavigationView.setSelectedItemId(R.id.ajustes);
        //Elemento seleccionado
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.calcula:
                        startActivity(new Intent(getApplicationContext(), Calcula.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.inicio:
                        startActivity(new Intent(getApplicationContext(), Inicio.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.ajustes:
                        return true;
                    case R.id.exit:
                        startActivity(new Intent(getApplicationContext(), Cerrar.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }
}