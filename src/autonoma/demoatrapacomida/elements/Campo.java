/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.demoatrapacomida.elements;

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
    
    public void moverIzquierda(){
        
    }
      public void moverDerecha(){
        
    }
      
      public void  atraparComida(){
          
      }
    
}
