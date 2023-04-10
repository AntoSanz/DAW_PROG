/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJERCICIO2.funcionalidad;

import static EJERCICIO2.funcionalidad.FuncionalidadArchivos.*;
import EJERCICIO2.funcionalidad.modelos.CuerpoCeleste;
import java.util.ArrayList;
import java.util.InputMismatchException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ANTO
 */
public class Funcionalidad extends EJERCICIO2.entornografico.EntornoGrafico {

    static public ArrayList<CuerpoCeleste> cuerposCelestes = new ArrayList<>();
    static final String FILE_URL_SS = "./src/EJERCICIO2/funcionalidad/data/sistemasolar.dat";

    //Metodos publicos para acceder a la funcionalidad privada
    //Los metodos privados son nombreDelMetodoPublico().
    public static void setCuerpoCeleste() {
        //Recoger datos del form
        try {
            
            short code = Short.parseShort(jTextFieldCodeAdd.getText());
            String name = jTextFieldNameAdd.getText();
            int diameter = Integer.parseInt(jTextFieldDiameterAdd.getText());
            String strType = jComboBoxTypeAdd.getSelectedItem().toString();
            _createCuerpoCeleste(code, name, diameter, strType);
        } catch (InputMismatchException e) {
            errorMessage("ERROR: Formato incorrecto (" + e + ")");
        } catch (IllegalStateException e) {
            errorMessage("ERROR: Tipo de dato no admitido");
        } catch (Exception e) {
            errorMessage("ERROR: Tipo de dato no admitido " + e.getMessage());
        }
    }

    public static void deleteAll() {
        _deleteAll(FILE_URL_SS);
    }

    public static void deleteByCode(Short code) {
        _deleteByCode(code, FILE_URL_SS);
    }

    public static void showAllCuerposCelestes() {
        if (cuerposCelestes.size() == 0) {

        } else {
            _addDataTojTableCuerposCelestes();
        }
    }

    public static void searchCuerpoCelesteByCode() {
        try {
            short code = Short.parseShort(jTextFieldSearchCode.getText());
            _searchCuerpoCelesteByCode(code);
        } catch (InputMismatchException e) {
            errorMessage("ERROR: " + e.getMessage());
        } catch (Exception e) {
            errorMessage("ERROR: " + e.getMessage());
        }
    }

    public static void searchCuerpoCelesteByType() {
        try {
            String type = jComboBoxSearchByType.getSelectedItem().toString();
            _searchCuerpoCelesteByType(type);
        } catch (InputMismatchException e) {
            errorMessage("ERROR: " + e.getMessage());

        } catch (Exception e) {
            errorMessage("ERROR: " + e.getMessage());
        }
    }

    public static void exit() {
        _exit();
    }

    //Metodos privados
    //Los metodos privados son _nombreDelMetodoPrivado().
    private static void _createCuerpoCeleste(short code, String name, int diameter, String strType) {
        try {
            //Crear cuerpo celeste
            CuerpoCeleste miCuerpoCeleste = new CuerpoCeleste(code, name, strType, diameter);
            cuerposCelestes.add(miCuerpoCeleste);
            //Añadir cuerpo celeste al archivo
            writeFileData(FILE_URL_SS, cuerposCelestes);
        } catch (InputMismatchException e) {
            errorMessage("ERROR: Formato incorrecto (" + e + ")");
        } catch (Exception e) {
            errorMessage("ERROR: " + e);
        }
    }

    private static void _addDataTojTableCuerposCelestes() {
        getFileData();
        //jTableCuerposCelestes
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Código");
        model.addColumn("Nombre");
        model.addColumn("Tipo");
        model.addColumn("Diámetro");

        if (!cuerposCelestes.isEmpty()) {
            for (CuerpoCeleste c : cuerposCelestes) {
                //System.out.println("_addDataTojTableCuerposCelestes");
                //System.out.println(c.toString());
                model.addRow(new Object[]{c.getCodigoCuerpo(), c.getNombre(), c.getTipoObjeto(), c.getDiametro()});
            }
        }

        jTableCuerposCelestes.setModel(model);
    }

    private static void _searchCuerpoCelesteByCode(short ccCode) {
        ArrayList<CuerpoCeleste> ccFinded = new ArrayList<>();

        int count = 0;
        //System.out.println("_searchCuerpoCelesteByCode");
        //System.out.println("Buscando cuerpos celestes con el código " + ccCode);
        for (CuerpoCeleste c : cuerposCelestes) {
            if (c.getCodigoCuerpo() == ccCode) {
                ccFinded.add(c);
                count++;
            }
        }
        if (count != 0) {
            _addDataTojTableSearchByCode(ccFinded);
        }
    }

