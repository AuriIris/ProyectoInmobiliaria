package com.example.proyectoinmobiliaria.ui.Contratos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectoinmobiliaria.R;
import com.example.proyectoinmobiliaria.model.Pago;

import java.util.ArrayList;
import java.util.List;

public class PagoAdapter extends RecyclerView.Adapter<PagoAdapter.ViewHolder> {

    private Context context;
    private List<Pago> pagos;

    public PagoAdapter(Context context) {
        this.context = context;
        this.pagos = new ArrayList<>();
    }

    public void setPagos(List<Pago> pagos) {
        this.pagos = pagos;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_pagos, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pago pago = pagos.get(position);
        holder.bind(pago);
    }

    @Override
    public int getItemCount() {
        return pagos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvId;
        private TextView tvNumeroPago;
        private TextView tvMonto;
        private TextView tvFecha;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tvId);
            tvNumeroPago = itemView.findViewById(R.id.tvNumeroPago);
            tvMonto = itemView.findViewById(R.id.tvMonto);
            tvFecha = itemView.findViewById(R.id.tvFecha);
        }

        public void bind(Pago pago) {
            tvId.setText("ID: " + pago.getId());
            tvNumeroPago.setText("Número de Pago: " + pago.getNumeroPago());
            tvMonto.setText("Monto: " + pago.getMonto());
            tvFecha.setText("Fecha: " + pago.getFecha());
        }
    }
}
