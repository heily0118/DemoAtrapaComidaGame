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
 * @author Heily Yohana Rios Ayala <heilyy.riosa@gmail.com>
 * @since 20250516
 * @version 1.0.0
 */

public class HotDog extends Comida {

    public HotDog(int x, int y, int height, int width, String nombre, Image comidaImage) {
        super(x, y, height, width, nombre, comidaImage);
        this.comidaImage = new ImageIcon(getClass().getResource("/autonoma/demoatrapacomida/images/PerroCaliente.png")).getImage();
    }

   

    @Override
    public void paint(Graphics g) {
        g.drawImage(this.comidaImage, this.x, this.y, this.width, this.height, null);
    }

  

    @Override
    public void run() {
        while (true) {
            try {
                // Mueve hacia abajo
                this.setY(this.getY() + 5);
                
                // Verifica si salió de la pantalla
                if (this.getY() > 800) {
                    break; // Termina si ya cayó fuera
                }

                Thread.sleep(100); // Velocidad de caída
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }

    @Override
    public void caer() {
        this.y += 5;
    }
    
  
    
}
