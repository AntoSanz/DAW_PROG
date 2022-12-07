package E05;

import java.util.Scanner;

/**
 *
 * @author ANTO
 */
public class PROG02_Ejer05 {

    public static void main(String[] args) {
        int num1;
        int num2;
        int num3;

        Scanner scan = new Scanner(System.in);
        System.out.println("Introduzca un numero");
        num1 = scan.nextInt();

        System.out.println("Introduzca un segundo numero");
        num2 = scan.nextInt();

        System.out.println("Introduzca un tercer numero");
        num3 = scan.nextInt();

        int resto = num1 % num2;
        if (resto == 0) {
            System.out.println(num1 + " es multiplo de num2");
        } else {
            System.out.println(num1 + " NO es multiplo de num2");
        }

        System.out.println("El resultado de sumar el segundo y el tercer numero y ese total, multiplicarlo por el primero es : "
                + ((num2 * num3) / num1)
        );
    }
}
