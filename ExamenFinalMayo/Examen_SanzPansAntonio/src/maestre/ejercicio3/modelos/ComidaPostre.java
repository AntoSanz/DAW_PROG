/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maestre.ejercicio3.modelos;

/**
 *
 * @author Antonio Sanz Pans
 */
public class ComidaPostre extends Comida {

    private String tipoPostre; //Frio, Caliente, del tiempo

    public ComidaPostre() {
    }

    public ComidaPostre(String tipoPostre) {
        this.tipoPostre = tipoPostre;
    }

    public ComidaPostre(String tipoPostre, String nombre, String elaboracion, Integer calorias, String dificultad) {
        super(nombre, elaboracion, calorias, dificultad);
        this.tipoPostre = tipoPostre;
    }

    public String getTipoPostre() {
        return tipoPostre;
    }

    public void setTipoPostre(String tipoPostre) {
        this.tipoPostre = tipoPostre;
    }

    @Override
    public String toString() {
        return "ComidaPostre{"
                + "nombre=" + super.getNombre()
                + ", elaboracion=" + super.getElaboracion()
                + ", calorias=" + super.getCalorias()
                + ", dificultad=" + super.getDificultad()
                + ", tipoPostre=" + tipoPostre
                + '}';
    }

    @Override
    public void explicarReceta() {
        System.out.println("Se va a proceder a explicar la receta para un postre");
        System.out.println(this.toString());
    }
}
