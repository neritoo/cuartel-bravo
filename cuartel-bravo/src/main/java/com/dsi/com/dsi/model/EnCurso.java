package com.dsi.com.dsi.model;

public class EnCurso extends Estado {


    public EnCurso(String nombre, String descripcion) {
        super(nombre, descripcion);
    }


    public Asistencia crearAsistencia( String fechaHoraLlegada, GuardiaBombero guardiaCurso ){
        Asistencia asistencia = new Asistencia(fechaHoraLlegada, guardiaCurso);
        return asistencia;
    }

    @Override
    public Asistencia registrarIngreso( GuardiaBombero guardiaCurso, Bombero bombero, String fechaHoraLlegada ){
        Asistencia asistencia = crearAsistencia(fechaHoraLlegada, guardiaCurso);
        bombero.registrarIngreso(asistencia);
        return asistencia;
    }


}
