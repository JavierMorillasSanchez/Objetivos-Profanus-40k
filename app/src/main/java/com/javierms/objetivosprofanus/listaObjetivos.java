package com.javierms.objetivosprofanus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class listaObjetivos extends AppCompatActivity {

    ListView lvObjetivos;
    private ArrayList<CObjetivo> miArrayObjetivos;
    private listAdapter objetivoAdapter;
    Button btnEmpezar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_objetivos);

        Toolbar miToolbar = findViewById(R.id.toolbar);
        miToolbar.setTitle("LISTADO DE OBJETIVOS");
        setSupportActionBar(miToolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        miToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnEmpezar = findViewById(R.id.btnALaGuerra);
        btnEmpezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent miIntent = new Intent(getApplicationContext(), juegoObjetivos.class);
                startActivity(miIntent);
            }
        });

        lvObjetivos = (ListView) findViewById(R.id.lvObjetivos);

        miArrayObjetivos = new ArrayList<CObjetivo>();
        objetivoAdapter = new listAdapter(this, R.layout.list_item, miArrayObjetivos);

        /* ACLARACIÓN: la puntuación es un código, no un número fijo:
        * puntuacion 0 = 1 punto de victoria
        * puntuacion 1 = 1D3 puntos de victoria
        * puntuacion 2 = otra puntuacion, como 1D3+2
        *
        * */
        miArrayObjetivos.add(new CObjetivo(
                11,
                "Objetivo Táctico 1",
                "1 Punto de Victoria si controlas el marcador número 1.",
                false,
                0));
        miArrayObjetivos.add(new CObjetivo(
                12,
                "Objetivo Táctico 2",
                "1 Punto de Victoria si controlas el marcador número 2.",
                false,
                0));
        miArrayObjetivos.add(new CObjetivo(
                13,
                "Objetivo Táctico 3",
                "1 Punto de Victoria si controlas el marcador número 3.",
                false,
                0));
        miArrayObjetivos.add(new CObjetivo(
                14,
                "Objetivo Táctico 4",
                "1 Punto de Victoria si controlas el marcador número 4.",
                false,
                0));
        miArrayObjetivos.add(new CObjetivo(
                15,
                "Objetivo Táctico 5",
                "1 Punto de Victoria si controlas el marcador número 5.",
                false,
                0));
        miArrayObjetivos.add(new CObjetivo(
                16,
                "Objetivo Táctico 6",
                "1 Punto de Victoria si controlas el marcador número 6.",
                false,
                0));
        miArrayObjetivos.add(new CObjetivo(
                21,
                "Objetivo Táctico 1",
                "1 Punto de Victoria si controlas el marcador número 1.",
                false,
                0));
        miArrayObjetivos.add(new CObjetivo(
                22,
                "Objetivo Táctico 2",
                "1 Punto de Victoria si controlas el marcador número 2.",
                false,
                0));
        miArrayObjetivos.add(new CObjetivo(
                23,
                "Objetivo Táctico 3",
                "1 Punto de Victoria si controlas el marcador número 3.",
                false,
                0));
        miArrayObjetivos.add(new CObjetivo(
                24,
                "Objetivo Táctico 4",
                "1 Punto de Victoria si controlas el marcador número 4.",
                false,
                0));
        miArrayObjetivos.add(new CObjetivo(
                25,
                "Objetivo Táctico 5",
                "1 Punto de Victoria si controlas el marcador número 5.",
                false,
                0));
        miArrayObjetivos.add(new CObjetivo(
                26,
                "Objetivo Táctico 6",
                "1 Punto de Victoria si controlas el marcador número 6.",
                false,
                0));
        miArrayObjetivos.add(new CObjetivo(
                31,
                "Objetivo Táctico 1",
                "1 Punto de Victoria si controlas el marcador número 1.",
                false,
                0));
        miArrayObjetivos.add(new CObjetivo(
                32,
                "Objetivo Táctico 2",
                "1 Punto de Victoria si controlas el marcador número 2.",
                false,
                0));
        miArrayObjetivos.add(new CObjetivo(
                33,
                "Objetivo Táctico 3",
                "1 Punto de Victoria si controlas el marcador número 3.",
                false,
                0));
        miArrayObjetivos.add(new CObjetivo(
                34,
                "Objetivo Táctico 4",
                "1 Punto de Victoria si controlas el marcador número 4.",
                false,
                0));
        miArrayObjetivos.add(new CObjetivo(
                35,
                "Objetivo Táctico 5",
                "1 Punto de Victoria si controlas el marcador número 5.",
                false,
                0));
        miArrayObjetivos.add(new CObjetivo(
                36,
                "Objetivo Táctico 6",
                "1 Punto de Victoria si controlas el marcador número 6.",
                false,
                0));
        miArrayObjetivos.add(new CObjetivo(
                41,
                "Controlar la batalla.",
                "1 Punto de Victoria por cada marcador bajo tu control.",
                false,
                0));
        miArrayObjetivos.add(new CObjetivo(
                42,
                "Invadir al enemigo.",
                "1 Punto de Victoria si 1 o más unidades aliadas están a 30cm o menos del borde del tablero enemigo. 1D3 Puntos de Victoria si 3 o más unidades lo están.",
                true,
                1));
        miArrayObjetivos.add(new CObjetivo(
                43,
                "Defender la base.",
                "1 Punto de Victoria si 3 o más unidades aliadas están a menos de 30cm de tu propio borde del talbero y ninguna unidad enemiga lo está.",
                false,
                0));
        miArrayObjetivos.add(new CObjetivo(
                44,
                "Victoria moral.",
                "1D3 Puntos de Victoria si controlas mas marcadores que su adversario.",
                true,
                1));
        miArrayObjetivos.add(new CObjetivo(
                45,
                "Estrategia brillante.",
                "1D3 Puntos de Victoria si controlas, al menos, 2 marcadores y, al menos, el doble que tu adversario.",
                true,
                1));
        miArrayObjetivos.add(new CObjetivo(
                46,
                "Estrategia brillante.",
                "1D3+2 Puntos de Victoria si controlas todos los marcadores del tablero.",
                true,
                2));
        miArrayObjetivos.add(new CObjetivo(
                51,
                "¡Fuego a discreción!",
                "1 Punto de Victoria si destruiste a disparos al menos a una unidad enemiga en tu turno. 1D3 Puntos de Victoria si destruiste a 3 o más unidades.",
                true,
                1));
        miArrayObjetivos.add(new CObjetivo(
                52,
                "¡Rajar y destripar!",
                "1 Punto de Victoria si destruiste cuerpo a cuerpo al menos a una unidad enemiga en tu turno. 1D3 Puntos de Victoria si destruiste a 3 o más unidades.",
                true,
                1));
        miArrayObjetivos.add(new CObjetivo(
                53,
                "Ataque constante.",
                "1 Punto de Victoria si destruiste a una unidad enemiga en tu turno. 1D3 Puntos de Victoria si destruiste a 3 o más unidades.",
                true,
                1));
        miArrayObjetivos.add(new CObjetivo(
                54,
                "Asesinato.",
                "1 Punto de Victoria si destruiste al menos a un personaje independiente enemigo en tu turno. 1D3 Puntos de Victoria si lo hiciste cuerpo a cuerpo.",
                true,
                1));
        miArrayObjetivos.add(new CObjetivo(
                55,
                "Presa del pánico.",
                "1 Punto de Victoria si provocaste chequeos de Moral o Acobardamiento fallidos por el adversario en tu turno. 1D3 Puntos de Victoria si provocaste 3 o más.",
                true,
                1));
        miArrayObjetivos.add(new CObjetivo(
                56,
                "Poder imparable.",
                "1 Punto de Victoria si lograste emplear 2 o más poderes psíquicos sin sufrir peligros de la disformidad. Sino, 1 Punto de Victoria si mataste a una miniatura que puede manifestar poderes psíquicos por cualq medio.",
                false,
                0));
        miArrayObjetivos.add(new CObjetivo(
                61,
                "¡A por su jefe!",
                "1 Punto de Victoria si mataste al menos a un Cuartel General enemigo este turno.",
                false,
                0));
        miArrayObjetivos.add(new CObjetivo(
                62,
                "A por los herejes.",
                "1 Punto de Victoria si mataste al menos a una unidad enemiga que pueda lanzar poderes psíquicos. 1D3 Puntos de Victoria si mataste a 3 o más.",
                true,
                1));
        miArrayObjetivos.add(new CObjetivo(
                63,
                "Despejar el cielo.",
                "1 Punto de Victoria si destruiste al menos a una unidad enemiga de tipo retropropulsada o gravítico este turno. 1D3 Puntos de Victoria si destruiste a 3 o más.",
                true,
                1));
        miArrayObjetivos.add(new CObjetivo(
                64,
                "Perdición de las bestias.",
                "1 Punto de Victoria si destruiste al menos a un vehículo o criatura monstruosa (incluidos gargantuescas y superpesados) este turno. 1D3 Puntos de Victoria si destruiste a 3 o más.",
                true,
                1));
        miArrayObjetivos.add(new CObjetivo(
                65,
                "Reducir a escombros.",
                "1 Punto de Victoria si destruiste al menos un edificio enemigo este turno; Si no hay edificios, lo obtienes si destruiste a una unidad enemiga en ruinas este turno. 1D3 Puntos de Victoria si destruiste a 3 o más.",
                true,
                1));
        miArrayObjetivos.add(new CObjetivo(
                66,
                "Cazador de titanes.",
                "1 Punto de Victoria si destruiste al menos un vehículo enemigo con resistencia 7 o superior o a una criatura monstruosa (o gargantuesca) cuyas heridas iniciales fueran 6 o más este turno.",
                false,
                0));

        objetivoAdapter.notifyDataSetChanged();
        lvObjetivos.setAdapter(objetivoAdapter);

        lvObjetivos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(), objetivoDetalle.class);
                intent.putExtra("objetivo", miArrayObjetivos.get(position));
                startActivity(intent);


            }
        });



    } // final onCreate
}