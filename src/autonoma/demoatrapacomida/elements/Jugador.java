/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.demoatrapacomida.elements;

import java.awt.Color;
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
        super(400, 400, 80, 80);
        this.puntaje = new Puntaje();
        this.nombre = nombre;
        jugadorImage = new ImageIcon(getClass().getResource("/autonoma/DemoAtrapaComida/images/Jugador.png")).getImage();
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

    public void atraparComida(ArrayList<Comida> comidas){
    
         if (comidas == null || comidas.isEmpty()) {
            System.out.println("No hay comida.");
            return;
        }

        for (int i = 0; i < comidas.size(); i++) {
            Comida comida = comidas.get(i);

            if (checkCollision(comida)) {
                puntaje.aumentarPuntaje(comida.getValor());
                comidas.remove(i);
                i--; 
            }
        }
    }   
    public void atraparVeneno(ArrayList<Veneno> venenos){
    
         if (venenos == null || venenos.isEmpty()) {
            System.out.println("No hay venenos.");
            return;
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
        public void move(int direccion) {
            int nx = x;
            int ny = y;

            switch(direccion) {
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

            // Verifica si el movimiento es válido
            if (limiteDeMapa(nx, ny)) {
                // Si es válido, actualiza x e y
                x = nx;
                y = ny;            
            }
        }

        public boolean limiteDeMapa(int nx, int ny) {
            // Verifica si nx y ny están dentro del rango permitido
            if (nx < 0 || nx > 800 - 80 || ny < 0 || ny > 800 - 80) {
                return false; // Movimiento no permitido
            }

            // Si el movimiento es válido, se asignan los valores a x e y
            this.x = nx;
            this.y = ny;
            return true; // Movimiento permitido
        }

    @Override
    public void paint(Graphics g){ 
            
        
        g.drawImage(jugadorImage, x, y, width, height, null);
    }

    @Override
    public void run() {

    }


  

   

}
