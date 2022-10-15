package com.finsol.myapplicationprueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtNombre, txtApellido;
    Button btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAgregar = findViewById(R.id.btn_agregar);
        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
    }

    public void irPaginaPrincipal(View view){
        Toast.makeText(MainActivity.this,"Hola"+" "+txtNombre.getText(),Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("nombre",txtNombre.getText().toString());
        intent.putExtra("apellido",txtApellido.getText().toString());
        startActivity(intent);

    }
}