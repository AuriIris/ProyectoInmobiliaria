package com.example.proyectoinmobiliaria.ui.Inquilinos;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectoinmobiliaria.R;
import com.example.proyectoinmobiliaria.model.Contrato;
import com.example.proyectoinmobiliaria.model.Inmueble;
import com.example.proyectoinmobiliaria.model.Inquilino;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class InquilinosAdapter extends RecyclerView.Adapter<InquilinosAdapter.ViewHolder> {

    private Context context;
    private List<Contrato> contratos;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onInquilinosClick(Inquilino inquilino);
    }

    public void setContratos(List<Contrato> contratos) {
        this.contratos = contratos;
        notifyDataSetChanged();
    }

    public InquilinosAdapter(Context context, List<Contrato> contratos) {
        this.context = context;
        this.contratos = contratos;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_inquilino, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contrato contrato = contratos.get(position);
        holder.bind(contrato);
        holder.btnVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(view);
                Bundle bundle = new Bundle();
                bundle.putSerializable("inquilino", contrato.getInquilino());
                navController.navigate(R.id.action_inquilinosFragment_to_detalleInquilinoFragment, bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contratos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView direccionTextView;
        private ImageView fotoImageView;
        private Button btnVer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            direccionTextView = itemView.findViewById(R.id.tvDireccion);
            fotoImageView = itemView.findViewById(R.id.ivImagen);
            btnVer = itemView.findViewById(R.id.buttonVerInq);
        }

        public void bind(Contrato contrato) {
            Inmueble inmueble = contrato.getInmueble();
            direccionTextView.setText(inmueble.getDireccion());
            Picasso.get().load(inmueble.getImagenUrl()).into(fotoImageView);
        }
    }
}
