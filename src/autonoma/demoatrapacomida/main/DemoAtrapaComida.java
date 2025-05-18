/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package autonoma.demoatrapacomida.main;

import autonoma.demoatrapacomida.elements.VideoJuego;
import autonoma.demoatrapacomida.gui.VentanaJuego;
import autonoma.demoatrapacomida.gui.VentanaPrincipal;

/**
 * 
 * @author Heily Yohana Rios Ayala <heilyy.riosa@gmail.com>
 * @since 20250516
 * @version 1.0.0
 */
public class DemoAtrapaComida {

   
    public static void main(String[] args) {
        
        VideoJuego juego = new VideoJuego();
        

        
        VentanaPrincipal ventana = new VentanaPrincipal (juego);
        ventana.setVisible(true);
       
    }
    
}
