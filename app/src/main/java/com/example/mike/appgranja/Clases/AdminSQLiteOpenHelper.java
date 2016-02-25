package com.example.mike.appgranja.Clases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Mike on 25/02/2016.
 */
public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    private static final int VERSION=1;
    private static final String NOMBRE ="mibasedatos.db";
    private static final String TablaGranjas ="CREATE TABLE Granjas (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, empresa TEXT, cartillaGanadera TEXT, localizacion TEXT)";
    private static final String TablaNaves ="CREATE TABLE Naves (id INTEGER PRIMARY KEY AUTOINCREMENT,idGranja INTEGER, nombre TEXT, tipoAnimal TEXT, numAnimales INTEGER, codNave TEXT, codOrdenador INTEGER)";


    public AdminSQLiteOpenHelper(Context context) {
        super(context, NOMBRE, null, VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TablaGranjas);
        db.execSQL(TablaNaves);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Granjas");
        db.execSQL(TablaGranjas);
        db.execSQL("DROP TABLE IF EXISTS Naves");
        db.execSQL(TablaNaves);
    }
    public void insertarGranja (String nombre, String empresa, String cartillaGanadera, String localizacion){
        SQLiteDatabase db = getWritableDatabase();
        if (db!=null){
            ContentValues valores = new ContentValues();
            valores.put("nombre",nombre);
            valores.put("empresa",empresa);
            valores.put("cartillaGanadera",cartillaGanadera);
            valores.put("localizacion",localizacion);
            db.insert("Granjas", null, valores);
            db.close();
        }
    }
    public void insertarNave (int idGranja,String nombre, String tipoAnimal, int numAnimales, int codOrdenador){
        SQLiteDatabase db = getWritableDatabase();
        if (db!=null){
            ContentValues valores = new ContentValues();
            valores.put("idGranja",idGranja);
            valores.put("nombre",nombre);
            valores.put("tipoAnimal",tipoAnimal);
            valores.put("numAnimales",numAnimales);
            valores.put("codOrdenador",codOrdenador);
            db.insert("Naves", null, valores);
            db.close();
        }
    }
    public void borrarGranja (int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete("Naves", "idGranja=" + id, null);
        db.delete("Granjas", "id=" + id, null);
        db.close();
    }

    public void borrarNave (int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete("Naves", "id=" + id, null);
        db.close();
    }

    public ArrayList<Granja> obtenerGranja(){
        try {
            SQLiteDatabase db = getReadableDatabase();


            ArrayList<Granja> Granjas = new ArrayList<>();

            Cursor c = db.rawQuery("Select * from Granjas", null);
            if (c.moveToFirst()) {
                do {
                    Granja Granja = new Granja(c.getInt(0),c.getString(1), c.getString(2), c.getString(3),c.getString(4));
                    if (obtenerNaves(c.getInt(0))!=null) {
                        Granja.setNaves(obtenerNaves(c.getInt(0)));
                    }
                    Granjas.add(Granja);

                } while (c.moveToNext());
            } else
                return null;
            c.close();
            db.close();

            return Granjas;
        }catch(NullPointerException ex){}
        return null;
    }

    public ArrayList<Nave> obtenerNaves(int id){
        try {
            SQLiteDatabase db = getReadableDatabase();


            ArrayList<Nave> naves = new ArrayList<>();

            Cursor c = db.rawQuery("Select * from Naves where idGranja="+id, null);
            if (c.moveToFirst()) {
                do {
                    Nave nave = new Nave(c.getInt(0),c.getInt(1),c.getString(2), c.getString(3), c.getInt(4),c.getString(5),c.getInt(6));
                    naves.add(nave);

                } while (c.moveToNext());
            } else
                return null;
            c.close();
            db.close();

            return naves;
        }catch(NullPointerException ex){}
        return null;
    }
}

