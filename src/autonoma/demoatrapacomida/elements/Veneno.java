/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.demoatrapacomida.elements;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Maria Paz Puerta Acevedo <mariap.puertaa@autonoma.edu.co>
 * @since 20250516
 * @version 1.0.0
 * 
 */
class Veneno extends SpriteMobile {
    
    /**
     * Tipo o nombre del veneno.
     */
    private String tipo;
    
    /**
     * Imagen que representa visualmente la veneno en el juego.
     */
    protected Image venenoImagen;

    public Veneno(int x, int y, int height, int width) {
        super(x, y, height, width);
        this.venenoImagen = new ImageIcon("/autonoma/demoatrapacomida/images/Cigarillo.png").getImage();
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
     * Dibuja la imagen del veneno en las coordenadas actuales.
     * 
     * @param g Es el objeto Graphics usado para dibujar.
     */
    @Override
    public void paint(Graphics g) {
        if (isVisible() && venenoImagen != null) {
            g.drawImage(venenoImagen, x, y, width, height, null);
        }
    }

    /**
     * Obtiene el tipo de veneno.
     * 
     * @return Retorna el tipo de veneno como String.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de veneno.
     * 
     * @param tipo Es el nuevo tipo de veneno.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene la imagen que representa el veneno.
     * 
     * @return Retorna la imagen del veneno.
     */
    public Image getVenenoImagen() {
        return venenoImagen;
    }

    /**
     * Establece la imagen que representa el veneno.
     * 
     * @param venenoImagen Es la nueva imagen del veneno.
     */
    public void setVenenoImagen(Image venenoImagen) {
        this.venenoImagen = venenoImagen;
    }    

    int getValor() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
