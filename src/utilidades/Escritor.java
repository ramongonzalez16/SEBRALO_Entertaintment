/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author F. Gonzalez Barrera
 */
public class Escritor {

    public Escritor() {
    }

    public void escribir(String ruta, String nombreArchivo, List<String> contenido) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(ruta + "/" + nombreArchivo);
            pw = new PrintWriter(fichero);
            for (String linea : contenido) {
                pw.println(linea);
                fichero.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void borrar(String ruta, String nombreArchivo) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(ruta + "/" + nombreArchivo);
            pw = new PrintWriter(fichero);
            pw.write("");
            fichero.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
