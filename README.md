# Kata Tres en Raya — TDD

Implementación Java con Maven y pruebas JUnit 4.13.2.

## Reglas asumidas
- Tablero 3×3; coordenadas fila/columna de 1 a 3.
- X comienza, los jugadores alternan entre `X` y `+`.
- No se permiten casillas ocupadas ni jugadas después del final.
- Gana quien completa fila, columna o diagonal; tablero completo sin ganador es empate.
- Las coordenadas inválidas/ocupadas generan `IllegalArgumentException`; juego terminado genera `IllegalStateException`.

## Ejecutar
Requiere JDK 17+ y Maven:
```bash
mvn test
```

## Estructura de suites
- `TresEnRayaTest`: pruebas diseñadas manualmente para las reglas principales y estados.
- `TresEnRayaIATest`: conjunto comparativo basado en `PROMPT_IA.md`. Es una muestra curada para el ejercicio; revisar junto al PDF.

## GitHub
1. Crea un repositorio público vacío en GitHub, por ejemplo `kata-tres-en-raya-tdd`.
2. Descomprime el proyecto y ejecuta:
```bash
git init
git add .
git commit -m "Implementa kata Tres en Raya y suites JUnit"
git branch -M main
git remote add origin https://github.com/TU_USUARIO/kata-tres-en-raya-tdd.git
git push -u origin main
```
3. Comparte el URL real del repositorio público en la entrega.
