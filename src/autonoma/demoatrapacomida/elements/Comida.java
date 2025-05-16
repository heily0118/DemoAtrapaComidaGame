/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.demoatrapacomida.elements;

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
     * Constructor de la clase Comida.
     * @param x
     * @param y
     * @param height
     * @param width 
     */
    public Comida(int x, int y, int height, int width, String nombre) {
        super(x, y, height, width);
        this.nombre = nombre;
    }
    
    /**
     * Verifica si la comida aún está cayendo dentro de la pantalla.
     * 
     * @return Retorna true si la posición en Y es menor a 900 (dentro de los límites) y false si ya salió.
     */
    public boolean estaCayendo() {
        return y < 900;
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
