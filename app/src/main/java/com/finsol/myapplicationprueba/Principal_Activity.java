package com.finsol.myapplicationprueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Principal_Activity extends AppCompatActivity {
    Button btnadd, btnLista, btnCombo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btnadd = findViewById(R.id.btnadd);
        btnLista = findViewById(R.id.btnList);
        btnCombo = findViewById(R.id.btnCombo);
        
       /* btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Principal_Activity.this, ActivityIngresar.class);
                startActivity(intent);
            }
        });*/

        btnCombo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Principal_Activity.this, ActivityCombo.class);
                startActivity(intent);
            }
        });
    }

    public void irIngresar(View view){
        Intent intent = new Intent(Principal_Activity.this, ActivityIngresar.class);
        startActivity(intent);
    }

    public void irLista(View view){
        Intent intent = new Intent(Principal_Activity.this, ActivityList.class);
        startActivity(intent);
    }
}