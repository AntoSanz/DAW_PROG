/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio6.maestre;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ANTONIO FERNANDO SANZ PANS
 * @fecha 21/02/2022
 */
public class JuegoMasterMind {

    private static final byte MAX_INTENTOS = 7;
    private static final String WELCOME_MESSAGE = "Bienvenido al juego del MasterMind!";

    public static void main(String[] args) {
        System.out.println(WELCOME_MESSAGE);
        System.out.println("El programa ha generado tres números aleatorios distintos entre 0 y 9.");
        System.out.println("Tienes" + MAX_INTENTOS + " oportunidades para adivinar los números y sus posiciones correctas.");

        // Generar los números aleatorios
        Scanner scanner = new Scanner(System.in);
        int[] numerosRandom = generarArrayAleatorios();
        // Comenzar el juego
        int intentos = 0;
        try {
            while (intentos < MAX_INTENTOS) {
                intentos++;
                int[] numerosUsuario = new int[3];
                for (int i = 0; i < 3; i++) {
                    System.out.print("Ingresa el número " + (i + 1) + ": ");
                    numerosUsuario[i] = scanner.nextInt();
                }
                // Comprobar si los números son correctos
                String result = generarResultado(numerosUsuario, numerosRandom, intentos);
                System.out.println(result);
            }

            // Se han agotado los intentos
            System.out.println("Lo siento, has perdido. Los números eran " + numerosRandom[0] + ", " + numerosRandom[1] + " y " + numerosRandom[2] + ".");
        } catch (InputMismatchException ex) {
            System.out.println("ERROR: Solo se admiten valores numéricos.");
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    /**
     * Genera un array con tres numeros aleatorios comprendidos entre 0 y 9
     *
     * @return int[]
     */
    private static int[] generarArrayAleatorios() {
        Random random = new Random();
        int[] numerosRandom = new int[3];
        numerosRandom[0] = random.nextInt(10);
        do {
            numerosRandom[1] = random.nextInt(10);
        } while (numerosRandom[1] == numerosRandom[0]);
        do {
            numerosRandom[2] = random.nextInt(10);
        } while (numerosRandom[2] == numerosRandom[0] || numerosRandom[2] == numerosRandom[1]);
        return numerosRandom;
    }

    /**
     * Genera un resultado con los datos introducidos por el usuario y los
     * numeros aleatorios generados
     *
     * @param numerosUsuario int[3]
     * @param numerosRandom int[3]
     * @param intentos int
     * @return String
     */
    private static String generarResultado(int[] numerosUsuario, int[] numerosRandom, int intentos) {
        String result = "";
        int aciertos = 0;
        if (numerosUsuario[0] == numerosRandom[0]) {
            aciertos++;
            result = result + " V";
        } else if (numerosUsuario[0] == numerosRandom[1] || numerosUsuario[0] == numerosRandom[2]) {
            result = result + " A";
        } else {
            result = result + " R";
        }
        if (numerosUsuario[1] == numerosRandom[1]) {
            aciertos++;
            result = result + " V";
        } else if (numerosUsuario[1] == numerosRandom[0] || numerosUsuario[1] == numerosRandom[2]) {
            result = result + " A";
        } else {
            result = result + " R";
        }
        if (numerosUsuario[2] == numerosRandom[2]) {
            aciertos++;
            result = result + " V";
        } else if (numerosUsuario[2] == numerosRandom[0] || numerosUsuario[2] == numerosRandom[1]) {
            result = result + " A";
        } else {
            result = result + " R";
        }
        if (aciertos == 3) {
            result = "Felicidades, has ganado en " + intentos + " intentos!";
            System.out.println("Fin del programa. ¡Hasta pronto!");
            System.exit(0);
        } else {
            //Pista          
            result = numerosUsuario[0] + " " + numerosUsuario[1] + " " + numerosUsuario[2] + "\t" + result;
        }
        return result;
    }
}
