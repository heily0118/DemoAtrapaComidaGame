package autonoma.demoatrapacomida.elements;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * @author Heily Yohana Rios Ayala
 * @since 20250516
 * @version 1.0.0
 */
public class Hamburguesa extends Comida {

    /**
     * @param x            Posición X inicial de la hamburguesa.
     * @param y            Posición Y inicial de la hamburguesa.
     * @param height       Altura de la hamburguesa.
     * @param width        Ancho de la hamburguesa.
     * @param nombre       Nombre de la comida.
     * @param comidaImage  Imagen base de comida (no usada directamente en este caso).
     */
    public Hamburguesa(int x, int y, int height, int width, String nombre, Image comidaImage) {
        super(x, y, height, width, nombre, comidaImage);
        this.comidaImage = new ImageIcon(getClass().getResource("/autonoma/demoatrapacomida/images/Hamburguesa.png")).getImage();
    }

    /**
     * Dibuja la hamburguesa en el campo de juego utilizando su imagen.
     * 
     * @param g Objeto gráfico utilizado para renderizar en pantalla.
     */
    @Override
    public void paint(Graphics g) {
        g.drawImage(this.comidaImage, this.x, this.y, this.width, this.height, null);
    }

    /**
     * Ejecuta el comportamiento de caída automática de la hamburguesa.
     * La hamburguesa se moverá hacia abajo hasta salir de la pantalla.
     */
    @Override
    public void run() {
        while (true) {
            try {
                // Mueve hacia abajo
                this.setY(this.getY() + 5);

                // Verifica si salió de la pantalla (fuera del límite inferior)
                if (this.getY() > 800) {
                    break;
                }

                // Controla la velocidad de caída
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Realiza una caída inmediata de la hamburguesa aumentando su coordenada Y.
     */
    @Override
    public void caer() {
        this.y += 10;
    }
}
