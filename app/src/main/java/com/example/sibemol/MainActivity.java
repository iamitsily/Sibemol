package com.example.sibemol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final List<Musica> listaMusica = new ArrayList<Musica>();
    public static final MediaPlayer musica[] = new MediaPlayer[10];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        if (Build.VERSION.SDK_INT > 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        setContentView(R.layout.activity_main);

        listaMusica.add(new Musica(0,"Pink Venom","Blackpink",R.mipmap.pinkvenom));
        listaMusica.add(new Musica(1,"Clink Eastwood","Gorillaz",R.mipmap.clinteastwood));
        listaMusica.add(new Musica(2,"Wires","The Neighbourhood",R.mipmap.wires));
        listaMusica.add(new Musica(3,"Centuries","Fall Out Boy",R.mipmap.centuries));
        listaMusica.add(new Musica(4,"Good 4 you","Olivia Rodrigo",R.mipmap.goodforyou));
        listaMusica.add(new Musica(5,"Suzume","RADWIMPS",R.mipmap.suzume));
        listaMusica.add(new Musica(6,"Beautiful Word","Hikaru Utada",R.mipmap.beautifulword));
        listaMusica.add(new Musica(7,"Money","Lisa",R.mipmap.money));
        listaMusica.add(new Musica(8,"Antifragile","LE SSERAFIM",R.mipmap.antifragile));
        listaMusica.add(new Musica(9,"Run BTS","BTS",R.mipmap.runbts));

        musica[0] = MediaPlayer.create(this,R.raw.pinkvenom);
        musica[1] = MediaPlayer.create(this,R.raw.clinteastwood);
        musica[2] = MediaPlayer.create(this,R.raw.wires);
        musica[3] = MediaPlayer.create(this,R.raw.centuries);
        musica[4] = MediaPlayer.create(this,R.raw.goodforyou);
        musica[5] = MediaPlayer.create(this,R.raw.suzume);
        musica[6] = MediaPlayer.create(this,R.raw.beautifulword);
        musica[7] = MediaPlayer.create(this,R.raw.money);
        musica[8] = MediaPlayer.create(this,R.raw.antifragile);
        musica[9] = MediaPlayer.create(this,R.raw.runbts);

        Intent intent = new Intent(this,index.class);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
                finish();
            }
        },1000);
    }
}