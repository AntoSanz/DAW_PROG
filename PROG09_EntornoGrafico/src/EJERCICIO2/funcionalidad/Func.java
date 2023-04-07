/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJERCICIO2.funcionalidad;

//import static EJERCICIO2.funcionalidad.Funcionalidad.CUERPOS_CELESTES_NOT_FOUND;
//import static EJERCICIO2.funcionalidad.Funcionalidad.cuerposCelestes;
import EJERCICIO2.funcionalidad.modelos.CuerpoCeleste;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ANTO
 */
public class Func extends EJERCICIO2.entornografico.EntornoGrafico {

    static ArrayList<CuerpoCeleste> cuerposCelestes = new ArrayList<>();
    static final String FILE_URL_SS = "./sistemasolar.dat";
    static final String CC_TIPO_1 = "Planeta";
    static final String CC_TIPO_2 = "Planeta enano";
    static final String CC_TIPO_3 = "Luna";
    static final String CUERPOS_CELESTES_NOT_FOUND = "No se han encontrado cuerpos celestes.";

    //Metodos publicos para acceder a la funcionalidad privada
    //Los metodos privados son nombreDelMetodoPublico().
    public static void setCuerpoCeleste() {
        _createCuerpoCeleste();
    }

    public static void setFileData(String urlFile, Object obj) {
        _writeFileData(urlFile, obj);
    }

    public static void addDataTojTableCuerposCelestes() {
        _addDataTojTableCuerposCelestes();
    }

    public static void exit() {
        _exit();
    }
    //Metodos privados
    //Los metodos privados son _nombreDelMetodoPrivado().

    private static void _createCuerpoCeleste() {
        try {
            //Recoger datos del form
            short code = Short.parseShort(jTextFieldCodeAdd.getText());
            String name = jTextFieldNameAdd.getText();
            int diameter = Integer.parseInt(jTextFieldDiameterAdd.getText());
            String strType = jComboBoxTypeAdd.getSelectedItem().toString();
            System.out.println("Datos recogidos");

            //Crear cuerpo celeste
            CuerpoCeleste miCuerpoCeleste = new CuerpoCeleste(code, name, strType, diameter);
            cuerposCelestes.add(miCuerpoCeleste);
            _writeFileData(FILE_URL_SS, cuerposCelestes);

        } catch (InputMismatchException e) {
            //TODO: Añadir codigo para mostrar errores
//            System.out.println("ERROR: Formato incorrecto (" + e + ")");

        } catch (Exception e) {
            //TODO: Añadir codigo para mostrar errores

//            System.out.println("ERROR: " + e);
            //throw new AssertionError(e);
        }
    }

    private static void _showAllCuerposCelestes() {
        if (!cuerposCelestes.isEmpty()) {
            for (CuerpoCeleste c : cuerposCelestes) {
                System.out.println(c.toString());
            }
        } else {
            System.out.println(CUERPOS_CELESTES_NOT_FOUND);
        }
    }

    private static void _addDataTojTableCuerposCelestes() {
        //jTableCuerposCelestes
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Código");
        model.addColumn("Nombre");
        model.addColumn("Tipo");
        model.addColumn("Diámetro");

        rellenarArchivoDatosPorDefecto();
        
        if (!cuerposCelestes.isEmpty()) {
            for (CuerpoCeleste c : cuerposCelestes) {
                System.out.println(c.toString());
                model.addRow(new Object[]{c.getCodigoCuerpo(), c.getNombre(), c.getTipoObjeto(), c.getDiametro()});
            }
        }

        jTableCuerposCelestes.setModel(model);
    }

    //Lectura de archivos
    private static void _writeFileData(String urlFile, Object obj) {
        try {
            ObjectOutputStream writingFile = new ObjectOutputStream(new FileOutputStream(urlFile));
            writingFile.writeObject(obj);
            writingFile.close();

        } catch (FileNotFoundException e) {
            throw new AssertionError(e.getMessage());
        } catch (Exception e) {
            throw new AssertionError(e.getMessage());
        }
    }

    private static void _getFileData(String urlFile) {
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

    private static void _exit() {
        System.out.println("Fin del programa. Hasta pronto!");
        System.exit(0);
    }

    //TODO: BORRAR METODO CUANDO TODO FUNCIONE BIEN
    private static void rellenarArchivoDatosPorDefecto() {
        CuerpoCeleste c1 = new CuerpoCeleste((short) 111, "Planeta 1", "Luna", 5000);
        CuerpoCeleste c2 = new CuerpoCeleste((short) 222, "Planeta 2", "Planeta enano", 7000);
        CuerpoCeleste c3 = new CuerpoCeleste((short) 333, "Planeta 3", "Planeta", 4000);
        CuerpoCeleste c4 = new CuerpoCeleste((short) 444, "Planeta 4", "Planeta", 1000);
        CuerpoCeleste c5 = new CuerpoCeleste((short) 555, "Planeta 5", "Luna", 500);
        CuerpoCeleste c6 = new CuerpoCeleste((short) 666, "Planeta 6", "Luna", 2000);

        cuerposCelestes.add(c1);
        cuerposCelestes.add(c2);
        cuerposCelestes.add(c3);
        cuerposCelestes.add(c4);
        cuerposCelestes.add(c5);
        cuerposCelestes.add(c6);

        for (int i = 0; i < cuerposCelestes.size(); i++) {
            _writeFileData(FILE_URL_SS, i);
        }
    }
}
