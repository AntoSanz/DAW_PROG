/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio4.maestre;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author ANTONIO FERNANDO SANZ PANS
 * @tema PROG07
 */
public class Launcher {

    static final String CC_TIPO_1 = "Planeta";
    static final String CC_TIPO_2 = "Planeta enano";
    static final String CC_TIPO_3 = "Luna";
    static ArrayList cuerposCelestes = new ArrayList();
    static boolean firstRunMessage = false;

    public static void main(String[] args) {
        firstRunMessage = true;
        wellcomeText();
        runMenu();
    }

    /**
     * Lanzar el menu
     */
    private static void runMenu() {
        if (!firstRunMessage) {
            showContinueMenu();
        }
        showTextMenu();
        checkMenuOption();
    }

    /**
     * Mostrar mensaje de bienvenida
     */
    private static void wellcomeText() {
        System.out.println("Bienvenido al programa para añadir cuerpos celestes.");
        System.out.println("¿Qué quiere hacer?");
        firstRunMessage = false;
    }

    /**
     * Mostrar mensaje para continuar creando cuerpos celestes
     */
    private static void showContinueMenu() {
        System.out.println("¿Quieres continuar añadiendo cuerpos celestes?");
    }

    /**
     * Mostrar el texto del menu
     */
    private static void showTextMenu() {
        System.out.println("1. Añadir cuerpo celeste");
        System.out.println("2. Salir del programa");
    }

    /**
     * Recoger la opcion elegida enel menu por el usuario
     */
    private static void checkMenuOption() {
        try {
            Scanner sc = new Scanner(System.in);
            byte option = sc.nextByte();
            switch (option) {
                case 1:
                    runAddCuerpoCelesteToArray();
                    break;
                case 2:
                    exit();
                    break;
                default:
                    break;
            }
        } catch (InputMismatchException ex) {
            System.out.println("ERROR: Solo se admiten valores numéricos.");
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    /**
     * Lanzar proceso para añadir cuerpo celeste al array
     */
    private static void runAddCuerpoCelesteToArray() {
        CuerpoCeleste cp = createCuerpoCeleste();
        addCuerpoCelesteToArray(cp);
    }

    /**
     * Crear cuerpo celeste
     *
     * @return miCuerpoCeleste
     */
    private static CuerpoCeleste createCuerpoCeleste() {

            Scanner sc = new Scanner(System.in);
            CuerpoCeleste miCuerpoCeleste = new CuerpoCeleste();
            System.out.println("Para añadir un nuevo cuerpo celeste debes rellenar los siguientes datos:");
            System.out.println("Código (maxLength: " + miCuerpoCeleste.getMaxLengthCodigo() + ")");
            short codigoCuerpo = sc.nextShort();

            System.out.println("Nombre (maxLength: " + miCuerpoCeleste.getMaxLengthNombre() + ")");
            sc.nextLine();
            String nombreCuerpo = sc.nextLine();

            System.out.println("Diámetro (maxLength: " + miCuerpoCeleste.getMaxLengthDiametro() + ")");
            int diametroCuerpo = sc.nextInt();

            System.out.println("Tipo");
            System.out.println("1. " + CC_TIPO_1);
            System.out.println("2. " + CC_TIPO_2);
            System.out.println("3. " + CC_TIPO_3);
            byte opcionTipo = sc.nextByte();
            String tipoCuerpo;
            switch (opcionTipo) {
                case 1 ->
                    tipoCuerpo = CC_TIPO_1;
                case 2 ->
                    tipoCuerpo = CC_TIPO_2;
                case 3 ->
                    tipoCuerpo = CC_TIPO_3;
                default ->
                    throw new AssertionError();
            }

            miCuerpoCeleste.setCodigoCuerpo(codigoCuerpo);
            miCuerpoCeleste.setNombre(nombreCuerpo);
            miCuerpoCeleste.setDiametro(diametroCuerpo);
            miCuerpoCeleste.setTipoObjeto(tipoCuerpo);
            System.out.println("Cuerpo celeste creado.");
            System.out.println(miCuerpoCeleste.toString());

            return miCuerpoCeleste;
    }

    /**
     * Añadir cuerpo celeste al array
     *
     * @param cuerpoCeleste
     */
    private static void addCuerpoCelesteToArray(CuerpoCeleste cuerpoCeleste) {
        cuerposCelestes.add(cuerpoCeleste);
        runMenu();
    }

    /**
     * Mostrar todos los cuerpos celestes
     */
    private static void showCuerposCelestes() {
        System.out.println("Lista de cuerpos celestes creados:");
        for (Object cp : cuerposCelestes) {
            System.out.println(cp.toString());
        }
    }

    /**
     * Salir
     */
    private static void exit() {
        showCuerposCelestes();
        System.out.println("Fin del programa. ¡Hasta pronto!");
        System.exit(0);
    }
}
