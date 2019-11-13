package com.dsi.com.dsi.model;

public abstract class Estado {
    private String nombre;
    private String descripcion;

    public Estado(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    public abstract Asistencia registrarIngreso(GuardiaBombero guardiaCurso, Bombero bombero, String fechaHoraLlegada );
}
