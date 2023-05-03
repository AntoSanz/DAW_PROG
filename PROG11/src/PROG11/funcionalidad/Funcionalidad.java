/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROG11.funcionalidad;

import PROG11.funcionalidad.modelos.Player;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ANTONIO SANZ PANS
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
}
