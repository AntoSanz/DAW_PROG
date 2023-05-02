/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROG10.conexiones.oracle;

import PROG10.funcionalidad.modelos.CuerpoCeleste;
import oracle.jdbc.pool.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ANTONIO SANZ PANS
 * TEMA 10 - PROGRAMACION
 */
public class OracleConnection {

    //Conexion con la BBDD
    private static Connection conn = null;
    private static final String SID = "XE";
    private static final String USER = "HR";
    private static final String PWD = "HR";

    /**
     * Función que facilita la conexión a un servidor oracle.
     *
     * @param ipDelServidor Dirección IP del servidor o nombre de la máquina
     * donde está el servidor (FQDN). Para desarrollo normalmente se pone
     * "localhost", dado que el servidor está instalado en la misma máquina.
     * @param puertoDelServidor Generalmente es el puerto 1521, salvo que se
     * haya alterado la conexión por defecto.
     * @param sid Nombre de la instancia. En el caso de Oracle XE el nombre de
     * la instancia de la base de datos es "XE".
     * @param usuario Usuario para conectarse, generalmente "HR".
     * @param password Password para conectarse, cuyo dato depende de como
     * tengas configurada la base de datos.
     * @return Retorna una instancia de la clase Connection, con la conexión o
     * null en caso de no haber podido conectarse.
     */
    public static Connection construirConexion(String ipDelServidor, int puertoDelServidor, String sid, String usuario, String password) {
        try {
            OracleDataSource ods = new OracleDataSource();
            String url = "jdbc:oracle:thin:@//" + ipDelServidor + ":" + puertoDelServidor + "/" + sid;
            ods.setURL(url);
            ods.setUser(usuario);
            ods.setPassword(password);
            conn = ods.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(OracleConnection.class.getName()).log(Level.SEVERE, null, ex);
            conn = null;
        }
        return conn;
    }

    public static Connection construirConexion(String sid, String usuario, String password) {
        return construirConexion("127.0.0.1", 1521, sid, usuario, password);
    }

    public static Connection getConn() {
        return conn;
    }

    //Metodos publicos para manejar informacion de la BBDD
    public static int setCuerpoCelesteBD(CuerpoCeleste cp) {
        return _setCuerpoCelesteDB(cp);
    }

    public static ResultSet getCuerpoCelesteByCodeBD(int code) {
        return _getCuerpoCelesteByCodeBD(code);
    }

    public static ResultSet getCuerpoCelesteByTypeBD(String tipo) {
        return _getCuerpoCelesteByTypeBD(tipo);
    }

    public static ResultSet getAllCuerposCelestesBD() {
        return _getAllCuerposCelestesBD();
    }

    public static int deleteCuerpoCelesteByCodeBD(short code) {
        return _deleteCuerpoCelesteByCodeBD(code);
    }

    public static int deleteAllCuerposCelestesBD() {
        return _deleteAllCuerposCelestesBD();
    }

    //Metodos privados para manejar datos de la BBDD
    /**
     * Metodo privado para almacenar un cuerpo celeste
     *
     * @param cp (CuerpoCeleste) Objeto CuerpoCeleste
     * @return OK=1, KO=0
     */
    private static int _setCuerpoCelesteDB(CuerpoCeleste cp) {
        try {
            //Construir conexion
            construirConexion(SID, USER, PWD);
            //Crear la consulta SQL
            String SQLquery = "INSERT INTO CUERPOS_CELESTES "
                    + "(nombre, codigo, tipo, diametro) "
                    + "VALUES (?,?,?,?)";

            //Preparar la ejecucion de la sentencia SQL
            PreparedStatement ps = conn.prepareStatement(SQLquery, Statement.RETURN_GENERATED_KEYS);

            //Establecer los valores para la consulta SQL
            ps.setString(1, cp.getNombre());
            ps.setShort(2, cp.getCodigoCuerpo());
            ps.setString(3, cp.getTipoObjeto());
            ps.setInt(4, cp.getDiametro());

            //Ejecutar la consulta
            int res = ps.executeUpdate();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(OracleConnection.class.getName()).log(Level.SEVERE, null, ex);
            conn = null;
            return 0;
        }
    }

