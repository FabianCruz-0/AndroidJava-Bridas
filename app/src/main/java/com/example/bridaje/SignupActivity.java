package com.example.bridaje;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {

    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //Cambia el color de la barra del título
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#006600"));
        actionBar.setBackgroundDrawable(colorDrawable);

        auth = FirebaseAuth.getInstance();

        Button register = findViewById(R.id.RegisterBtn);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = findViewById(R.id.nameEditText).toString().trim();
                EditText email = findViewById(R.id.emailEditText);
                String stringEmail = email.getText().toString().trim();
                EditText pass = findViewById(R.id.passEditText);
                String stringPass = pass.getText().toString().trim();

                auth.createUserWithEmailAndPassword(stringEmail, stringPass)
                        .addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(SignupActivity.this, "Usuario creado.", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(SignupActivity.this, Inicio.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(SignupActivity.this, "Se produjo un error.", Toast.LENGTH_SHORT).show();
                                    System.out.println(task.getException());
                                }
                            }
                        });

            }
        });

    }
}