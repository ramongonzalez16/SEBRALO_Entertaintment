/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author F González Barrera
 */
public class Tipo_Documento {

    /*
      id, nombre, descripcion
    */
    private int id;//Número de identificación del tipo de documento
    private String nombre;//Nombre del tipo docuemto, puede ser tarjeta de identidad o cedula
    /*
      variables bandera
    */
    public final static String[] ATRIBUTOS={"id","nombre"};
    public final static String ARCHIVO = "Tipo_Documento.txt";
    
    /**
     * Constructor vacio
     */
    public Tipo_Documento() {
    }

    /**
     * Constructor con parametros
     * @param id - Número de identificación del tipo de documento
     * @param nombre - Nombre del tipo usuario, puede ser tarjeta de identidad o cedula
     */
    public Tipo_Documento(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * Getter del Número de identificación del tipo de documento
     * @return Número de identificación del tipo de documento
     */
    public int getId() {
        return id;
    }

    /**
     * Setter del Número de identificación del tipo de documento
     * @param id - Número de identificación del tipo de documento a asignar
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter delNombre del tipo documento, puede ser tarjeta de identidad o cedula
     * @return Nombre del tipo documento, puede ser tarjeta de identidad o cedula
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter del Nombre del tipo documento, puede ser tarjeta de identidad o cedula
     * @param nombre - Nombre del tipo documento, puede ser tarjeta de identidad o cedula a asignar
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return id + " - " + nombre;
    }
    
    
}
