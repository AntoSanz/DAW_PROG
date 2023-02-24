/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio5.maestre;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ANTONIO FERNANDO SANZ PANS
 * @fecha 19/02/2022
 */
public class MoscaBidimensional {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            Random random = new Random();

            //Pedir al usuario el tamaño de la matriz
            System.out.println("Filas de la matriz?");
            byte nFilaPanel = sc.nextByte();
            System.out.println("Columnas de la matriz?");
            byte nColPanel = sc.nextByte();
            //Establecer el número de moscas
            System.out.println("¿Cuántas moscas quieres que haya?");
            byte nroMoscas = sc.nextByte();
            //Una vez establecidos los parámetros básicos, crear la matriz.
            char[][] panel = new char[nFilaPanel][nColPanel];
            //Establecer la posición de las moscas
            System.out.println("DEBUG");
            int filaMosca = 0, colMosca = 0;
            for (int i = 0; i < nroMoscas; i++) {
                // Colocamos cada mosca en una posición aleatoria del panel
                filaMosca = random.nextInt(nFilaPanel);
                colMosca = random.nextInt(nColPanel);
                panel[filaMosca][colMosca] = 'M';
            }
            System.out.println("debug");
            // Inicializamos el contador de rondas
            int numRondas = 0;
            while (numRondas < 5) {

                // Pedimos al jugador que elija una posición
                int filaJugador, colJugador;
                System.out.print("Introduce la fila (entre 0 y " + (nFilaPanel - 1) + "): ");
                filaJugador = sc.nextInt();
                System.out.print("Introduce la columna (entre 0 y " + (nColPanel - 1) + "): ");
                colJugador = sc.nextInt();

                // Aumentamos el contador de rondas
                numRondas++;
                // Comprobamos si el jugador ha cazado la mosca
                if (panel[filaJugador][colJugador] == 'M') {
                    System.out.println("¡Enhorabuena! Has cazado la mosca en " + numRondas + " rondas.");
                    return;
                }

                // Si no ha cazado la mosca, comprobamos si está en una casilla adyacente o diagonal
                boolean moscaRevolotea = false;
                for (int i = 0; i < nroMoscas; i++) {
                    if (hayMoscaAdyacente(panel, filaJugador, colJugador, filaMosca, colMosca)) {
                        System.out.println("La mosca ha revoloteado.");
                        // La mosca se mueve a una casilla aleatoria
                        int nuevaFilaMosca, nuevaColMosca;
                        do {
                            nuevaFilaMosca = random.nextInt(nFilaPanel);
                            nuevaColMosca = random.nextInt(nColPanel);
                        } while (panel[nuevaFilaMosca][nuevaColMosca] != 0);  // comprobamos que la casilla esté vacía
                        panel[filaMosca][colMosca] = 0;  // eliminamos la mosca de la casilla anterior
                        panel[nuevaFilaMosca][nuevaColMosca] = 'M';  // colocamos la mosca en la nueva casilla
                        filaMosca = nuevaFilaMosca;
                        colMosca = nuevaColMosca;
                        moscaRevolotea = true;
                    } else {
                        System.out.println("La mosca sigue donde estaba.");
                    }
                }
                // Si ha llegado aquí, el jugador no ha cazado la mosca en 5 rondas
                System.out.println("No has cazado la mosca en 5 rondas. ¡Inténtalo de nuevo!");

            }
        } catch (InputMismatchException ex) {
            System.out.println("ERROR: Solo se admiten valores numéricos.");
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    /**
     * Metodo para procesar la posición que proporciona el jugador y las
     * posiciones adyacentes de donde está la mosca.
     *
     * @param panel matriz NxM
     * @param filaJugador int, fila proporcionada por el jugador
     * @param colJugador int, columna proporcionada por el jugador
     * @param filaMosca int, fila donde está la mosca
     * @param colMosca int columna donde está la mosca
     * @return
     */
    private static boolean hayMoscaAdyacente(char[][] panel, int filaJugador, int colJugador, int filaMosca, int colMosca) {
        //Metodo para comprobar si hay una mosca adyacente
        boolean hayRevoloteo = false;
        ArrayList<int[]> adyacentes = new ArrayList<>(); // el ArrayList para almacenar las posiciones adyacentes

        for (int i = filaMosca - 1; i <= filaMosca + 1; i++) {
            for (int j = colMosca - 1; j <= colMosca + 1; j++) {
                if (i >= 0 && i < panel.length && j >= 0 && j < panel[0].length && (i != filaMosca || j != colMosca)) {

                    int[] pos = {i, j};
                    adyacentes.add(pos); // Añadir la posicion al array de posiciones adyacentes.
                }
            }
        }
        //Comparo las posiciones adyacentes almacenadas en el array con la posicion que proporciona el jugador
        for (int i = 0; i < adyacentes.size(); i++) {
            int[] checkPos = adyacentes.get(i);
            if (checkPos[0] == filaJugador && checkPos[1] == colJugador) {
                hayRevoloteo = true;
                break;
            }
        }
        //Si hay adyacente devuelve true, y si no, false
        return hayRevoloteo;
    }

}
