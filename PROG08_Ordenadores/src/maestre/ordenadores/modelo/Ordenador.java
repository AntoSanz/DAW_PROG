/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maestre.ordenadores.modelo;

import java.util.Objects;
import maestre.ordenadores.excepciones.ExcepcionLongitudNroSerie;
import maestre.ordenadores.excepciones.ExcepcionMaxMemoriaRam;
import maestre.ordenadores.excepciones.ExcepcionMaxNucleos;

/**
 *
 * @author ANTONIO SANZ PANS
 */
abstract public class Ordenador {

    private final byte MAX_LONG_NRO_SERIE = 20;
    private final byte MAX_MEMORIA_RAM = 99;
    private final byte MAX_NUCLEOS = 99;
    private final String OPCIONES_DISCO_DURO[] = {"HDD", "SDD"};

    private String nroSerie; //MAX: 20
    private String marca;
    private String modelo;
    private byte memoriaRAM; //MAX: 2
    private String procesador;
    private byte nucleos; // MAX: 2
    private String tipoDiscoDuro; //HDD / SDD
    private Boolean arrancado;

    //CONSTRUCTORES
    public Ordenador() {
    }

    public Ordenador(String nroSerie, String marca, String modelo, byte memoriaRAM, String procesador, byte nucleos, String tipoDiscoDuro) {
        try {
            maxLongitudNroSerie(nroSerie);
            maxMemoriaRam(memoriaRAM);
            maxNucleos(nucleos);

            this.nroSerie = nroSerie;
            this.marca = marca;
            this.modelo = modelo;
            this.memoriaRAM = memoriaRAM;
            this.procesador = procesador;
            this.nucleos = nucleos;
            this.tipoDiscoDuro = tipoDiscoDuro;
            this.arrancado = false;
        } catch (ExcepcionLongitudNroSerie | ExcepcionMaxMemoriaRam | ExcepcionMaxNucleos ex) {
            throw new AssertionError(ex);
        } catch (Exception ex) {
            throw new AssertionError(ex);
        }

    }

    //GET Y SET
    public String getNroSerie() {
        return nroSerie;
    }

    public void setNroSerie(String nroSerie) {
        this.nroSerie = nroSerie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public byte getMemoriaRAM() {
        return memoriaRAM;
    }

    public void setMemoriaRAM(byte memoriaRAM) {
        this.memoriaRAM = memoriaRAM;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public byte getNucleos() {
        return nucleos;
    }

    public void setNucleos(byte nucleos) {
        this.nucleos = nucleos;
    }

    public String getTipoDiscoDuro() {
        return tipoDiscoDuro;
    }

    public void setTipoDiscoDuro(String tipoDiscoDuro) {
        this.tipoDiscoDuro = tipoDiscoDuro;
    }

    public Boolean getArrancado() {
        return arrancado;
    }

    public void setArrancado(Boolean arrancado) {
        this.arrancado = arrancado;
    }

    //OVERRIDE
    @Override
    public String toString() {
        return "nroSerie=" + nroSerie + ", marca=" + marca + ", modelo=" + modelo + ", memoriaRAM=" + memoriaRAM + ", procesador=" + procesador + ", nucleos=" + nucleos + ", tipoDiscoDuro=" + tipoDiscoDuro + ", ";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ordenador other = (Ordenador) obj;
        return Objects.equals(this.nroSerie, other.nroSerie);
    }

    //METODOS
    /**
     * Enciende un ordenador
     */
    public void arrancar() {
        try {
            System.out.println("Arrancando...");
            for (int i = 0; i < 3; i++) {
                Thread.sleep(1 * 1000);
                System.out.println("...");
            }
            this.arrancado = true;
            System.out.println("Ordenador encendido");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    /**
     * Apaga un ordenador
     */
    public void apagar() {
        try {
            System.out.println("Apagando...");
            for (int i = 0; i < 3; i++) {
                Thread.sleep(1 * 1000);
                System.out.println("...");
            }
            this.arrancado = false;
            System.out.println("Ordenador apagado");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    /**
     * Muestra los datos del ordenador. Muestra una linea por cada nucleo.
     * Muestra un * por cada GB de RAM en cada nucleo.
     */
    abstract public void dibujar();

    //EXCEPCIONES
    private void maxMemoriaRam(byte ram) throws ExcepcionMaxMemoriaRam {
        if (ram > this.MAX_MEMORIA_RAM) {
            throw new ExcepcionMaxMemoriaRam("ERROR RAM: máximo superado (" + this.MAX_MEMORIA_RAM + ")");
        }
    }

    private void maxNucleos(byte nucleos) throws ExcepcionMaxNucleos {
        if (nucleos > this.MAX_NUCLEOS) {
            throw new ExcepcionMaxNucleos("ERROR RAM: máximo superado (" + this.MAX_NUCLEOS + ")");
        }
    }

    private void maxLongitudNroSerie(String nroSerie) throws ExcepcionLongitudNroSerie {
        if (nroSerie.length() > this.MAX_LONG_NRO_SERIE) {
            throw new ExcepcionLongitudNroSerie("ERROR RAM: máximo superado (" + this.MAX_LONG_NRO_SERIE + ")");
        }
    }
}
