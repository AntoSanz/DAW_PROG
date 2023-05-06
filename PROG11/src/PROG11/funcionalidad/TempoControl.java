package PROG11.funcionalidad;

import PROG11.entornografico.GameFrame;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author ANTONIO SANZ PANS
 * TEMA 11
 */
public class TempoControl {

    public static void tempoClickInMonster(int delayInMiliseconds) {
        GameFrame.gameMonsterBtn.setEnabled(false);
        CompletableFuture.delayedExecutor(delayInMiliseconds, TimeUnit.MILLISECONDS).execute(() -> {
            GameFrame.gameMonsterBtn.setEnabled(true);
        });
    }
}
