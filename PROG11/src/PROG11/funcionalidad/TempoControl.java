/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROG11.funcionalidad;

import PROG11.entornografico.GameFrame;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author ANTONIO SANZ PANS
 */
public class TempoControl {

    public static void tempoClickInMonster(int delayInMiliseconds) {
        GameFrame.gameMonsterBtn.setEnabled(false);
        CompletableFuture.delayedExecutor(delayInMiliseconds, TimeUnit.MILLISECONDS).execute(() -> {
            GameFrame.gameMonsterBtn.setEnabled(true);
        });
    }
}
