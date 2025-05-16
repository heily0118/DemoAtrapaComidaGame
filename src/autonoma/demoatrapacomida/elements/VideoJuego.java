/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.demoatrapacomida.elements;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 * 
 * @author Heily Yohana Rios Ayala <heilyy.riosa@gmail.com>
 * @since 20250516
 * @version 1.0.0
 */
public class VideoJuego {
    
    private Campo campo;

    public VideoJuego() {
        Jugador j = new Jugador(""); 
        this.campo = new Campo(j); 
    }

    public VideoJuego(Campo campo) {
        this.campo = campo;
    }

    public Campo getCampo() {
        return campo;
    }

    public void setCampo(Campo campo) {
        this.campo = campo;
    }

    public void iniciarJuego() {
       
    }

    public void manejarEventoTeclado(int code) throws IOException {
        
        if(code == KeyEvent.VK_UP |
           code == KeyEvent.VK_DOWN |
           code == KeyEvent.VK_LEFT |
           code == KeyEvent.VK_RIGHT)
        {
        campo.manejarEventoTeclado(code);
        
        }
<<<<<<< HEAD
}
=======
    }
    
    
      /**
     * Dibuja todos los elementos del campo en pantalla.
     * 
     * @param g Objeto gráfico para dibujar
     */
    public void dibujarElementos(Graphics g) {
           
    }
    
    
>>>>>>> aac758543183e5d21d874e30b6a986ecefe0f7a0
}