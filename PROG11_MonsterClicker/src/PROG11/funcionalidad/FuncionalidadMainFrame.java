package PROG11.funcionalidad;

import PROG11.entornografico.*;

/**
 *
 * @author ANTONIO SANZ PANS
 * TEMA 11
 */
public class FuncionalidadMainFrame {

    public static void openGameFrame() {
        GameFrame gf = new GameFrame();
        gf.setVisible(true);
    }

    public static void closeApp() {
        System.exit(0);
    }
}
