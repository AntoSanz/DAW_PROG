package CoheteEspacial;

import java.util.Scanner;

/**
 *
 * @author Antonio Sanz Pans
 */
public class CoheteEspacial {

    //Lista de constantes para controlar funcionalidades
    static final float GRAVEDAD = 9.81f;
    static final float PI = 3.1416f;
    static final int MAX_ETAPAS = 5;
    static final int MIN_ETAPAS = 1;

    //variable que se ira incrementando con la creacion de cada cohete
    private static int contadorCohetes;

    private String denominacion; //Nombre y modelo del cohete
    private String agenciaEspacial; //Nombre de la agencia
    private float altura; //Altura en metros
    private float diametro; //Diametro en metros
    private int masa; //Masa en Kg
    private int etapas; //Numero de etapas de un cohete.
    private boolean reutilizable; //Indica si el cohete es reutilizable o no

    //INICIALIZACION DE VARIABLES
    public CoheteEspacial() {
        //Inicializamos el cohete con valores por defecto
        this.denominacion = "S/N";
        this.agenciaEspacial = "S/A";
        this.altura = 0;
        this.diametro = 0;
        this.masa = 0;
        this.etapas = 1;
        this.reutilizable = false;
    }

    //CONSTRUCTOR
    public CoheteEspacial(String denominacion, String agenciaEspacial, float altura, float diametro, int masa, int etapas, boolean reutilizable) {
        //Inicializamos el cohete con los valores que se pasen al crear el objeto
        this.denominacion = denominacion;
        this.agenciaEspacial = agenciaEspacial;
        this.altura = altura;
        this.diametro = diametro;
        this.masa = masa;
        this.etapas = etapas;
        this.reutilizable = reutilizable;
        //6J. Cada vez que se cree un cohete se incrementa el contador en 1 y se muestra en pantalla
        contadorCohetes++;
        System.out.println("Contador de cohetes: " + contadorCohetes);
    }

    //Todos los Getter y Setter
    public static int getContadorCohetes() {
        return contadorCohetes;
    }

