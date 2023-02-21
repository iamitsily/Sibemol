package com.example.sibemol;

import android.content.Context;

import java.util.List;

public class albumClass {
    private int id;
    String nombre,artista;
    int img;
    Context context;
    List<albumClass> listAlbum;

    public albumClass(int id, String nombre, String artista,int img){
        this.id = id;
        this.nombre = nombre;
        this.artista = artista;
        this.img = img;
    }
    public albumClass(Context context, List<albumClass> listAlbum) {
        this.context = context;
        this.listAlbum = listAlbum;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

}
