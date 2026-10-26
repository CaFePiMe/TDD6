package com.ucb.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Suite propuesta por IA a partir del prompt incluido en PROMPT_IA.md.
 * Se conserva separada para comparar estrategias de prueba.
 */
public class TresEnRayaIATest {
    private TresEnRaya juego;
    @BeforeEach public void inicializar() { juego = new TresEnRaya(); }

    @Test public void iniciaConX() { assertEquals('X', juego.siguienteTurno()); }
    @Test public void turnosSeAlternan() {
        juego.jugar(3,2); assertEquals('+', juego.siguienteTurno());
        juego.jugar(3,3); assertEquals('X', juego.siguienteTurno());
    }
    @Test public void fueraDeRangoEnAmbosEjes() {
        assertThrows(IllegalArgumentException.class, () -> juego.jugar(-1,2));
        assertThrows(IllegalArgumentException.class, () -> juego.jugar(2,8));
    }
    @Test public void movimientoDuplicadoSeRechaza() {
        juego.jugar(2,2);
        assertThrows(IllegalArgumentException.class, () -> juego.jugar(2,2));
    }
    @Test public void ganaEnCadaFila() {
        for (int r=1;r<=3;r++) {
            TresEnRaya g = new TresEnRaya();
            int other = r == 1 ? 2 : 1;
            g.jugar(r,1); g.jugar(other,1); g.jugar(r,2); g.jugar(other,2);
            assertEquals("X es el ganador", g.jugar(r,3));
        }
    }
    @Test public void ganaEnDiagonalPrincipal() {
        juego.jugar(1,1); juego.jugar(1,2); juego.jugar(2,2); juego.jugar(1,3);
        assertEquals("X es el ganador",juego.jugar(3,3));
    }
    @Test public void ganaEnDiagonalInversa() {
        juego.jugar(1,3); juego.jugar(1,1); juego.jugar(2,2); juego.jugar(2,1);
        assertEquals("X es el ganador",juego.jugar(3,1));
    }
    @Test public void noSeAceptanMovimientosTrasVictoria() {
        juego.jugar(1,1); juego.jugar(2,1); juego.jugar(1,2); juego.jugar(2,2); juego.jugar(1,3);
        assertThrows(IllegalStateException.class, () -> juego.jugar(3,3));
    }
}
