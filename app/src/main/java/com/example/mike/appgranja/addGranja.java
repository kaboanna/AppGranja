package com.example.mike.appgranja;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mike.appgranja.Clases.AdminSQLiteOpenHelper;
import com.example.mike.appgranja.MainActivity;
import com.example.mike.appgranja.R;

public class addGranja extends AppCompatActivity {
    TextView nombre;
    TextView empresa;
    TextView cartilla;
    TextView local;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_granja);
    }
    public void onClick(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this);
        nombre = (TextView)findViewById(R.id.nombre);
        empresa = (TextView)findViewById(R.id.empresa);
        cartilla = (TextView)findViewById(R.id.cartilla);
        local = (TextView)findViewById(R.id.localizacion);
        admin.insertarGranja(nombre.getText().toString(), empresa.getText().toString(), cartilla.getText().toString(), local.getText().toString());
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
