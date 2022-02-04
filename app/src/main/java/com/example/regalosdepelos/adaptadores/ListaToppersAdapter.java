package com.example.regalosdepelos.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.regalosdepelos.R;
import com.example.regalosdepelos.VerActivity;
import com.example.regalosdepelos.entidades.Toppers;

import java.util.ArrayList;

public class ListaToppersAdapter extends RecyclerView.Adapter<ListaToppersAdapter.TopperViewHolder> {

    ArrayList<Toppers> listaToppers;

    public  ListaToppersAdapter(ArrayList<Toppers> listaToppers){
        this.listaToppers = listaToppers;
    }

    @NonNull
    @Override
    public TopperViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_topper, null, false);
        return new TopperViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopperViewHolder holder, int position) {

        holder.viewNombre.setText(listaToppers.get(position).getNombre());
        holder.viewDescripcion.setText(listaToppers.get(position).getDescripcion());
        holder.viewPrecio.setText(listaToppers.get(position).getPrecio());

    }

    @Override
    public int getItemCount() {
        return listaToppers.size();
    }

    public class TopperViewHolder extends RecyclerView.ViewHolder {

        TextView viewNombre, viewDescripcion, viewPrecio;

        public TopperViewHolder(@NonNull View itemView) {
            super(itemView);

            viewNombre = itemView.findViewById(R.id.viewNombre);
            viewDescripcion = itemView.findViewById(R.id.viewDescripcion);
            viewPrecio = itemView.findViewById(R.id.viewPrecio);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, VerActivity.class);
                    intent.putExtra("ID", listaToppers.get(getAdapterPosition()).getId());
                    context.startActivity(intent);
                }
            });

        }
    }
}
