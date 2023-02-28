/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1.maestre;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author ANTONIO FERNANDO SANZ PANS
 * @tema PROG07
 */
public class Launcher {

    public static void main(String[] args) {
        welcome();
        runMenu();
    }

    /**
     * Mensaje de bienvenida
     */
    private static void welcome() {
        System.out.println("Programa hecho por Antonio Sanz Pans");
        System.out.println("Fecha: 17/02/2023");
    }

    /**
     * Lanzar el menu
     */
    public static void runMenu() {
        printMenu();
        selectMenuOption();
    }

    /**
     * Mostrar texto para el menu
     */
    private static void printMenu() {
        System.out.println("Que utilidad quieres probar?");
        System.out.println("1. unirCadenas");
        System.out.println("2. contarLetra");
        System.out.println("3. esPalindroma");
        System.out.println("4. invertirCadena");
        System.out.println("5. Exit");
    }

    /**
     * Seleccionar una opcion del menú
     */
    private static void selectMenuOption() {
        try {
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
        } catch (InputMismatchException ex) {
            System.out.println("ERROR: Solo se admiten valores numéricos.");
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    /**
     * Unir strings
     */
    private static void joinStrings() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Cadena 1:");
        String str1 = sc.nextLine();
        System.out.println("Cadena 2:");
        String str2 = sc.nextLine();
        System.out.println("El resultado de unir tus cadenas es: ");
        System.out.println(UtilidadesCadenas.unirCadenas(str1, str2));

        runMenu();
    }

    /**
     * Contar las veces que una letra aparece en una palabra
     */
    private static void countLetterInWord() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Indica que letra quieres buscar:");
        String letter = sc.nextLine();
        System.out.println("Indica la palabra donde quieres buscar la letra \"" + letter + "\"");
        String word = sc.nextLine();
        System.out.println("Veces que la letra aparece: ");
        System.out.println(UtilidadesCadenas.contarLetra(word, letter.charAt(0)));

        runMenu();
    }

    /**
     * Comprobar si un string es palindromo
     */
    private static void isPalindrome() {
        //TODO: Controlar que solo se introduzcan letras

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la cadena de texto que creas que es un palíndromo:");
        String textChain = sc.nextLine();
        System.out.println(UtilidadesCadenas.esPalindromo(textChain));

        runMenu();
    }

    /**
     * Dar la vuelta a un string
     */
    private static void reverseString() {
        //TODO: Controlar que solo se introduzcan letras

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la cadena de texto que quieras dar la vuelta:");
        String textChain = sc.nextLine();
        System.out.println(UtilidadesCadenas.invertirCadena(textChain));

        runMenu();
    }

    /**
     * Salir
     */
    private static void Exit() {
        System.out.println("Fin del programa. Hasta pronto!");
        System.exit(0);
    }
}
