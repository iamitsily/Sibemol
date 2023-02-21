package com.example.sibemol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText loginEmail, loginPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        loginEmail = (EditText) findViewById(R.id.loginEmail);
        loginPass = (EditText) findViewById(R.id.loginPass);
    }
    public void registro(View view) {
        Intent intent = new Intent(this, registro.class);
        startActivity(intent);
        finish();
    }
    public void inicioSesion(View view) {
        String loginEmailString = loginEmail.getText().toString();
        String loginPassString = loginPass.getText().toString();
        SharedPreferences inicioSesion = getSharedPreferences("login", Context.MODE_PRIVATE);
        String nombre = inicioSesion.getString("nombre", "");
        System.out.println("nombre "+nombre);
        String email = inicioSesion.getString("email", "");
        System.out.println(email);
        String pass = inicioSesion.getString("pass", "");
        System.out.println(pass);
        if (email.length() == 0) {
            Toast.makeText(this, "Ese email no esta registrado", Toast.LENGTH_SHORT).show();
        } else {
            if (loginPassString.equals(pass)) {
                Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show();
                Intent a = new Intent(this, index.class);
                a.putExtra("nombre", nombre);
                startActivity(a);
                finish();
            }
        }
    }
}