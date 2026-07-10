/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;



/**
 *
 * @author F. Gonzalez Barrera
 */
public class Codificador {
    /**
     * Metodo que codifica una letra en código acci 
     * @param c - Letra a codificar
     * @return - entero asignado a la respectiva letra en código acci
     */
    private int codificarLetra(char c){
        //se saca el codigo acci de la letra y se retorna
        return (int)c;
    }
    /**
     * Metodo que decodifica una letra sacada de su  respectivo código acci
     * @param i - entero asignado a la respectiva letra en código acci
     * @return - Letra decodificada
     */
    private char decodificarLetra(int i){
        //se castea la letra del codigo acci y se retorna
        return (char)i;
    }
    
    /**
     * Metodo usado cara codificar un campo
     * @param palabra - Palabra(s) a codificar
     * @return - Serie de números, separados por el caracter *, correspondientes
     * al codigo acci
     */
    public String codificarPalabra(String palabra){
        //Variable de retorno
        String retorno= "";
        //se recorre letra por letra
        for (int i = 0; i < palabra.length(); i++) {
            //se codifica la letra y se agrega a la variable de retorno
            retorno+=codificarLetra(palabra.charAt(i))+"*";
        } 
        //se le suprime el ulrimo caracter al resultado y se retorna
        return retorno.substring(0, retorno.length()-1);
    }
    
    /**
     * Metodo usado para decodificar un campo
     * @param palabra - Serie de números, separados por el caracter *, 
     * correspondientes al codigo acci
     * @return Palabra(s) decodificada(s)
     */
    public String decodificarPalabra(String palabra){
        //Variable de retorno
        String retorno="";
        //Se divide la(s) palabra(s) decodificada(s)
        String[] caracteres= palabra.split("\\*");
        //Se recorre el resultado sacando cada número
        for (int i = 0; i < caracteres.length; i++) {
            //se decodifica la letra y se agrega a la variable de retorno
            retorno+=decodificarLetra(Integer.parseInt(caracteres[i]));
        }
        //se retorna el resultado
        return retorno;
    }
}
