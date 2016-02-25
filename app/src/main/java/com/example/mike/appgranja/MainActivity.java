package com.example.mike.appgranja;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mike.appgranja.Clases.AdminSQLiteOpenHelper;
import com.example.mike.appgranja.Clases.Granja;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {
    private ArrayList<Granja> datos;

    private ListView listaGranjas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this);
        if (admin.obtenerGranja() != null) {
            datos = admin.obtenerGranja();
            AdaptadorGranjas adaptador = new AdaptadorGranjas(this, datos);

            listaGranjas = (ListView) findViewById(R.id.listaGranjas);

            listaGranjas.setAdapter(adaptador);
            listaGranjas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View v, int posicion, long id) {
                    Granja Granja = (Granja) listaGranjas.getItemAtPosition(posicion);
                    Intent intent = new Intent(MainActivity.this, VistaNave.class);
                    intent.putExtra("idGranja", Granja.getId());
                    startActivity(intent);
                }
            });
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //	Inflate	the	menu;	this	adds	items	to	the	ac8on	bar	if	it	is	present.
        getMenuInflater().inflate(R.menu.menu_granja, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_nuevo:
                Intent intent = new Intent(this, addGranja.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    class AdaptadorGranjas extends ArrayAdapter<Granja> {
        public AdaptadorGranjas(Context context, ArrayList<Granja> datos) {
            super(context, R.layout.activity_main, datos);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());

            View item = inflater.inflate(R.layout.granja_item, null);
            Log.d("creation", String.valueOf(position));

            TextView nombre = (TextView) item.findViewById(R.id.nombre);
            nombre.setText(datos.get(position).getNombre());

            TextView empresa = (TextView) item.findViewById(R.id.empresa);
            empresa.setText(datos.get(position).getEmpresa());

            TextView cartilla = (TextView) item.findViewById(R.id.cartilla);
            cartilla.setText(datos.get(position).getcartillaGanadera());

            LinearLayout naves = (LinearLayout) item.findViewById(R.id.naves);
            for (int i=0;i<datos.get(position).naves.size();i++){
                TextView nave = new TextView(getContext());
                nave.setText(datos.get(position).naves.get(i).getNombre());
                naves.addView(nave);
            }

            return (item);
        }
    }
}
