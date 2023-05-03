/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.Texts to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROG11.funcionalidad;

import PROG11.entornografico.*;

import PROG11.funcionalidad.modelos.Texts;

/**
 *
 * @author ANTO
 */
public class FuncionalidadEntornoGrafico {

    public static void openGameFrame() {
        GameFrame gf = new GameFrame();
        gf.setVisible(true);
    }

    public static void openRankFrame() {
        RankFrame rf = new RankFrame();
        rf.setVisible(true);
    }



    public static void closeApp() {
        System.exit(0);
    }
}