    /**
     * Método que obtiene una lista de cuerpos celestes por código
     *
     * @param code (int) Código del cuerpo celeste
     * @return null = ko
     */
    private static ResultSet _getCuerpoCelesteByCodeBD(int code) {
        try {
            //Construir conexion
            construirConexion(SID, USER, PWD);

            //Preparar la ejecucion de la sentencia SQL
            String SQLquery = "SELECT nombre, codigo, tipo, diametro FROM CUERPOS_CELESTES WHERE codigo=?";
            PreparedStatement ps = conn.prepareStatement(SQLquery);

            //Establecer los valores para la consulta SQL
            ps.setInt(1, code);

            //Ejecutar la consulta
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(OracleConnection.class.getName()).log(Level.SEVERE, null, ex);
            conn = null;
            return null;
        }
    }

    /**
     * Método que obtiene una lista de cuerpos celestes por tipo
     *
     * @param code (String) Tipo del cuerpo celeste
     * @return null = ko
     */
    private static ResultSet _getCuerpoCelesteByTypeBD(String tipo) {
        try {
            //Construir conexion
            construirConexion(SID, USER, PWD);

            //Preparar la ejecucion de la sentencia SQL
            String SQLquery = "SELECT nombre, codigo, tipo, diametro FROM CUERPOS_CELESTES WHERE tipo=?";
            PreparedStatement ps = conn.prepareStatement(SQLquery);

            //Establecer los valores para la consulta SQL
            ps.setString(1, tipo);

            //Ejecutar la consulta
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(OracleConnection.class.getName()).log(Level.SEVERE, null, ex);
            conn = null;
            return null;
        }
    }

    /**
     * Obtiene todos los registros de la tabla CUERPOS_CELESTES
     *
     * @return null = ko
     */
    private static ResultSet _getAllCuerposCelestesBD() {
        try {
            //Construir conexion
            construirConexion(SID, USER, PWD);
            //Preparar la ejecucion de la sentencia SQL
            String SQLquery = "SELECT nombre, codigo, tipo, diametro FROM CUERPOS_CELESTES";

            //Establecer los valores para la consulta SQL
            PreparedStatement ps = conn.prepareStatement(SQLquery);

            //Ejecutar la consulta
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(OracleConnection.class.getName()).log(Level.SEVERE, null, ex);
            conn = null;
            return null;
        }
    }

    /**
     * Método para eliminar cuerpos celestes
     *
     * @param code (short) Código del cuerpo celeste que queremos eliminar
     * @return OK=1, KO=0
     */
    private static int _deleteCuerpoCelesteByCodeBD(short code) {
        try {
            //Construir conexion
            construirConexion(SID, USER, PWD);

            //Preparar la ejecucion de la sentencia SQL
            String SQLquery = "DELETE FROM CUERPOS_CELESTES WHERE codigo=?";
            PreparedStatement ps = conn.prepareStatement(SQLquery);

            //Establecer los valores para la consulta SQL
            ps.setShort(1, code);

            //Ejecutar la consulta
            int res = ps.executeUpdate();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(OracleConnection.class.getName()).log(Level.SEVERE, null, ex);
            conn = null;
            return 0;
        }
    }

    private static int _deleteAllCuerposCelestesBD() {
        try {
            //Construir conexion
            construirConexion(SID, USER, PWD);

            //Preparar la ejecucion de la sentencia SQL
            String SQLquery = "DELETE FROM CUERPOS_CELESTES";
            PreparedStatement ps = conn.prepareStatement(SQLquery);

            //Ejecutar la consulta
            int res = ps.executeUpdate();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(OracleConnection.class.getName()).log(Level.SEVERE, null, ex);
            conn = null;
            return 0;
        }
    }
}
