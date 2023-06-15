package com.example.proyectoinmobiliaria.ui.Inmuebles;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.proyectoinmobiliaria.R;
import com.example.proyectoinmobiliaria.model.Contrato;
import com.example.proyectoinmobiliaria.model.Inmueble;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class InmueblesAdapter extends RecyclerView.Adapter<InmueblesAdapter.ViewHolder> {
    private Context context;
    private List<Contrato> inmuebles;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onInmuebleClick(Inmueble inmueble);
    }

    public InmueblesAdapter(Context context, OnItemClickListener listener) {
        this.context = context;
        this.listener = listener;
    }

    public void setInmuebles(List<Contrato> inmuebles) {
        this.inmuebles = inmuebles;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_inmueble, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Contrato contrato = inmuebles.get(position);
        holder.bind(contrato);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onInmuebleClick(contrato.getInmueble1());
            }
        });
    }

    @Override
    public int getItemCount() {
        if (inmuebles != null) {
            return inmuebles.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvDireccion;
        private TextView tvPrecio;
        private ImageView ivImagen;

        public ViewHolder(View itemView) {
            super(itemView);
            tvDireccion = itemView.findViewById(R.id.tvDireccion);
            tvPrecio = itemView.findViewById(R.id.tvPrecio);
            ivImagen = itemView.findViewById(R.id.ivImagen);
        }

        public void bind(Contrato contrato) {
            tvDireccion.setText(contrato.getInmueble1().getDireccion());
            tvPrecio.setText(String.valueOf(contrato.getInmueble1().getPrecio()));
            Picasso.get().load(contrato.getInmueble1().getImagenUrl()).into(ivImagen);
        }
    }
}
