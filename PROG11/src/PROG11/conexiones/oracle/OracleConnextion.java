/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROG11.conexiones.oracle;

import PROG11.funcionalidad.modelos.Player;
import java.sql.*;
import oracle.jdbc.*;
import oracle.jdbc.pool.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ANTONIO SANZ PANS
 */
public class OracleConnextion {

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

    public static ResultSet checkForPlayer(String name) {
        try {
            //Construir conexion
            construirConexion(SID, USER, PWD);
            //Crear la consulta SQL
            String SQLquery = "SELECT * FROM PLAYERS WHERE name=?";

            //Preparar la ejecucion de la sentencia SQL
            PreparedStatement ps = conn.prepareStatement(SQLquery, Statement.RETURN_GENERATED_KEYS);

            //Establecer los valores para la consulta SQL
            ps.setString(1, name);
            //Ejecutar la consulta
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(OracleConnection.class.getName()).log(Level.SEVERE, null, ex);
            conn = null;
            return null;
        }
    }

    public static int createPlayer(Player p) {
        try {
            //Construir conexion
            construirConexion(SID, USER, PWD);
            //Crear la consulta SQL
            String SQLquery = "INSERT INTO PLAYERS "
                    + "(name, power, multiclick, cooldown, autoclick, score) "
                    + "VALUES (?,?,?,?,?,?)";

            //Preparar la ejecucion de la sentencia SQL
            PreparedStatement ps = conn.prepareStatement(SQLquery, Statement.RETURN_GENERATED_KEYS);

            //Establecer los valores para la consulta SQL
            int autoclick = p.isAutoclick() ? 1 : 0;

            ps.setString(1, p.getName());
            ps.setInt(2, p.getPower());
            ps.setInt(3, p.getMulticlick());
            ps.setInt(4, p.getCooldown());
            ps.setInt(5, autoclick);
            ps.setInt(6, p.getScore());
            //Ejecutar la consulta
            int res = ps.executeUpdate();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(OracleConnection.class.getName()).log(Level.SEVERE, null, ex);
            conn = null;
            return 0;
        }
    }

    public static int updatePlayer(Player p) {
        try {
            //Construir conexion
            construirConexion(SID, USER, PWD);
            //Crear la consulta SQL
            String SQLquery = "UPDATE PLAYERS SET power=?, multiclick=?, cooldown=?, autoclick=?, score=?  WHERE name=?";

            //Preparar la ejecucion de la sentencia SQL
            PreparedStatement ps = conn.prepareStatement(SQLquery, Statement.RETURN_GENERATED_KEYS);

            //Establecer los valores para la consulta SQL
            int autoclick = p.isAutoclick() ? 1 : 0;

            ps.setInt(1, p.getPower());
            ps.setInt(2, p.getMulticlick());
            ps.setInt(3, p.getCooldown());
            ps.setInt(4, autoclick);
            ps.setInt(5, p.getScore());
            ps.setString(6, p.getName());

            //Ejecutar la consulta
            int res = ps.executeUpdate();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(OracleConnection.class.getName()).log(Level.SEVERE, null, ex);
            conn = null;
            return 0;
        }
    }

    public static int deletePlayer(Player p) {
        try {
            //Construir conexion
            construirConexion(SID, USER, PWD);
            //Crear la consulta SQL
            String SQLquery = "DELETE FROM PLAYERS WHERE name=?";

            //Preparar la ejecucion de la sentencia SQL
            PreparedStatement ps = conn.prepareStatement(SQLquery, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, p.getName());
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