    public static void setContadorCohetes(int contadorCohetes) {
        CoheteEspacial.contadorCohetes = contadorCohetes;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getAgenciaEspacial() {
        return agenciaEspacial;
    }

    public void setAgenciaEspacial(String agenciaEspacial) {
        this.agenciaEspacial = agenciaEspacial;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getDiametro() {
        return diametro;
    }

    public void setDiametro(float diametro) {
        this.diametro = diametro;
    }

    public int getMasa() {
        return masa;
    }

    public void setMasa(int masa) {
        this.masa = masa;
    }

    public int getEtapas() {
        return etapas;
    }

    public void setEtapas(int etapas) {
        //Aqui aseguramos que el numero de etapas esta en el rango permitido
        if (etapas >= MIN_ETAPAS) {
            if (etapas > MAX_ETAPAS) {
                this.etapas = MAX_ETAPAS;
            } else {
                this.etapas = etapas;
            }
        } else {
            this.etapas = MIN_ETAPAS;
        }
    }

    public boolean isReutilizable() {
        return reutilizable;
    }

    public void setReutilizable(boolean reutilizable) {
        this.reutilizable = reutilizable;
    }

    @Override
    public String toString() {
        return "CoheteEspacial{" + "denominacion=" + denominacion
                + ", agenciaEspacial=" + agenciaEspacial
                + ", altura =" + altura + ", diametro=" + diametro
                + ", masa=" + masa + ", etapas=" + etapas
                + ", reutilizable=" + reutilizable + '}';
    }

    //APARTADO 4
    public double calcularVolumen() {
        //volumen = altura * r2 * PI
        double volumen = 0;
        double radio = this.diametro / 2;

        volumen = altura * Math.pow(radio, 2) * PI;
        return volumen;
    }

    //APARTADO 5
    public int sumarEtapas(CoheteEspacial c) {
        int totalEtapas = this.etapas + c.etapas;
        return totalEtapas;
    }

    //Metodo main
    public static void main(String[] args) {
        //APARTADO 2
        //Mensaje de bienvenida
        System.out.println("Bienvenido al programa de la clase Cohete Espacial de Antonio Sanz Pans");

        //Declaración y creación de objetos
        CoheteEspacial miCohete = new CoheteEspacial();
        Scanner sc = new Scanner(System.in);

        //El usuario debe de introducir el nombre del cohete creado.
        System.out.println("Por favor, indique el NOMBRE del cohete.");
        String strDenominacionCohete = sc.nextLine(); //Almacenamos lo que el usuario escriba
        miCohete.setDenominacion(strDenominacionCohete); //Asignamos el valor de la variable al atributo

        //El usuario debe de introducir el nombre de la agencia para el cohete creado.
        System.out.println("Por favor, indique la AGENCIA ESPACIAL del cohete.");
        String strAgenciaCohete = sc.nextLine(); //Almacenamos lo que el usuario escriba
        miCohete.setAgenciaEspacial(strAgenciaCohete); //Asignamos el valor de la variable al atributo

        //Mostramos los valores que el usuario ha establecido
        System.out.println("El nombre del cohete creado es: " + miCohete.getDenominacion());
        System.out.println("El nombre de la agencia espacial para el cohete"
                + miCohete.getDenominacion()
                + " es: "
                + miCohete.getAgenciaEspacial());

        //APARTADO 3
        //Pedimos el resto de datos por consola
        //Altura
        System.out.println("Por favor, indique la ALTURA del cohete en metros.");
        float flAltura = sc.nextFloat(); //Almacenamos lo que el usuario escriba
        miCohete.setAltura(flAltura); //Asignamos el valor de la variable al atributo
        //Diametro
        System.out.println("Por favor, indique el DIAMETRO del cohete en metros.");
        float flDiametro = sc.nextFloat(); //Almacenamos lo que el usuario escriba
        miCohete.setDiametro(flDiametro); //Asignamos el valor de la variable al atributo
        //Etapas
        System.out.println("Por favor, indique el numero de ETAPAS para el cohete.");
        int intEtapas = sc.nextInt(); //Almacenamos lo que el usuario escriba
        miCohete.setEtapas(intEtapas); //Asignamos el valor de la variable al atributo
        //Masa
        System.out.println("Por favor, indique la MASA del cohete en kilos.");
        int intMasa = sc.nextInt(); //Almacenamos lo que el usuario escriba
        miCohete.setMasa(intMasa); //Asignamos el valor de la variable al atributo

        //Lo mostramos por la consola
        System.out.println(miCohete.toString());

        //APARTADO 6
        //6A. Crear tres objetos utilizando el constructor
        CoheteEspacial cohete1 = new CoheteEspacial("Ariane 5", "ESA", 59, 5.4f, 777000, 2, false);
        CoheteEspacial cohete2 = new CoheteEspacial("Saturno V", "NASA", 110.6f, 10.1f, 2970000, 3, false);
        CoheteEspacial cohete3 = new CoheteEspacial("Falcon 9", "SpaceX", 70, 3.66f, 549054, 2, true);

        //6B. Mostrar los datos de los cohetes
        System.out.println(cohete1.toString());
        System.out.println(cohete2.toString());
        System.out.println(cohete3.toString());

        //6C. Cambiar algunsa propiedades de los objetos utilizando metodos del apartado 1
        cohete1.setAltura(100.3f);
        cohete1.setDiametro(6.2f);

        cohete2.setDenominacion("Jupiter III");
        cohete2.setEtapas(2);

        cohete3.setAgenciaEspacial("LaAntoAgencia");
        cohete3.setMasa(600000);

        //6D. Volver a mostrar datos de los cohetes
        System.out.println(cohete1.toString());
        System.out.println(cohete2.toString());
        System.out.println(cohete3.toString());

        //6E. Crear un nuevo cohete inventado y mostrarlo con toString
        CoheteEspacial cohete4 = new CoheteEspacial("AntoInTheSpace", "LaAntoAgencia", 174.5f, 33, 970000, 2, true);
        System.out.println(cohete4.toString());

        //6F. Cambiar datos del cohete personalizado y volverlo a mostrar
        cohete4.setAltura(169.3f);
        cohete4.setDiametro(30);
        System.out.println(cohete4.toString());

        //6H. Mostrar la suma de etapas de dos cohetes
        System.out.println("La suma de etapas de los cohetes "
                + cohete1.getDenominacion()
                + " y "
                + cohete2.getDenominacion()
                + " es: "
                + cohete1.sumarEtapas(cohete2));

        //6I. Mostrar el volumen de uno de los cohetes
        System.out.println("Volumen de " + cohete1.getDenominacion() + ": " + cohete1.calcularVolumen());

        //6K. Cambiar las etapas a uno de los cohetes y mostrarlo en pantalla
        cohete4.setEtapas(10);
        System.out.println("Etapas de " + cohete4.getDenominacion() + ": " + cohete4.getEtapas());

        //6L. Cambiar el numbero de etapas por -1 a un cohete y mostrarlo
        cohete4.setEtapas(-1);
        System.out.println("Etapas de " + cohete4.getDenominacion() + ": " + cohete4.getEtapas());

        //6M. Mostrar el total de cohetes que se han creado
        System.out.println("Total de cohetes: " + contadorCohetes);

        //6N. Mostrar Gravedad
        System.out.println("Gravedad: " + GRAVEDAD);
    }
}
