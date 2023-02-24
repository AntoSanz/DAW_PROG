/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio3.maestre;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author ANTONIO FERNANDO SANZ PANS
 * @fecha 17/02/2022
 */
public class Matriz {

    private int[][] matriz;
    private int tamanoMatriz;

    private int[] maximos;
    private double mediaMaximos;

    //Constructores
    public Matriz() {
    }

    public Matriz(int n) {
        this.matriz = new int[n][n];
        this.maximos = new int[n];
        this.tamanoMatriz = n;
        this.rellenarMatrizAleatoria();
    }

    //Getter y Setters
    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

    public int getTamanoMatriz() {
        return tamanoMatriz;
    }

    public void setTamanoMatriz(int tamanoMatriz) {
        this.tamanoMatriz = tamanoMatriz;
    }

    public int[] getMaximos() {
        return maximos;
    }

    public void setMaximos(int[] maximos) {
        this.maximos = maximos;
    }

    public double getMediaMaximos() {
        return mediaMaximos;
    }

    public void setMediaMaximos(double mediaMaximos) {
        this.mediaMaximos = mediaMaximos;
    }

    //Metodos
    private void rellenarMatrizAleatoria() {
        Random r = new Random();
        for (int i = 0; i < tamanoMatriz; i++) {
            for (int j = 0; j < tamanoMatriz; j++) {
                matriz[i][j] = r.nextInt(9) + 1;
            }
        }
    }

    public void mostrarMatriz() {
        for (int i = 0; i < tamanoMatriz; i++) {
            for (int j = 0; j < tamanoMatriz; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void buscarMaximos() {
        int maximoFila;
        for (int i = 0; i < tamanoMatriz; i++) {
            maximoFila = 0; //Reiniciar en cada vuelta.
            for (int j = 0; j < tamanoMatriz; j++) {
                if (matriz[i][j] > maximoFila) {
                    maximoFila = matriz[i][j];
                     this.maximos[i] = maximoFila;
                }
            }
        }
    }
    
    public void mostrarMaximos() {
        this.buscarMaximos();

        for (int i = 0; i < tamanoMatriz; i++) {
            System.out.print(maximos[i] + " ");
        }
        System.out.println();
    }

    public double calcularMediaMaximos() {
        int sumaMaximos = 0;
        for (int i = 0; i < tamanoMatriz; i++) {
            sumaMaximos += maximos[i];
        }
        this.mediaMaximos = (double) sumaMaximos / tamanoMatriz;
        return mediaMaximos;
    }
}
