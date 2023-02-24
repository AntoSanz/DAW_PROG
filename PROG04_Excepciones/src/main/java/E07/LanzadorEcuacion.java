package E07;

import java.util.Scanner;

/**
 *
 * @author ANTO
 */
public class LanzadorEcuacion {

    public static void main(String[] args) {
        MensajeBienvenida();
        RunProgram();
    }

    private static void RunProgram() {
        PideValores();
    }

    private static void MensajeBienvenida() {
        System.out.println("Bienvenido al lanzador.");
    }

    private static void PideValores() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduce el valor de a:");
            int a = sc.nextInt();
            System.out.println("Introduce el valor de b:");
            int b = sc.nextInt();
            System.out.println("Introduce el valor de c:");
            int c = sc.nextInt();

            Ecuacion_Antonio ecuacion = new Ecuacion_Antonio(a, b, c);

            ecuacion.calcularX1();
            ecuacion.calcularX2();

            Continuar();

        } catch (ExcepcionDiscriminanteNegativo e) {
            System.out.println(e.getMessage());
            Continuar();
        } catch (Exception ex) {
            System.out.println("Valor no permitido.");
            RunProgram();
        }
    }

    private static void Continuar() {
        System.out.println("¿Quieres realizar un nuevo cálculo? (S/N)");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        switch (input) {
            case "S" ->
                RunProgram();
            case "s" ->
                RunProgram();
            case "N" ->
                FinalizarPrograma();
            case "n" ->
                FinalizarPrograma();
            default -> {
                System.out.println("No he entendido, por favor, selecciona Si (S) o No (N).");
                Continuar();
            }
        }
    }

    private static void FinalizarPrograma() {
        System.out.println("Fin del programa. Hasta pronto!");
        System.exit(0);
    }
}
