package com.javierms.objetivosprofanus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button btnEmpezarPartida, btnListaObjetivos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEmpezarPartida = findViewById(R.id.btnEmpezarPartida);
        btnListaObjetivos = findViewById(R.id.btnListaObjetivos);

        btnEmpezarPartida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent miIntent = new Intent(getApplicationContext(), juegoObjetivos.class);
                startActivity(miIntent);
            }
        });

        btnListaObjetivos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent miIntent = new Intent(getApplicationContext(), listaObjetivos.class);
                startActivity(miIntent);
            }
        });


    }
}