package com.example.sibemol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class album extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        getSupportActionBar().hide();
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setAdapter(new AdaptadorAlbum(MainActivity.listaAlbum));
    }

}