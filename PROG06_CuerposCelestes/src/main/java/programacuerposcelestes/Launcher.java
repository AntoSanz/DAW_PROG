/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacuerposcelestes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import modelo.CuerpoCeleste;

/**
 *
 * @author ANTONIO SANZ PANS
 */
public class Launcher {

    static ArrayList<CuerpoCeleste> cuerposCelestes = new ArrayList<>();
    static final String FILE_URL_SS = "./sistemasolar.dat";
    static final String CC_TIPO_1 = "Planeta";
    static final String CC_TIPO_2 = "Planeta enano";
    static final String CC_TIPO_3 = "Luna";
    static final String CUERPOS_CELESTES_NOT_FOUND = "No se han encontrado cuerpos celestes.";

    public static void main(String[] args) {
        welcomeMessage();
        getFileData(FILE_URL_SS);
        runMenu();
    }

    private static void welcomeMessage() {
        final String MSG_BIENVENIDA = "Bienvenido a la TAREA 06 de ANTONIO SANZ";
        System.out.println(MSG_BIENVENIDA);
    }

    /**
     * Obtiene los datos almacenados en un archivo
     *
     * @param fileName Nombre del archivo donde estan los datos almacenados
     */
    private static void getFileData(String urlFile) {
        try {
            ObjectInputStream readingFile = new ObjectInputStream(new FileInputStream(urlFile));
            System.out.println("El archivo de datos " + urlFile + " ha sido cargado");

            //Recuperar datos del archivo
            ArrayList<CuerpoCeleste> cuerposCelestesRecuperados = new ArrayList<>();
            cuerposCelestesRecuperados = (ArrayList<CuerpoCeleste>) readingFile.readObject();

            //Actualizar el array con los datos traidos del archivo
            System.out.println("Datos en el sistema encontrados:");
            cuerposCelestes.clear();
            for (CuerpoCeleste c : cuerposCelestesRecuperados) {
                cuerposCelestes.add(c);
                System.out.println(c.toString());
            }
            readingFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("No hay datos sobre el sistema solar almacenados.");
        } catch (Exception e) {
            throw new AssertionError(e.getMessage());
        }
    }

    /**
     * Sobreescribe el archivo indicado con la informacion enviada
     *
     * @param urlFile Archivo que se va a sobreescribir
     * @param obj Información que se va a almacenar en el archivo
     */
    private static void writeFileData(String urlFile, Object obj) {
        try {
            ObjectOutputStream writingFile = new ObjectOutputStream(new FileOutputStream(urlFile));
            writingFile.writeObject(obj);
            writingFile.close();
            runMenu();

        } catch (FileNotFoundException e) {
            throw new AssertionError(e.getMessage());
        } catch (Exception e) {
            throw new AssertionError(e.getMessage());
        }
    }

    /**
     * Ejecuta el menú completo.
     */
    public static void runMenu() {
        showMenu();
        selectMenuOption();
    }

    /**
     * Muestra las distintas opciones del menú.
     */
    public static void showMenu() {
        System.out.println("Seleccione una de las siguientes opciones:");
        System.out.println("1. Añadir cuerpo celeste");
        System.out.println("2. Listar cuerpos celestes");
        System.out.println("3. Buscar cuerpo celeste por código");
        System.out.println("4. Buscar cuerpo celeste por tipo");
        System.out.println("5. Borrar cuerpo celeste");
        System.out.println("6. Borrar fichero de cuerpos celestes");
        System.out.println("7. Salir de la aplicación");
    }

    /**
     * Funcionalidad del menú. Recoge una opción introducida por el usuario y en
     * función de ello ejecuta el método correspondiente
     */
    public static void selectMenuOption() {
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();

        switch (option) {
            case 1 ->
                runAddCuerpoCeleste();
            case 2 ->
                showAllCuerposCelestes();
            case 3 ->
                runSearchCuerpoCelesteBy("code");
            case 4 ->
                runSearchCuerpoCelesteBy("type");
            case 5 -> {
                runDeleteCuerpoCelesteByCode();
            }
            case 6 ->
                deleteFile(FILE_URL_SS);
            case 7 ->
                Exit();
            default -> {
                System.out.println("ERROR: Opcion incorrecta.");
                runMenu();
            }
        }
    }

