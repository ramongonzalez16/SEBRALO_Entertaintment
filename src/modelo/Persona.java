/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author F González Barrera
 */
public class Persona {

    /*
      id,tipoDocumento,nombres,apellidos,fechaNacimiento,direccion,telefono,email
    */
    private int id;//Número de identificación del tipo de la persona
    private Tipo_Documento tpDocumento;//Tipo de documento de la persona
    private String nombres;//Nombre(s) de la persona
    private String apellidos;//Apellidos de la persona
    private Date fechaNacimiento;//Fecha de nacimiento de la persona
    private String direccion;//Dirección de residencia de  la persona
    private List<String> telefono;//Teléfono(s) de contacto de la persona
    private String email;//Email de la persona 
    /*
      variables bandera
    */
    public final static String[] ATRIBUTOS={"id","id_tipo_documento","nombres",
        "apellidos","fecha_nacimiento","direccion","telefonos","email"};
    public final static String ARCHIVO = "Persona.txt";

    /**
     * Constructor vacio
     */
    public Persona() {
    }

    /**
     * Constructor con parametros
     * @param id Número de identificación del tipo de la persona
     * @param tpDocumento Tipo de documento de la persona
     * @param nombres Nombre(s) de la persona
     * @param apellidos Apellidos de la persona
     * @param fechaNacimiento Fecha de nacimiento de la persona
     * @param direccion Dirección de residencia de  la persona
     * @param telefono Teléfono(s) de contacto de la persona
     * @param email Email de la persona 
     */
    public Persona(int id, Tipo_Documento tpDocumento, String nombres, 
            String apellidos, Date fechaNacimiento, String direccion, 
            List<String> telefono, String email) {
        this.id = id;
        this.tpDocumento = tpDocumento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    /**
     * Getter del Número de identificación de la persona
     * @return Número de identificación de la persona
     */
    public int getId() {
        return id;
    }

    /**
     * Setter del Número de identificación de la persona
     * @param id - Número de identificación de la persona
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter del Tipo de documento de la persona
     * @return Tipo de documento de la persona
     */
    public Tipo_Documento getTpDocumento() {
        return tpDocumento;
    }

    /**
     * Setter del Tipo de documento de la persona
     * @param tpDocumento
     */
    public void setTpDocumento(Tipo_Documento tpDocumento) {
        this.tpDocumento = tpDocumento;
    }

    /**
     * Getter del Nombre(s) de la persona
     * @return Nombre(s) de la persona
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Setter del Nombre(s) de la persona
     * @param nombres
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Getter de los Apellidos de la persona
     * @return Apellidos de la persona
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Setter de los Apellidos de la persona
     * @param apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Getter de la Fecha de nacimiento de la persona
     * @return Fecha de nacimiento de la persona
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Setter de la Fecha de nacimiento de la persona
     * @param fechaNacimiento
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Getter de la Dirección de residencia de  la persona
     * @return Dirección de residencia de  la persona
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Setter de la Dirección de residencia de la persona
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Getter del Teléfono(s) de contacto de la persona
     * @return Teléfono(s) de contacto de la persona
     */
    public List<String> getTelefono() {
        return telefono;
    }

    /**
     * Setter del Teléfono(s) de contacto de la persona
     * @param telefono
     */
    public void setTelefono(List<String> telefono) {
        this.telefono = telefono;
    }

    /**
     * Getter del Email de la persona
     * @return Email de la persona
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter del Email de la persona
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        String telefonos ="";
        for (String tel : telefono) {
            telefonos += tel + "/";
        }
        telefonos=telefonos.substring(0,telefonos.length()-1);
        return id + " - " + tpDocumento.getId() + " - " + nombres + " - " + 
                apellidos + " - " + new SimpleDateFormat("YYYY/MMMMMM/dd").format(fechaNacimiento) + 
                " - " + direccion + " - " + telefonos + " - " + email;
        
    }

    
}
