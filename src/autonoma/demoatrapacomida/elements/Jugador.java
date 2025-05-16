/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.demoatrapacomida.elements;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Mateo Quintero <mateo.quinterom@autonoma.edu.co>
 * @version 1.0.0
 * @since 20250501
 * @see autonoma.emoatrapacomida..elements
 */
public class Jugador extends SpriteMobile{
    
    
    ////////////////////////////////
    /// Atributos
    ///
    private  Puntaje puntaje;
    private String nombre;
    private Image jugadorImage;
    private int pasos = 20;

    
    /////////////////////////////////
    /// Constructor
    ////
    ///
    public Jugador( String nombre) {
        super(0, 0, 80, 80);
        this.puntaje = new Puntaje();
        this.nombre = nombre;
        jugadorImage = new ImageIcon(getClass().getResource("/autonoma/DemoAtrapaComida/images/Jugador.jpeg")).getImage();
    }

    //////////////////////////////////
    /// Metodos de acceso (set)
    ///
    public void setPuntaje(Puntaje puntaje) {
        this.puntaje = puntaje;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    //////////////////////////////////
    /// Metodos de acceso (get)
    ///
    public Puntaje getPuntaje() {
        return puntaje;
    }

    public String getNombre() {
        return nombre;
    }


    
    //////////////////////////////////
    /// Metodos
    ///

    public void atraparComida(ArrayList<Comida> comidas, ArrayList<Veneno> venenos){
    
   
       
        //se hace un ciclo de las comidas par ver si el jugador esta encima de una  
        for (Comida comida : comidas) {
            
            ///se verifica si esa comida esta ensima del jugador
            if (checkCollision(comida)) {
                
                //se elemina esa comida en especifico
                comidas.remove(comida);
                
                puntaje.aumentarPuntaje(comida.getValor());
                
            }
        }
        
        
        //se hace un ciclo de las comidas par ver si el jugador esta encima de una  
        for (Veneno veneno : venenos) {
            
            ///se verifica si esa comida esta ensima del jugador
            if (checkCollision(veneno)) {
                
                //se elemina esa comida en especifico
                venenos.remove(veneno);
                puntaje.dismuirPuntaje(veneno.getValor());
            }
        }
        
        
        
        
        
        
        
        
    }
    public void move(int direction)
    {
        int nx = x;
        int ny = y;
        
        switch(direction)
        {
            case KeyEvent.VK_UP:
                ny -= pasos;
            break;

            case KeyEvent.VK_DOWN:
                ny += pasos;
            break;

            case KeyEvent.VK_LEFT:
                nx -= pasos;
            break;

            case KeyEvent.VK_RIGHT:
                nx += pasos;
            break;
        }
        
        

        
      
    }

    @Override
    public void paint(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
