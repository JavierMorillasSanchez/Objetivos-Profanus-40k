package com.javierms.objetivosprofanus;

import android.content.Intent;

import java.io.Serializable;

public class CObjetivo implements Serializable {

    public CObjetivo(Integer id, String nombre, String descripcion, Boolean multiple, Integer puntuacion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.multiple = multiple;
        this.puntuacion = puntuacion;
    }

    private Integer id;
    private String nombre;
    private String descripcion;
    private Boolean multiple;
    private Integer puntuacion;

    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public boolean getMultiple() {
        return multiple;
    }
    public int getPuntuacion() {
        return puntuacion;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDescripcion(String resultado) {
        this.descripcion = resultado;
    }
    public void setMultiple(boolean multiple) {
        this.multiple = multiple;
    }
    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }


}
