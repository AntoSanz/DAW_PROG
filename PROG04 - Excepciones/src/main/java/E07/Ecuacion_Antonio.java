package E07;

/**
 *
 * @author ANTO
 */
public class Ecuacion_Antonio {

    static void ExDiscriminanteNegativo(double num) throws ExcepcionDiscriminanteNegativo {
        if (num < 0) {
            throw new ExcepcionDiscriminanteNegativo("EL DISCRIMINANTE ES NEGATIVO: NO HAY SOLUCIONES REALES");
        }
    }

    private int a;
    private int b;
    private int c;

    //CONSTRUCTORES
    public Ecuacion_Antonio() {
        //Inicializacion de todos los valores en 0
        this.a = 0;
        this.b = 0;
        this.c = 0;
    }

    public Ecuacion_Antonio(int a, int b, int c) {
        //Inicializacion de valores introducidos por el usuario
        this.a = a;
        this.b = b;
        this.c = c;
    }

    //GETTERS y SETTERS
    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    //METODOS
    double calcularX1() throws ExcepcionDiscriminanteNegativo {
        double x = 0;
        //Calcula la solucion resultante de SUMAR la raid del discriminante
        double discriminante = (double) Math.pow(this.b, 2) - 4 * this.a * c;
        ExDiscriminanteNegativo(discriminante);

        double raizDelDiscriminante = (double) Math.sqrt(discriminante);

        x = (-(this.b) + raizDelDiscriminante) / (2 * this.a);
        System.out.println("La primera solución de la ecuación de segundo grado a=" + this.a + ", b=" + this.b + ", c=" + this.c + " es: " + x);

        return x;
    }

    double calcularX2() throws ExcepcionDiscriminanteNegativo {
        double x = 0;
        ExDiscriminanteNegativo(comprobarDiscriminante());
        //Calcula la solucion resultante de RESTAR la raid del discriminante
        int discriminante = comprobarDiscriminante();

        double raizDelDiscriminante = Math.sqrt(discriminante);

        x = (-(this.b) - raizDelDiscriminante) / (2 * this.a);
        System.out.println("La segunda solución de la ecuación de segundo grado a=" + this.a + ", b=" + this.b + ", c=" + this.c + " es: " + x);
        return x;
    }

    int comprobarDiscriminante() {
        int d = (int) Math.pow(this.b, 2) - 4 * this.a * c;
        return d;
    }
}
