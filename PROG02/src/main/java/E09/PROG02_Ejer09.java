/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package E09;

import java.util.Scanner;

/**
 *
 * @author ANTO enunciado Diseña un programa Java que solicite un número de 8
 * dígitos del teclado, separe el número en sus dígitos individuales y los
 * muestre por pantalla. Por ejemplo, si el número es 43218765 que muestre: El
 * número desgranado es: 4 / 3 / 3 / 1 / 8 / 7 / 6 / 5 Tienen que salir las
 * barras y el mensaje
 */
public class PROG02_Ejer09 {

    public static void main(String[] args) {
        int num;
        int numCheck;
        int digitos = 0;
        String result = "";
        Scanner scan = new Scanner(System.in);
        System.out.println("Por favor introduzca un número de 8 digitos:");
        num = scan.nextInt();
        
        //Comprobación para ver si tiene 8 digitos.
        numCheck = num;
        while (numCheck != 0) {
            numCheck = numCheck / 10;
            digitos++;
        }
        if (digitos < 8) {
            //Si no tiene 8 digitos lo descartamos
            System.out.println("El numero" + num + " no tiene 8 digitos.");
        } else {
            //Si tiene 8 digitos
            String number = String.valueOf(num);
            char[] numbers = number.toCharArray();
            
            for (int i = 0; i < numbers.length; i++) {
                result = result + numbers[i] + " / ";
            }
            System.out.println("El número desgranado es: " + result);
        }

    }
}
