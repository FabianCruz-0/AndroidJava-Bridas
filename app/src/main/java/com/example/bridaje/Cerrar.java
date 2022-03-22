package com.example.bridaje;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class Cerrar extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cerrar);

        //Cambia el color de la barra del título
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#006600"));
        actionBar.setBackgroundDrawable(colorDrawable);

        TextView signOut;
        //Inicializar y asignar la variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        //Establecer inicio seleccionado
        bottomNavigationView.setSelectedItemId(R.id.exit);
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
                        startActivity(new Intent(getApplicationContext(), Ajustes.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.exit:
                        return true;
                }
                return false;
            }
        });

        signOut = findViewById(R.id.signOut);

        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(Cerrar.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}