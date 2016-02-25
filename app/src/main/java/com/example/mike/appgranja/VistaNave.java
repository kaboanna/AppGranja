package com.example.mike.appgranja;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mike.appgranja.Clases.AdminSQLiteOpenHelper;
import com.example.mike.appgranja.Clases.Nave;
import com.example.mike.appgranja.Clases.infoNave;

import java.util.ArrayList;

public class VistaNave extends AppCompatActivity {
    public int id;
    private ArrayList<Nave> datos;

    private ListView listaNaves;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_nave);
        Bundle bundle = getIntent().getExtras();
        id=bundle.getInt("idGranja");

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this);

        if (admin.obtenerNaves(id) != null) {
            datos = admin.obtenerNaves(id);
            AdaptadorNaves adaptador = new AdaptadorNaves(this, datos);

            listaNaves = (ListView) findViewById(R.id.listaNaves);

            listaNaves.setAdapter(adaptador);
            listaNaves.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View v, int posicion, long id) {
                    Nave Nave = (Nave) listaNaves.getItemAtPosition(posicion);
                    Intent intent = new Intent(VistaNave.this, infoNave.class);
                    intent.putExtra("idNave", Nave.getId());
                    startActivity(intent);
                }
            });
        }
    }
    class AdaptadorNaves extends ArrayAdapter<Nave> {
        public AdaptadorNaves(Context context, ArrayList<Nave> datos) {
            super(context, R.layout.activity_vista_nave, datos);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());

            View item = inflater.inflate(R.layout.nave_item, null);
            Log.d("creation", String.valueOf(position));

            TextView nombre = (TextView) item.findViewById(R.id.nombre);
            nombre.setText(datos.get(position).getNombre());

            TextView empresa = (TextView) item.findViewById(R.id.tipoAnimal);
            empresa.setText(datos.get(position).getAnimalTipo());

            return (item);
        }
    }
    @Override
    public boolean	onCreateOptionsMenu(Menu menu)	{
        //	Inflate	the	menu;	this	adds	items	to	the	ac8on	bar	if	it	is	present.
        getMenuInflater().inflate(R.menu.menu_nave, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)	{
        switch	(item.getItemId())	{
            case R.id.action_nuevo:
                Intent intent = new Intent(this, addNave.class);
                intent.putExtra("idGranja",id);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
