/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROG11.funcionalidad;

import static PROG11.conexiones.oracle.OracleConnextion.updatePlayer;
import PROG11.entornografico.GameFrame;
import PROG11.entornografico.MainFrame;
import static PROG11.funcionalidad.Funcionalidad.updatePlayerToken;
import static PROG11.funcionalidad.TempoControl.tempoClickInMonster;
import PROG11.funcionalidad.modelos.Token;
import PROG11.funcionalidad.modelos.Values;
import javax.swing.JPanel;

/**
 *
 * @author ANTONIO SANZ PANS
 */
public class FuncionalidadGameFrame {

    private static int coins = 0;
    private static int powerLevel = 0;
    private static int cooldownLevel = 0;
    private static int multiclickLevel = 0;
    private static boolean autoclick = false;
    private static int score = 0;

    /**
     * Reinicia los valores de las variables
     */
    private static void resetValues() {
        coins = 0;
        powerLevel = 0;
        cooldownLevel = 0;
        multiclickLevel = 0;
        autoclick = false;
        setUpdatedValues();
    }
    /**
     * Importa los valores del token en los campos correspondientes
     */
    public static void updateValuesWhitToken() {
        if (Token.currentPlayer != null) {
            powerLevel = Token.currentPlayer.getPower();
            cooldownLevel = Token.currentPlayer.getCooldown();
            multiclickLevel = Token.currentPlayer.getMulticlick();
            autoclick = Token.currentPlayer.isAutoclick();
            coins = 0;
            setUpdatedValues();
        }
    }
    
    //Actualizar labels
    public static void setUpdatedValues() {
        setCoinLabel();
        setPowerLabel();
        setCooldownLabel();
        setMulticlickLabel();
    }



    public static void setCoinLabel() {
        GameFrame.gameCoinNumberLabel.setText(Integer.toString(coins));
    }

    public static void setPowerLabel() {
        GameFrame.gameAddPowerCountLabel.setText(Integer.toString(powerLevel));
    }

    public static void setCooldownLabel() {
        GameFrame.gameAddClicksCdCountLabel.setText(Integer.toString(cooldownLevel));
    }

    public static void setMulticlickLabel() {
        GameFrame.gameAddMulticlickCountLabel.setText(Integer.toString(multiclickLevel));
    }

    //Funcionamiento
    public static void clickInMonster() {
        //Añade tantas monedas como multiclics haya
        for (int i = 0; i < multiclickLevel; i++) {
            addCoins();
        }
        Values v = new Values();
        int delay = v.getCooldown(cooldownLevel);
        tempoClickInMonster(delay);
    }

    /**
     * Añade momendas en funcion del nivel de poder
     */
    public static void addCoins() {
        coins = coins + (powerLevel + 1);
        setCoinLabel();
    }

    /**
     * Redirecciona al MainFrame y cierra GameFrame
     */
    public static void openMainFrame() {
        resetValues();
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
    }

    /**
     * Aumenta el nivel de poder si tienes monedas
     */
    public static void levelUpPower() {
        Values v = new Values();
        int cost = v.getPowerCost(powerLevel);
        if (coins >= cost) {
            System.out.println("DEBUG: Gasta monedas");
            coins = coins - cost;
            powerLevel++;
            setCoinLabel();
            setPowerLabel();
            updatePlayerToken("power", powerLevel);
        } else {
            System.out.println("DEBUG: No hay monedas suficientes");
        }

    }

    /**
     * Aumenta el nivel de Coooldown si tienes monedas
     */
    public static void levelUpClickCooldown() {
        Values v = new Values();
        int cost = v.getCooldownReductionCost(cooldownLevel);
        if (coins >= cost) {
            System.out.println("DEBUG: Gasta monedas");
            coins = coins - cost;
            cooldownLevel++;
            setCoinLabel();
            setCooldownLabel();
            updatePlayerToken("cooldown", cooldownLevel);

        } else {
            System.out.println("DEBUG: No hay monedas suficientes");
        }
    }

    public static void levelUpMulticlick() {
        Values v = new Values();
        int cost = v.getMulticlickCost(multiclickLevel);
        if (coins >= cost) {
            System.out.println("DEBUG: Gasta monedas");
            coins = coins - cost;
            multiclickLevel++;
            setCoinLabel();
            setMulticlickLabel();
            updatePlayerToken("multiclick", multiclickLevel);

        } else {
            System.out.println("DEBUG: No hay monedas suficientes");
        }
    }

    /**
     * Activa el autoclick si tienes monedas
     */
    public static void levelUpAutoclick() {

        Values v = new Values();
        int cost = v.getAutoclickCost(autoclick);
        if (coins >= cost) {
            System.out.println("DEBUG: Gasta monedas");
            coins = coins - cost;
            autoclick = true;
            setCoinLabel();
            //setAutoclickLabel();
            updatePlayerToken("autoclick", autoclick == true ? 1 : 0);

        } else {
            System.out.println("DEBUG: No hay monedas suficientes");
        }
    }

    /**
     * Activa o desactiva la visibilidad de los powerups
     */
    public static void tooglePowersups() {
        JPanel powerPanel = GameFrame.gamePowersLabel;
        if (powerPanel.isVisible()) {
            GameFrame.gamePowersLabel.setVisible(false);
        } else {
            GameFrame.gamePowersLabel.setVisible(true);
        }
    }

    public static void saveProgress() {
        updatePlayer(Token.currentPlayer);
    }

    public static void automaticGrouth(){
        
    }
}
