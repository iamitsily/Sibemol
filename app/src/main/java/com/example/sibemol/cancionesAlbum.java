package com.example.sibemol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class cancionesAlbum extends AppCompatActivity {
    RecyclerView recyclerView;
    Adaptador adapter;
    ImageView imagenAlbum;
    TextView nombreAlbum,autorAlbum;
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canciones_album);
        getSupportActionBar().hide();

        Bundle bundle = getIntent().getExtras();
        int id = bundle.getInt("id");
        String nombre = bundle.getString("nombre");
        String author = bundle.getString("artista");
        int img = bundle.getInt("img");

        imagenAlbum = (ImageView) findViewById(R.id.imagenAlbum);
        nombreAlbum = (TextView) findViewById(R.id.nombreAlbum);
        autorAlbum = (TextView) findViewById(R.id.authorAlbum);

        imagenAlbum.setImageResource(img);
        nombreAlbum.setText(nombre);
        autorAlbum.setText(author);

        recyclerView = (RecyclerView) findViewById(R.id.rv);
        adapter = new Adaptador(getApplicationContext(),MainActivity.listaMusica,id,1);

        recyclerView.setAdapter(adapter);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Intent intent = new Intent(this, index.class);
        startActivity(intent);
        finish();
        return super.onKeyDown(keyCode, event);
    }

}