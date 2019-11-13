package com.dsi.com.dsi.model;

public class Asistencia {
    private String fechaHoraLlegada;
    private String fechaHoraSalida;
    private GuardiaBombero guardiaBombero;

    public Asistencia (String fechaHoraLlegada){
        this.fechaHoraLlegada = fechaHoraLlegada;
        this.fechaHoraSalida = "";
    }

    public Asistencia (String fechaHoraLlegada, GuardiaBombero guardiaBombero){
        this.fechaHoraLlegada = fechaHoraLlegada;
        this.guardiaBombero = guardiaBombero;
        this.fechaHoraSalida = "";
    }
    public Asistencia(String fechaHoraLlegada, String fechaHoraSalida, GuardiaBombero guardiaBombero) {
        this.fechaHoraLlegada = fechaHoraLlegada;
        this.fechaHoraSalida = fechaHoraSalida;
        this.guardiaBombero = guardiaBombero;
    }

    public String getFechaHoraLlegada() {
        return fechaHoraLlegada;
    }

    public void setFechaHoraLlegada(String fechaHoraLlegada) {
        this.fechaHoraLlegada = fechaHoraLlegada;
    }

    public String getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public void setFechaHoraSalida(String fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    public GuardiaBombero getGuardiaBombero() {
        return guardiaBombero;
    }

    public void setGuardiaBombero(GuardiaBombero guardiaBombero) {
        this.guardiaBombero = guardiaBombero;
    }

    @Override
    public String toString() {
        return "Asistencia{" +
                "fechaHoraLlegada='" + fechaHoraLlegada + '\'' +
                ", fechaHoraSalida='" + fechaHoraSalida + '\'' +
                '}';
    }

    public boolean tieneFechaHoraSalida(){
        return !fechaHoraSalida.equals("");
    }
}
