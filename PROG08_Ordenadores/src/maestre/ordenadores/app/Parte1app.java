/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maestre.ordenadores.app;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import maestre.ordenadores.modelo.Ordenador;
import maestre.ordenadores.modelo.Portatil;
import maestre.ordenadores.modelo.Sobremesa;

/**
 *
 * @author ANTONIO SANZ PANS
 */
public class Parte1app {

    private static final Ordenador ordenadores[] = new Ordenador[6];
    private static final String MSG_INPUT_MISMATCH_EX = "Introduce un valor valido.";
    private static final String MSG_ERROR = "Ha ocurrido un error.";

    public static void main(String[] args) {
        System.out.println(msgBienvenida());
        generarArrayOrdenadores();
        showOrdenadores();
        //showPortatiles();
        //showSobremesa();
        //seleccionarOrdenador();
        runMenu();
    }

    /**
     * Rellena el array de ordenadores con datos precargados.
     */
    private static void generarArrayOrdenadores() {
        Portatil miPortatil1 = new Portatil("c0043ns", "HP", "OMEN 16", (byte) 8, "AMD Ryzen 7", (byte) 4, "SSD", (byte) 22);
        Portatil miPortatil2 = new Portatil("15IAH7", "Lenovo ", "IdeaPad Gaming 3", (byte) 4, "Intel Core i5", (byte) 2, "HDD", (byte) 23);
        Portatil miPortatil3 = new Portatil("M6500QC", "ASUS", "VivoBook Pro 15", (byte) 16, "AMD Ryzen 7", (byte) 8, "SSD", (byte) 24);

        Sobremesa miSobremesa1 = new Sobremesa("10023724", "PcCom", "Gold Elite", (byte) 8, "Intel Core i5", (byte) 6, "HDD", "MSI B560M PRO-VDH", "GeForce RTX2060");
        Sobremesa miSobremesa2 = new Sobremesa("657XES", "MSI", "MAG Infinite S3", (byte) 16, "Intel Core i7", (byte) 8, "SSD", "MSI MPG B550 GAMING PLUS", "GeForce RTX3060");
        Sobremesa miSobremesa3 = new Sobremesa("D500TC", "ASUS ", "ExpertCenter D5", (byte) 8, "Intel Core i5", (byte) 2, "HDD", "GeForceGigabyte B760", "GeForce 1080");

        ordenadores[0] = miPortatil1;
        ordenadores[1] = miPortatil2;
        ordenadores[2] = miPortatil3;
        ordenadores[3] = miSobremesa1;
        ordenadores[4] = miSobremesa2;
        ordenadores[5] = miSobremesa3;
    }

    /**
     * Muestra un mensaje de bienvenida.
     *
     * @return msg (String)
     */
    private static String msgBienvenida() {
        final String msg = "Bienvenido a la tarea PROG08 parte 1.";
        return msg;
    }

    /**
     * Lanza el menú de selección.
     */
    private static void runMenu() {
        showMenu();
        funcionalidadMenu();
    }

    /**
     * Muestra las opciones para el menu.
     */
    private static void showMenu() {
        System.out.println("---------------------");
        System.out.println("Selecciona una opción");
        System.out.println("1. Mostrar todos los ordenadores");
        System.out.println("2. Mostrar todos los portátiles");
        System.out.println("3. Mostrar todos los sobremesa");
        System.out.println("4. Encender un ordenador");
        System.out.println("5. Apagar un ordenador");
        System.out.println("6. Dibujar un ordenador");
        System.out.println("7. Cargar portátiles");
        System.out.println("8. Descargar portçatiles");
        System.out.println("0. Salir");
    }

    /**
     * Funcionalidad para el menú generado por showMenu.
     */
    private static void funcionalidadMenu() {
        try {
            Scanner sc = new Scanner(System.in);
            byte option = sc.nextByte();
            switch (option) {
                case 1 ->
                    showOrdenadores();
                case 2 ->
                    showPortatiles();
                case 3 ->
                    showSobremesa();
                case 4 ->
                    runOnOffOrdenador("ON");
                case 5 ->
                    runOnOffOrdenador("OFF");
                case 6 ->
                    dibujarOrdenador();
                case 7 ->
                    cargarPortatiles();
                case 8 ->
                    descargarPortatiles();
                case 0 ->
                    exit();
                default -> {
                    System.out.println("Selecciona un opcion valida.");
                    runMenu();
                    throw new AssertionError();
                }
            }
        } catch (InputMismatchException ex) {
            System.out.println(ex + ". " + MSG_INPUT_MISMATCH_EX);
            runMenu();
        } catch (Exception ex) {
            System.out.println(ex + ". " + MSG_ERROR);
            throw new AssertionError();
        }
    }

    /**
     * Muestra una lista de los TODOS los ordenadores.
     */
    private static void showOrdenadores() {
        System.out.println("--------------------------------------");
        System.out.println("Estos son los ordenadores almacenados:");
        for (Ordenador ordenador : ordenadores) {
            System.out.println(ordenador.toString());
        }
        runMenu();
    }

