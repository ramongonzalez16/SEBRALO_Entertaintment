/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Fa Barrera González
 */
public class Conexion {
    /*
     Datos basicos de la conexion
     */

    public String db = "sebralo";//nombre de la base de datos
    public String user = "root";//usuario del host
    public String pass = "rhg123";//contraseña para el usuario del host
    public String url = "jdbc:mysql://localhost/" + db;//localización de la base de datos
    Connection conn = null;

    /**
     * Constructor vacio
     */
    public Conexion() {
    }

    /**
     * Metodo que retorna la conexion o informa si ha ocurrido un error
     *
     * @return - conexion establecida o null si ocurre un error
     */
    public Connection conectar() {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conn = DriverManager.getConnection(this.url, this.user, this.pass);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            System.out.println(e.getCause().getLocalizedMessage());
        }

        return conn;
    }

    /**
     * metodo que cierra una conexión a la bd
     */
    public void desconectar() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getCause().getLocalizedMessage());

        }
    }

    /**
     * Metodo que busca un regisro en la bd, configurada en la clase Conexion,
     * de la clase dada por parametro retornando el registro en to string
     *
     * @param clase Entidad sobre la que se va a realizar la busqueda
     * @param atributo Nombre del atributo de búsqueda por el que se va a buscar
     * @param cadena Criterio de comparacion para el sql
     * @param atributos Arreglo que contiene los nombres de las columnas
     * @return - Entidad pasada a una cadena atributo por atributo
     */
    public String buscar(Class clase, String atributo, String cadena, String[] atributos) {
        conn = conectar();
        String retorno = "";
        String sql = "SELECT * FROM " + clase.getName().split("\\.")[1].toLowerCase()
                + " WHERE " + clase.getName().split("\\.")[1].toLowerCase()
                + "." + atributo + " LIKE '" + cadena + "';";
        try {
            Statement st = conn.createStatement();//se crea la conexion
            ResultSet rs = st.executeQuery(sql);//se ejecuta la consulta
            while (rs.next()) {//se recorre el resultado
                if (!rs.getString(atributos[0]).isEmpty()) {//se valida que hallan resultados
                    for (int i = 0; i < atributos.length; i++) {
                        retorno += rs.getString(atributos[i]) + "-";
                    }
                }
            }
            //se cierra la conexion
            desconectar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (!retorno.isEmpty()) {
            //se le suprime el ultimo caracter al resultado y se retorna
            System.out.println(clase.getName().split("\\.")[1].toLowerCase()
                    + " encontrado");
            return retorno.substring(0, retorno.length() - 1);
        }
        //se retrona una cadena vacia
        return retorno;
    }

    /**
     * Metodo que inserta un regisro en la bd, configurada en la clase Conexion,
     * de la clase dada por parametro retornando si fué exitosa o no la
     * inserción
     *
     * @param clase Entidad sobre la que se va a realizar la inserción
     * @param atributos Arreglo que contiene los nombres de las columnas
     * @param valores Arreglo que contiene los valore almacenados en los
     * atributos
     * @return - true si insertó con exito || false en el caso contrario
     */
    public boolean insertar(Class clase, String[] atributos, String[] valores) {
        conn = conectar();
        String atribs = "";
        String spacesVals = "";
        //recorrer nombres de los atributos
        for (int i = 0; i < atributos.length; i++) {
            atribs += atributos[i] + ",";
            spacesVals += "'" + valores[i] + "',";
        }
        //sql generado a partir de la injección de datos 
        String sql = "INSERT INTO " + clase.getName().split("\\.")[1].toLowerCase()
                + " " + '(' + atribs.substring(0, atribs.length() - 1) + ')' + " VALUES " + '('
                + spacesVals.substring(0, spacesVals.length() - 1) + ')' + ";";
        try {
            System.out.println(sql);
            //Preparamos la query 
            Statement pst = conn.prepareStatement(sql);
            //se ejecuta la query ya lista
            pst.executeUpdate(sql);
            desconectar();//se desconecta
            return true;//se informa que se insertó 
        } catch (Exception e) {
            desconectar();//se desconecta
            System.out.println(e.getCause().getLocalizedMessage());//se informa del error que ocurrio
        }
        return false;//se informa que no se pudo insertar 
    }

    /**
     * Metodo que elimina un regisro en la bd, configurada en la clase Conexion,
     * de la clase dada por parametro retornando si fué exitosa o no la
     * eliminación
     *
     * @param clase Entidad sobre la que se va a realizar la eliminación
     * @param atributos Arreglo que contiene los nombres de las columnas
     * @param valor Clave de acceso a la eliminación del registro
     * @return - true si eliminó con exito || false en el caso contrario
     */
    public boolean eliminar(Class clase, String[] atributos, String valor) {
        conn = conectar();
        //sql generado a partir de la injección de datos
        String sql = "DELETE FROM " + clase.getName().split("\\.")[1].toLowerCase()
                + " WHERE " + atributos[0] + " LIKE " + new Codificador().codificarPalabra(valor) + ";";
        try {
            System.out.println(sql);
            //Preparamos la query 
            Statement pst = conn.prepareStatement(sql);
            //se ejecuta la query ya lista
            pst.executeUpdate(sql);
            desconectar();//se desconecta
            return true;//se informa que se eliminó 
        } catch (Exception e) {
            desconectar();//se desconecta
            System.out.println(e.getCause().getLocalizedMessage());//se informa del error que ocurrio
        }
        return false;//se informa que no se pudo eliminar 
    }

    /**
     * Metodo que edita un regisro en la bd, configurada en la clase Conexion,
     * de la clase dada por parametro retornando si fué exitosa o no la edición
     *
     * @param clase Entidad sobre la que se va a realizar la edición
     * @param atributos Arreglo que contiene los nombres de las columnas
     * @param valores Arreglo que contiene los valore almacenados en los
     * atributos
     * @return - true si editó con exito || false en el caso contrario
     */
    public boolean editar(Class clase, String[] atributos, String[] valores) {
        conn = conectar();
        String valoresToString = "";
        //se alista los valores a editar para la sentencia sql (campo=valor)
        for (int i = 0; i < atributos.length; i++) {
            valoresToString += (atributos[i] + " = " + new Codificador().codificarPalabra(valores[i]) + ", ");

        }
        //sql generado a partir de la injección de datos
        String sql = "UPDATE " + clase.getName().split("\\.")[1].toLowerCase()
                + " SET " + valoresToString.substring(0, valoresToString.length() - 2)
                + " WHERE " + atributos[0] + " LIKE " + new Codificador().codificarPalabra(valores[0]) + ";";
        try {
            System.out.println(sql);
            //Preparamos la query 
            Statement pst = conn.prepareStatement(sql);

            //se ejecuta la query ya lista
            pst.executeUpdate(sql);
            desconectar();//se desconecta
            return true;//se informa que se editó 
        } catch (Exception e) {
            desconectar();//se desconecta
            System.out.println(e.getCause().getLocalizedMessage());//se informa del error que ocurrio
        }
        return false;//se informa que no se pudo editar 
    }

    /**
     * Metodo que lista todos los regisros en la bd, configurada en la clase
     * Conexion, de la clase dada por parametro retornando si hay o no registros
     *
     * @param clase Entidad sobre la que se va a realizar la consulta de
     * registos
     * @param atributos Arreglo que contiene los nombres de las columnas
     * @return - Si hay o no registros
     */
    public List<String> listar(Class clase, String[] atributos) {
        conn = conectar();
        //sql generado a partir de la injección de datos
        String sql = "SELECT * FROM " + clase.getName().split("\\.")[1].toLowerCase() + ";";
        List<String> retorno = new ArrayList<>();
        try {
            Statement st = conn.createStatement();//se crea la conexion
            ResultSet rs = st.executeQuery(sql);//se ejecuta la consulta
            while (rs.next()) {//se recorre el resultado
                if (!rs.getString(atributos[0]).isEmpty()) {//se valida que hallan resultados
                    String regristro = "";
                    //se saca el registro
                    for (int i = 0; i < atributos.length; i++) {
                        regristro += rs.getString(atributos[i]) + "-";
                    }
                    //se decodifica y se agrega el registro al retorno
                    retorno.add(new Codificador().decodificarPalabra(regristro));
                }
            }
            //se cierra la conexion
            desconectar();
        } catch (Exception e) {
            desconectar();
            System.out.println(e.getMessage());
        }
        //se retornan los resultados
        return retorno;
    }
}
