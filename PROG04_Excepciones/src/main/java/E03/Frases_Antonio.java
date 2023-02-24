package E03;

import java.util.Scanner;

/**
 *
 * @author ANTONIO SANZ PANS
 */
public class Frases_Antonio {

    public static void main(String[] args) {
        Bienvenida();
        RunProgram();
    }

    private static void RunProgram() {
        //Metodo encargado de ejecutar el programa. Como el main no se puede llamar,
        //utilizo esta función para cuando el usuario introduzca un valor no váludo reiniciar el programa.
        MostrarMenu();
        int input = RecogerDatos();
        ElijeFrase(input);
    }
    
    private static void Bienvenida(){
            System.out.println("BIENVENIDO A FRASES_NOMBRE");
    }
    
    private static void MostrarMenu() {
        //Mensaje de inicio con todas las opciones.
        System.out.println("Elija que quiere hacer:");
        System.out.println("1. Mostrar una frase motivacional.");
        System.out.println("2. Mostrar frase pesimista.");
        System.out.println("3. Contar un chiste.");
        System.out.println("4. Decir un refrán.");
        System.out.println("5. Salir");
    }

    private static int RecogerDatos() {
        int input = 5;
        try {
            //Metodo para recogida de datos
            Scanner sc = new Scanner(System.in);
            input = sc.nextInt();
        } catch (Exception ex) {
            //Error para cuando no se introduce un int y reinicio del programa
            System.out.println("ERROR: Se ha introducido un valor no permitido.");
            RunProgram();
        }
        return input;
    }

    private static void ElijeFrase(int input) {
        //Este metodo el función del input introducido por el usuario, 
        //elegirá un metodo que genere una frase aleatoria.
        int nRandom = GenerarRandom();
        switch (input) {
            case 1:
                GenerarMotivacional(nRandom);
                break;
            case 2:
                GenerarPesimista(nRandom);
                break;
            case 3:
                GenerarChiste(nRandom);
                break;
            case 4:
                GenerarRefran(nRandom);
                break;
            case 5:
                FinalizarPrograma();
                break;
            default:
                System.out.println("Debes elegir una de las opciones permitidas.");
                RunProgram();
        }
    }

    private static int GenerarRandom() {
        //Genera un numero aleatorio entre 1 y 3.
        final double  MIN = 1;
        final double MAX = 3;
        double x = (int) (Math.random() * ((MAX - MIN) + 1)) + MIN;
        return (int) x;
    }

    private static void GenerarMotivacional(int nRandom) {
        switch (nRandom) {
            case 1:
                System.out.println("El único modo de hacer un gran trabajo es amar lo que haces. -Anónimo");
                break;
            case 2:
                System.out.println("Hasta el viaje mas largo comienza con un primer paso. -Anónimo");
                break;
            case 3:
                System.out.println("La risa llama a la felicidad. -Anónimo");
                break;
            default:
                throw new AssertionError();
        }
    }

    private static void GenerarPesimista(int nRandom) {
        switch (nRandom) {
            case 1:
                System.out.println("Hay una linea muy fina entre la esperanza y la desilusión. -Harlan Coben");
                break;
            case 2:
                System.out.println("El problema de nuestra epoca es que los hombres no quieren ser útiles sino importantes. -Winston Churchill");
                break;
            case 3:
                System.out.println("El infierno está vacío, todos los demonios están aquí. -William Shakespeare");
                break;
            default:
                throw new AssertionError();
        }
    }

    private static void GenerarChiste(int nRandom) {
        switch (nRandom) {
            case 1:
                System.out.println("¿Por qué el mar es azul? Porque los peces hacen Blue... Blue... Blue...");
                break;
            case 2:
                System.out.println("¿Cómo se despiden los químicos? Ácido un placer.");
                break;
            case 3:
                System.out.println("¡Qué guarda Darth Vader en su nevera? HELADO OSCURO.");
                break;
            default:
                throw new AssertionError();
        }
    }

    private static void GenerarRefran(int nRandom) {
        switch (nRandom) {
            case 1:
                System.out.println("El que regala bien vende, si el que recibe lo entiende");
                break;
            case 2:
                System.out.println("Lo bien hecho, bien parece.");
                break;
            case 3:
                System.out.println("A donde fueres, haz lo que vieres.");
                break;
            default:
                throw new AssertionError();
        }
    }

    private static void FinalizarPrograma() {
        System.out.println("Fin del programa. Hasta pronto!");
        System.exit(0);
    }
}
