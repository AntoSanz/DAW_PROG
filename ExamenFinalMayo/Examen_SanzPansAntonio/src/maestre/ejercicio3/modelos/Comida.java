/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maestre.ejercicio3.modelos;

import java.util.Objects;
import maestre.ejercicio3.excepciones.ExcepcionMaxLengthElaboracion;
import maestre.ejercicio3.excepciones.ExcepcionMaxLengthNombre;

/**
 *
 * @author Antonio Sanz Pans
 */
abstract public class Comida implements Comparable<Comida>{

    private final byte MAX_LENGTH_NOMBRE = 20;
    private final byte MAX_LENGTH_ELABORACION = 100;
    private String nombre; //maximo 20
    private String elaboracion; //Texto de maximo 100
    private Integer calorias; //integer
    private String dificultad; //Facil, moderada, dificil

    public Comida() {
    }

    public Comida(String nombre, String elaboracion, Integer calorias, String dificultad) {
        try {
            maxLengthNombre(nombre);
            maxLengthElaboracion(elaboracion);
            this.nombre = nombre;
            this.elaboracion = elaboracion;
            this.calorias = calorias;
            this.dificultad = dificultad;
        } catch (ExcepcionMaxLengthNombre ex) {
            throw new AssertionError(ex);
        } catch (ExcepcionMaxLengthElaboracion ex) {
            throw new AssertionError(ex);
        } catch (Exception ex) {
            throw new AssertionError(ex);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getElaboracion() {
        return elaboracion;
    }

    public void setElaboracion(String elaboracion) {
        this.elaboracion = elaboracion;
    }

    public Integer getCalorias() {
        return calorias;
    }

    public void setCalorias(Integer calorias) {
        this.calorias = calorias;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    @Override
    public String toString() {
        return "Comida{" + "nombre=" + nombre + ", elaboracion=" + elaboracion + ", calorias=" + calorias + ", dificultad=" + dificultad + '}';
    }

    public String mostrarDificultad() {
        String valorDificultad = "";
        switch (this.getDificultad()) {
            case "facil" ->
                valorDificultad = "*";
            case "moderada" ->
                valorDificultad = "***";
            case "dificil" ->
                valorDificultad = "*****";
            default ->
                throw new AssertionError();
        }
        System.out.println("Difucltad: " + valorDificultad);
        return valorDificultad;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.calorias);
        return hash;
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
        final Comida other = (Comida) obj;
        return Objects.equals(this.calorias, other.calorias);
    }
    

    @Override
    public int compareTo(Comida o) {
        if (this.calorias < o.getCalorias()) {
            return -1;
        } else if (this.calorias > o.getCalorias()) {
            return 1;
        } else {
            return 0;
        }
    }

    abstract public void explicarReceta();
    //EXCEPCIONES

    private void maxLengthNombre(String nombre) throws ExcepcionMaxLengthNombre {
        if (nombre.length() > this.MAX_LENGTH_NOMBRE) {
            throw new ExcepcionMaxLengthNombre("ERROR: El nombre es demasiado largo(" + this.MAX_LENGTH_NOMBRE + ")");
        }
    }

    private void maxLengthElaboracion(String elaboracion) throws ExcepcionMaxLengthElaboracion {
        if (elaboracion.length() > this.MAX_LENGTH_ELABORACION) {
            throw new ExcepcionMaxLengthElaboracion("ERROR: La elaboracion es demasiado larga(" + this.MAX_LENGTH_NOMBRE + ")");
        }
    }
}
