package com.dsi.com.dsi.model;

public class DiaSemana {
    private String nombre;

    public DiaSemana(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "DiaSemana{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
