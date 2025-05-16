/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.demoatrapacomida.elements;

/**
 * 
 * @author Maria Paz Puerta Acevedo <mariap.puertaa@sutonoma.edu.co>
 * @since 20250516
 * @version 1.0.0
 */
public abstract class SpriteMobile extends Sprite {

    /**
     * Velocidad en el eje X.
     */
    private int velocidadX;

    /**
     * Velocidad en el eje Y.
     */
    private int velocidadY;
    

    /**
     * Constructor de la clase SpriteMobile.
     * @param x Es la posición en x.
     * @param y Es la posición en y.
     * @param height Es el ancho del sprite.
     * @param width Es el alto del sprite.
     */
    public SpriteMobile(int x, int y, int height, int width) {
        super(x, y, height, width);
        this.velocidadX = 0;
        this.velocidadY = 0;
    }

    /**
     * Obtiene la velocidad en el eje X.
     * 
     * @return Retorna la velocidad en X.
     */
    public int getVelocidadX() {
        return velocidadX;
    }

    /**
     * Establece la velocidad en el eje X.
     * 
     * @param velocidadX Es la nueva velocidad en X.
     */
    public void setVelocidadX(int velocidadX) {
        this.velocidadX = velocidadX;
    }

    /**
     * Obtiene la velocidad en el eje Y.
     * 
     * @return Retorna la velocidad en Y.
     */
    public int getVelocidadY() {
        return velocidadY;
    }

    /**
     * Establece la velocidad en el eje Y.
     * 
     * @param velocidadY Es la nueva velocidad en Y.
     */
    public void setVelocidadY(int velocidadY) {
        this.velocidadY = velocidadY;
    } 

    /**
     * Mueve el sprite actual en el campo, según su velocidad.
     */
    public void mover(){
       this.x += this.velocidadX;
       this.y += this.velocidadY; 
    }      
}
