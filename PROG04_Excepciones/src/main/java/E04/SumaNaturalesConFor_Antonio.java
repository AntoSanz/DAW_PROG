package E04;

import java.util.Scanner;

/**
 *
 * @author ANTO
 */
public class SumaNaturalesConFor_Antonio {

    static final String ERROR_VALOR_NO_PERMITIDO = "ERROR: Se ha introducido un valor no permitido.";
    static final String MENSAJE_BIENVENIDA = "Bienvenido a SumaNaturalesConFor_Antonio";
    static final String MENSAJE_DESPEDIDA = "Fin del programa. Hasta pronto!";

    public static void main(String[] args) {
        Bienvenida();
        RunProgram();
    }

    private static void RunProgram() {
        MostrarMenu();
        int inputNum = RecogerNumeroEntero();
        CalculoNaturales(inputNum);
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

    private static void CalculoNaturales(int n) {
        //Calcula el valor de la suma de los n primeros numeros naturales (Incluido n). 
        int r = 0;
        String rInConsole = "";
        for (int i = 0; i <= n; i++) {
            r = r + i;
            rInConsole = rInConsole + r + " ";
            System.out.println(rInConsole);
        }
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
}
