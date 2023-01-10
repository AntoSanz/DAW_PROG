package modeladopersonaje;

import java.util.Random;

/**
 *
 * @author ANTONIO SANZ PANS
 */
public class Personaje {

    public static final byte MAX_STAT = 100;
    public static final byte MIN_STAT = 0;

    private String nombre;
    private byte inteligencia;
    private byte fuerza;
    private byte vida;

    public Personaje() {
        //Constructor vacío
    }
    
    public Personaje(String nombre, byte inteligencia, byte fuerza) {
        this.nombre = nombre;
        this.inteligencia = inteligencia;
        this.fuerza = fuerza;
        this.vida = MAX_STAT;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(byte inteligencia) {
        this.inteligencia = inteligencia;
    }

    public byte getFuerza() {
        return fuerza;
    }

    public void setFuerza(byte fuerza) {
        this.fuerza = fuerza;
    }

    public byte getVida() {
        return vida;
    }

    @Override
    public String toString() {
        return "Personaje{" + "nombre=" + nombre + ", inteligencia=" + inteligencia + ", fuerza=" + fuerza + ", vida=" + vida + '}';
    }

    public void batalla(Personaje p) {
        System.out.println(this.toString() + " Vs " + p.toString());
        
        byte statTotalPropia = (byte) (this.getFuerza() + this.getInteligencia());
        byte statTotalEnemigo = (byte) (p.getFuerza() + p.getInteligencia());

        if (statTotalPropia == statTotalEnemigo) {
            //Si las estadisticas son iguales, ambos pierden vida
            this.restarVida((byte) 20);
            p.restarVida((byte) 20);
        } else if (statTotalPropia > statTotalEnemigo) {
            //Si la estadistica propia es mayor, el enemigo pierde vida
            p.restarVida((byte) 20);
        } else if (statTotalPropia < statTotalEnemigo) {
            //Si la estadistica propia es menor, el personaje pierde vida
            this.restarVida((byte) 20);
        }
        
        if (this.getVida() > 0 && p.getVida() > 0) {
            //Si ambos personajes aun tienen vida, se aplica desgaste.

            
            System.out.println("Ambos personajes siguen vivos, pero sufren desgaste... ¡Y sus estadisticas han cambiado!");
            p.desgaste();
            this.desgaste();
            System.out.println(this.toString());
            System.out.println(p.toString());
            
        } else{
            //Si la vida de cualquier personaje es 0 (o menos) la batalla finaliza.
            System.out.println("¡Batalla finalizada!");
            if (this.getVida() > 0 && p.getVida() <= 0) {
                System.out.println("El ganador es " + this.getNombre());
            } else if (this.getVida() <= 0 && p.getVida() > 0){
                System.out.println("El ganador es " + p.getNombre());
            }
        }
    }

    private void restarVida(byte damage) {
        this.vida = (byte) (this.getVida() - damage);
        if (this.getVida() <= 0) {
            this.vida = 0;
        }
    }

    private void desgaste() {
        this.setFuerza(this.getRandom());
        this.setInteligencia(this.getRandom());
    }
    
    private byte getRandom(){
        byte r = 0;
       Random rd = new Random();
       r = (byte) rd.nextInt(101);
        return r;
    }
}
