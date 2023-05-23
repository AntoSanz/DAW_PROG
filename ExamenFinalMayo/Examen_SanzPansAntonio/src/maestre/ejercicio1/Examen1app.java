/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maestre.ejercicio1;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Antonio Sanz Pans
 */
public class Examen1app {

    public static void main(String[] args) {
        mensajeInicio();
        //Crear constantes para N y M
        final byte N = 10;
        final byte M = 10;
        //Crear matriz NxM
        byte[][] matriz = new byte[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                byte r = getRandom();
                matriz[i][j] = r;
            }

        }
        mostrarSumaColumna(matriz);
        mensajeFin();
    }

    private static byte getRandom() {
        byte r = 0;
        Random rd = new Random();
        r = (byte) rd.nextInt(101);
        return r;
    }

    private static void mostrarSumaColumna(byte[][] matriz) {
        System.out.println("Se va a mostrar lo que suma cada columna de la matriz:");
        int suma = 0;
        ArrayList<Integer> sumas = new ArrayList<>();
        for (int i = 0; i < matriz.length; i++) {
            //por cada vuelta suma se reinicia
            suma = 0;
            for (int j = 0; j < 10; j++) {
                suma = suma + matriz[i][j];
            }
            //añado cada valor de suma a un arraylist para almacenar todas las sumas
            sumas.add(suma);
            System.out.println("SUMA COLUMNA[" + i + "] = " + suma);
        }
        getMaxSuma(sumas);
    }

    private static void getMaxSuma(ArrayList<Integer> sumas) {
        //Establecer que columna es la de la suma mayor
        int maxSuma = 0;
        int winnerCol = 0;
        
        for (int i = 0; i < sumas.size(); i++) {
            if (maxSuma < sumas.get(i)) {
                maxSuma = sumas.get(i);
                winnerCol = i;
            }   
        }
        System.out.println("La columna con el valor mas alto es " + winnerCol + " con un valor de " + maxSuma);
    }

    private static void mensajeInicio() {
        System.out.println("¡Hola! Bienvenido al ejercicio 1 de Antonio Sanz Pans");
        System.out.println("-----------------------------------------------------");
    }

    private static void mensajeFin() {
        System.out.println("---------------------------------------------------------");
        System.out.println("Ejercicio 1 de Antonio Sanz Pans finalzado. ¡Hasta luego!");
    }
}
