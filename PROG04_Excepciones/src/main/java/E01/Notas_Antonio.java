package E01;

import java.util.Scanner;
/**
 *
 * @author ANTONIO SANZ PANS
 */
public class Notas_Antonio {

    static void rangoNotas(float nota) throws ExcepcionRangoNotas {
        if (nota > 10 || nota < 0) {
            throw new ExcepcionRangoNotas("ERROR: La nota está fuera del rango (0-10)");
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("BIENVENIDO A NOTAS");
            System.out.println("Introduce un nombre");
            Scanner sc = new Scanner(System.in);
            String nombre = sc.nextLine();
            System.out.println("Introduce una nota (0-10)");
            float nota = sc.nextFloat();
            //Compruebo que la nota está en el rango permitido
            rangoNotas(nota);

            if (nota < 5) {
                System.out.println("SUSPENSO");
            } else if (nota >= 5 && nota < 6) {
                System.out.println("APROBADO");
            } else if (nota >= 6 && nota < 7) {
                System.out.println("BIEN");
            } else if (nota >= 7 && nota < 9) {
                System.out.println("NOTABLE");
            } else if (nota >= 9 && nota < 10) {
                System.out.println("SOBRESALIENTE");
            } else if (nota == 10) {
                System.out.println("MATRICULA");
            }
        } catch (ExcepcionRangoNotas e) {
            System.out.println(e.getMessage());
        } catch (Exception ex) {
            System.out.println("ERROR: Se ha introducido un valor no permitido.");
        }

    }
}
