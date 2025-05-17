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
            
//            actualizarComidas();
//            actualizarVenenos();
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
    
    public void agregarComidas(){
        Random rand = new Random();
        int anchoCampo = getWidth(); 
        int anchoComida = 50;

        int posXHotDog = rand.nextInt(anchoCampo - anchoComida);
        int posXHamburguesa = rand.nextInt(anchoCampo - anchoComida);

        HotDog h = new HotDog(posXHotDog, 0, 50, 50, "HotDog", null);
        Hamburguesa b = new Hamburguesa(posXHamburguesa, 0, 50, 50, "Hamburguesa", null);

        comidas.add(h);
        comidas.add(b);

        new Thread(h).start();
        new Thread(b).start();
        
    }
    
    public void agregarVeneno(){
        Random rand = new Random();
        int anchoCampo = getWidth(); 
        int anchoCigarrillo = 50;

        for (int i = 0; i < 2; i++) {  // Bucle para agregar 2 venenos
           int posX = rand.nextInt(anchoCampo - anchoCigarrillo);
            Veneno v = new Veneno(posX, 0, 50, 50);
            venenos.add(v);
            new Thread(v).start();
        }
    }

    private int getWidth() {
        return 800; 
    }
}
