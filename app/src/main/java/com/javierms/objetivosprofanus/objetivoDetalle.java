package com.javierms.objetivosprofanus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class objetivoDetalle extends AppCompatActivity {

    TextView txtId,txtNombre,txtDescripcion,txtPuntuacion;
    
    CObjetivo miObjetivoDetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objetivo_detalle);

        Toolbar miToolbar = findViewById(R.id.toolbar);
        miToolbar.setTitle("OBJETIVO");
        setSupportActionBar(miToolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        miToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        miObjetivoDetalle = (CObjetivo) getIntent().getSerializableExtra("objetivo");

        txtId = findViewById(R.id.txtIdObjetivo);
        txtNombre = findViewById(R.id.txtNombreObjetivo);
        txtDescripcion = findViewById(R.id.txtDescripcionObjetivo);
        txtPuntuacion = findViewById(R.id.txtPuntuacionObjetivo);

        txtId.setText(""+miObjetivoDetalle.getId());
        txtNombre.setText(miObjetivoDetalle.getNombre());
        txtDescripcion.setText(miObjetivoDetalle.getDescripcion());

        if(miObjetivoDetalle.getPuntuacion() == 2){
            txtPuntuacion.setText("Mirar Descripción.");
        } else if (miObjetivoDetalle.getPuntuacion() == 1){
            txtPuntuacion.setText("1 PV / 1D3 PV");
        } else {
            txtPuntuacion.setText("1 PV");
        }

    }
}