    private static void _addDataTojTableSearchByCode(ArrayList<CuerpoCeleste> cc) {
        //Crear modelo y cabecera
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Código");
        model.addColumn("Nombre");
        model.addColumn("Tipo");
        model.addColumn("Diámetro");

        //System.out.println("_addDataTojTableSearchByCode");
        if (!cc.isEmpty()) {
            for (CuerpoCeleste c : cc) {
                //System.out.println(c.toString());
                model.addRow(new Object[]{c.getCodigoCuerpo(), c.getNombre(), c.getTipoObjeto(), c.getDiametro()});
            }
        }

        jTableSearchByCode.setModel(model);
    }

    private static void _searchCuerpoCelesteByType(String ccType) {

        ArrayList<CuerpoCeleste> ccFinded = new ArrayList<>();

        int count = 0;
        //System.out.println("_searchCuerpoCelesteByType");
        //System.out.println("Buscando cuerpos celestes del tipo " + ccType);
        for (CuerpoCeleste c : cuerposCelestes) {
            if (c.getTipoObjeto().equals(ccType)) {
                ccFinded.add(c);
                count++;
            }
        }
        if (count != 0) {
            _addDataTojTableSearchByType(ccFinded);
        }
    }

    private static void _addDataTojTableSearchByType(ArrayList<CuerpoCeleste> cc) {
        //Crear modelo y cabecera
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Código");
        model.addColumn("Nombre");
        model.addColumn("Tipo");
        model.addColumn("Diámetro");

        //System.out.println("_addDataTojTableSearchByCode");
        if (!cc.isEmpty()) {
            for (CuerpoCeleste c : cc) {
                //System.out.println(c.toString());
                model.addRow(new Object[]{c.getCodigoCuerpo(), c.getNombre(), c.getTipoObjeto(), c.getDiametro()});
            }
        }
        jTableSearchByType.setModel(model);
    }

    private static void _deleteAll(String pathName) {
        deleteFile(pathName);
    }

    private static void _deleteByCode(Short code, String pathName) {
        deleteCuerpoCelesteByCode(code, pathName);
    }

    private static void _exit() {
        //System.out.println("Fin del programa. Hasta pronto!");
        System.exit(0);
    }

    //TODO: BORRAR METODO CUANDO TODO FUNCIONE BIEN
//    public static void rellenarArchivoDatosPorDefecto() {
//        CuerpoCeleste c1 = new CuerpoCeleste((short) 111, "Planeta 1", "Luna", 5000);
//        CuerpoCeleste c2 = new CuerpoCeleste((short) 222, "Planeta 2", "Planeta enano", 7000);
//        CuerpoCeleste c3 = new CuerpoCeleste((short) 333, "Planeta 3", "Planeta", 4000);
//        CuerpoCeleste c4 = new CuerpoCeleste((short) 444, "Planeta 4", "Planeta", 1000);
//        CuerpoCeleste c5 = new CuerpoCeleste((short) 555, "Planeta 5", "Luna", 500);
//        CuerpoCeleste c6 = new CuerpoCeleste((short) 666, "Planeta 6", "Luna", 2000);
//        CuerpoCeleste c7 = new CuerpoCeleste((short) 777, "Planeta 2", "Planeta enano", 7000);
//        CuerpoCeleste c8 = new CuerpoCeleste((short) 888, "Planeta 3", "Planeta", 4000);
//        CuerpoCeleste c9 = new CuerpoCeleste((short) 999, "Planeta 4", "Planeta", 1000);
//        CuerpoCeleste c10 = new CuerpoCeleste((short) 100, "Planeta 5", "Luna", 500);
//        CuerpoCeleste c11 = new CuerpoCeleste((short) 110, "Planeta 6", "Luna", 2000);
//        CuerpoCeleste c12 = new CuerpoCeleste((short) 120, "Planeta 2", "Planeta enano", 7000);
//        CuerpoCeleste c13 = new CuerpoCeleste((short) 130, "Planeta 3", "Planeta", 4000);
//        CuerpoCeleste c14 = new CuerpoCeleste((short) 140, "Planeta 4", "Planeta", 1000);
//        CuerpoCeleste c15 = new CuerpoCeleste((short) 150, "Planeta 5", "Luna", 500);
//
//        cuerposCelestes.clear();
//
//        cuerposCelestes.add(c1);
//        cuerposCelestes.add(c2);
//        cuerposCelestes.add(c3);
//        cuerposCelestes.add(c4);
//        cuerposCelestes.add(c5);
//        cuerposCelestes.add(c6);
//        cuerposCelestes.add(c7);
//        cuerposCelestes.add(c8);
//        cuerposCelestes.add(c9);
//        cuerposCelestes.add(c10);
//        cuerposCelestes.add(c11);
//        cuerposCelestes.add(c12);
//        cuerposCelestes.add(c13);
//        cuerposCelestes.add(c14);
//        cuerposCelestes.add(c15);
//        System.out.println("cuerposCelestes relleno");
//        for (int i = 0; i < cuerposCelestes.size(); i++) {
//            _writeFileData(FILE_URL_SS, i);
//        }
    //}
}
