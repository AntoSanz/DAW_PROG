/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1.maestre;

/**
 *
 * @author ANTONIO FERNANDO SANZ PANS
 * @tema PROG07
 */
public class UtilidadesCadenas {

    /**
     * Método para unir dos cadenas
     *
     * @param cadena1
     * @param cadena2
     * @return String
     */
    public static String unirCadenas(String cadena1, String cadena2) {
        return cadena1 + cadena2;
    }

    /**
     * Método para contar cuántas veces aparece una letra en una cadena
     *
     * @param cadena
     * @param letra
     * @return String
     */
    public static int contarLetra(String cadena, char letra) {
        int count = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == letra) {
                count++;
            }
        }
        return count;
    }

    /**
     * Método para verificar si una cadena es palíndroma
     *
     * @param cadena
     * @return String
     */
    public static String esPalindromo(String cadena) {
        //Elimino espacios y pongo en minuscula
        String cadenaSinEspacios = cadena.replaceAll("\\s", "").toLowerCase();
        StringBuilder sb = new StringBuilder(cadenaSinEspacios);
        //Le doy la vuelta
        String cadenaAlReves = sb.reverse().toString();
        //Comparo con un ternario las dos cadenas de texto
        String resultado = (cadenaSinEspacios.equalsIgnoreCase(cadenaAlReves)) ? "Es palíndromo" : "No es palíndromo";
        return resultado;
    }

    /**
     * Método para invertir una cadena
     *
     * @param cadena
     * @return String
     */
    public static String invertirCadena(String cadena) {
        StringBuilder sb = new StringBuilder(cadena);
        return sb.reverse().toString();
    }
}