    /**
     * Muestra una lista de los ordenadores PORTATILES.
     */
    private static void showPortatiles() {
        System.out.println("-------------------------------------");
        System.out.println("Estos son los portatiles almacenados:");

        for (Ordenador ordenador : ordenadores) {
            if (ordenador instanceof Portatil) {
                System.out.println(ordenador.toString());
            }
        }
        runMenu();
    }

    /**
     * Muestra una lista de los ordenadores SOBREMESA.
     */
    private static void showSobremesa() {
        System.out.println("------------------------------------");
        System.out.println("Estos son los sobremesa almacenados:");

        for (Ordenador ordenador : ordenadores) {
            if (ordenador instanceof Sobremesa) {
                System.out.println(ordenador.toString());
            }
        }
        runMenu();
    }

    /**
     * Selecciona un ordenador. Se pide la posición del ordenador en el array.
     *
     * @return opcion (byte)
     */
    private static byte seleccionarOrdenador() {
        System.out.println("---------------------");
        for (int i = 0; i < ordenadores.length; i++) {
            System.out.println("[" + i + "] " + ordenadores[i].toString());
        }
        System.out.println("---------------------");
        System.out.println("Indica qué ordenador.");
        byte option = 0;
        try {
            Scanner sc = new Scanner(System.in);
            option = sc.nextByte();
            //return option;
        } catch (InputMismatchException ex) {
            System.out.println(ex + ". " + MSG_INPUT_MISMATCH_EX);
            seleccionarOrdenador();
        } catch (Exception ex) {
            System.out.println(ex + ". " + MSG_ERROR);
            throw new AssertionError();
        }
        return option;
    }

    /**
     * Enciende un ordenador.
     *
     * @param nOrdenador (byte)
     */
    private static void encenderOrdenador(byte nOrdenador) {
        ordenadores[nOrdenador].arrancar();
        System.out.println(ordenadores[nOrdenador].toString());
        runMenu();
    }

    /**
     * Apagar un ordenador.
     *
     * @param nOrdenador (byte)
     */
    private static void apagarOrdenador(byte nOrdenador) {
        ordenadores[nOrdenador].apagar();
        System.out.println(ordenadores[nOrdenador].toString());
        runMenu();
    }

    /**
     * Selección para apagar o encender un ordenador
     *
     * @param option (String) "ON" para encender, "OFF" para apagar
     */
    private static void runOnOffOrdenador(String option) {
        byte iOrdenador = seleccionarOrdenador();
        switch (option) {
            case "ON" ->
                encenderOrdenador(iOrdenador);
            case "OFF" ->
                apagarOrdenador(iOrdenador);
            default ->
                throw new AssertionError();
        }
    }

    /**
     * Utiliza el método dibujar de la clase Ordenador. Pide qué posicion del
     * array de ordenadores dibujar
     */
    private static void dibujarOrdenador() {
        byte iOrdenador = seleccionarOrdenador();
        ordenadores[iOrdenador].dibujar();
        runMenu();
    }

    /**
     * Carga los portátiles el numero indicado
     */
    private static void cargarPortatiles() {
        try {
            System.out.println("¿Cuanta batería quieres cargar a los portátiles?");
            Scanner sc = new Scanner(System.in);
            short carga = sc.nextShort();

            System.out.println("Cargando ordenadores...");
            Thread.sleep(1 * 1000);
            for (Ordenador ordenador : ordenadores) {
                if (ordenador instanceof Portatil portatil) {
                    System.out.println(portatil.cargar(carga));
                    Thread.sleep(1 * 1000);
                }
            }
            runMenu();
        } catch (InterruptedException ex) {
            throw new AssertionError();

        } catch (InputMismatchException ex) {
            System.out.println(ex + MSG_INPUT_MISMATCH_EX);
            runMenu();
        } catch (Exception ex) {
            System.out.println(ex + MSG_ERROR);
            throw new AssertionError();
        }
    }

    /**
     * Descarga los portátiles el número indicado
     */
    private static void descargarPortatiles() {
        try {
            System.out.println("¿Cuanta batería quieres descargar a los portátiles?");
            Scanner sc = new Scanner(System.in);
            short descarga = sc.nextShort();

            System.out.println("Descargando ordenadores...");
            Thread.sleep(1 * 1000);
            for (Ordenador ordenador : ordenadores) {
                if (ordenador instanceof Portatil portatil) {
                    System.out.println(portatil.descargar(descarga));
                    Thread.sleep(1 * 1000);
                }
            }
            runMenu();
        } catch (InterruptedException ex) {
            throw new AssertionError();
        } catch (InputMismatchException ex) {
            System.out.println(ex + ". " + MSG_INPUT_MISMATCH_EX);
            runMenu();
        } catch (Exception ex) {
            System.out.println(ex + ". " + MSG_ERROR);
            throw new AssertionError();
        }
    }

    /**
     * Salir
     */
    private static void exit() {
        System.out.println("Fin del programa. Hasta pronto!");
        System.exit(0);
    }
}
