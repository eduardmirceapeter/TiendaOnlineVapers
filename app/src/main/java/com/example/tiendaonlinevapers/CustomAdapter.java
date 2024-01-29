package com.example.tiendaonlinevapers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> implements View.OnClickListener{
    Context context;
    List<Item> items;
    private View.OnClickListener listener;


    public CustomAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }


    @NonNull
    @Override
    public CustomAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item,parent,false);

        view.setOnClickListener(this);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.CustomViewHolder holder, int position) {
        CharSequence charSequence;
        //LE DECIMOS QUE QUEREMOS QUE RECOGJA EN CADA PARAMETRO Y LA POSICION DEL ARRAY
        holder.nombreView.setText(items.get(position).getNombre());
        holder.precioView.setText( charSequence = String.valueOf(items.get(position).getPrecio()) + "€");
        holder.imageView.setImageResource(items.get(position).getImage());
        holder.descripcionView.setText(items.get(position).getDescripcion());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }


    @Override
    public void onClick(View v) {
        if (listener!=null){
            listener.onClick(v);
        }
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        //AQUI DECLARAMOS LOS COMPONENTES DEL RECYCLER
        ImageView imageView;
        TextView nombreView;
        TextView precioView;
        TextView descripcionView;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView2);
            nombreView = itemView.findViewById(R.id.textView3);
            precioView = itemView.findViewById(R.id.textView5);
            descripcionView = itemView.findViewById(R.id.textView4);
        }
    }
}