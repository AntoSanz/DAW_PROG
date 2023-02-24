/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio3.maestre;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author ANTONIO FERNANDO SANZ PANS
 * @tema PROG07
 */
public class OperacionesArraysMultidimensionales {

    public static void main(String[] args) {
        try {
            //Pedir al usuario que indique el tamaño de la matriz.
            System.out.println("Indica el tamaño de la matriz");
            Scanner sc = new Scanner(System.in);
            int size = sc.nextInt();
            //Crea matriz y automaticamente, en la clase, la rellena con numeros aleatorios.
            Matriz miMatriz = new Matriz(size);
            System.out.println("Matriz aleatoria:");
            miMatriz.mostrarMatriz();
            //Busca y muestra el valor máximo de cada fila.
            System.out.println("Máximos:");
            miMatriz.mostrarMaximos();
            //Calcula la media de los máximos.
            System.out.println("Media de los máximos:");
            System.out.println(miMatriz.calcularMediaMaximos());
        } catch (InputMismatchException ex) {
            System.out.println("ERROR: Solo se admiten valores numéricos.");
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }
}
