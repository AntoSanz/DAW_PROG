/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROG10.funcionalidad;

//import static PROG10.funcionalidad.FuncionalidadArchivos.*;
import static PROG10.conexiones.oracle.OracleConnection.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import PROG10.funcionalidad.modelos.CuerpoCeleste;
import java.sql.*;

/**
 *
 * @author ANTONIO SANZ PANS
 */
public class Funcionalidad extends PROG10.entornografico.EntornoGrafico {

    static public ArrayList<CuerpoCeleste> cuerposCelestes = new ArrayList<>();

    //Metodos publicos para acceder a la funcionalidad privada
    //Los metodos privados son nombreDelMetodoPublico().
    public static void setCuerpoCeleste() {
        //Recoger datos del form
        try {

            short code = Short.parseShort(jTextFieldCodeAdd.getText());
            String name = jTextFieldNameAdd.getText();
            int diameter = Integer.parseInt(jTextFieldDiameterAdd.getText());
            String strType = jComboBoxTypeAdd.getSelectedItem().toString();

            CuerpoCeleste miCuerpoCeleste = new CuerpoCeleste(code, name, strType, diameter);
            cuerposCelestes.add(miCuerpoCeleste);

            //Conexion con la BBDD
            setCuerpoCelesteBD(miCuerpoCeleste);

        } catch (InputMismatchException e) {
            errorMessage("ERROR: Formato incorrecto (" + e + ")");
        } catch (IllegalStateException e) {
            errorMessage("ERROR: Tipo de dato no admitido");
        } catch (Exception e) {
            errorMessage("ERROR: Tipo de dato no admitido " + e.getMessage());
        }
    }

    public static void deleteAll() {
        //Conexion con la BBDD
        deleteAllCuerposCelestesBD();
    }

    public static void deleteByCode(Short code) {
        //Conexion con la BBDD
        deleteCuerpoCelesteByCodeBD(code);
    }

    public static void showAllCuerposCelestes() {
        try {
            //Conexion con la BBDD
            ResultSet rs = getAllCuerposCelestesBD();
            //Transformar informacion obtenida de la BD
            List<CuerpoCeleste> cuerposCelestesFromResultSet = getCuerposCelestesFromResultSet(rs);
            //Rellenar el array cuerposCelestes
            _wipeTableCuerposCelestes();
            for (int i = 0; i < cuerposCelestesFromResultSet.size(); i++) {
                cuerposCelestes.add(cuerposCelestesFromResultSet.get(i));
            }
            //Añadir datos a la tabla para mostrarlos
            _addDataTojTableCuerposCelestes();
        } catch (InputMismatchException e) {
            errorMessage("ERROR: " + e.getMessage());
        } catch (Exception e) {
            errorMessage("ERROR: " + e.getMessage());
        }
    }

    public static void searchCuerpoCelesteByCode() {
        try {
            short code = Short.parseShort(jTextFieldSearchCode.getText());
            //Conexion con la BBDD
            ResultSet rs = getCuerpoCelesteByCodeBD(code);
            //Transformar informacion obtenida de la BD
            List<CuerpoCeleste> cuerposCelestesFromResultSet = getCuerposCelestesFromResultSet(rs);
            //Añadir datos a la tabla para mostrarlos
            _addDataTojTableSearchByCode(cuerposCelestesFromResultSet);

            System.out.println("DEBUG");
        } catch (InputMismatchException e) {
            errorMessage("ERROR: " + e.getMessage());
        } catch (Exception e) {
            errorMessage("ERROR: " + e.getMessage());
        }
    }

    public static void searchCuerpoCelesteByType() {
        try {
            String type = jComboBoxSearchByType.getSelectedItem().toString();
            //Conexion con la BBDD
            ResultSet rs = getCuerpoCelesteByTypeBD(type);
            //Transformar informacion obtenida de la BD
            List<CuerpoCeleste> cuerposCelestesFromResultSet = getCuerposCelestesFromResultSet(rs);
            //Añadir datos a la tabla para mostrarlos
            _addDataTojTableSearchByType(cuerposCelestesFromResultSet);

        } catch (InputMismatchException e) {
            errorMessage("ERROR: " + e.getMessage());

        } catch (Exception e) {
            errorMessage("ERROR: " + e.getMessage());
        }
    }

    public static List<CuerpoCeleste> getCuerposCelestesFromResultSet(ResultSet rs) throws SQLException {
        List<CuerpoCeleste> cuerposCelestesLocal = new ArrayList<>();
        while (rs.next()) {
            String nombre = rs.getString("nombre");
            short codigo = rs.getShort("codigo");
            String tipo = rs.getString("tipo");
            int diametro = rs.getInt("diametro");
            CuerpoCeleste miCuerpoCeleste = new CuerpoCeleste(codigo, nombre, tipo, diametro);
            cuerposCelestesLocal.add(miCuerpoCeleste);
        }
        return cuerposCelestesLocal;
    }

    public static void exit() {
        _exit();
    }

    //Metodos privados
    private static void _addDataTojTableCuerposCelestes() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Código");
        model.addColumn("Nombre");
        model.addColumn("Tipo");
        model.addColumn("Diámetro");

        if (!cuerposCelestes.isEmpty()) {
            for (CuerpoCeleste c : cuerposCelestes) {
                model.addRow(new Object[]{c.getCodigoCuerpo(), c.getNombre(), c.getTipoObjeto(), c.getDiametro()});
            }
        }

        jTableCuerposCelestes.setModel(model);
    }
    private static void _wipeTableCuerposCelestes(){
        cuerposCelestes.clear();
    }
    
    
    private static void _addDataTojTableSearchByCode(List<CuerpoCeleste> cc) {
        //Crear modelo y cabecera
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Código");
        model.addColumn("Nombre");
        model.addColumn("Tipo");
        model.addColumn("Diámetro");

        if (!cc.isEmpty()) {
            for (CuerpoCeleste c : cc) {
                model.addRow(new Object[]{c.getCodigoCuerpo(), c.getNombre(), c.getTipoObjeto(), c.getDiametro()});
            }
        }

        jTableSearchByCode.setModel(model);
    }

    private static void _addDataTojTableSearchByType(List<CuerpoCeleste> cc) {
        //Crear modelo y cabecera
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Código");
        model.addColumn("Nombre");
        model.addColumn("Tipo");
        model.addColumn("Diámetro");
        if (!cc.isEmpty()) {
            for (CuerpoCeleste c : cc) {
                model.addRow(new Object[]{c.getCodigoCuerpo(), c.getNombre(), c.getTipoObjeto(), c.getDiametro()});
            }
        }
        jTableSearchByType.setModel(model);
    }

    private static void _exit() {
        System.exit(0);
    }
}
