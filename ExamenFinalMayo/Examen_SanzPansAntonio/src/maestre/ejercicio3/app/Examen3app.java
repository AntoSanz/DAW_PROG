/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maestre.ejercicio3.app;

import java.util.Arrays;
import maestre.ejercicio3.modelos.Comida;
import maestre.ejercicio3.modelos.ComidaPostre;
import maestre.ejercicio3.modelos.ComidaPrincipal;

/**
 *
 * @author Antonio Sanz Pans
 */
public class Examen3app {
    private static final Comida comidas[] = new Comida[4];

    public static void main(String[] args) {
        mensajeInicio();
        crearComida();
        mostrarComida();
        mostrarTodo();
        mostrarPrincipal();
        mostrarPostre();
        explicarPosicion3();
        ordenarCalorias(comidas);
        mensajeFin();
    }

    private static void crearComida() {
        ComidaPrincipal miComidaPizza = new ComidaPrincipal(6, "Pizza", "Crearla masa y añadir los ingredientes", 200, "moderada");
        ComidaPrincipal miComidaEnsalada = new ComidaPrincipal(2, "Ensalada", "Cortar los ingredientes y aliñarlos", 20, "facil");
        ComidaPostre miComidaFruta = new ComidaPostre("frio", "Fruta", "Comprar en la fruteria", 10, "facil");
        ComidaPostre miComidaTarta = new ComidaPostre("frio", "Tarta Red Velvet", "Hacer la masa, mezclar con colorante rojo, preparar la nata, montar la tarta", 300, "dificil");

        comidas[0] = miComidaPizza;
        comidas[1] = miComidaEnsalada;
        comidas[2] = miComidaFruta;
        comidas[3] = miComidaTarta;
    }

    private static void mostrarComida() {
        for (Comida comida : comidas) {
            System.out.println(comida.toString());
        }
    }

    private static void mostrarTodo() {
        System.out.println("");
        System.out.println("MOSTRAR TODAS LAS COMIDAS SIN FILTRO");
        for (Comida comida : comidas) {
            System.out.println(comida.toString());
        }
    }

    private static void mostrarPrincipal() {
        System.out.println("");
        System.out.println("MOSTRAR SOLO PLATOS PRINCIPALES");
        for (Comida comida : comidas) {
            if (comida instanceof ComidaPrincipal) {
                System.out.println(comida.toString());
            }
        }
    }

    private static void mostrarPostre() {
        System.out.println("");
        System.out.println("MOSTRAR SOLO POSTRES");
        for (Comida comida : comidas) {
            if (comida instanceof ComidaPostre) {
                System.out.println(comida.toString());
            }
        }
    }

    private static void explicarPosicion3() {
        System.out.println("");
        System.out.println("EXPLICAR POSICION 3");
        comidas[3].explicarReceta();
    }

    static void ordenarCalorias(Comida[] c) {
        //TODO: NO FUNCIONA
        System.out.println("");
        System.out.println("ORDENAR POR CALORIAS");
        Arrays.sort(c);
        for (Comida comida : c) {
            System.out.println(comida.toString());
        }
    }

    private static void mensajeInicio() {
        System.out.println("¡Hola! Bienvenido al ejercicio 3 de Antonio Sanz Pans");
        System.out.println("-----------------------------------------------------");
    }

    private static void mensajeFin() {
        System.out.println("---------------------------------------------------------");
        System.out.println("Ejercicio 3 de Antonio Sanz Pans finalzado. ¡Hasta luego!");
    }
}
