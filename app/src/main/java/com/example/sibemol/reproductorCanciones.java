package com.example.sibemol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class reproductorCanciones extends AppCompatActivity {
    ImageButton playpausabtn, siguientebtn, atrasbtn, repetirbtn;
    ImageView imagenMusica;
    TextView nombre, artista;
    int repetir = 1, posicion = 0;
    MediaPlayer musica[] = MainActivity.musica;
    List<Musica> listaMusica = MainActivity.listaMusica;
    List<albumClass> listaAlbum = MainActivity.listaAlbum;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==event.KEYCODE_BACK){
            musica[posicion].stop();
            posicion=0;
            reset();
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductor_canciones);
        getSupportActionBar().hide();

        //Vincular parte grafica con logica
        playpausabtn = (ImageButton) findViewById(R.id.btnplaypausa);
        siguientebtn = (ImageButton) findViewById(R.id.siguientebtn);
        atrasbtn = (ImageButton) findViewById(R.id.atrasbtn);
        repetirbtn = (ImageButton) findViewById(R.id.repetirbtn);
        imagenMusica = (ImageView) findViewById(R.id.imagenMusica);
        nombre = (TextView) findViewById(R.id.tvnombre);
        artista = (TextView) findViewById(R.id.tvartista);
        Bundle datosMusica = getIntent().getExtras();
        ponerDatos(datosMusica);
    }
    public void ponerDatos(Bundle datos){
        int id = datos.getInt("id");
        int img = datos.getInt("img");
        String nombreString = datos.getString("nombre");
        String artistaString = datos.getString("artista");

        nombre.setText(nombreString);
        artista.setText(artistaString);
        imagenMusica.setImageResource(img);
        posicion = id;
        playPausaMetodo(new View(this));
    }
    public void playPausaMetodo(View view){
        if (musica[posicion].isPlaying()) {
            musica[posicion].pause();
            playpausabtn.setImageResource(R.mipmap.play);
        } else {
            musica[posicion].start();
            playpausabtn.setImageResource(R.mipmap.pause);
        }
    }
    public void detener(View view) {
        if (musica[posicion] != null) {
            musica[posicion].stop();
            posicion=0;
            reset();
            finish();

        }
    }
    public void repetir(View view) {
        if (repetir == 1) {
            repetirbtn.setImageResource(R.mipmap.online);
            musica[posicion].setLooping(false);
            repetir = 2;
        } else {
            repetirbtn.setImageResource(R.mipmap.repeat);
            musica[posicion].setLooping(true);
            repetir = 1;
        }
    }
    public void next(View view) {
        if (posicion < musica.length - 1) {
            if (musica[posicion].isPlaying()) {
                musica[posicion].stop();
                reset();
                posicion++;
                nombre.setText(MainActivity.listaMusica.get(posicion).getNombre());
                artista.setText(MainActivity.listaMusica.get(posicion).getArtista());
                imagenMusica.setImageResource(MainActivity.listaMusica.get(posicion).getImgCancion());
                musica[posicion].start();
            } else {
                posicion++;

                nombre.setText(MainActivity.listaMusica.get(posicion).getNombre());
                artista.setText(MainActivity.listaMusica.get(posicion).getArtista());
                imagenMusica.setImageResource(MainActivity.listaMusica.get(posicion).getImgCancion());

            }
        } else {
            Toast.makeText(this, "No hay mas canciones", Toast.LENGTH_SHORT).show();
        }
    }
    public void back(View view){
        if (posicion>=1){
            if (musica[posicion].isPlaying()){
                musica[posicion].stop();
                reset();
                posicion--;

                musica[posicion].start();
                nombre.setText(MainActivity.listaMusica.get(posicion).getNombre());
                artista.setText(MainActivity.listaMusica.get(posicion).getArtista());
                imagenMusica.setImageResource(MainActivity.listaMusica.get(posicion).getImgCancion());

            }else{
                posicion--;
                nombre.setText(MainActivity.listaMusica.get(posicion).getNombre());
                artista.setText(MainActivity.listaMusica.get(posicion).getArtista());
                imagenMusica.setImageResource(MainActivity.listaMusica.get(posicion).getImgCancion());

            }
        }else{
            Toast.makeText(this, "No hay mas canciones", Toast.LENGTH_SHORT).show();
        }
    }
    public void reset() {
        listaMusica.clear();
        listaAlbum.clear();
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
    }
}