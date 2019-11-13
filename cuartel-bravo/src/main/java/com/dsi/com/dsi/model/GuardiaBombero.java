package com.dsi.com.dsi.model;

import java.security.Guard;
import java.sql.Time;
import java.util.Date;

public class GuardiaBombero {
    private String horaDesde;
    private String horaHasta;
    private String motivoRechazo;
    private Bombero bombero;
    private Estado estado;
    private DiaSemana dia;

    public GuardiaBombero(String horaDesde, String horaHasta, Bombero bombero, Estado estado, DiaSemana dia) {
        this.horaDesde = horaDesde;
        this.horaHasta = horaHasta;
        this.bombero = bombero;
        this.estado = estado;
        this.dia = dia;
    }

    public GuardiaBombero(String horaDesde, String horaHasta, String motivoRechazo, Bombero bombero, Estado estado) {
        this.horaDesde = horaDesde;
        this.horaHasta = horaHasta;
        this.motivoRechazo = motivoRechazo;
        this.bombero = bombero;
        this.estado = estado;
    }

    public String getHoraDesde() {
        return horaDesde;
    }

    public void setHoraDesde(String horaDesde) {
        this.horaDesde = horaDesde;
    }

    public String getHoraHasta() {
        return horaHasta;
    }

    public void setHoraHasta(String horaHasta) {
        this.horaHasta = horaHasta;
    }

    public String getMotivoRechazo() {
        return motivoRechazo;
    }

    public void setMotivoRechazo(String motivoRechazo) {
        this.motivoRechazo = motivoRechazo;
    }

    public Bombero getBombero() {
        return bombero;
    }

    public void setBombero(Bombero bombero) {
        this.bombero = bombero;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public DiaSemana getDia() {
        return dia;
    }

    public void setDia(DiaSemana dia) {
        this.dia = dia;
    }

    @Override
    public String toString() {
        return  "Hora desde: " + horaDesde +
                "\n\t\t Hora hasta: " + horaHasta +
                "\n\t\t Motivo rechazo: " + motivoRechazo +
                "\n\t\t Bombero: " + bombero.getApellido() + ", " + bombero.getNombre() +
                "\n\t\t Estado: " + estado.getNombre() +
                "\n\t\t Dia: " + dia.getNombre();
    }

    public void registrarIngreso(String fechaHoraLlegada){
        this.estado.registrarIngreso( this, this.bombero, fechaHoraLlegada);
    }

    public boolean estaEnCurso(){
        return this.estado.getNombre().equals("EnCurso");
    }

    public boolean esDeBombero(Bombero bombero){
        return this.bombero==bombero;
    }
}
