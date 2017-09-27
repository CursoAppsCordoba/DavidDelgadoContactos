package com.example.david.contactos;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by David on 21/09/2017.
 */



public class Contacto implements Parcelable {

    private String nombre;
    private String email;
    private int edad;


    public Contacto(String nombre, String email, int edad) {
        this.nombre = nombre;
        this.email = email;
        this.edad = edad;
    }

    protected Contacto(Parcel in) {
        nombre = in.readString();
        email = in.readString();
        edad = in.readInt();
    }

    public static final Creator<Contacto> CREATOR = new Creator<Contacto>() {
        @Override
        public Contacto createFromParcel(Parcel in) {
            return new Contacto(in);
        }

        @Override
        public Contacto[] newArray(int size) {
            return new Contacto[size];
        }
    };

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contacto contacto = (Contacto) o;

        if (edad != contacto.edad) return false;
        if (!nombre.equals(contacto.nombre)) return false;
        return email.equals(contacto.email);

    }

    @Override
    public int hashCode() {
        int result = nombre.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + edad;
        return result;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nombre);
        parcel.writeString(email);
        parcel.writeInt(edad);
    }
}
