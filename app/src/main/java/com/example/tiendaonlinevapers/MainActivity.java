package com.example.tiendaonlinevapers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<Item> listItems =  new ArrayList<>(); //ARRAY DE ITEMS
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //CREAMOS COMPONENTES
        rv = findViewById(R.id.recyclerView);
        //CREAMOS ITEM
        Item i = new Item();
        //CARACTERISTICAS ITEMS
        listItems.add(new Item("Vaper Sabor Mora Mix","Este dispositivo te ofrece la libertad de saborear tus momentos sin las restricciones del tabaco tradicional.",15,R.drawable.mora));
        listItems.add(new Item("Vaper Sabor Piña","Este dispositivo te ofrece la libertad de saborear tus momentos sin las restricciones del tabaco tradicional.",15,R.drawable.pina));
        listItems.add(new Item("Vaper Sabor Platano Ice","Este dispositivo te ofrece la libertad de saborear tus momentos sin las restricciones del tabaco tradicional.",20,R.drawable.platano));
        listItems.add(new Item("Vaper Sabor Pomelo Ice","Este dispositivo te ofrece la libertad de saborear tus momentos sin las restricciones del tabaco tradicional.",20,R.drawable.pomelo));
        listItems.add(new Item("Vaper Sabor Red Bull","Este dispositivo te ofrece la libertad de saborear tus momentos sin las restricciones del tabaco tradicional.",25,R.drawable.redbull));
        listItems.add(new Item("Vaper Sabor Sandia","Este dispositivo te ofrece la libertad de saborear tus momentos sin las restricciones del tabaco tradicional.",15,R.drawable.sandia));

        //LE DECIMOS AL ADAPTER QUE COJA EL ARRAY DE ITEMS
        CustomAdapter adapter = new CustomAdapter(getApplicationContext(),listItems);

        //Y SE LE PASA TODA LA INFORMACION A OTRA ACTIVIDAD AL PULSAR UN ITEM
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),InformacionActivity.class);
                intent.putExtra("Nombre", listItems.get(rv.getChildAdapterPosition(view)).getNombre());
                intent.putExtra("Descripcion", listItems.get(rv.getChildAdapterPosition(view)).getDescripcion());
                intent.putExtra("Precio", listItems.get(rv.getChildAdapterPosition(view)).getPrecio());
                intent.putExtra("Imagen", listItems.get(rv.getChildAdapterPosition(view)).getImage());
                startActivity(intent);

                Toast.makeText(getApplicationContext(),
                        "Selección: "+listItems.get(rv.getChildAdapterPosition(view)).getNombre(),Toast.LENGTH_SHORT).show();
            }
        });
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);

    }

    //TE MANDA A LA VISTA DEL CARRITO
    public void carrito(View view) {
        Intent intent = new Intent(this,CarritoActivity.class);
        startActivity(intent);
    }
}