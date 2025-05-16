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
 */
public abstract class SpriteMobile extends Sprite implements Runnable {
    protected boolean running;
    protected boolean pausa;
    
    protected long delay;
    protected Thread hilo;
    
   
    
    
    public SpriteMovil(int x, int y, int width, int height) {
        super(x, y, width, height);
        
        hilo = new Thread(this);
        
     
        
        delay = 500;
        running = false;
        pausa = false;
        
        
    }

    public abstract boolean mover();

    
    public boolean isRunning() {
        return running;
    }

    public void parar() {
        this.running = false;
    }

    public boolean isPausa() {
        return pausa;
    }

    public void pausar () {
        this.pausa = true;
    }
    
    public void dePausar () {
        this.pausa = false;
    }
}
