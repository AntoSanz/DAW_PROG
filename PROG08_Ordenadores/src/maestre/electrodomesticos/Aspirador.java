/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maestre.electrodomesticos;

import maestre.general.interfaces.Reparable;

/**
 *
 * @author ANTONIO SANZ PANS
 */
public class Aspirador implements Reparable {

    String modelo;
    byte peso;
    byte potencia;
    Boolean encendido;

    //CONSTRUCTORES
    public Aspirador() {
    }

    public Aspirador(String modelo, byte peso, byte potencia) {
        this.modelo = modelo;
        this.peso = peso;
        this.potencia = potencia;
        this.encendido = false;
    }

    //GET Y SET
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public byte getPeso() {
        return peso;
    }

    public void setPeso(byte peso) {
        this.peso = peso;
    }

    public byte getPotencia() {
        return potencia;
    }

    public void setPotencia(byte potencia) {
        this.potencia = potencia;
    }

    public Boolean getEncendido() {
        return encendido;
    }

    public void setEncendido(Boolean encendido) {
        this.encendido = encendido;
    }

    //OVERRIDE
    @Override
    public String toString() {
        return "Aspirador{" + "modelo=" + modelo + ", peso=" + peso + ", ruido=" + potencia + ", encendido=" + encendido + '}';
    }

    //METODOS
    public void limpiar() throws InterruptedException {
        System.out.println("¡Comienza la limpieza!");
        for (int i = 0; i < 3; i++) {
            System.out.println("Limpiando...");
            Thread.sleep((this.potencia / 100) * 1000);
        }
        System.out.println("Limpieza terminada.");
    }

    /**
     * Enciende una aspiradora
     */
    public void encender() {
        try {
            System.out.println("Encendiendo...");
            for (int i = 0; i < 3; i++) {
                Thread.sleep(1 * 1000);
                System.out.println("...");
            }
            this.encendido = true;
            System.out.println("Aspiradora encendida");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    /**
     * Apaga una aspiradora
     */
    public void apagar() {
        try {
            System.out.println("Apagando...");
            for (int i = 0; i < 3; i++) {
                Thread.sleep(1 * 1000);
                System.out.println("...");
            }
            this.encendido = false;
            System.out.println("Aspiradora apagada");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    //INTERFACE
    /**
     * Muestra unas almohadillas y un mensaje indicando que el ordenador se está
     * reparando
     */
    @Override
    public void reparar() {
        System.out.println("### La aspiradora se está reparando. ###");
    }

}
