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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Calcula extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcula);

        //Cambia el color de la barra del título
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#006600"));
        actionBar.setBackgroundDrawable(colorDrawable);

        Button calcularBtn = findViewById(R.id.calcularBtn);

        calcularBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText brida = findViewById(R.id.bridaEditText);
                String bridaString = brida.getText().toString().trim();

                EditText empaque = findViewById(R.id.empaqueEditText);
                String empaqueString = empaque.getText().toString().trim();

                EditText diamEXT = findViewById(R.id.diamEXTEditText);
                String diamEXTString = diamEXT.getText().toString().trim();

                EditText basal = findViewById(R.id.basalEditText);
                String basalString = basal.getText().toString().trim();

                EditText barrenos = findViewById(R.id.barrenosEditText);
                String barrenosString = barrenos.getText().toString().trim();

                EditText esparragos = findViewById(R.id.esparragosEditText);
                String esparragosString = esparragos.getText().toString().trim();

                EditText llave = findViewById(R.id.llaveEditText);
                String llaveString = llave.getText().toString().trim();

                if (bridaString.equals("")  || empaqueString.equals("") || diamEXTString.equals("") || basalString.equals("")
                        || barrenosString.equals("") || esparragosString.equals("") || llaveString.equals(""))
                {
                    Toast.makeText(Calcula.this, "INTRODUCIR TODOS LOS CAMPOS.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    TextView res = findViewById(R.id.resTextView);
                    res.setText("RESULTADO:");

                    TextView result = findViewById(R.id.resultTextView);
                    result.setText("Calculando...");

                    Toast.makeText(Calcula.this, "CALCULANDO...", Toast.LENGTH_SHORT).show();
                }
            }
        });



        //Inicializar y asignar la variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        //Establecer inicio seleccionado
        bottomNavigationView.setSelectedItemId(R.id.calcula);
        //Elemento seleccionado
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.calcula:
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
                        startActivity(new Intent(getApplicationContext(), Cerrar.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }
}