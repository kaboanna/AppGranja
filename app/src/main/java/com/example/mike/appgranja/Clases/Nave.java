package com.example.mike.appgranja.Clases;

/**
 * Created by Mike on 25/02/2016.
 */
public class Nave {
    public int id;
    public int idGranja;
    public String nombre;
    public int codeOrdenador;
    public String animalTipo;
    public int numAnimales;
    public String codNave;



    public Nave(int id, int idGranja,String nombre, String animalTipo, int cantidad, String codNave,int codeOrdenador) {
        this.id=id;
        this.idGranja=idGranja;
        this.nombre = nombre;
        this.codeOrdenador = codeOrdenador;
        this.animalTipo = animalTipo;
        this.numAnimales=cantidad;
        this.codNave=codNave;
    }

    public String getCodNave() {
        return codNave;
    }

    public void setCodNave(String codNave) {
        this.codNave = codNave;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdGranja() {
        return idGranja;
    }

    public void setIdGranja(int idGranja) {
        this.idGranja = idGranja;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumAnimales() {
        return numAnimales;
    }

    public void setNumAnimales(int numAnimales) {
        this.numAnimales = numAnimales;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodeOrdenador() {
        return codeOrdenador;
    }

    public void setCodeOrdenador(int codeOrdenador) {
        this.codeOrdenador = codeOrdenador;
    }

    public String getAnimalTipo() {
        return animalTipo;
    }

    public void setAnimalTipo(String animalTipo) {
        this.animalTipo = animalTipo;
    }

}
