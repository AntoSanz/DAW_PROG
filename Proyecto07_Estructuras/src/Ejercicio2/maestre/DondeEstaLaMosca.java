/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2.maestre;

/**
 *
 * @author ANTONIO FERNANDO SANZ PANS
 * @fecha 17/02/2022
 */
import java.util.Random;
import java.util.Scanner;

public class DondeEstaLaMosca {

    public static void main(String[] args) {
        // Creamos un array de 8 posiciones
        boolean[] panel = new boolean[8];

        // Posicionamos la mosca aleatoriamente en una de las posiciones
        Random random = new Random();
        int posicionMosca = random.nextInt(8);
        System.out.println("posicion de la mosca " + posicionMosca);
        panel[posicionMosca] = true;

        // Inicializamos el número de rondas y el Scanner
        int numRondas = 0;
        Scanner sc = new Scanner(System.in);

        // Comenzamos el juego
        while (numRondas < 5) {
            // Mostramos el panel actual al jugador
            System.out.println("Panel actual:");
            System.out.println("-----------------------");
            for (int i = 0; i < panel.length; i++) {
                System.out.print(i + "  ");
            }
            System.out.println();
            System.out.println("-----------------------");

            // Pedimos al jugador que elija una posición
            System.out.print("Elige una posición (0-7): ");
            int posicionElegida = sc.nextInt();

            // Validamos que la posición elegida sea correcta
            if (posicionElegida < 0 || posicionElegida > 7) {
                System.out.println("Posición incorrecta, elige una posición del 0 al 7.");
                continue;
            }

            // Incrementamos el número de rondas
            numRondas++;

            // Comprobamos si se ha cazado la mosca
            if (posicionElegida == posicionMosca) {
                System.out.println("¡Enhorabuena! Has cazado la mosca en " + numRondas + " rondas.");
                return;
            }

            // Comprobamos si la mosca ha revoloteado
            int distancia = Math.abs(posicionElegida - posicionMosca);
            if (distancia == 1) {
                System.out.println("La mosca ha revoloteado a otra posición.");
                posicionMosca = random.nextInt(8);
                panel[posicionMosca] = true;
            } else {
                System.out.println("La mosca sigue donde estaba, elige otra posición.");
            }
        }

        // Si ha llegado aquí, el jugador no ha cazado la mosca en 5 rondas
        System.out.println("No has cazado la mosca en 5 rondas. ¡Inténtalo de nuevo!");
    }

}
