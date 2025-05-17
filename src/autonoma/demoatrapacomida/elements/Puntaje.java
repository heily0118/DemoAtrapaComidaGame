/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.demoatrapacomida.elements;

/**
 *
  * @author Mateo Quintero <mateo.quinterom@autonoma.edu.co>
 * @version 1.0.0
 * @since 20250501
 * @see autonoma.emoatrapacomida..elements
 */
public class Puntaje {

    ////////////////////////////////
    /// Atributos
    ///
    private int puntajeActual;


    /////////////////////////////////
    /// Constructor
    ////
    
    public Puntaje() {
        this.puntajeActual = 0;
    }

    
    //////////////////////////////////
    /// Metodos de acceso (set)
    ///
    
    public void setPuntajeActual(int puntajeActual) {
        this.puntajeActual = puntajeActual;
    }

    //////////////////////////////////
    /// Metodos de acceso (get)
    ///
    public int getPuntajeActual() {
        return puntajeActual;
    }


    //////////////////////////////////
    /// Metodos
    ///

    public void aumentarPuntaje(int valor){
        
        this.puntajeActual += valor;
    }
    public void dismuirPuntaje(int valor ){
    
        System.out.println("se resta "+ valor);
        this.puntajeActual += valor;
    
    }
    public void actualizarPuntaje(){
            this.puntajeActual = 0;

    }
    
    
}
