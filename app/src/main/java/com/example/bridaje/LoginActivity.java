package com.example.bridaje;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Cambia el color de la barra del título
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#006600"));
        actionBar.setBackgroundDrawable(colorDrawable);

        auth = FirebaseAuth.getInstance();

        Button signIn = findViewById(R.id.signInBtn);
        Button signUp = findViewById(R.id.signUpBtn);
        TextView resetPassText = findViewById(R.id.resetPassTextView);

        signIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText email = findViewById(R.id.emailEditText);
                String stringEmail = email.getText().toString().trim();
                EditText pass = findViewById(R.id.passEditText);
                String stringPass = pass.getText().toString().trim();

                if (stringEmail.equals("") || stringPass.equals("")) {
                    Toast.makeText(getApplicationContext(), "FAVOR DE INTRODUCIR CAMPOS VÁLIDOS.", Toast.LENGTH_SHORT).show();
                } else {
                    auth.signInWithEmailAndPassword(stringEmail, stringPass).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                //entro
                                Intent intent = new Intent(LoginActivity.this, Inicio.class);
                                startActivity(intent);
                                finish();
                            } else {
                                //algo fallo
                                Toast.makeText(LoginActivity.this, "Usuario o contraseña incorrectos.", Toast.LENGTH_SHORT).show();
                                System.out.println(task.getException());
                            }
                        }
                    });
                }
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

        resetPassText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, ResetPasswordActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null)
        FirebaseUser currentUser = auth.getCurrentUser();
        if (currentUser != null) {
            //hay sesión
            Intent intent = new Intent(LoginActivity.this, Inicio.class);
            startActivity(intent);
            finish();
        }
    }
}