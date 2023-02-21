package com.example.sibemol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class index extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        getSupportActionBar().hide();

    }
    public void reproductor(View view){
//        listaMusica.add(new Musica(5,1,"Feel Good","Gorillaz",R.mipmap.clinteastwood));
        Intent intent = new Intent(this,reproductorCanciones.class);
        intent.putExtra("id",5);
        intent.putExtra("nombre","Feel Good");
        intent.putExtra("artista","Gorillaz");
        intent.putExtra("img",R.mipmap.clinteastwood);
        startActivity(intent);
    }
    public void listaMusica(View view){
        Intent intent = new Intent(this,listaCanciones.class);
        startActivity(intent);
    }
    public void acercaDe(View view){
        Intent intent = new Intent(this,acercaDe.class);
        startActivity(intent);
    }
    public void playlist(View view){
        Intent intent = new Intent(this,album.class);
        startActivity(intent);
    }

}