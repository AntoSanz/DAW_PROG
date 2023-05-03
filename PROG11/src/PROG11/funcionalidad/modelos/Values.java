/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROG11.funcionalidad.modelos;

/**
 *
 * @author ANTO
 */
public class Values {

    //Valores iniciales
    private final byte INITIAL_POWER_LEVEL = 0;
    private final byte INITIAL_MULTICLICK_LEVEL = 0;
    private final byte INITIAL_COOLDOWN_REDUCTION_LEVEL = 0;
    private final boolean INITIAL_AUTOCLICK_LEVEL = false;
    private final int INITIAL_COOLDOWN_MS = 3000;
    //Costes iniciales
    private final byte INITIAL_POWER_COST = 2;
    private final short INITIAL_MULTICLICK_COST = 2;
    private final byte INITIAL_COOLDOWN_REDUCTION_COST = 2;
    private final short INITIAL_AUTOCLICK_COST = 2;
    //Incremento del coste por nivel
    private final double INITIAL_POWER_COST_INC = 2;
    private final byte INITIAL_MULTICLICK_COST_INC = 3;
    private final double INITIAL_COOLDOWN_REDUCTION_COST_INC = 2;
    //Repercusion de la subida de nivel
    private final int COOLDOWN_REDUCTION_PER_LEVEL = 50;
    
    public int getPowerCost(int currentLevel) {
        int cost = INITIAL_POWER_COST;
        if (currentLevel != 0) {
            for (int i = 0; i < currentLevel; i++) {
                cost = (int) (cost * INITIAL_POWER_COST_INC);
            }
        }
        return cost;
    }

    public int getMulticlickCost(int currentLevel) {
        int cost = INITIAL_MULTICLICK_COST;
        if (currentLevel != 0) {
            for (int i = 0; i < currentLevel; i++) {
                cost = (int) (cost * INITIAL_MULTICLICK_COST_INC);
            }
        }
        return cost;
    }

    public int getCooldownReductionCost(int currentLevel) {
        int cost = INITIAL_COOLDOWN_REDUCTION_COST;
        if (currentLevel != 0) {
            for (int i = 0; i < currentLevel; i++) {
                cost = (int) (cost * INITIAL_COOLDOWN_REDUCTION_COST_INC);
            }
        }
        return cost;
    }

    public int getAutoclickCost(boolean currentLevel) {
        int cost = 0;
        if (!currentLevel) {
            cost = INITIAL_AUTOCLICK_COST;
        }
        return cost;
    }
    
    public int getCooldown(int currentLevel){
        return this.INITIAL_COOLDOWN_MS - (this.COOLDOWN_REDUCTION_PER_LEVEL * currentLevel);
    }
}
