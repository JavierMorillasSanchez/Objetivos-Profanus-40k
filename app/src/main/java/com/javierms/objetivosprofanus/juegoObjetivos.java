package com.javierms.objetivosprofanus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;

import java.util.ArrayList;
import java.util.Random;

public class juegoObjetivos extends AppCompatActivity {

    ListView lvJuegoObjetivos;
    private ArrayList<CObjetivo> miArrayJuegoObjetivos, miArrayUso;
    private listAdapter objetivoUsoAdapter;
    Random miRandom;
    CObjetivo varNuevoObjetivo;
    Integer randomNum;
    Integer puntuacionTotal = 0;
    CheckBox cbDescartar;
    TextView txtPuntosTotales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_objetivos);

        Toolbar miToolbar = findViewById(R.id.toolbar);
        miToolbar.setTitle("MIS OBJETIVOS ACTUALES");
        setSupportActionBar(miToolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        miToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        cbDescartar = findViewById(R.id.cbDescartar);

        txtPuntosTotales = findViewById(R.id.txtPuntosTotales);

        lvJuegoObjetivos = findViewById(R.id.lvJuegoObjetivos);

        miArrayJuegoObjetivos = new ArrayList<>(); // de aqui saco los objetivos a mostrar

        miArrayUso = new ArrayList<>(); // aqui meto los objetivos que muestro

        miArrayUso.clear();

        objetivoUsoAdapter = new listAdapter(this, R.layout.list_item, miArrayUso);

        miArrayJuegoObjetivos.add(new CObjetivo(
                11,
                "Objetivo T??ctico 1",
                "1 Punto de Victoria si controlas el marcador n??mero 1.",
                false,
                0));
        miArrayJuegoObjetivos.add(new CObjetivo(
                12,
                "Objetivo T??ctico 2",
                "1 Punto de Victoria si controlas el marcador n??mero 2.",
                false,
                0));
        miArrayJuegoObjetivos.add(new CObjetivo(
                13,
                "Objetivo T??ctico 3",
                "1 Punto de Victoria si controlas el marcador n??mero 3.",
                false,
                0));
        miArrayJuegoObjetivos.add(new CObjetivo(
                14,
                "Objetivo T??ctico 4",
                "1 Punto de Victoria si controlas el marcador n??mero 4.",
                false,
                0));
        miArrayJuegoObjetivos.add(new CObjetivo(
                15,
                "Objetivo T??ctico 5",
                "1 Punto de Victoria si controlas el marcador n??mero 5.",
                false,
                0));
        miArrayJuegoObjetivos.add(new CObjetivo(
                16,
                "Objetivo T??ctico 6",
                "1 Punto de Victoria si controlas el marcador n??mero 6.",
                false,
                0));
        miArrayJuegoObjetivos.add(new CObjetivo(
                21,
                "Objetivo T??ctico 1",
                "1 Punto de Victoria si controlas el marcador n??mero 1.",
                false,
                0));
        miArrayJuegoObjetivos.add(new CObjetivo(
                22,
                "Objetivo T??ctico 2",
                "1 Punto de Victoria si controlas el marcador n??mero 2.",
                false,
                0));
        miArrayJuegoObjetivos.add(new CObjetivo(
                23,
                "Objetivo T??ctico 3",
                "1 Punto de Victoria si controlas el marcador n??mero 3.",
                false,
                0));
        miArrayJuegoObjetivos.add(new CObjetivo(
                24,
                "Objetivo T??ctico 4",
                "1 Punto de Victoria si controlas el marcador n??mero 4.",
                false,
                0));
        miArrayJuegoObjetivos.add(new CObjetivo(
                25,
                "Objetivo T??ctico 5",
                "1 Punto de Victoria si controlas el marcador n??mero 5.",
                false,
                0));
        miArrayJuegoObjetivos.add(new CObjetivo(
                26,
                "Objetivo T??ctico 6",
                "1 Punto de Victoria si controlas el marcador n??mero 6.",
                false,
                0));
        miArrayJuegoObjetivos.add(new CObjetivo(
                31,
                "Objetivo T??ctico 1",
                "1 Punto de Victoria si controlas el marcador n??mero 1.",
                false,
                0));
        miArrayJuegoObjetivos.add(new CObjetivo(
                32,
                "Objetivo T??ctico 2",
                "1 Punto de Victoria si controlas el marcador n??mero 2.",
                false,
                0));
        miArrayJuegoObjetivos.add(new CObjetivo(
                33,
                "Objetivo T??ctico 3",
                "1 Punto de Victoria si controlas el marcador n??mero 3.",
                false,
                0));
        miArrayJuegoObjetivos.add(new CObjetivo(
                34,
                "Objetivo T??ctico 4",
                "1 Punto de Victoria si controlas el marcador n??mero 4.",
                false,
                0));
        miArrayJuegoObjetivos.add(new CObjetivo(
                35,
                "Objetivo T??ctico 5",
                "1 Punto de Victoria si controlas el marcador n??mero 5.",
                false,
                0));
        miArrayJuegoObjetivos.add(new CObjetivo(
                36,
                "Objetivo T??ctico 6",
                "1 Punto de Victoria si controlas el marcador n??mero 6.",
                false,
                0));
        miArrayJuegoObjetivos.add(new CObjetivo(
                41,
                "Controlar la batalla.",
                "1 Punto de Victoria por cada marcador bajo tu control.",
                false,
                0));
        miArrayJuegoObjetivos.add(new CObjetivo(
                42,
                "Invadir al enemigo.",
                "1 Punto de Victoria si 1 o m??s unidades aliadas est??n a 30cm o menos del borde del tablero enemigo. 1D3 Puntos de Victoria si 3 o m??s unidades lo est??n.",
                true,
                1));
        miArrayJuegoObjetivos.add(new CObjetivo(
                43,
                "Defender la base.",
                "1 Punto de Victoria si 3 o m??s unidades aliadas est??n a menos de 30cm de tu propio borde del talbero y ninguna unidad enemiga lo est??.",
                false,
                0));
        miArrayJuegoObjetivos.add(new CObjetivo(
                44,
                "Victoria moral.",
                "1D3 Puntos de Victoria si controlas mas marcadores que su adversario.",
                true,
                1));
        miArrayJuegoObjetivos.add(new CObjetivo(
                45,
                "Estrategia brillante.",
                "1D3 Puntos de Victoria si controlas, al menos, 2 marcadores y, al menos, el doble que tu adversario.",
                true,
                1));
        miArrayJuegoObjetivos.add(new CObjetivo(
                46,
                "Estrategia brillante.",
                "1D3+2 Puntos de Victoria si controlas todos los marcadores del tablero.",
                true,
                2));
        miArrayJuegoObjetivos.add(new CObjetivo(
                51,
                "??Fuego a discreci??n!",
                "1 Punto de Victoria si destruiste a disparos al menos a una unidad enemiga en tu turno. 1D3 Puntos de Victoria si destruiste a 3 o m??s unidades.",
                true,
                1));
        miArrayJuegoObjetivos.add(new CObjetivo(
                52,
                "??Rajar y destripar!",
                "1 Punto de Victoria si destruiste cuerpo a cuerpo al menos a una unidad enemiga en tu turno. 1D3 Puntos de Victoria si destruiste a 3 o m??s unidades.",
                true,
                1));
        miArrayJuegoObjetivos.add(new CObjetivo(
                53,
                "Ataque constante.",
                "1 Punto de Victoria si destruiste a una unidad enemiga en tu turno. 1D3 Puntos de Victoria si destruiste a 3 o m??s unidades.",
                true,
                1));
        miArrayJuegoObjetivos.add(new CObjetivo(
                54,
                "Asesinato.",
                "1 Punto de Victoria si destruiste al menos a un personaje independiente enemigo en tu turno. 1D3 Puntos de Victoria si lo hiciste cuerpo a cuerpo.",
                true,
                1));
        miArrayJuegoObjetivos.add(new CObjetivo(
                55,
                "Presa del p??nico.",
                "1 Punto de Victoria si provocaste chequeos de Moral o Acobardamiento fallidos por el adversario en tu turno. 1D3 Puntos de Victoria si provocaste 3 o m??s.",
                true,
                1));
        miArrayJuegoObjetivos.add(new CObjetivo(
                56,
                "Poder imparable.",
                "1 Punto de Victoria si lograste emplear 2 o m??s poderes ps??quicos sin sufrir peligros de la disformidad. Sino, 1 Punto de Victoria si mataste a una miniatura que puede manifestar poderes ps??quicos por cualq medio.",
                false,
                0));
        miArrayJuegoObjetivos.add(new CObjetivo(
                61,
                "??A por su jefe!",
                "1 Punto de Victoria si mataste al menos a un Cuartel General enemigo este turno.",
                false,
                0));
        miArrayJuegoObjetivos.add(new CObjetivo(
                62,
                "A por los herejes.",
                "1 Punto de Victoria si mataste al menos a una unidad enemiga que pueda lanzar poderes ps??quicos. 1D3 Puntos de Victoria si mataste a 3 o m??s.",
                true,
                1));
        miArrayJuegoObjetivos.add(new CObjetivo(
                63,
                "Despejar el cielo.",
                "1 Punto de Victoria si destruiste al menos a una unidad enemiga de tipo retropropulsada o grav??tico este turno. 1D3 Puntos de Victoria si destruiste a 3 o m??s.",
                true,
                1));
        miArrayJuegoObjetivos.add(new CObjetivo(
                64,
                "Perdici??n de las bestias.",
                "1 Punto de Victoria si destruiste al menos a un veh??culo o criatura monstruosa (incluidos gargantuescas y superpesados) este turno. 1D3 Puntos de Victoria si destruiste a 3 o m??s.",
                true,
                1));
        miArrayJuegoObjetivos.add(new CObjetivo(
                65,
                "Reducir a escombros.",
                "1 Punto de Victoria si destruiste al menos un edificio enemigo este turno; Si no hay edificios, lo obtienes si destruiste a una unidad enemiga en ruinas este turno. 1D3 Puntos de Victoria si destruiste a 3 o m??s.",
                true,
                1));
        miArrayJuegoObjetivos.add(new CObjetivo(
                66,
                "Cazador de titanes.",
                "1 Punto de Victoria si destruiste al menos un veh??culo enemigo con resistencia 7 o superior o a una criatura monstruosa (o gargantuesca) cuyas heridas iniciales fueran 6 o m??s este turno.",
                false,
                0));

        objetivoUsoAdapter.notifyDataSetChanged();

        lvJuegoObjetivos.setAdapter(objetivoUsoAdapter);

        lvJuegoObjetivos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if(!cbDescartar.isChecked()) {

                        AlertDialog.Builder builder = new AlertDialog.Builder(juegoObjetivos.this);
                        builder.setTitle("??Has cumplido el objetivo?");
                        builder.setCancelable(false);
                        builder.setMessage("" + miArrayUso.get(position).getNombre() + "\n\n" + miArrayUso.get(position).getDescripcion());

                        if (miArrayUso.get(position).getPuntuacion() == 0) {

                            builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    puntuacionTotal = puntuacionTotal + 1;
                                    txtPuntosTotales.setText("PV: " + puntuacionTotal);
                                    Toast.makeText(getApplicationContext(), "Has ganado 1 Punto de Victoria", Toast.LENGTH_SHORT).show();
                                    nuevoObjetivo();
                                    miArrayUso.remove(position);
                                    objetivoUsoAdapter.notifyDataSetChanged();

                                }
                            });
                        } else {

                            builder.setPositiveButton("1D3 PV", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    actualizarPuntuacion(miArrayUso.get(position));
                                    nuevoObjetivo();
                                    miArrayUso.remove(position);
                                    objetivoUsoAdapter.notifyDataSetChanged();

                                }
                            });

                            builder.setNegativeButton("1 PV", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    puntuacionTotal = puntuacionTotal + 1;
                                    txtPuntosTotales.setText("PV: " + puntuacionTotal);
                                    Toast.makeText(getApplicationContext(), "Has ganado 1 Punto de Victoria", Toast.LENGTH_SHORT).show();
                                    nuevoObjetivo();
                                    miArrayUso.remove(position);
                                    objetivoUsoAdapter.notifyDataSetChanged();
                                }
                            });

                        }

                        builder.setNeutralButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });

                        builder.create().show();
                    } else {

                        AlertDialog.Builder builder = new AlertDialog.Builder(juegoObjetivos.this);
                        builder.setTitle("??Descartar Objetivo?");
                        builder.setCancelable(false);
                        builder.setMessage("??Quieres descartar el objetivo " + miArrayUso.get(position).getNombre() + "?"+
                        "\n\nNo conseguir??s Puntos de Victoria pero podr??s obtener un nuevo objetivo.");

                        builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                nuevoObjetivo();
                                miArrayUso.remove(position);
                                objetivoUsoAdapter.notifyDataSetChanged();
                            }
                        });

                        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });

                        builder.create().show();

                    }
                }
            });

        for(int i = 0; i < 3; i++){
            nuevoObjetivo();
        }

    }


    public void nuevoObjetivo(){

        miRandom = new Random();
        randomNum = miRandom.nextInt((35 - 1) + 1) + 1;
        varNuevoObjetivo = miArrayJuegoObjetivos.get(randomNum);
        miArrayUso.add(varNuevoObjetivo);

    }

    public void actualizarPuntuacion(CObjetivo puntosObjetivo){

        Integer puntos = puntosObjetivo.getPuntuacion();

        if(puntos == 2){

            miRandom = new Random();
            randomNum = miRandom.nextInt((3 - 1) + 1) + 1 + 2;
            puntuacionTotal = puntuacionTotal + randomNum;
            Toast.makeText(getApplicationContext(), "Has ganado "+randomNum+ " Puntos de Victoria",Toast.LENGTH_SHORT).show();

            txtPuntosTotales.setText("PV: "+puntuacionTotal);

        } else if (puntos == 1){

            miRandom = new Random();
            randomNum = miRandom.nextInt((3 - 1) + 1) + 1;
            puntuacionTotal = puntuacionTotal + randomNum;
            txtPuntosTotales.setText("PV: "+puntuacionTotal);
            if(randomNum == 1){
                Toast.makeText(getApplicationContext(), "Has ganado 1 Punto de Victoria",Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Has ganado "+randomNum+ " Puntos de Victoria",Toast.LENGTH_SHORT).show();
            }

        } else {
            puntuacionTotal = puntuacionTotal + 1;
            txtPuntosTotales.setText("PV: "+puntuacionTotal);
            Toast.makeText(getApplicationContext(), "Has ganado 1 Punto de Victoria",Toast.LENGTH_SHORT).show();
        }

    }

}