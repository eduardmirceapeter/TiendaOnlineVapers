package com.example.tiendaonlinevapers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class CarritoActivity extends AppCompatActivity {
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);
        //DECLARAMOS COMPONENTES
        rv= findViewById(R.id.recyclerView2);
        //CREAMOS UN NUEVO CARRITP
        Carrito c = new Carrito();
        //Y LE DECIMOS QUE COJA LA LISTA AÑADIDA
        CustomAdapter adapter = new CustomAdapter(getApplicationContext(),c.getLista());
        //Y QUE LO MUESTRE RECOGIENDO LOS DATOS Y LA POSICION EN EL ARRAY
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),InformacionActivity.class);
                intent.putExtra("Nombre", c.getLista().get(rv.getChildAdapterPosition(view)).getNombre());
                intent.putExtra("Descripcion", c.getLista().get(rv.getChildAdapterPosition(view)).getDescripcion());
                intent.putExtra("Precio", c.getLista().get(rv.getChildAdapterPosition(view)).getPrecio());
                intent.putExtra("Imagen", c.getLista().get(rv.getChildAdapterPosition(view)).getImage());
                startActivity(intent);

                Toast.makeText(getApplicationContext(),
                        "Selección: "+c.getLista().get(rv.getChildAdapterPosition(view)).getNombre(),Toast.LENGTH_SHORT).show();
            }
        });
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);


    }


}