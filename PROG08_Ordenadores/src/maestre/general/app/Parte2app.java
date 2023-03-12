/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maestre.general.app;

import java.util.Arrays;
import maestre.electrodomesticos.Aspirador;
import maestre.general.interfaces.Reparable;
import maestre.ordenadores.modelo.Portatil;
import maestre.ordenadores.modelo.Sobremesa;

/**
 *
 * @author ANTONIO SANZ PANS
 */
public class Parte2app {

    private static final Reparable reparables[] = new Reparable[6];
    private static final Portatil portatiles[] = new Portatil[3];

    public static void main(String[] args) {
        generarArrayReparables();
        generarArrayPortatiles();
        reparaTodo(reparables);
        mostrarPortatilesDesordenados();
        ordenarPortatiles(portatiles);
    }

    private static void generarArrayReparables() {
        Portatil miPortatil1 = new Portatil("c0043ns", "HP", "OMEN 16", (byte) 8, "AMD Ryzen 7", (byte) 4, "SSD", (byte) 22, (short) 250);
        Portatil miPortatil2 = new Portatil("15IAH7", "Lenovo ", "IdeaPad Gaming 3", (byte) 4, "Intel Core i5", (byte) 2, "HDD", (byte) 23, (short) 200);
        Sobremesa miSobremesa1 = new Sobremesa("10023724", "PcCom", "Gold Elite", (byte) 8, "Intel Core i5", (byte) 6, "HDD", "MSI B560M PRO-VDH", "GeForce RTX2060");
        Sobremesa miSobremesa2 = new Sobremesa("657XES", "MSI", "MAG Infinite S3", (byte) 16, "Intel Core i7", (byte) 8, "SSD", "MSI MPG B550 GAMING PLUS", "GeForce RTX3060");
        Aspirador miAspirador1 = new Aspirador("Dyson v15", (byte) 3, (byte) 88);
        Aspirador miAspirador2 = new Aspirador("Xiaomi G10", (byte) 2, (byte) 60);

        reparables[0] = miPortatil1;
        reparables[1] = miPortatil2;
        reparables[2] = miSobremesa1;
        reparables[3] = miSobremesa2;
        reparables[4] = miAspirador1;
        reparables[5] = miAspirador2;
    }

    private static void generarArrayPortatiles() {
        Portatil miPortatil1 = new Portatil("15IAH7", "Lenovo ", "IdeaPad Gaming 3", (byte) 4, "Intel Core i5", (byte) 2, "HDD", (byte) 23, (short) 200);
        Portatil miPortatil2 = new Portatil("c0043ns", "HP", "OMEN 16", (byte) 8, "AMD Ryzen 7", (byte) 4, "SSD", (byte) 22, (short) 250);
        Portatil miPortatil3 = new Portatil("M6500QC", "ASUS", "VivoBook Pro 15", (byte) 16, "AMD Ryzen 7", (byte) 8, "SSD", (byte) 24, (short) 300);

        portatiles[0] = miPortatil1;
        portatiles[1] = miPortatil2;
        portatiles[2] = miPortatil3;
    }

    static void reparaTodo(Reparable cosas[]) {
        System.out.println("----------------------");
        System.out.println("Reparaciones iniciadas");
        for (Reparable cosa : cosas) {
            cosa.reparar();
        }
    }

    static void mostrarPortatilesDesordenados() {
        System.out.println("-----------------------");
        System.out.println("Portatiles desordenados");
        for (Portatil portatil : portatiles) {
            System.out.println(portatil.toString());
        }
    }

    static void ordenarPortatiles(Portatil[] p) {
        System.out.println("--------------------");
        System.out.println("Portatiles ordenados");
        Arrays.sort(p);
        for (Portatil portatil : p) {
            System.out.println(portatil.toString());
        }
    }
}