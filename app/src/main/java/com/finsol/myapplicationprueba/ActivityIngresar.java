package com.finsol.myapplicationprueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.finsol.myapplicationprueba.configuracion.SQLiteConexion;
import com.finsol.myapplicationprueba.tablas.Transacciones;

public class ActivityIngresar extends AppCompatActivity {

    Button btnIngresar;
    EditText nombres, apellidos, edad, correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar);
        Config();

    }

    private void Config()
    {
        btnIngresar = findViewById(R.id.btnIngresar);
        nombres = findViewById(R.id.ai_nombre);
        apellidos = findViewById(R.id.ai_apellidos);
        edad = findViewById(R.id.ai_edad);
        correo = findViewById(R.id.ai_correo);
    }

    public void agregarPersona(View view)
    {
        SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.NameDatabase, null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Transacciones.nombres,nombres.getText().toString());
        values.put(Transacciones.apellidos,apellidos.getText().toString());
        values.put(Transacciones.edad,edad.getText().toString());
        values.put(Transacciones.correo,correo.getText().toString());

        try {
            Long resultado = db.insert(Transacciones.TablaPersona, Transacciones.id, values);
            Toast.makeText(getApplicationContext(), "Registo Ingresado. "+resultado.toString(), Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Error al insertar. "+e.toString(), Toast.LENGTH_SHORT).show();
        }

        db.close();
        ClearScreem();

    }

    private void ClearScreem() {

        nombres.setText("");
        apellidos.setText("");
        edad.setText("");
        correo.setText("");
    }
}