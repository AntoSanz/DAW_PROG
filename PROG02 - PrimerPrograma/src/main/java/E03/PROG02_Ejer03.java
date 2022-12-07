package E03;

public class PROG02_Ejer03 {
    /**
     * @className EjercicioUtilizacionVariables
     * @author Antonio Sanz
     * @date 04/11/2022
     * @description Ejercicio de definición de variables
     */
    public enum sexo {V,M}
    
    public static void main(String[] args) {
        /*
     Metodo de inicio de un programa en java
     Es un ejercicio para 1DAW del modulo de Programacion
         */
        final int MAXIMO;
        final float PI;
        boolean casado;
        byte diasem[] = {1,2,3,4,5,6,7};
        short diaanual;
        long miliseg;
        double totalfactura;
        long poblacion;
        int distanciaTierraSol;

        casado = true;
        MAXIMO = 123456;
        diaanual = 300;
        miliseg = 1298332800000L;
        totalfactura = 10350.678;
        poblacion = 6945567000L;
        distanciaTierraSol = 150000000;


//        Usando sólo la orden println:
        System.out.println("----- EJERCICIO DE VARIABLES Y TIPOS DE DATOS -----");
        System.out.println("\t El valor de la variable casado es " + casado);
        System.out.println("\t El valor de la variable MAXIMO es " + MAXIMO);
        System.out.println("\t El valor de la variable diasem es " + diasem[0]);
        System.out.println("\t El valor de la variable diaanual es " + diaanual);
        System.out.println("\t El valor de la variable miliseg es " + miliseg);
        System.out.println("\t El valor de la variable totalfactura es " + totalfactura + " euros.");
        System.out.println("\t El valor de la variable poblacion es " + poblacion + " habitantes aproximadamente.");
        System.out.println("\t El valor de la variable sexo es " + sexo.M);
        System.out.println("\t La distancia de La Tierra al Sol es de " + distanciaTierraSol + " kilómetros.");

//        Usando sólo la orden print:
        System.out.print("----- EJERCICIO DE VARIABLES Y TIPOS DE DATOS ----- \n");
        System.out.print("\t El valor de la variable casado es " + casado + "\n");
        System.out.print("\t El valor de la variable MAXIMO es " + MAXIMO + "\n");
        System.out.print("\t El valor de la variable diasem es " + diasem[0] + "\n");
        System.out.print("\t El valor de la variable diaanual es " + diaanual + "\n");
        System.out.print("\t El valor de la variable miliseg es " + miliseg + "\n");
        System.out.print("\t El valor de la variable totalfactura es " + totalfactura + " euros. \n");
        System.out.print("\t El valor de la variable poblacion es " + poblacion + " habitantes aproximadamente. \n");
        System.out.print("\t El valor de la variable sexo es " + sexo.M + "\n");
        System.out.print("\t La distancia de La Tierra al Sol es de " + distanciaTierraSol + " kilómetros. \n");

//        Usando sólo la orden printf:
        System.out.printf("----- EJERCICIO DE VARIABLES Y TIPOS DE DATOS ----- \n");
        System.out.printf("\t El valor de la variable casado es %b \n",casado);
        System.out.printf("\t El valor de la variable MAXIMO es %d \n", MAXIMO);
        System.out.printf("\t El valor de la variable diasem es %d \n", diasem[0]);
        System.out.printf("\t El valor de la variable diaanual es %d \n", diaanual);
        System.out.printf("\t El valor de la variable miliseg es %d \n", miliseg);
        System.out.printf("\t El valor de la variable totalfactura es %5.3f euros. \n", totalfactura);
        System.out.printf("\t El valor de la variable poblacion es %d habitantes aproximadamente. \n", poblacion);
        System.out.printf("\t El valor de la variable sexo es %s", sexo.M + "\n");
        System.out.printf("\t La distancia de La Tierra al Sol es de %d  kilómetros. \n", distanciaTierraSol);

    }
}
