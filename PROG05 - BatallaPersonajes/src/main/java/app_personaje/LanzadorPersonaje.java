package app_personaje;

import excepcionespersonaje.ExcepcionPersonajeCreado;
import excepcionespersonaje.ExcepcionRangoEstadisticas;
import java.util.Scanner;
import modeladopersonaje.Personaje;
import static modeladopersonaje.Personaje.MIN_STAT;
import static modeladopersonaje.Personaje.MAX_STAT;

/**
 *
 * @author ANTONIO SANZ PANS
 */
public class LanzadorPersonaje {

    static final String NOMBRE_JUEGO = "JUEGO DE ANTO";
    static byte personajesCreados = 0;
    static Personaje[] arrPersonajes = new Personaje[2];

    static void rangoEstadisticas(byte stat) throws ExcepcionRangoEstadisticas {
        if (stat < MIN_STAT || stat > MAX_STAT) {
            throw new ExcepcionRangoEstadisticas("ERROR: La estadistica está fuera del rango. Valor máximo: " + MAX_STAT + ", Valor mínimo: " + MIN_STAT);
        }
    }

    static void personajeCreado(Personaje p) throws ExcepcionPersonajeCreado {
        if (p != null) {
            throw new ExcepcionPersonajeCreado("El personaje de ese espacio ya ha sido creado");
        }
    }

    public static void main(String[] args) {
        MensajeBienvenida();
        MostrarMenu();
    }

    private static void MensajeBienvenida() {
        System.out.println("Bienvenido a " + NOMBRE_JUEGO);
    }

    private static void MostrarMenu() {
        System.out.println("Numero de personajes creados: " + personajesCreados);
        System.out.println("Elije una opción");
        System.out.println("1. Crear personaje 1");
        System.out.println("2. Crear personaje 2");
        System.out.println("3. Batalla");
        System.out.println("4. Mostrar personajes");
        System.out.println("5. Modificar personaje 1");
        System.out.println("6. Modificar personaje 2");
        System.out.println("7. Salir");

        SeleccionarOpcionMenu();
    }

    private static void SeleccionarOpcionMenu() {
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();

        switch (option) {
            case 1:
                try {
                    personajeCreado(arrPersonajes[0]);
                    CrearPersonaje(1);
                } catch (ExcepcionPersonajeCreado e) {
                    System.out.println(e.getMessage());
                    MostrarMenu();
                }
            break;
            case 2: 
            try {
                personajeCreado(arrPersonajes[1]);
                CrearPersonaje(2);
            } catch (ExcepcionPersonajeCreado e) {
                System.out.println(e.getMessage());
                MostrarMenu();
            }
            break;
            case 3:
                arrPersonajes[0].batalla(arrPersonajes[1]);
                MostrarMenu();
                break;
            case 4:
                MostrarPersonajes();
                break;
            case 5:
                MenuModificarPersonaje(1);
                break;
            case 6:
                MenuModificarPersonaje(2);
                break;
            case 7:
                FinalizarPrograma();
                break;

            default:
                throw new AssertionError();
        }
    }

    private static void MostrarPersonaje(int numPersonaje) {
        System.out.println(arrPersonajes[numPersonaje].toString());
    }

    private static void MostrarPersonajes() {
        for (int i = 0; i < arrPersonajes.length; i++) {
            if (arrPersonajes[i] != null) {
                MostrarPersonaje(i);
            } else {
                System.out.println("El personaje " + (i + 1) + " no ha sido creado");
            }
        }
        MostrarMenu();
    }

    private static void CrearPersonaje(int numPersonaje) {
        Scanner scPersonaje = new Scanner(System.in);

        System.out.println("Introduzca los datos del personaje");
        System.out.println("Nombre");
        String nombre = scPersonaje.nextLine();
        System.out.println("Inteligencia");
        byte inteligencia = (byte) scPersonaje.nextInt();

        System.out.println("Fuerza");
        byte fuerza = (byte) scPersonaje.nextInt();
        try {
            rangoEstadisticas(inteligencia);
            rangoEstadisticas(fuerza);

            if (numPersonaje == 1) {
                Personaje miPersonaje1 = new Personaje(nombre, inteligencia, fuerza);
                System.out.println(miPersonaje1.toString());
                arrPersonajes[0] = miPersonaje1;

            } else {
                Personaje miPersonaje2 = new Personaje(nombre, inteligencia, fuerza);
                System.out.println(miPersonaje2.toString());
                arrPersonajes[1] = miPersonaje2;
            }
            System.out.println("¡Personaje " + numPersonaje + " creado!");
            personajesCreados++;
            MostrarMenu();
        } catch (ExcepcionRangoEstadisticas e) {
            System.out.println(e.getMessage());
        } catch (Exception ex) {
            System.out.println("ERROR: Se ha introducido un valor no permitido.");
        }
    }

    private static void MenuModificarPersonaje(int numPersonaje) {
        System.out.println("Has seleccionado el personaje " + numPersonaje + "(" + arrPersonajes[numPersonaje-1].getNombre() + ")");
        System.out.println("¿Qué caracteristica quieres modificar del personaje?");
        System.out.println("1. Nombre(" + arrPersonajes[numPersonaje-1].getNombre() + ")");
        System.out.println("2. Inteligencia(" + arrPersonajes[numPersonaje-1].getInteligencia() + ")");
        System.out.println("3. Fuerza(" + arrPersonajes[numPersonaje-1].getFuerza() + ")");
        Scanner scIdAtributo = new Scanner(System.in);
        byte idAtributo = scIdAtributo.nextByte();
        System.out.println("¿Cual es el nuevo valor del atributo seleccionado?");
        Scanner scValorAtributo = new Scanner(System.in);

        String valorAtributo;
        if (idAtributo == 1) {
            valorAtributo = scValorAtributo.nextLine();
        } else {
            valorAtributo = String.valueOf(scValorAtributo.nextByte());
        }
        ModificarPersonaje(numPersonaje, idAtributo, valorAtributo);
    }

    private static void ModificarPersonaje(int numPersonaje, byte idAtributo, String valorAtributo) {
        try {
            Personaje personajeSeleccionado;
            if (numPersonaje == 1) {
                personajeSeleccionado = arrPersonajes[0];
            } else {
                personajeSeleccionado = arrPersonajes[1];
            }

            switch (idAtributo) {
                case 1:
                    //Nombre
                    personajeSeleccionado.setNombre(valorAtributo);
                    break;
                case 2:
                    //Inteligencia
                    rangoEstadisticas(Byte.parseByte(valorAtributo));
                    personajeSeleccionado.setInteligencia(Byte.parseByte(valorAtributo));
                    break;
                case 3:
                    //Fuerza
                    rangoEstadisticas(Byte.parseByte(valorAtributo));
                    personajeSeleccionado.setFuerza(Byte.parseByte(valorAtributo));
                    break;
                default:
                    throw new AssertionError();
            }

            System.out.println("¡Datos modificados!");
            MostrarPersonaje(numPersonaje-1);
            MostrarMenu();
        } catch (ExcepcionRangoEstadisticas e) {
            System.out.println(e.getMessage());
        } catch (Exception ex) {
            System.out.println("ERROR: Se ha introducido un valor no permitido.");
        }
    }

    private static void FinalizarPrograma() {
        System.out.println("Fin del programa. Hasta pronto!");
        System.exit(0);
    }
}
