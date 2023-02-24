package E05;

import java.util.Scanner;

/**
 *
 * @author ANTONIO SANZ PANS
 */
public class Mostrar_AsteriscosConFor_Antonio {

    static final String ERROR_VALOR_NO_PERMITIDO = "ERROR: Se ha introducido un valor no permitido.";
    static final String MENSAJE_BIENVENIDA = "Bienvenido a Mostrar_AsteriscosConFor_Antonio";
    static final String MENSAJE_DESPEDIDA = "Fin del programa. Hasta pronto!";

    public static void main(String[] args) {
        Bienvenida();
        RunProgram();
    }

    private static void RunProgram() {
        MostrarMenu();
        int inputNum = RecogerNumeroEntero();
        MostrarAsteriscos(inputNum);
        Continuar();
    }

    private static void Bienvenida() {
        System.out.println(MENSAJE_BIENVENIDA);
    }

    private static void MostrarMenu() {
        System.out.println("Introduzca un número entero.");
    }

    private static int RecogerNumeroEntero() {
        int input = 0;
        try {
            Scanner sc = new Scanner(System.in);
            input = sc.nextInt();
        } catch (Exception ex) {
            System.out.println(ERROR_VALOR_NO_PERMITIDO);
            RunProgram();
        }
        return input;
    }

    private static void Continuar() {
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

    private static void MostrarAsteriscos(int n) {
        String asteriscos = "";
        for (int i = 0; i < n; i++) {
            asteriscos = asteriscos + "*";
            System.out.println(asteriscos);
        }
    }
}
