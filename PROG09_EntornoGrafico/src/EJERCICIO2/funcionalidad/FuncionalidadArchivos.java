/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJERCICIO2.funcionalidad;

import static EJERCICIO2.funcionalidad.Funcionalidad.cuerposCelestes;
import EJERCICIO2.funcionalidad.modelos.CuerpoCeleste;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author ANTO
 */
public class FuncionalidadArchivos {
    //Metodos publicos para acceder a los metodos privados desde fuera
    public static void writeFileData(String pathName, Object obj) {
        _writeFileData(pathName, obj);
    }

    public static void getFileData(String pathName) {
        _getFileData(pathName);
    }

    public static void createFile(String pathName) {
        _createFile(pathName);
    }

    public static void deleteFile(String pathName) {
        _deleteFile(pathName);
    }

    public static void deleteCuerpoCelesteByCode(short ccCode, String pathName) {
        _deleteCuerpoCelesteByCode(ccCode, pathName);
    }

    //Metodos para archivos privados
    private static void _writeFileData(String pathName, Object obj) {
        try {
            ObjectOutputStream writingFile = new ObjectOutputStream(new FileOutputStream(pathName));
            writingFile.writeObject(obj);
            writingFile.close();
            System.out.println("Cuerpo celeste añadido");
        } catch (FileNotFoundException e) {
            throw new AssertionError(e.getMessage());
        } catch (Exception e) {
            throw new AssertionError(e.getMessage());
        }
    }

    private static void _getFileData(String pathName) {
        try {
            ObjectInputStream readingFile = new ObjectInputStream(new FileInputStream(pathName));
            System.out.println("El archivo de datos " + pathName + " ha sido cargado");

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

    private static void _createFile(String pathName) {
        try {
            File file = new File(pathName);
            file.createNewFile();
            System.out.println("Archivo creado en " + pathName);
        } catch (IOException e) {
            System.out.println("ERROR: No se ha podido crear el archivo.");
            System.out.println(e);
            //throw new AssertionError(e);
        } catch (Exception e) {
            System.out.println("ERROR: No se ha podido crear el archivo.");
            System.out.println(e);
            //throw new AssertionError(e);
        }
    }

    private static void _deleteFile(String pathName) {
        File file = new File(pathName);
        if (!file.exists()) {
            System.out.println("No hay ningun fichero de datos.");
        } else {
            try {
                //File file = new File(pathName);
                file.delete();
                cuerposCelestes.clear();
                System.out.println("¡Datos borrados!");
            } catch (Exception e) {
                System.out.println("ERROR: " + e);
                //throw new AssertionError(e);
            }

        }

    }

    private static void _deleteCuerpoCelesteByCode(short ccCode, String pathName) {
        if (!cuerposCelestes.isEmpty()) {
            int count = 0;
            System.out.println("Buscando cuerpos celestes con el código " + ccCode);

            for (CuerpoCeleste c : cuerposCelestes) {
                if (c.getCodigoCuerpo() == ccCode) {

                    System.out.println(c.toString());
                    cuerposCelestes.remove(c);
                    count++;

                }
                System.out.println(count + " elementos eliminados.");
                writeFileData(pathName, cuerposCelestes);
            }
        }
    }
}
