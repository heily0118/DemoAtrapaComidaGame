/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.demoatrapacomida.elements;

import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author Maria Paz Puerta Acevedo <mariap.puertaa@autonoma.edu.co>
 * @since 20250516
 * @version 1.0.0
 * 
 */
public abstract class Comida extends SpriteMobile {
    
    /**
     * Nombre de la comida.
     */
    private String nombre;
    
    /**
     * Cantidad de puntos de la comida.
     */
    private int valor = 1;
    
    /**
     * 
     * Imagen que representa visualmente la comida en el juego.
     * 
     */
    protected Image comidaImage;
    

    /**
     * Constructor de la clase Comida.
     * @param x Es la posición en x.
     * @param y Es la posición en y.
     * @param height Es el ancho del sprite.
     * @param width Es el alto del sprite.
     * @param nombre Es el nombre de la comida.
     */
    public Comida(int x, int y, int height, int width, String nombre, Image comidaImage) {
        super(x, y, height, width);
        this.nombre = nombre;
        this.comidaImage = comidaImage;
    }
    
    /**
     * Dibuja la imagen de la comida en pantalla si está visible.
     * 
     * @param g el objeto Graphics utilizado para dibujar la comida.
     */
    public void dibujar(Graphics g) {
        if (isVisible() && comidaImage != null) {
            g.drawImage(comidaImage, x, y, width, height, null);  
        }
    }
    
    /**
     * Verifica si la comida aún está cayendo dentro de la pantalla.
     * 
     * @return Retorna true si la posición en Y es menor a 900 (dentro de los límites) y false si ya salió.
     */
    public boolean estaCayendo() {
        return y < 800;
    }

    /**
     * Hace que la comida caiga.
     * 
     */
    public void caer() {
        if (estaCayendo()) {
            mover();
        } else {
            setVisible(false);  
        }
    }

    /**
     * Obtiene el nombre de la comida.
     * 
     * @return Retorna el nombre de la comida.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la comida.
     * 
     * @param nombre Es el nuevo nombre de la comida.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el valor en puntos que otorga esta comida.
     * 
     * @return Retorna el valor de la comida.
     */
    public int getValor() {
        return valor;
    }

    /**
     * Establece el valor en puntos que otorga esta comida.
     * 
     * @param valor Es el nuevo valor de la comida.
     */
    public void setValor(int valor) {
        this.valor = valor;
    }
}
