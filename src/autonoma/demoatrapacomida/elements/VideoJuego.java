/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.demoatrapacomida.elements;

import autonoma.demoatrapacomida.elements.Campo;
import autonoma.demoatrapacomida.elements.Jugador;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 * @author Heily Yohana Rios Ayala
 * @since 20250516
 * @version 1.0.0
 */
public class VideoJuego {

    private Campo campo;

    /**
     * Constructor por defecto. Crea un nuevo campo con un jugador vacío.
     */
    public VideoJuego() {
        Jugador j = new Jugador("");
        this.campo = new Campo(j);
    }

    /**
     * Constructor que recibe un campo ya creado.
     * 
     * @param campo El campo de juego a utilizar.
     */
    public VideoJuego(Campo campo) {
        this.campo = campo;
    }

    /**
     * Retorna el campo actual del juego.
     * 
     * @return El campo del juego.
     */
    public Campo getCampo() {
        return campo;
    }

    /**
     * Asigna un nuevo campo al juego.
     * 
     * @param campo El nuevo campo de juego.
     */
    public void setCampo(Campo campo) {
        this.campo = campo;
    }

    /**
     * Inicia el juego generando comidas y venenos en el campo.
     */
    public void iniciarJuego() {
        generarComida();
        generarVeneno();
    }

    /**
     * Maneja los eventos del teclado relacionados con el movimiento del jugador.
     * 
     * @param code Código de la tecla presionada.
     * @throws IOException Si ocurre un error de entrada/salida al mover al jugador.
     */
    public void manejarEventoTeclado(int code) throws IOException {
        if (code == KeyEvent.VK_UP ||
            code == KeyEvent.VK_DOWN ||
            code == KeyEvent.VK_LEFT ||
            code == KeyEvent.VK_RIGHT) {
            campo.manejarEventoTeclado(code);
        }
    }

    /**
     * Genera nuevas comidas en el campo.
     */
    public void generarComida() {
        campo.agregarComidas();
    }

    /**
     * Genera venenos en el campo.
     */
    public void generarVeneno() {
        campo.agregarVeneno();
    }

    /**
     * Dibuja todos los elementos del campo en pantalla.
     * 
     * @param g Objeto gráfico utilizado para dibujar los elementos.
     */
    public void dibujarElementos(Graphics g) {
        for (Comida comida : campo.getComidas()) {
            comida.paint(g);
        }

        campo.getJugador().paint(g);

        for (Veneno v : campo.getVenenos()) {
            v.paint(g);
        }
    }

    /**
     * Reinicia el juego limpiando el campo y restableciendo el puntaje del jugador.
     */
    public void reinicarJuego() {
        campo.getComidas().clear();
        campo.getVenenos().clear();
        campo.getJugador().getPuntaje().actualizarPuntaje();
    }
}
