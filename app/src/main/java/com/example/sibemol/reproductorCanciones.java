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
    }
}