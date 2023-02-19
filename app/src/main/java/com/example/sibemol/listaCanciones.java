package com.example.sibemol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;

public class listaCanciones extends AppCompatActivity implements SearchView.OnQueryTextListener{
    RecyclerView recyclerView;
    SearchView searchView;
    Adaptador adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_canciones);
        getSupportActionBar().hide();
        searchView = findViewById(R.id.buscarCancion);
        recyclerView = (RecyclerView) findViewById(R.id.rvCanciones);
        adaptador = new Adaptador(MainActivity.listaMusica);
        recyclerView.setAdapter(adaptador);

        searchView.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adaptador.filtrado(newText);
        return false;
    }
}