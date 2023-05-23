/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maestre.ejercicio2;

import java.util.Scanner;

/**
 *
 * @author Antonio Sanz Pans
 */
public class Examen2app {

    //private static final String PALABRA_OCULTA = "MIRANDO";
    private static final byte MAX_INTENTOS = 7;
    private static final byte LETRAS_PALABRA = 7;
    private static final char[] palabraOculta = new char[LETRAS_PALABRA];

    public static void main(String[] args) {
        mensajeInicio();
        rellenarPalabraOculta();
        startGame();
        mensajeFin();
    }

    private static void startGame() {
        Scanner sc = new Scanner(System.in);
        int intentos = 0;
        while (intentos < MAX_INTENTOS) {
            intentos++;
            System.out.println("Escribe tu palabra (7 Letras, sin repetir letras)");
            String palabraUsuario = sc.nextLine();
            //TODO?: Excepcion de que no sea mas de 7 letras y que cada letra no se repita
            //Como en el ejercicio se dice que se presupone que las cosas se van a hacer bien,
            //proporcionando una palabra que cumpla las codiciones no he creido necesaria la excepcion
            char[] palabraUsuarioArr = palabraUsuario.toCharArray();
            System.out.println("");
            String result = generarResultado(palabraUsuarioArr, palabraOculta, intentos);
            System.out.println(result);

        }
    }

    private static String generarResultado(char[] palabraUsuarioArr, char[] palabraOculta, int intentos) {
        int aciertos = 0;
        char value = '*';
        String result = "";

        for (int i = 0; i < palabraOculta.length; i++) {
            for (int j = 0; j < palabraUsuarioArr.length; j++) {
                value = '*';
                //MIRAR SI ENCUENTRA LA LETRA DENTRO DE LA PALABRA
                if (palabraOculta[i] == palabraUsuarioArr[j]) {
                    if (i == j) {
                        //Si la letra la encuentra y la posicion coincide se muestra la letra
                        value = palabraUsuarioArr[j];
                        aciertos++;
                        break;
                    } else {
                        //Si no coincide ninguna posicion, el valor es ?
                        value = '?';
                    }
                }

            }
            result = result + value;
        }
        System.out.println("Aciertos " + aciertos);
        System.out.println("Intentos " + intentos);
        
        if (aciertos == LETRAS_PALABRA) {
            System.out.println("HAS GANADO");
            System.out.println("Fin del programa. ¡Hasta pronto!");
            System.exit(0);
        } else if (aciertos < 7 && intentos == 7) {
            System.out.println("HAS PERDIDO");
            System.out.println("Fin del programa. ¡Hasta pronto!");
            System.exit(0);
        }

        return result;
    }

    private static void rellenarPalabraOculta() {
        //Aqui deberia haber unc odigo que generase palabras basandose en el maximo numero de letras proporcionado y que no se repitan, 
        //pero lo voy a insertar a la fuerzapor tiempo.
        palabraOculta[0] = 'M';
        palabraOculta[1] = 'I';
        palabraOculta[2] = 'R';
        palabraOculta[3] = 'A';
        palabraOculta[4] = 'N';
        palabraOculta[5] = 'D';
        palabraOculta[6] = 'O';
    }

    private static void mensajeInicio() {
        System.out.println("¡Hola! Bienvenido al ejercicio 2 de Antonio Sanz Pans");
        System.out.println("-----------------------------------------------------");
    }

    private static void mensajeFin() {
        System.out.println("---------------------------------------------------------");
        System.out.println("Ejercicio 2 de Antonio Sanz Pans finalizado. ¡Hasta luego!");
    }
}