    private static void runAddCuerpoCeleste() {
        collectDataCuerpoCeleste();
    }

    /**
     * Añade un cuerpo celeste
     */
    private static void collectDataCuerpoCeleste() {
        try {

            Scanner sc = new Scanner(System.in);

            System.out.println("Introduzca los datos del cuerpo celeste");

            System.out.println("Código (max: 3 dígitos, sin decimales)");
            short code = sc.nextShort();

            System.out.println("Nombre (max: 15)");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.println("Tipo");
            System.out.println("1. " + CC_TIPO_1);
            System.out.println("2. " + CC_TIPO_2);
            System.out.println("3. " + CC_TIPO_3);
            int type = sc.nextInt();

            String strType;
            switch (type) {
                case 1 ->
                    strType = CC_TIPO_1;
                case 2 ->
                    strType = CC_TIPO_2;
                case 3 ->
                    strType = CC_TIPO_3;
                default ->
                    throw new AssertionError();
            }

            System.out.println("Diametro (max: 6 digitos");
            int diameter = sc.nextInt();
            CuerpoCeleste miCuerpoCeleste = new CuerpoCeleste(code, name, strType, diameter);

            cuerposCelestes.add(miCuerpoCeleste);
            writeFileData(FILE_URL_SS, cuerposCelestes);
            runMenu();

        } catch (InputMismatchException e) {
            System.out.println("ERROR: Formato incorrecto (" + e + ")");
            runMenu();
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
            runMenu();
            //throw new AssertionError(e);
        }
    }

    /**
     * Muestra todos los cuerpos celestes
     */
    private static void showAllCuerposCelestes() {
        if (!cuerposCelestes.isEmpty()) {
            for (CuerpoCeleste c : cuerposCelestes) {
                System.out.println(c.toString());
            }
        } else {
            System.out.println(CUERPOS_CELESTES_NOT_FOUND);
        }
        runMenu();
    }

    private static void runSearchCuerpoCelesteBy(String n) throws NumberFormatException {
        Scanner sc = new Scanner(System.in);
        switch (n) {
            case "code" -> {
                try {
                    System.out.println("Introducir codigo para buscar planeta");
                    short code = sc.nextShort();
                    searchCuerpoCelesteByCode(code);
                } catch (InputMismatchException e) {
                    System.out.println("ERROR: Formato incorrecto (" + e + ")");
                    runMenu();
                } catch (Exception e) {
                    System.out.println("ERROR: " + e);
                    runMenu();
                    //throw new AssertionError(e);
                }
            }

            case "type" -> {
                try {
                    System.out.println("Introducir tipo para buscar planeta");
                    System.out.println("1. " + CC_TIPO_1);
                    System.out.println("2. " + CC_TIPO_2);
                    System.out.println("3. " + CC_TIPO_3);
                    int type = sc.nextInt();

                    String strType;
                    switch (type) {
                        case 1 ->
                            strType = CC_TIPO_1;
                        case 2 ->
                            strType = CC_TIPO_2;
                        case 3 ->
                            strType = CC_TIPO_3;
                        default ->
                            throw new AssertionError();
                    }
                    searchCuerpoCelesteByType(strType);
                } catch (InputMismatchException e) {
                    System.out.println("ERROR: Formato incorrecto (" + e + ")");
                    runMenu();
                } catch (Exception e) {
                    System.out.println("ERROR: " + e);
                    runMenu();
                    //throw new AssertionError(e);
                }
            }

            default ->
                throw new AssertionError();
        }

    }

    /**
     * Busca un cuerpo celeste por código
     *
     * @param ccCode Código del cuerpo celeste
     */
    private static void searchCuerpoCelesteByCode(short ccCode) {
        int count = 0;
        System.out.println("Buscando cuerpos celestes con el código " + ccCode);
        for (CuerpoCeleste c : cuerposCelestes) {
            if (c.getCodigoCuerpo() == ccCode) {
                System.out.println(c.toString());
                count++;
            }

        }
        if (count == 0) {
            System.out.println(CUERPOS_CELESTES_NOT_FOUND);
        }
        runMenu();
    }

