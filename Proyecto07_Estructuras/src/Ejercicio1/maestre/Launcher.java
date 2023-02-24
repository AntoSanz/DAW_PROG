/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1.maestre;

import java.util.Scanner;

/**
 *
 * @author ANTONIO FERNANDO SANZ PANS
 * @fecha 17/02/2022
 */
public class Launcher {

    public static void main(String[] args) {
        welcome();
        runMenu();
    }

    private static void welcome() {
        System.out.println("Programa hecho por Antonio Sanz Pans");
        System.out.println("Fecha: 17/02/2023");
    }

    public static void runMenu() {
        printMenu();
        selectMenuOption();
    }

    private static void printMenu() {
        System.out.println("Que utilidad quieres probar?");
        System.out.println("1. unirCadenas");
        System.out.println("2. contarLetra");
        System.out.println("3. esPalindroma");
        System.out.println("4. invertirCadena");
        System.out.println("5. Exit");
    }

    private static void selectMenuOption() {
        //TODO: Controlar que solo se introduzcan numeros

        Scanner sc = new Scanner(System.in);
        byte option = sc.nextByte();
        switch (option) {
            case 1:
                joinStrings();
                break;
            case 2:
                countLetterInWord();
                break;
            case 3:
                isPalindrome();
                break;
            case 4:
                reverseString();
                break;
            case 5: 
                Exit();
                break;
            default:
                System.out.println("Opción no encontrada, selecciona otra.");
                runMenu();
                break;
        }
    }

    private static void joinStrings() {
        //TODO: Controlar que solo se introduzcan letras

        Scanner sc = new Scanner(System.in);
        System.out.println("Cadena 1:");
        String str1 = sc.nextLine();
        System.out.println("Cadena 2:");
        String str2 = sc.nextLine();
        System.out.println("El resultado de unir tus cadenas es: ");
        System.out.println(UtilidadesCadenas.unirCadenas(str1, str2));

        runMenu();
    }

    private static void countLetterInWord() {
        //TODO: Controlar que solo se introduzcan letras
        Scanner sc = new Scanner(System.in);
        System.out.println("Indica que letra quieres buscar:");
        //TODO: Controlar que solo se introduzca una letra.
        String letter = sc.nextLine();
        System.out.println("Indica la palabra donde quieres buscar la letra \"" + letter + "\"");
        String word = sc.nextLine();
        System.out.println("Veces que la letra aparece: ");
        System.out.println(UtilidadesCadenas.contarLetra(word, letter.charAt(0)));

        runMenu();
    }

    private static void isPalindrome() {
        //TODO: Controlar que solo se introduzcan letras

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la cadena de texto que creas que es un palíndromo:");
        String textChain = sc.nextLine();
        System.out.println(UtilidadesCadenas.esPalindromo(textChain));

        runMenu();
    }

    private static void reverseString() {
        //TODO: Controlar que solo se introduzcan letras

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la cadena de texto que quieras dar la vuelta:");
        String textChain = sc.nextLine();
        System.out.println(UtilidadesCadenas.invertirCadena(textChain));

        runMenu();
    }

    private static void Exit() {
        System.out.println("Fin del programa. Hasta pronto!");
        System.exit(0);
    }
}
