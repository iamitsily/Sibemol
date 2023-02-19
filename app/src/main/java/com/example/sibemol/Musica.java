package com.example.sibemol;

import android.content.Context;

import java.util.List;


public class Musica {

    private int idCancion, imgCancion;
    private String nombre, artista;
    Context context;
    List<Musica> listMusic;

    public Musica(int idCancion, String nombre, String artista, int imgCancion) {
        this.idCancion = idCancion;
        this.nombre = nombre;
        this.artista = artista;
        this.imgCancion = imgCancion;
    }

    public int getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(int idCancion) {
        this.idCancion = idCancion;
    }

    public int getImgCancion() {
        return imgCancion;
    }

    public void setImgCancion(int imgCancion) {
        this.imgCancion = imgCancion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public Musica(Context context, List<Musica> listMusic) {
        this.context = context;
        this.listMusic = listMusic;
    }


}
