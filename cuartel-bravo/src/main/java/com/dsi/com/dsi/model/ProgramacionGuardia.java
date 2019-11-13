package com.dsi.com.dsi.model;

import java.util.ArrayList;

public class ProgramacionGuardia {
    private String fechaDesde;
    private String fechaHasta;
    private boolean vigente;
    private ArrayList<GuardiaBombero> guardias;
    private Estado estado;

    public ProgramacionGuardia() {
        this.guardias = new ArrayList<>();
    }

    public ProgramacionGuardia(String fechaDesde, String fechaHasta, Estado estado, boolean vigente) {
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.vigente = vigente;
        this.estado = estado;
        this.guardias = new ArrayList<>();
    }

    public String getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(String fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public String getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(String fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }


    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

    public ArrayList<GuardiaBombero> getGuardias() {
        return guardias;
    }

    public void setGuardias(ArrayList<GuardiaBombero> guardias) {
        this.guardias = guardias;
    }

    @Override
    public String toString() {
        return "ProgramacionGuardia{" +
                "fechaDesde='" + fechaDesde + '\'' +
                ", fechaHasta='" + fechaHasta + '\'' +
                '}';
    }

    public boolean sosVigente(){
        return this.vigente;
    }

    public boolean estaEnCurso(){
        return estado.getNombre().equals("EnCurso");
    }

    public void agregarGuardia(GuardiaBombero g){
        this.guardias.add(g);
    }

}
