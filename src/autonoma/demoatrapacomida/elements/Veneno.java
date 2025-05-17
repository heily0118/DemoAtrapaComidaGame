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
public class Veneno extends SpriteMobile{
    
    /**
     * Tipo o nombre del veneno.
     */
    private String tipo;
    
    /**
     * Cantidad de puntos del veneno.
     */
    private int valor = 2;
    
    /**
     * Imagen que representa visualmente la veneno en el juego.
     */
    protected Image venenoImagen;

    public Veneno(int x, int y, int height, int width) {
        super(x, y, height, width);
        this.venenoImagen = new ImageIcon(getClass().getResource("/autonoma/demoatrapacomida/images/Cigarrillo.png")).getImage();
        this.pausa = false;
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
     * Hace que el veneno caiga.
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

    /**
     * Obtiene el valor en puntos que representa atrapar este objeto en el juego.
     * 
     * @return Retorna -2, indicando que el veneno resta puntos si se atrapa.
     */
    public int getValor() {
        return -2;
    }

    /**
     * Mueve el objeto veneno hacia abajo en la pantalla.
     * 
     * @return Retorna true siempre, ya que se mueve cada vez que se llama.
     */
    public boolean mover() {
        this.y += 10;  
        return true;
    }

    /**
     * Ejecuta el comportamiento en hilo del objeto veneno.
     */
    @Override
    public void run() {
        running = true;
    
        while (running) {
            try {
                if (!pausa) {
                    caer(); 
                }        
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                System.out.println("Hilo del veneno interrumpido: " + e.getMessage());
                running = false;
            }
        }
    }

//    /**
//     * Verifica si el objeto ha salido del área visible del campo de juego.
//     *
//     * @return  Retorna true si la posición vertical del objeto es mayor que 800,
//     *         indicando que ha salido del campo hacia abajo y false en caso contrario.
//     */
//    public boolean yaSalioDelCampo() {
//        return this.getY() > 800;
//    }
}
