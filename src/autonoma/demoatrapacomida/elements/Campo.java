/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.demoatrapacomida.elements;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

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
    HotDog hotdog = new HotDog(100, 0, 50, 50, "HotDog", null);
    Hamburguesa hamburguesa = new Hamburguesa(200, 0, 50, 50, "Hamburguesa", null);

    
    comidas.add(hotdog);
    comidas.add(hamburguesa);

  
    new Thread(hotdog).start();
    new Thread(hamburguesa).start();
        
    }
    
    public void agregarVeneno(){
        
    }
}
