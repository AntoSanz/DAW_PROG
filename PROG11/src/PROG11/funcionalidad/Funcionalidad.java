package PROG11.funcionalidad;

import PROG11.funcionalidad.modelos.Player;
import PROG11.funcionalidad.modelos.Texts;
import PROG11.funcionalidad.modelos.Token;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ANTONIO SANZ PANS
 * TEMA 11
 */
public class Funcionalidad {

    public static Player parseRStoObject(ResultSet rs) throws SQLException {
        Player player = new Player();
        while (rs.next()) {
            player.setName(rs.getString("name"));
            player.setPower(rs.getInt("power"));
            player.setMulticlick(rs.getInt("multiclick"));
            player.setCooldown(rs.getInt("cooldown"));
            player.setAutoclick(rs.getInt("autoclick") == 1);
            player.setScore(rs.getInt("score"));
        }
        return player;
    }

    public static void setCurrentPlayerInToken(Player p) {
        try {
            Token.currentPlayer = p;
        } catch (Exception e) {
            System.err.println(Texts.ERROR_TOKEN + e.getMessage());
        }
    }

    public static void updatePlayerToken(String id, int value) {
        switch (id) {
            case "power" ->
                Token.currentPlayer.setPower(value);
            case "multiclick" ->
                Token.currentPlayer.setMulticlick(value);
            case "cooldown" ->
                Token.currentPlayer.setCooldown(value);
            case "autoclick" -> {
                Boolean bValue = value == 1;
                Token.currentPlayer.setAutoclick(bValue);
            }
            case "score" ->
                Token.currentPlayer.setScore(value);
            default ->
                 throw new IllegalArgumentException(Texts.INVALID_ID + id);
        }
    }
}
