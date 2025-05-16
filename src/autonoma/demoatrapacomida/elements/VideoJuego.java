/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.demoatrapacomida.elements;

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
        this.campo = new Campo(); 
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

    public void manejarEventoTeclado(KeyEvent e) throws IOException {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_P:
                campo.atraparComida();
                break;
            case KeyEvent.VK_M:
                campo.moverIzquierda();
                break;
            case KeyEvent.VK_S:
                campo.moverDerecha(); 
                break;
        }
    }
}