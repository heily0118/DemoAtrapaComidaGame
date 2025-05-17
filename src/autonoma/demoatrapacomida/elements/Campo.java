/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.demoatrapacomida.elements;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javax.swing.Timer;

  /**
 *
  * @author Mateo Quintero <mateo.quinterom@autonoma.edu.co>
 * @version 1.0.0
 * @since 20250501
 * @see autonoma.emoatrapacomida.elements
 */
public class Campo extends SpriteContainer{

    ////////////////////////////////
    /// Atributos
    ///
    public ArrayList<Comida> comidas;
    public ArrayList<Veneno> venenos;
    public Jugador jugador;

    
    
    /////////////////////////////////
    /// Constructo
    public Campo(Jugador jugador) {
        
        super(0,0,0,0);
        this.jugador = jugador;
        this. comidas  = new ArrayList<>();
        this.venenos = new ArrayList<>();
        
        Timer timer = new Timer(500, e -> {
            if (comidas.size() < 4) {
                agregarComidas();
            }
            
            if (venenos.size() < 4) {
                agregarVeneno();
            }
           
        });
        timer.start();
        
    }

    public Jugador getJugador() {
        return jugador;
    }

    public ArrayList<Comida> getComidas() {
        return comidas;
    }

    public ArrayList<Veneno> getVenenos() {
        return venenos;
    }
    
   
    
    //////////////////////////////////
    /// Metodos
    ///
    
    public void manejarEventoTeclado(int code){
     

          jugador.move(code);
    
    }
    
    
    
    public void agregarComidas() {
        Random rand = new Random();
        int anchoCampo = getWidth();
        int anchoComida = 50;

        for (int i = 0; i < 3; i++) {
            HotDog h;
            Hamburguesa b;
            boolean colision;

            do {
                int posX = rand.nextInt(anchoCampo - anchoComida);
                h = new HotDog(posX, 0, 50, 50, "HotDog", null);
                colision = verificarColisionComida(h);
            } while (colision);
            comidas.add(h);
            new Thread(h).start();

            do {
                int posX = rand.nextInt(anchoCampo - anchoComida);
                b = new Hamburguesa(posX, 0, 50, 50, "Hamburguesa", null);
                colision = verificarColisionComida(b);
            } while (colision);
            comidas.add(b);
            new Thread(b).start();
        }
    }
    
    public void agregarVeneno() {
        Random rand = new Random();
        int anchoCampo = getWidth();
        int anchoCigarrillo = 50;

        for (int i = 0; i < 3; i++) {
            Veneno v;
            boolean colision;

            do {
                int posX = rand.nextInt(anchoCampo - anchoCigarrillo);
                v = new Veneno(posX, 0, 50, 50);
                colision = verificarColisionVeneno(v) || verificarColisionConComidas(v);
            
            } while (colision);

            venenos.add(v);
            new Thread(v).start();
        }
    }


    private int getWidth() {
        return 800; 
    }
    
    private boolean verificarColisionComida(Comida nueva) {
        for (Comida c : comidas) {
            if (nueva.checkCollision(c)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean verificarColisionVeneno(Veneno nuevo) {
        for (Veneno v : venenos) {
            if (nuevo.checkCollision(v)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean verificarColisionConComidas(Veneno v) {
        for (Comida comida : comidas) {
            if (v.checkCollision(comida)) {
                return true;
            }
        }
        return false;
    }
    
    
    public void reiniciarCampo(){
       jugador.reiniciarPuntaje();
    }
}
