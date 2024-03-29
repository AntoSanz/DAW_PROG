package PROG11.funcionalidad;

import PROG11.funcionalidad.excepciones.InvalidUsernameException;
import PROG11.funcionalidad.modelos.Texts;

/**
 *
 * @author ANTONIO SANZ PANS
 * TEMA 11
 */
public class UsernameValidator {
    public static void validateUsername(String username) throws InvalidUsernameException {
        if (username == null || username.trim().isEmpty()) {
            throw new InvalidUsernameException(Texts.ERROR_NAME_VOID);
        }

        if (!username.matches("^[a-zA-Z0-9_-]*$")) {
            throw new InvalidUsernameException(Texts.ERROR_NAME_SPACE_SPECIALCHAR);
        }

        if (username.contains("á") || username.contains("é") || username.contains("í") || username.contains("ó") || username.contains("ú") || username.contains("ñ")) {
            throw new InvalidUsernameException(Texts.ERROR_NAME_ACCENTS_OR_SPECHIALCHAR);
        }
    }
}
