package com.finsol.myapplicationprueba;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.finsol.myapplicationprueba.configuracion.SQLiteConexion;
import com.finsol.myapplicationprueba.tablas.Personas;
import com.finsol.myapplicationprueba.tablas.Transacciones;

import java.util.ArrayList;

public class ActivityCombo extends AppCompatActivity {

    //Variables Globales

    SQLiteConexion conexion;
    Spinner spPersonas;
    EditText txtNombre, txtApellidos, txtCorreo;
    ArrayList<Personas> lista;
    ArrayList<String> listString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combo);

        conexion = new SQLiteConexion(this, Transacciones.NameDatabase, null, 1);
        spPersonas = findViewById(R.id.spPersonas);
        txtNombre = findViewById(R.id.txtNombre_Ac);
        txtApellidos = findViewById(R.id.txtApellidos_ac);
        txtCorreo = findViewById(R.id.txtCorreo_ac);

        obtenerPersonas();

        ArrayAdapter<CharSequence> adp = new ArrayAdapter(this, android.R.layout.simple_spinner_item, listString);
        spPersonas.setAdapter(adp);
    }

    private void obtenerPersonas() {

        SQLiteDatabase db = conexion.getReadableDatabase();
        Personas listaPersonas = null;
        lista = new ArrayList<Personas>();

        Cursor cursor = db.rawQuery("SELECT * FROM "+Transacciones.TablaPersona,null);

        while(cursor.moveToNext()){
            listaPersonas = new Personas();
            listaPersonas.setId(cursor.getInt(0));
            listaPersonas.setNombre(cursor.getString(1));
            listaPersonas.setApellidos(cursor.getString(2));
            listaPersonas.setEdad(cursor.getInt(3));
            listaPersonas.setCorreo(cursor.getString(4));
            lista.add(listaPersonas);
        }
        cursor.close();

        fillCombo();


    }

    private void fillCombo() {
        listString = new ArrayList<String>();
        for(int i=0; i < lista.size(); i++){
            listString.add(lista.get(i).getNombre()+
                    " "+lista.get(i).getApellidos() +
                    " "+lista.get(i).getCorreo());


        }
    }
}