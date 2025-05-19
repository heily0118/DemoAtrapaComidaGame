package autonoma.demoatrapacomida.elements;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * @author Heily Yohana Rios Ayala
 * @since 20250516
 * @version 1.0.0
 */
public class HotDog extends Comida {

    /**
     * Constructor que inicializa un HotDog con posición, tamaño y nombre.
     * Además, asigna la imagen correspondiente del recurso local.
     * 
     * @param x            Posición X inicial del HotDog.
     * @param y            Posición Y inicial del HotDog.
     * @param height       Altura del HotDog.
     * @param width        Ancho del HotDog.
     * @param nombre       Nombre del elemento.
     * @param comidaImage  Imagen base recibida (no se usa directamente aquí).
     */
    public HotDog(int x, int y, int height, int width, String nombre, Image comidaImage) {
        super(x, y, height, width, nombre, comidaImage);
        this.comidaImage = new ImageIcon(getClass().getResource("/autonoma/demoatrapacomida/images/PerroCaliente.png")).getImage();
    }

    /**
     * Dibuja el HotDog en la pantalla utilizando su imagen.
     * 
     * @param g Objeto gráfico utilizado para pintar el HotDog.
     */
    @Override
    public void paint(Graphics g) {
        g.drawImage(this.comidaImage, this.x, this.y, this.width, this.height, null);
    }

    /**
     * Define el comportamiento de caída del HotDog en un hilo.
     * Cae hacia abajo continuamente hasta salir del área de juego.
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
     * Ejecuta una caída instantánea del HotDog aumentando su posición Y.
     */
    @Override
    public void caer() {
        this.y += 5;
    }
}
