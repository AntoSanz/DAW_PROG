package PROG11.funcionalidad.excepciones;

/**
 *
 * @author ANTONIO SANZ PANS
 * TEMA 11
 */
public class InvalidUsernameException extends Exception{
         public InvalidUsernameException(String msg) {
        super(msg);
    }
}