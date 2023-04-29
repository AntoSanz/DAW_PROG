package PROG10.funcionalidad.modelos;

import PROG10.funcionalidad.excepciones.ExcepcionCuerpoCeleste;
import PROG10.funcionalidad.excepciones.ExcepcionLongitudCodigoCuerpo;
import PROG10.funcionalidad.excepciones.ExcepcionLongitudDiametro;
import PROG10.funcionalidad.excepciones.ExcepcionLongitudNombre;
import java.io.Serializable;


/**
 *
 * @author ANTONIO SANZ PANS
 */
public class CuerpoCeleste implements Serializable {

    private final byte MAX_LENGTH_CODIGO = 3;
    private final byte MAX_LENGTH_NOMBRE = 15;
    private final byte MAX_LENGTH_DIAMETRO = 6;
    private short codigoCuerpo;
    private String nombre;
    private String tipoObjeto;
    private int diametro;

    public CuerpoCeleste() {
    }

    public CuerpoCeleste(short codigoCuerpo, String nombre, String tipoObjeto, int diametro) {
        try {
            //excepcionCuerpoCeleste(nombre, diametro, codigoCuerpo);
            longitudNombre(nombre);
            longitudDiametro(diametro);
            longitudCodigoCuerpo(codigoCuerpo);

            this.codigoCuerpo = codigoCuerpo;
            this.nombre = nombre;
            this.tipoObjeto = tipoObjeto;
            this.diametro = diametro;
//        } catch (ExcepcionCuerpoCeleste ex){
//            throw new AssertionError(ex);
        } catch (ExcepcionLongitudNombre ex) {
            System.out.println(ex);
//            throw new AssertionError(ex);
        } catch (ExcepcionLongitudDiametro ex) {
            System.out.println(ex);
//            throw new AssertionError(ex);
        } catch (ExcepcionLongitudCodigoCuerpo ex) {
            System.out.println(ex);
//           throw new AssertionError(ex);
        } catch (Exception ex) {
            System.out.println(ex);
//            throw new AssertionError(ex);
        }
    }

    public short getCodigoCuerpo() {
        return codigoCuerpo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoObjeto() {
        return tipoObjeto;
    }

    public int getDiametro() {
        return diametro;
    }

    /**
     * Numero entero de 3 digitos
     *
     * @param codigoCuerpo
     */
    public void setCodigoCuerpo(short codigoCuerpo) {
        try {
            longitudCodigoCuerpo(codigoCuerpo);
            this.codigoCuerpo = codigoCuerpo;
        } catch (ExcepcionLongitudCodigoCuerpo ex) {
            throw new AssertionError(ex);
        }
    }

    /**
     * Cadena de texto maximo 15
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        try {
            longitudNombre(nombre);
            this.nombre = nombre;
        } catch (ExcepcionLongitudNombre ex) {
            throw new AssertionError(ex);
        }
    }

    /**
     * Cadena de texto (planeta, planeta enano, luna)
     *
     * @param tipoObjeto
     */
    public void setTipoObjeto(String tipoObjeto) {
        this.tipoObjeto = tipoObjeto;
    }

    /**
     * Numero entero 6 digitos, sin decimales
     *
     * @param diametro
     */
    public void setDiametro(int diametro) {
        try {
            longitudDiametro(diametro);
            this.diametro = diametro;
        } catch (ExcepcionLongitudDiametro ex) {
            throw new AssertionError(ex);
        }
    }

    @Override
    public String toString() {
        return "CuerpoCeleste{"
                + "codigoCuerpo=" + codigoCuerpo
                + ", nombre=" + nombre
                + ", tipoObjeto=" + tipoObjeto
                + ", diametro=" + diametro + '}';
    }

    private void excepcionCuerpoCeleste(String name, int diametro, short codigo) throws ExcepcionCuerpoCeleste {
        if (name.length() > MAX_LENGTH_NOMBRE
                || Integer.toString(diametro).length() > MAX_LENGTH_DIAMETRO
                || diametro < 0
                || Short.toString(codigo).length() > MAX_LENGTH_CODIGO) {
            throw new ExcepcionCuerpoCeleste("ERROR: Longitud maxima de alguno de los campos superada.");
        }
    }

    private void longitudNombre(String name) throws ExcepcionLongitudNombre {
        if (name.length() > MAX_LENGTH_NOMBRE) {
            throw new ExcepcionLongitudNombre("ERROR Codigo: Longitud maxima superada (" + MAX_LENGTH_NOMBRE + ")");
        }
    }

    private void longitudDiametro(int diametro) throws ExcepcionLongitudDiametro {
        if (Integer.toString(diametro).length() > MAX_LENGTH_DIAMETRO || diametro < 0) {
            throw new ExcepcionLongitudDiametro("ERROR Codigo: Longitud maxima superada (" + MAX_LENGTH_DIAMETRO + ")");
        }
    }

    private void longitudCodigoCuerpo(short codigo) throws ExcepcionLongitudCodigoCuerpo {
        if (Short.toString(codigo).length() > MAX_LENGTH_CODIGO) {
            throw new ExcepcionLongitudCodigoCuerpo("ERROR Codigo: Longitud maxima superada (" + MAX_LENGTH_CODIGO + ")");
        }
    }
}
