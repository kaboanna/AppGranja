package com.example.mike.appgranja.Clases;

import java.util.ArrayList;

/**
 * Created by Mike on 25/02/2016.
 */
public class Granja {
    public int id;
    public String nombre;
    public String cartillaGanadera;
    public String empresa;
    public ArrayList<Nave> naves;
    public String localizacion;


    public Granja(int id, String nombre, String empresa, String cartillaGanadera, String localizacion) {
        this.id=id;
        this.nombre = nombre;
        this.cartillaGanadera = cartillaGanadera;
        this.empresa = empresa;
        this.localizacion = localizacion;
        this.naves=new ArrayList<>();
    }

    public String getCartillaGanadera() {
        return cartillaGanadera;
    }

    public void setCartillaGanadera(String cartillaGanadera) {
        this.cartillaGanadera = cartillaGanadera;
    }

    public ArrayList<Nave> getNaves() {
        return naves;
    }

    public void setNaves(ArrayList<Nave> naves) {
        this.naves = naves;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getcartillaGanadera() {
        return cartillaGanadera;
    }

    public void setcartillaGanadera(String cartillaGanadera) {
        this.cartillaGanadera = cartillaGanadera;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

}
