/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maestre.ordenadores.modelo;

import maestre.general.interfaces.Reparable;

/**
 *
 * @author ANTONIO SANZ PANS
 */
public class Sobremesa extends Ordenador implements Reparable {

    private String placaBase;
    private String tarjetaGrafica;

    //CONSTRUCTORES
    public Sobremesa() {
        super();
    }

    public Sobremesa(String nroSerie, String marca, String modelo, byte memoriaRAM, String procesador, byte nucleos, String tipoDiscoDuro, String placaBase, String tarjetaGrafica) {
        super(nroSerie, marca, modelo, memoriaRAM, procesador, nucleos, tipoDiscoDuro);
        this.placaBase = placaBase;
        this.tarjetaGrafica = tarjetaGrafica;
    }

    //GET y SET
    public String getPlacaBase() {
        return placaBase;
    }

    public void setPlacaBase(String placaBase) {
        this.placaBase = placaBase;
    }

    public String getTarjetaGrafica() {
        return tarjetaGrafica;
    }

    public void setTarjetaGrafica(String tarjetaGrafica) {
        this.tarjetaGrafica = tarjetaGrafica;
    }

    //OVERRIDE
    @Override
    public String toString() {
        String ordenador = super.toString();
        return "Sobremesa{" + ordenador + "placaBase=" + placaBase + ", tarjetaGrafica=" + tarjetaGrafica + ", arrancado=" + super.getArrancado() + '}';
    }

    /**
     * Muestra los datos del ordenador. Muestra una linea por cada nucleo.
     * Muestra un * por cada GB de RAM en cada nucleo.
     */
    @Override
    public void dibujar() {
        System.out.println(this.toString());
        String strRam = this.mostrarStrRam();
        for (int i = 0; i < this.getNucleos(); i++) {
            System.out.println(strRam);
        }
    }

    //METODOS
    /**
     * Muestra una linea con tantos asteriscos como RAM haya.
     *
     * @return strRAM (String)
     */
    private String mostrarStrRam() {
        String strRAM = "";
        for (int i = 0; i < super.getMemoriaRAM(); i++) {
            strRAM = strRAM + "*";
        }
        return strRAM;
    }

    /**
     * Muestra unos asteriscos y unmensaje indicando que el ordenador se está
     * reparando
     */
    @Override
    public void reparar() {
        System.out.println("*** El sobremesa se está reparando. ***");
    }

}
