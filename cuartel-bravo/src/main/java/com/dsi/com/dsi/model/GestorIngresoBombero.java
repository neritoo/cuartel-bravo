package com.dsi.com.dsi.model;

import java.util.ArrayList;

//Alternativas del caso de uso dentro de cada metodo

public class GestorIngresoBombero {
    private ArrayList<Bombero> bomberos;

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    private ArrayList<GuardiaBombero> guardias;
    private GuardiaBombero guardiaSeleccionada;
    private ArrayList<ProgramacionGuardia> programaciones;
    private ProgramacionGuardia programacionVigente;
    private Bombero bomberoSeleccionado;

    public GestorIngresoBombero(){
        this.cargarDatos();
    }

    public void cargarDatos(){
        //Método que crea distintas instancias simulando una base de datos.

        this.bomberos = new ArrayList<>();
        this.guardias = new ArrayList<>();
        this.programaciones = new ArrayList<>();
        Bombero b1 = new Bombero(true,"Gavilan","Ezequiel","Arquimedes 3012",
                "39058250", "3512483758", "ezegavilan95@gmail.com", "12/09/1995");
        Bombero b2 = new Bombero(true,"Ledesma","Lisandro","Octavio Pintos 124",
                "41354987", "3534876254", "licha@gmail.com", "28/01/1998");
        Bombero b3 = new Bombero(false,"Funes","Francisco","Calazans 541",
                "20123487", "351469852", "fran@gmail.com", "10/11/1997");

        DiaSemana lunes = new DiaSemana("Lunes");
        DiaSemana martes = new DiaSemana("Martes");
        DiaSemana miercoles = new DiaSemana("Miercoles");
        DiaSemana jueves = new DiaSemana("Jueves");
        DiaSemana viernes = new DiaSemana("Viernes");

        Estado estadoGuardia = new EnCurso("EnCurso","La guardia se encuentra en curso");
        Estado estadoGuardia1 = new Finalizada("Finalizada", "La guardia finalizó");

        GuardiaBombero guardiaBombero1 = new GuardiaBombero("12:00", "18:00", b1, estadoGuardia1, lunes);
        GuardiaBombero guardiaBombero2 = new GuardiaBombero("09:00", "12:00", b1, estadoGuardia, martes);
        GuardiaBombero guardiaBombero3 = new GuardiaBombero("09:00", "12:00", b3, estadoGuardia, jueves);

        this.guardias.add(guardiaBombero1);
        this.guardias.add(guardiaBombero2);
        this.guardias.add(guardiaBombero3);

        this.bomberos.add(b1);
        this.bomberos.add(b2);
        this.bomberos.add(b3);

        Estado estadoProgramacion = new EnCurso("EnCurso","La programación se encuentra en curso");
        ProgramacionGuardia programacionGuardia = new ProgramacionGuardia("10/10/2019", "10/11/2019", estadoProgramacion, true);
        ProgramacionGuardia programacionGuardia1 = new ProgramacionGuardia("15/01/2019", "15/02/2019", null, false);

        programacionGuardia.agregarGuardia(guardiaBombero1);
        programacionGuardia.agregarGuardia(guardiaBombero2);
        programacionGuardia.agregarGuardia(guardiaBombero3);

        this.programaciones.add(programacionGuardia);
        this.programaciones.add(programacionGuardia1);

        Asistencia asistencia = new Asistencia("11/11/2019 - 12:00hs", "11/11/2019 - 18:00hs", guardiaBombero1);
        b1.registrarIngreso(asistencia);


    }

        public void tomarDatosIngreso( String dniBombero, String fechaHoraIngreso ){
        //this.dniIngresado = dniBombero;
        //this.fechaHoraIngreso = fechaHoraIngreso;
        this.verificarBomberoActivo(dniBombero, fechaHoraIngreso);
    }

    public void verificarBomberoActivo( String dniBombero, String fechaHoraIngreso ) throws NullPointerException{
        Bombero b = null;
        boolean flag=false;
        for (Bombero bombero : this.bomberos) {
            if (bombero.esDelDNI(dniBombero)) {
                b = bombero;
                flag = true;
                break;
            }
        }

        if(b != null && b.esActivo()) {
            this.bomberoSeleccionado = b;
        }
        else{
            flag=false;
        }

        if (flag){
            this.verificarAsistenciaPrevia(fechaHoraIngreso);
        }
        else{
            System.out.println("El bombero no existe / no es activo");
            this.finCasoDeUso();
        }
    }

    public void verificarAsistenciaPrevia(String fechaHoraIngreso){
        boolean flag = false;
        ArrayList<Asistencia> asistencias = this.bomberoSeleccionado.getAsistencias();
        for (Asistencia asistencia : asistencias) {
            //No se resuelve el this.verificarProgramacion... aca porque necesitamos recorrer todas las asistencias,
            //y que todas tengan una fecha de salida asignada.
            if (asistencia.tieneFechaHoraSalida()) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        //Si todas las asistencias tienen hora de salida, o si no existe asistencia registrada
        //al bombero, se continua.
        if (flag  || asistencias.size() == 0){
            this.verificarProgramacionGuardiaExistenteYEnCurso(fechaHoraIngreso);
        }
        //Si se encuentra una sola asistencia sin salida, se debe registrar el ingreso.
        else{
            System.out.println("Asistencia previa sin egreso registrado");
            /*Se instancia el gestor egreso bombero para registrar la salida de la asistencia previa.
            GestorEgresoBombero gestor = new GestorEgresoBombero();
            gestor.registrarEgreso();...*/
        }
    }

    public void verificarProgramacionGuardiaExistenteYEnCurso(String fechaHoraIngreso) {
        for (ProgramacionGuardia programacion : this.programaciones) {
            if (programacion.sosVigente()) {
                this.programacionVigente = programacion;
                break;
            }
        }
        if (this.programacionVigente.estaEnCurso()){
            this.verificarGuardiaEnCursoYDeBombero(fechaHoraIngreso);
        }
        else{
            System.out.println("No existe ninguna programacion de guardias en curso.");
            this.finCasoDeUso();
        }
    }

    public void verificarGuardiaEnCursoYDeBombero(String fechaHoraIngreso){
        boolean flagEnCurso=false;
        ArrayList<GuardiaBombero> guardias = this.programacionVigente.getGuardias();
        for (GuardiaBombero guardia : guardias) {
            if ( guardia.estaEnCurso() && guardia.esDeBombero(guardia.getBombero()) ) {
                this.guardiaSeleccionada = guardia;
                flagEnCurso=true;
                break;
            }
        }
        if (flagEnCurso){
            this.registrarNuevaAsistencia(fechaHoraIngreso);
        }
        else{
            System.out.println("El bombero identificado no tiene ninguna guardia en curso");
            this.finCasoDeUso();
        }
        this.guardias.toArray();
    }

    public void registrarNuevaAsistencia(String fechaHoraIngreso){
        this.guardiaSeleccionada.registrarIngreso(fechaHoraIngreso);
        System.out.println("\033[32m\t\t\t\t\t\t\t\t\t\t***Se registraron correctamente los datos de ingreso de" +
                "\n\t\t\t\t\t\t\t\t\t\tun bombero al cuartel desde el lector de huellas*** \u001B[0m\n");
        System.out.println(this.bomberoSeleccionado);
        this.finCasoDeUso();
    }

    public void finCasoDeUso(){
        System.out.println("\nFin caso de uso");
    }



}
