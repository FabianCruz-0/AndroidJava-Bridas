package com.example.bridaje;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Inicio extends AppCompatActivity {
    ImageSlider imageSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        //Cambia el color de la barra del título
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#006600"));
        actionBar.setBackgroundDrawable(colorDrawable);

        imageSlider = findViewById(R.id.image_slider);
        ArrayList<SlideModel> images = new ArrayList<>();
        images.add(new SlideModel(R.drawable.tabla150, null));
        images.add(new SlideModel(R.drawable.tabla300, null));
        imageSlider.setImageList(images, ScaleTypes.CENTER_CROP);
        //Inicializar y asignar la variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        //Establecer inicio seleccionado
        bottomNavigationView.setSelectedItemId(R.id.inicio);
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
                        return true;
                    case R.id.ajustes:
                        startActivity(new Intent(getApplicationContext(), Ajustes.class));
                        overridePendingTransition(0, 0);
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