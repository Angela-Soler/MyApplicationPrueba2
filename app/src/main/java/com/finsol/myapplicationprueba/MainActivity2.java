package com.finsol.myapplicationprueba;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView txtResultado;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtResultado = findViewById(R.id.txtRes);
        Bundle Resultado = getIntent().getExtras();
        txtResultado.setText(Resultado.getString("nombre")+" "+Resultado.getString("apellido"));

    }
}