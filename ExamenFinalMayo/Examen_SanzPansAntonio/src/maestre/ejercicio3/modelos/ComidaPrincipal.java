/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maestre.ejercicio3.modelos;

/**
 *
 * @author Antonio Sanz Pans
 */
public class ComidaPrincipal extends Comida{

    private Integer numeroPersonas;

    public ComidaPrincipal() {
    }

    public ComidaPrincipal(Integer numeroPersonas) {
        this.numeroPersonas = numeroPersonas;
    }

    public ComidaPrincipal(Integer numeroPersonas, String nombre, String elaboracion, Integer calorias, String dificultad) {
        super(nombre, elaboracion, calorias, dificultad);
        this.numeroPersonas = numeroPersonas;
    }

    public Integer getNumeroPersonas() {
        return numeroPersonas;
    }

    public void setNumeroPersonas(Integer numeroPersonas) {
        this.numeroPersonas = numeroPersonas;
    }

    @Override
    public String toString() {
        return "ComidaPrincipal{"
                + "nombre=" + super.getNombre()
                + ", elaboracion=" + super.getElaboracion()
                + ", calorias=" + super.getCalorias()
                + ", dificultad=" + super.getDificultad()
                + ", numeroPersonas=" + numeroPersonas
                + '}';
    }

    @Override
    public void explicarReceta() {
        System.out.println("Se va a proceder a explicar la receta para un plato Principal");
        System.out.println(this.toString());
    }

}
