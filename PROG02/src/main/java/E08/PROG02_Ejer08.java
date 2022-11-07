/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package E08;

import java.util.Scanner;

/**
 *
 * @author ANTO
 * @enunciado Diseña un programa Java que calcule la suma, resta, multiplicación
 * y división de dos números introducidos por teclado. Incorpora también las
 * funciones que permitan realizar la potencia de un número y la raíz cuadrada
 * del otro.
 */
public class PROG02_Ejer08 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        float x;
        float y;

        System.out.println("Por favor introduzca el primer número:");
        x = scan.nextFloat();
        System.out.println("Por favor introduzca el segundo número:");
        y = scan.nextFloat();

        System.out.println("x = " + x + " y = " + y);
        //SUMA
        System.out.println("x + y = " + (x + y));
        //RESTA
        System.out.println("x - y = " + (x - y));
        //MULTIPLICACION
        System.out.println("x * y = " + (x * y));
        //DIVISION
        System.out.println("x / y = " + (x / y));
        //POTENCIA
        System.out.println("x ^ 2 = " + Math.pow(x,2));
        //RAIZ
        System.out.println("√ y = " + Math.sqrt(y));
    }
}
