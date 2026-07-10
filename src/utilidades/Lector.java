/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author F. Gonzalez Barrera
 */
public class Lector {

    public Lector() {
    }

    public List <String> leer(String ruta, String nombreArchivo) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        List <String> retorno = new ArrayList<>();
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
//            archivo = new File("D:\\Cliente.txt");
            archivo = new File(ruta+"\\"+nombreArchivo);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                retorno.add(linea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                    return retorno;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return retorno;
    }

}
