/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package E07;

import java.util.Scanner;

/**
 *
 * @author ANTO
 * @enunciado Diseña un programa Java para resolver una ecuación de primer grado
 * con una incógnita (x), suponiendo que los coeficientes de la ecuación (A y B)
 * se introducen desde teclado. Ax + B = 0 Se tienen que pedir los coeficientes
 * (a y b) y mostrar un mensaje que diga: "La solución de la ecuación con
 * coeficientes (poner los que hayas metido), es: (poner solución)"
 */
public class PROG02_Ejer07 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        float a;
        float b;
        float x;

        //Escanear los valores para A y B desde el teclado.
        System.out.println("Escribe el valor de A");
        a = scan.nextFloat();
        System.out.println("Escribe el valor de B:");
        b = scan.nextFloat();

        //Calculo de la ecuación
        if (a == 0 || b == 0) {
            System.out.println("No se puede calcular la solución");
        } else {
            x = -b / a;
            System.out.println("La solución de la ecuación con coeficientes" + a + "y" + b + ", es: " + x);
        }
    }
}
