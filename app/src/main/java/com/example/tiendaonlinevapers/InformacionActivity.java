package com.example.tiendaonlinevapers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class InformacionActivity extends AppCompatActivity {
    Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);
        //DECLARAMOS COMPONENTES
        TextView tv1 = findViewById(R.id.textView);
        TextView tv2 = findViewById(R.id.textView2);
        ImageView imageView = findViewById(R.id.imageView4);

        //RECOGEMOS DATOS DE LA OTRA ACTIVIDAD
        Intent intent = getIntent();
        Bundle b = getIntent().getExtras();
        String nombre =  b.getString("Nombre");
        Integer imagen = b.getInt("Imagen");
        Integer precio = b.getInt("Precio");
        String descrp = b.getString("Descripcion");

        //Y LAS SETEAMOS EN LOS TEXTVIEW E IMAGEN
        tv1.setText(nombre);
        tv2.setText(descrp);
        imageView.setImageResource(imagen);

        //Y LE DECIMOS QUE UN NUEVO ITEM CON ESTOS PARAMETROS
       item = new Item(nombre,descrp,precio,imagen);


    }

    //BOTON PARA AÑADIR EL ITEM AL CARRITO
    public void anadir(View view) {
        Carrito.anyadir(item);
        Toast.makeText(getApplicationContext(),"Se ha añadido correctamente",Toast.LENGTH_SHORT);
    }
}