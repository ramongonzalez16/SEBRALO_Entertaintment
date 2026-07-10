/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JInternalFrame;

/**
 *
 * @author Fa Barrera González
 */
public class Cronometro implements ActionListener {

    /*
    Variables de iniciacion del cronometro, usadas para utilizar el cronometro 
    en las mismas
    */
    public JInternalFrame ventana;
    public String texto;

    /**
     * Constructor del cronometro
     * @param ventana Ventana a mostrar el cronometro
     * @param texto texto que se va a mostrar en la ventana
     */
    public Cronometro(JInternalFrame ventana, String texto) {
        this.ventana = ventana;
        this.texto= texto;
    }

    /**
     * Metodo que pone a correr el cronometro a partir de la hora y fecha actual
     * @param evt 
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        GregorianCalendar tiempo = new GregorianCalendar();
        String ampm = "";
        if (tiempo.get(Calendar.AM_PM) == 0) {
            ampm = "AM";
        } else {
            ampm = "PM";
        }
        String diaSemana = "";
        if (tiempo.get(Calendar.DAY_OF_WEEK) == 1) {
            diaSemana = "Domingo";
        }
        if (tiempo.get(Calendar.DAY_OF_WEEK) == 2) {
            diaSemana = "Lunes";
        }
        if (tiempo.get(Calendar.DAY_OF_WEEK) == 3) {
            diaSemana = "Martes";
        }
        if (tiempo.get(Calendar.DAY_OF_WEEK) == 4) {
            diaSemana = "Miercoles";
        }
        if (tiempo.get(Calendar.DAY_OF_WEEK) == 5) {
            diaSemana = "Jueves";
        }
        if (tiempo.get(Calendar.DAY_OF_WEEK) == 6) {
            diaSemana = "Viernes";
        }
        if (tiempo.get(Calendar.DAY_OF_WEEK) == 7) {
            diaSemana = "Sabado";
        }
        String mesLetras = "";
        if (tiempo.get(Calendar.MONTH) == 0) {
            mesLetras = "Enero";
        }
        if (tiempo.get(Calendar.MONTH) == 1) {
            mesLetras = "Febero";
        }
        if (tiempo.get(Calendar.MONTH) == 2) {
            mesLetras = "Marzo";
        }
        if (tiempo.get(Calendar.MONTH) == 3) {
            mesLetras = "Abril";
        }
        if (tiempo.get(Calendar.MONTH) == 4) {
            mesLetras = "Mayo";
        }
        if (tiempo.get(Calendar.MONTH) == 5) {
            mesLetras = "Junio";
        }
        if (tiempo.get(Calendar.MONTH) == 6) {
            mesLetras = "Julio";
        }
        if (tiempo.get(Calendar.MONTH) == 7) {
            mesLetras = "Agosto";
        }
        if (tiempo.get(Calendar.MONTH) == 8) {
            mesLetras = "Septiembre";
        }
        if (tiempo.get(Calendar.MONTH) == 9) {
            mesLetras = "Octubre";
        }
        if (tiempo.get(Calendar.MONTH) == 10) {
            mesLetras = "Noviembre";
        }
        if (tiempo.get(Calendar.MONTH) == 11) {
            mesLetras = "Diciembre";
        }
        String dia = Integer.toString(tiempo.get(Calendar.DATE));
        String annio = Integer.toString(tiempo.get(Calendar.YEAR));
        int hora = tiempo.get(Calendar.HOUR_OF_DAY);
        if (hora == 0) {
            hora = 12;
        } else {
            if (hora > 12) {
                hora = hora-12;
            }
        }
        int minuto = tiempo.get(Calendar.MINUTE);
        int segundo = tiempo.get(Calendar.SECOND);
        ventana.setTitle(diaSemana + " " + dia + " de " + mesLetras + " de " + annio + "; "
                + "" + hora + ":" + minuto + ":" + segundo + " " + ampm 
                +"                                                             "+texto);
    }
}
