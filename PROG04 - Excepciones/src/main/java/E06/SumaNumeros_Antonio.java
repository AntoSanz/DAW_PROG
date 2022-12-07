package E06;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ANTONIO SANZ PANS
 */
public class SumaNumeros_Antonio {

    static final String ERROR_VALOR_NO_PERMITIDO = "ERROR: Se ha introducido un valor no permitido.";
    static final String MENSAJE_BIENVENIDA = "Bienvenido a Mostrar_AsteriscosConFor_Antonio";
    static final String MENSAJE_DESPEDIDA = "Fin del programa. Hasta pronto!";
    static ArrayList listaNumeros = new ArrayList();

    public static void main(String[] args) {
        Bienvenida();
        RunProgram();
    }

    private static void RunProgram() {
        RecogerNumeroEntero();
        Continuar();
    }

    private static void Bienvenida() {
        System.out.println(MENSAJE_BIENVENIDA);
    }

    private static void MostrarMenu() {
        System.out.println("Introduzca un número entero. (-1 para terminar)");
    }

    private static void Continuar() {
        listaNumeros.clear();
        System.out.println("¿Quieres realizar un nuevo cálculo? (S/N)");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        switch (input) {
            case "S":
                RunProgram();
                break;
            case "s":
                RunProgram();
                break;
            case "N":
                FinalizarPrograma();
                break;
            case "n":
                FinalizarPrograma();
                break;
            default:
                System.out.println("No he entendido, por favor, selecciona Si (S) o No (N).");
                Continuar();
        }
    }

    private static void FinalizarPrograma() {
        System.out.println(MENSAJE_DESPEDIDA);
        System.exit(0);
    }

    private static int RecogerNumeroEntero() {
        MostrarMenu();
        int input = 0;
        Scanner sc = new Scanner(System.in);
        try {
            input = sc.nextInt();
            if (input != -1) {
                listaNumeros.add(input);
                RecogerNumeroEntero();
            } else {
                CalculoResultado();
            }

        } catch (Exception ex) {
            System.out.println(ERROR_VALOR_NO_PERMITIDO);
            RunProgram();
        }
        return input;
    }

    private static void CalculoResultado() {
        int result = 0;
        for (int i = 0; i < listaNumeros.size(); i++) {
            result += (int) listaNumeros.get(i);
        }
        System.out.println("Resultado de sumar " + listaNumeros + ": " + result);
        Continuar();
    }
}
