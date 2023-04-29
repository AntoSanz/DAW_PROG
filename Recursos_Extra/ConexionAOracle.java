/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import oracle.jdbc.pool.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase facilitadora para la realización de conexiones a oracle.
 * @author Salvador Romero
 */
public class ConexionAOracle {
   
    Connection conn=null;
    /**
     * Función que facilita la conexión a un servidor oracle.
     * @param ipDelServidor Dirección IP del servidor o nombre de la máquina
     * donde está el servidor (FQDN). Para desarrollo normalmente se pone 
     * "localhost", dado que el servidor está instalado en la misma máquina.
     * @param puertoDelServidor Generalmente es el puerto 1521, salvo que se
     * haya alterado la conexión por defecto.
     * @param sid Nombre de la instancia. En el caso de Oracle XE el nombre
     * de la instancia de la base de datos es "XE".
     * @param usuario Usuario para conectarse, generalmente "HR".
     * @param password Password para conectarse, cuyo dato depende de como 
     * tengas configurada la base de datos.
     * @return Retorna una instancia de la clase Connection, con la conexión
     * o null en caso de no haber podido conectarse. 
     */
    public Connection construirConexion (String ipDelServidor,
            int puertoDelServidor, String sid, String usuario,
            String password)
    {
        try {
            OracleDataSource ods = new OracleDataSource();                                
            String url = "jdbc:oracle:thin:@//"+ipDelServidor+":"+puertoDelServidor+"/"+sid;
            ods.setURL(url);
            ods.setUser(usuario);
            ods.setPassword(password);
            conn = ods.getConnection();                                   
        } catch (SQLException ex) {
            Logger.getLogger(ConexionAOracle.class.getName()).log(Level.SEVERE, null, ex);
            conn=null;
        }
        return conn;
    }

    /**
     * Crea una conexión a oracle cuando está instalado en el mismo ordenador
     * donde se desarrolla y al puerto por defecto (1521).
     * @param sid Nombre de la instancia. En el caso de Oracle XE el nombre
     * de la instancia de la base de datos es "XE".
     * @param usuario Usuario para conectarse, generalmente "HR".
     * @param password Password para conectarse, cuyo dato depende de como 
     * tengas configurada la base de datos.
     * @return El identificador de la conexión, instancia de la Connection o
     * null si no se ha podido conectar.     
     */
    public Connection construirConexion (String sid, String usuario, String password) {
        return construirConexion("127.0.0.1", 1521, sid, usuario, password);
    }
    
    /**
     * Obtiene la conexión realizada a Oracle o null si todavía no se ha conectado.
     * @return Una instancia de la clase Connection, con la conexión a la base 
     * de datos, o null en caso de no haberse conectado.
     */
    public Connection getConn ()
    {
        return conn;
    }
    
    
}
