# Prompt utilizado para generar pruebas unitarias con IA

Actúa como ingeniero QA con experiencia en TDD y JUnit 4. Genera pruebas unitarias para una implementación Java de Tres en Raya con API `jugar(int fila, int columna)`, coordenadas de 1 a 3, jugador X inicia y luego alterna con '+'. Debe rechazar coordenadas fuera de rango y casillas ocupadas; detectar victoria por filas, columnas y ambas diagonales; informar empate cuando se llena el tablero sin ganador; impedir nuevas jugadas después de una victoria o empate; permitir consultar el contenido de una celda.

Entrega:
1. Una clase JUnit 4 independiente, compilable, con nombres descriptivos.
2. Usa Arrange-Act-Assert, una intención por prueba y aserciones explícitas.
3. Incluye casos positivos, negativos, límites (1 y 3), estado después de un movimiento inválido, las ocho líneas ganadoras, empate y juego finalizado.
4. No uses mocks si no son necesarios. Evita acoplar pruebas a detalles privados.
5. Señala supuestos ambiguos y posibles pruebas redundantes.
6. No inventes métodos: si una operación requerida no existe, indícalo como propuesta de contrato.
7. Al final presenta una tabla breve de cobertura por regla.

Para esta comparación académica, etiqueta el resultado como suite generada por IA. Revisa cada caso para detectar errores de lógica antes de darlo por válido.
