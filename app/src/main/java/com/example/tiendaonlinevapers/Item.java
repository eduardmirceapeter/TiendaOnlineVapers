package com.example.tiendaonlinevapers;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Item implements Parcelable {
    //POJO + PARCELABE (SIRVE PARA PODER PASAR DATOS ENTRE ACTIVIDADES)
    private String nombre;
    private String descripcion;
    private int precio;
    private int image;

    Context context;

    public Item(){}

    public Item(String nombre, String descripcion, int precio, int image) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.image = image;
    }
    //**************************************************************************************
    protected Item(Parcel in) {
        nombre = in.readString();
        descripcion = in.readString();
        precio = in.readInt();
        image = in.readInt();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
    //**************************************************************************************
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    //***********************************************************************************

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(descripcion);
        dest.writeInt(precio);
        dest.writeInt(image);
    }
}