    /**
     * Busca un cuerpo celeste por tipo
     *
     * @param ccType
     */
    private static void searchCuerpoCelesteByType(String ccType) {
        if (cuerposCelestes.isEmpty()) {
            System.out.println(CUERPOS_CELESTES_NOT_FOUND);
        } else {
            System.out.println("Buscando cuerpos celestes del tipo " + ccType);
            for (CuerpoCeleste c : cuerposCelestes) {
                if (c.getTipoObjeto().toUpperCase().trim().equals(ccType.toUpperCase().trim())) {
                    System.out.println(c.toString());
                }
            }
        }

        runMenu();
    }

    private static void runDeleteCuerpoCelesteByCode() {
        if (cuerposCelestes.isEmpty()) {
            System.out.println(CUERPOS_CELESTES_NOT_FOUND);
            runMenu();
        } else {
            try {
                System.out.println("Introduce el código del cuerpo celeste que deseas borrar");
                Scanner sc = new Scanner(System.in);
                short code = sc.nextShort();
                deleteCuerpoCelesteByCode(code);
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Formato incorrecto (" + e + ")");
                runMenu();
            } catch (Exception e) {
                System.out.println("ERROR: " + e);
                runMenu();
                //throw new AssertionError(e);
            }
        }
    }

    /**
     * Pide un codigo de un cuerpo celeste y lo borra
     *
     * @param ccCode Código del cuerpo celeste
     */
    private static void deleteCuerpoCelesteByCode(short ccCode) {
        if (cuerposCelestes.isEmpty()) {
            System.out.println(CUERPOS_CELESTES_NOT_FOUND);
            runMenu();
        } else {
            int count = 0;
            System.out.println("Buscando cuerpos celestes con el código " + ccCode);

            for (CuerpoCeleste c : cuerposCelestes) {
                if (c.getCodigoCuerpo() == ccCode) {
                    Boolean delete = confirmDeleteCuerpoCeleste(c.toString());
                    if (delete) {
                        System.out.println(c.toString());
                        cuerposCelestes.remove(c);
                        count++;
                    }
                }
                System.out.println(count + " elementos eliminados.");
                writeFileData(FILE_URL_SS, cuerposCelestes);
            }
        }
    }

    private static Boolean confirmDeleteCuerpoCeleste(String name) {
        System.out.println("¿Estas seguro que deseas borrar la siguiente entrada?");
        System.out.println(name);
        System.out.println("Pulsa 1 (uno) para borrar");
        Boolean delete = false;
        try {
            Scanner sc = new Scanner(System.in);
            String op;
            op = sc.nextLine();
            if ("1".equals(op)) {
                delete = true;
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
            runMenu();
            //throw new AssertionError(e);
        }
        return delete;
    }

    /**
     * Elimina del disco el archivo de la ruta indicada
     *
     * @param pathName url del archivo
     */
    private static void deleteFile(String pathName) {
        File file = new File(pathName);
        if (!file.exists()) {
            System.out.println("No hay ningun fichero de datos.");
        } else {
            Boolean delete = confirmDeleteFile(pathName);
            if (delete) {
                try {
                    //File file = new File(pathName);
                    file.delete();
                    cuerposCelestes.clear();
                    System.out.println("¡Datos borrados!");
                } catch (Exception e) {
                    System.out.println("ERROR: " + e);
                    runMenu();
                    //throw new AssertionError(e);
                }
            }
        }

        runMenu();
    }

    private static Boolean confirmDeleteFile(String pathName) {
        System.out.println("¿Estas seguro que deseas borrar el archivo" + pathName + "?");
        System.out.println("Pulsa 1 (uno) para borrar.");
        Boolean delete = false;
        try {
            Scanner sc = new Scanner(System.in);
            String op;
            op = sc.nextLine();
            if ("1".equals(op)) {
                delete = true;
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
            runMenu();
        }
        return delete;
    }

    /**
     * Crea el un archivo en la ruta indicada
     *
     * @param url
     */
    private static void createFile(String url) {
        try {
            File file = new File(url);
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("ERROR: No se ha podido crear el archivo.");
            System.out.println(e);
            runMenu();
            //throw new AssertionError(e);
        } catch (Exception e) {
            System.out.println("ERROR: No se ha podido crear el archivo.");
            System.out.println(e);
            runMenu();
            //throw new AssertionError(e);
        }
    }

    /**
     * Finaliza el programa
     */
    private static void Exit() {
        System.out.println("Fin del programa. Hasta pronto!");
        System.exit(0);
    }
}
