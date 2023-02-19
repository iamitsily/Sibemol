package com.example.sibemol;


import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolderDatos> {
    List<Musica> listaMusica;
    List<Musica> listaOriginal;
    Context contex;
    public Adaptador(List<Musica> listaMusica) {
        this.listaMusica = listaMusica;
        this.listaOriginal = new ArrayList<>();
        listaOriginal.addAll(listaMusica);
    }
    public void filtrado(String musica){
        int longitud = musica.length();
        if (longitud==0){
            listaMusica.clear();
            listaMusica.addAll(listaOriginal);
        }else{
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                List<Musica> filtrado = listaMusica.stream().filter(i->i.getNombre().toLowerCase().contains(musica.toLowerCase())).collect(Collectors.toList());
                listaMusica.clear();
                listaMusica.addAll(filtrado);
            }else{
                for (Musica c : listaMusica) {
                    if (c.getNombre().toLowerCase().contains(musica.toLowerCase())){
                        listaMusica.add(c);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.musicaitem,null,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador.ViewHolderDatos holder, int position) {
        holder.nombre.setText(listaMusica.get(position).getNombre());
        holder.artista.setText(listaMusica.get(position).getArtista());
        holder.imagenMusica.setImageResource(listaMusica.get(position).getImgCancion());
        holder.id =listaMusica.get(position).getIdCancion();
        holder.img = listaMusica.get(position).getImgCancion();

        holder.setOnClickListener();
    }

    @Override
    public int getItemCount() {
        return listaMusica.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder implements View.OnClickListener {
        int id,img;
        TextView nombre,artista;
        ImageView imagenMusica;
        LinearLayout linearLayout;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            contex = itemView.getContext();
            nombre = (TextView) itemView.findViewById(R.id.nombreMusica);
            artista = (TextView) itemView.findViewById(R.id.nombreArtista);
            imagenMusica = (ImageView) itemView.findViewById(R.id.imgMusica);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.musiclist_relativelayout);
        }
        public void setOnClickListener(){
            linearLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(contex,reproductorCanciones.class);
            intent.putExtra("id",id);
            intent.putExtra("nombre",nombre.getText());
            intent.putExtra("artista",artista.getText());
            intent.putExtra("img",img);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            contex.startActivity(intent);
        }
    }
}
