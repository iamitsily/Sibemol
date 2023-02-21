package com.example.sibemol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class registro extends AppCompatActivity {
    EditText nombre, email, pass, confirmPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        getSupportActionBar().hide();
        nombre = (EditText) findViewById(R.id.registroNombre);
        email = (EditText) findViewById(R.id.loginEmail);
        pass = (EditText) findViewById(R.id.loginPass);
        confirmPass = (EditText) findViewById(R.id.registroPassConfirm);
    }
    public void registrar(View view) {
        String nombreString = nombre.getText().toString();
        String emailString = email.getText().toString();
        String passString = pass.getText().toString();
        String passConfirmString = confirmPass.getText().toString();
        if (passString.equals(passConfirmString)) {
            SharedPreferences inicioSesion = getSharedPreferences("login", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = inicioSesion.edit();
            editor.putString("nombre", nombreString);
            editor.putString("email", emailString);
            editor.putString("pass", passString);
            editor.commit();
            Toast.makeText(this, "Registrado", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, nombreString + " " + emailString + " " + passString, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, index.class);
            intent.putExtra("nombre", nombreString);
            startActivity(intent);
        } else {
            Toast.makeText(this, "La contraseña no coincide", Toast.LENGTH_SHORT).show();
        }

    }
}