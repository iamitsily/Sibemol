package com.example.sibemol;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
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

public class AdaptadorAlbum extends RecyclerView.Adapter<AdaptadorAlbum.ViewHolderDatos> {

    Context contex;
    List<albumClass> listAlbum;

    public AdaptadorAlbum(List<albumClass> listAlbum) {
        this.listAlbum = listAlbum;

    }
    @NonNull
    @Override
    public AdaptadorAlbum.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemalbum,null,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorAlbum.ViewHolderDatos holder, int position) {
        holder.id = listAlbum.get(position).getId();
        holder.nombre.setText(listAlbum.get(position).getNombre());
        holder.artista = listAlbum.get(position).getArtista();
        holder.img = listAlbum.get(position).getImg();
        holder.linearLayout.setBackgroundResource(listAlbum.get(position).getImg());
        holder.setOnClickListener();
    }

    @Override
    public int getItemCount() {
        return listAlbum.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder implements View.OnClickListener{
        int id,img;
        TextView nombre;
        String artista;
        LinearLayout linearLayout;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            contex = itemView.getContext();
            nombre = (TextView) itemView.findViewById(R.id.tvm_name);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.music_item_linerearL);

        }

        public void setOnClickListener() {
            linearLayout.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(contex,cancionesAlbum.class);
            intent.putExtra("id",id);
            intent.putExtra("nombre",nombre.getText());
            intent.putExtra("artista",artista);
            intent.putExtra("img",img);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            contex.startActivity(intent);
        }
    }
}
