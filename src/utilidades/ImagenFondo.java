
package utilidades;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.border.Border;
 
/*
  Clase que agrega una imagen de fondo a un componente
*/
public class ImagenFondo implements Border{
    //declaramos un bufer para la imagen
    public BufferedImage back;
 
    /**
     * Constructor sin parametros
     */
    public ImagenFondo(){
        try {
            //sacamos la imagen 
            URL imagePath = new URL(getClass().getResource("/imagenes/Logo.jpg").toString());
            //cargamos el bufer con la imagen
            back = ImageIO.read(imagePath);
        } catch (Exception ex) {            
        }
    }
    
    /**
     * Constructor con parametros
     * @param url Ubicacion de la imagen
     * @param imagen Nombre de la imagen
     */
    public ImagenFondo(String url,String imagen){
        try {
            //sacamos la imagen dada por el usuario
            URL imagePath = new URL(getClass().getResource("/"+url+"/"+imagen).toString());
            //cargamos el bufer con la imagen
            back = ImageIO.read(imagePath);
        } catch (Exception ex) {            
        }
    }

    /**
     * Metodo que pinta, por asi decirlo, una imagen seleccionada en el constructor
     * 
     * @param c Componente en el que se va a poner la imagen
     * @param g Grafico del componente que se va a poner la imagen
     * @param x Ubicación en X del Componente
     * @param y Ubicacion en Y del Componente
     * @param width Ancho del componente
     * @param height Alto del componente
     */
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawImage(back, (x + (width - back.getWidth())/2),(y + (height - back.getHeight())/2), null);
    }
 
    /**
     * Metodo que quita los bordes de un componente
     * @param c Componente al que se van a quitar los bordes
     * @return - Bordes que se van a poner
     */
    public Insets getBorderInsets(Component c) {
        return new Insets(0,0,0,0);
    }
 
    /**
     * Metodo que hace transparente la imagen
     * @return true si no es transparnte o false en el caso contrario
     */
    public boolean isBorderOpaque() {
        return false;
    }
 
}
