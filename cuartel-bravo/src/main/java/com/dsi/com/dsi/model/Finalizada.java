package com.dsi.com.dsi.model;

public class Finalizada extends Estado {

    public Finalizada(String nombre, String descripcion) {
        super(nombre, descripcion);
    }

    @Override
    public Asistencia registrarIngreso(GuardiaBombero guardiaCurso, Bombero bombero, String fechaHoraLlegada) {
        return null;
    }
}
