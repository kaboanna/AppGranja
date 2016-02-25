package com.example.mike.appgranja;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mike.appgranja.Clases.AdminSQLiteOpenHelper;

public class addNave extends AppCompatActivity {
    TextView nombre;
    TextView tipo;
    TextView cantidad;
    TextView ordenador;
    int dato;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_nave);

        Bundle bundle = getIntent().getExtras();
        dato=bundle.getInt("idGranja");

    }
    public void onClick(View view) {


        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this);
        nombre = (TextView)findViewById(R.id.nombre);
        tipo = (TextView)findViewById(R.id.tipoAnimal);
        cantidad = (TextView)findViewById(R.id.cantAnimal);
        ordenador = (TextView)findViewById(R.id.codOrdenador);
        admin.insertarNave(dato, nombre.getText().toString(), tipo.getText().toString(), Integer.parseInt(cantidad.getText().toString()), Integer.parseInt(ordenador.getText().toString()));
        Intent intent = new Intent(this, VistaNave.class);
        intent.putExtra("idGranja",dato);
        startActivity(intent);

    }
}
