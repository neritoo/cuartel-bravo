package com.dsi.com.dsi.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Bombero {
    private boolean activo;
    private String apellido;
    private String nombre;
    private String direccion;
    private String dni;
    private String telefono;
    private String email;
    private String fechaNacimiento;
    private ArrayList<Asistencia> asistencias;

    public Bombero(boolean activo, String apellido, String nombre, String direccion, String dni, String telefono, String email, String fechaNacimiento) {
        this.activo = activo;
        this.apellido = apellido;
        this.nombre = nombre;
        this.direccion = direccion;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.asistencias = new ArrayList<>();

    }

    public boolean esActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public ArrayList<Asistencia> getAsistencias() {
        return asistencias;
    }

    //mostrarDatos()
    @Override
    public String toString() {
        return "Bombero:\n" +
                "\nNombre: " + apellido + ", " + nombre +
                "\nDirección: " + direccion +
                "\nN° documento: " + dni +
                "\nN° teléfono: " + telefono +
                "\nEmail: " + email +
                "\nFecha de nacimiento: " + fechaNacimiento +
                "\nAsistencias:\n{" + this.mostrarAsistencias() +
                "\n}";
    }

    public void registrarIngreso(Asistencia asistencia){
        this.asistencias.add(asistencia);
    }

    public String mostrarAsistencias(){
        Asistencia asistencia;
        StringBuilder msg = new StringBuilder();
        Iterator<Asistencia> iterator = this.asistencias.iterator();
        while(iterator.hasNext()){
            asistencia = iterator.next();

            msg.append("\nLlegada: ") .append(asistencia.getFechaHoraLlegada());
            msg.append("\nSalida: ") .append(asistencia.getFechaHoraSalida());
            msg.append("\nGuardia: ") .append(asistencia.getGuardiaBombero());

        }
        return msg.toString();
    }

    public void obtenerDisponibilidad(){

    }

    public boolean validarDiaHorarioGuardia(){
        return false;
    }

    public Asistencia obtenerAsistenciasEnPeriodo(){
        return null;
    }

    public boolean asistiEnFecha(){
        return false;
    }

    public boolean esDelDNI(String dni){
        return this.dni.equals(dni);
    }
}
