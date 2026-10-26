package com.ucb.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TresEnRayaTest {
    private TresEnRaya juego;
    @BeforeEach public void setUp() { juego = new TresEnRaya(); }

    @Test public void primerTurnoEsX() { assertEquals('X', juego.siguienteTurno()); }
    @Test public void alternaTurnosTrasJugadasValidas() {
        juego.jugar(1,1); assertEquals('+', juego.siguienteTurno());
        juego.jugar(2,1); assertEquals('X', juego.siguienteTurno());
    }
    @Test public void jugadaSinGanadorInformaEstado() { assertEquals("No hay ganador", juego.jugar(2,2)); }
    @Test public void coordenadaFilaMenorQueUnoEsRechazada() {
        assertThrows(IllegalArgumentException.class, () -> juego.jugar(0,1));
    }
    @Test public void coordenadaColumnaMayorQueTresEsRechazada() {
        assertThrows(IllegalArgumentException.class, () -> juego.jugar(1,4));
    }
    @Test public void rechazaCasillaOcupadaSinCambiarTurno() {
        juego.jugar(1,1);
        assertThrows(IllegalArgumentException.class, () -> juego.jugar(1,1));
        assertEquals('+', juego.siguienteTurno());
    }
    @Test public void detectaVictoriaEnFila() {
        juego.jugar(1,1); juego.jugar(2,1); juego.jugar(1,2); juego.jugar(2,2);
        assertEquals("X es el ganador", juego.jugar(1,3));
    }
    @Test public void detectaVictoriaEnColumna() {
        juego.jugar(1,1); juego.jugar(1,2); juego.jugar(2,1); juego.jugar(2,2);
        assertEquals("X es el ganador", juego.jugar(3,1));
    }
    @Test public void detectaDiagonalPrincipal() {
        juego.jugar(1,1); juego.jugar(1,2); juego.jugar(2,2); juego.jugar(1,3);
        assertEquals("X es el ganador", juego.jugar(3,3));
    }
    @Test public void detectaDiagonalSecundaria() {
        juego.jugar(1,3); juego.jugar(1,1); juego.jugar(2,2); juego.jugar(2,1);
        assertEquals("X es el ganador", juego.jugar(3,1));
    }
    @Test public void detectaEmpateEnTableroLleno() {
        // X O X / X X O / O X O: no hay línea ganadora
        juego.jugar(1,1); juego.jugar(1,2); juego.jugar(1,3);
        juego.jugar(2,2); juego.jugar(2,1); juego.jugar(2,3);
        juego.jugar(3,2); juego.jugar(3,1);
        assertEquals("Empate", juego.jugar(3,3));
    }
    @Test public void noPermiteJugarTrasVictoria() {
        juego.jugar(1,1); juego.jugar(2,1); juego.jugar(1,2); juego.jugar(2,2); juego.jugar(1,3);
        assertThrows(IllegalStateException.class, () -> juego.jugar(3,3));
    }
    @Test public void consultaCeldaOcupadaYVacia() {
        juego.jugar(2,3);
        assertEquals('X', juego.obtenerCelda(2,3)); assertEquals(' ', juego.obtenerCelda(1,1));
    }
}
