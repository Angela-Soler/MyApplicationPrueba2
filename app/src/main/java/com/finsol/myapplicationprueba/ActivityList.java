package com.finsol.myapplicationprueba;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.finsol.myapplicationprueba.configuracion.SQLiteConexion;
import com.finsol.myapplicationprueba.tablas.Personas;
import com.finsol.myapplicationprueba.tablas.Transacciones;

import java.util.ArrayList;
import java.util.List;

public class ActivityList extends AppCompatActivity {

    SQLiteConexion conexion;
    ListView listPerson;
    ArrayList<Personas> lista;
    ArrayList<String> listaConcatenada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        conexion = new SQLiteConexion(this, Transacciones.NameDatabase, null, 1);
        listPerson = (ListView) findViewById(R.id.listPerson);

        GetListPerson();

        ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaConcatenada);
        listPerson.setAdapter(adp);

        listPerson.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ActivityList.this, listaConcatenada.get(i), Toast.LENGTH_SHORT ).show();

            }
        });
    }

    private void GetListPerson() {
        SQLiteDatabase db = conexion.getReadableDatabase(); //Base de Datos en modo lectura
        Personas listPersonas;

        lista = new ArrayList<>(); //lista de objetos del tipo Personas
        Cursor cursor = db.rawQuery(Transacciones.GetPersona,null);

        while (cursor.moveToNext()){
            listPersonas = new Personas();
            listPersonas.setId(cursor.getInt(0));
            listPersonas.setNombre(cursor.getString(1));
            listPersonas.setApellidos(cursor.getString(2));
            listPersonas.setEdad(cursor.getInt(3));
            listPersonas.setCorreo(cursor.getString(4));

            lista.add(listPersonas);
        }
        cursor.close();

        llenarLista();
    }

    private void llenarLista() {

        listaConcatenada = new ArrayList<>();

        for (int i=0; i < lista.size(); i++){
            listaConcatenada.add("Nombres: "+lista.get(i).getNombre()+" \nApellidos: "+
                    lista.get(i).getApellidos()+" \nEdad: "+
                    lista.get(i).getEdad()+" \nCorreo: "+
                    lista.get(i).getCorreo());
        }
    }
}