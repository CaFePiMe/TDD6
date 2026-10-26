package com.ucb.tdd;

/**
 * Tres en Raya. Coordenadas públicas: fila y columna entre 1 y 3.
 * X inicia. '+' es el segundo jugador.
 */
public class TresEnRaya {
    private final char[][] tablero = new char[3][3];
    private char ultimoJugador = '+';
    private boolean terminado = false;

    public String jugar(int fila, int columna) {
        validarCoordenada(fila, "fila");
        validarCoordenada(columna, "columna");
        if (terminado) throw new IllegalStateException("La partida ya terminó");
        if (tablero[fila - 1][columna - 1] != '\0')
            throw new IllegalArgumentException("La posición ya está ocupada");

        char jugador = siguienteTurno();
        tablero[fila - 1][columna - 1] = jugador;
        ultimoJugador = jugador;

        if (hayGanador(jugador)) {
            terminado = true;
            return jugador + " es el ganador";
        }
        if (tableroLleno()) {
            terminado = true;
            return "Empate";
        }
        return "No hay ganador";
    }

    public char siguienteTurno() { return ultimoJugador == 'X' ? '+' : 'X'; }

    public char obtenerCelda(int fila, int columna) {
        validarCoordenada(fila, "fila"); validarCoordenada(columna, "columna");
        return tablero[fila - 1][columna - 1] == '\0' ? ' ' : tablero[fila - 1][columna - 1];
    }

    public boolean estaTerminada() { return terminado; }

    private void validarCoordenada(int valor, String nombre) {
        if (valor < 1 || valor > 3)
            throw new IllegalArgumentException("La " + nombre + " debe estar entre 1 y 3");
    }

    private boolean hayGanador(char jugador) {
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == jugador && tablero[i][1] == jugador && tablero[i][2] == jugador) return true;
            if (tablero[0][i] == jugador && tablero[1][i] == jugador && tablero[2][i] == jugador) return true;
        }
        return (tablero[0][0] == jugador && tablero[1][1] == jugador && tablero[2][2] == jugador)
            || (tablero[0][2] == jugador && tablero[1][1] == jugador && tablero[2][0] == jugador);
    }

    private boolean tableroLleno() {
        for (char[] fila : tablero) for (char celda : fila) if (celda == '\0') return false;
        return true;
    }
}
