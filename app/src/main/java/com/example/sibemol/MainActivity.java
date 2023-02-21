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
    public static final List<albumClass> listaAlbum = new ArrayList<albumClass>();

    public static final MediaPlayer musica[] = new MediaPlayer[24];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        if (Build.VERSION.SDK_INT > 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        setContentView(R.layout.activity_main);
        //Se llena la lista albun con los albunes a mostrar
        listaAlbum.add(new albumClass(0,"Born Pink","Blackpink",R.mipmap.pinkvenom));
        listaAlbum.add(new albumClass(1,"Demon Days","Gorillaz",R.mipmap.clinteastwood));
        listaAlbum.add(new albumClass(2,"Wiped Out","The Neighbourhood",R.mipmap.wires));
        listaAlbum.add(new albumClass(3,"American Beauty","Fall Out Boy",R.mipmap.centuries));
        listaAlbum.add(new albumClass(4,"Proof","BTS",R.mipmap.proof));
        listaAlbum.add(new albumClass(5,"BTS, THE BEAST","BTS",R.mipmap.btsthebeast));

        //Se llena la lista musica, junto con el id del albun al que pertenecen
        listaMusica.add(new Musica(0,0,"Pink Venom","Blackpink",R.mipmap.pinkvenom));
        listaMusica.add(new Musica(1,0,"Shutdown","Blackpink",R.mipmap.pinkvenom));
        listaMusica.add(new Musica(2,0,"Typa Girl","Blackpink",R.mipmap.pinkvenom));
        listaMusica.add(new Musica(3,0,"Yeah Yeah Yeah","Blackpink",R.mipmap.pinkvenom));

        listaMusica.add(new Musica(4,1,"Clint Eastwood","Gorillaz",R.mipmap.clinteastwood));
        listaMusica.add(new Musica(5,1,"Feel Good","Gorillaz",R.mipmap.clinteastwood));
        listaMusica.add(new Musica(6,1,"On Melancholy Hill","Gorillaz",R.mipmap.clinteastwood));
        listaMusica.add(new Musica(7,1,"New Gold","Gorillaz",R.mipmap.clinteastwood));

        listaMusica.add(new Musica(8,2,"Wires","The Neighbourhood",R.mipmap.wires));
        listaMusica.add(new Musica(9,2,"Sweater Wheater","The Neighbourhood",R.mipmap.wires));
        listaMusica.add(new Musica(10,2,"Daddy Issues","The Neighbourhood",R.mipmap.wires));
        listaMusica.add(new Musica(11,2,"Softcore","The Neighbourhood",R.mipmap.wires));

        listaMusica.add(new Musica(12,3,"Centuries","Fall Out Boy",R.mipmap.centuries));
        listaMusica.add(new Musica(13,3,"Thnks","Fall Out Boy",R.mipmap.centuries));
        listaMusica.add(new Musica(14,3,"Sugar, We're goind down","Fall Out Boy",R.mipmap.centuries));
        listaMusica.add(new Musica(15,3,"Dance dance","Fall Out Boy",R.mipmap.centuries));

        listaMusica.add(new Musica(16,4,"Born Singer","BTS",R.mipmap.proof));
        listaMusica.add(new Musica(17,4,"No more dream","BTS",R.mipmap.proof));
        listaMusica.add(new Musica(18,4,"N.O","BTS",R.mipmap.proof));
        listaMusica.add(new Musica(19,4,"Boy In Lux","BTS",R.mipmap.proof));

        listaMusica.add(new Musica(16,5,"Run BTS","BTS",R.mipmap.btsthebeast));
        listaMusica.add(new Musica(17,5,"Fiml Out","BTS",R.mipmap.btsthebeast));
        listaMusica.add(new Musica(18,5,"Lights","BTS",R.mipmap.btsthebeast));
        listaMusica.add(new Musica(19,5,"Stay Gold","BTS",R.mipmap.btsthebeast));


        musica[0] = MediaPlayer.create(this,R.raw.pinkvenom);
        musica[1] = MediaPlayer.create(this,R.raw.shutdown);
        musica[2] = MediaPlayer.create(this,R.raw.typagirl);
        musica[3] = MediaPlayer.create(this,R.raw.yeahyeahyeah);

        musica[4] = MediaPlayer.create(this,R.raw.clinteastwood);
        musica[5] = MediaPlayer.create(this,R.raw.feelgood);
        musica[6] = MediaPlayer.create(this,R.raw.onmelancholy);
        musica[7] = MediaPlayer.create(this,R.raw.newgold);

        musica[8] = MediaPlayer.create(this,R.raw.wires);
        musica[9] = MediaPlayer.create(this,R.raw.wheater);
        musica[10] = MediaPlayer.create(this,R.raw.daddyissues);
        musica[11] = MediaPlayer.create(this,R.raw.softcore);

        musica[12] = MediaPlayer.create(this,R.raw.centuries);
        musica[13] = MediaPlayer.create(this,R.raw.thnks);
        musica[14] = MediaPlayer.create(this,R.raw.sugar);
        musica[15] = MediaPlayer.create(this,R.raw.dancedance);

        musica[16] = MediaPlayer.create(this,R.raw.bornsigner);
        musica[17] = MediaPlayer.create(this,R.raw.nomoredream);
        musica[18] = MediaPlayer.create(this,R.raw.no);
        musica[19] = MediaPlayer.create(this,R.raw.boyinluv);

        musica[20] = MediaPlayer.create(this,R.raw.runbts);
        musica[21] = MediaPlayer.create(this,R.raw.filmout);
        musica[22] = MediaPlayer.create(this,R.raw.lights);
        musica[23] = MediaPlayer.create(this,R.raw.staygold);

        Intent intent = new Intent(this,login.class);
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