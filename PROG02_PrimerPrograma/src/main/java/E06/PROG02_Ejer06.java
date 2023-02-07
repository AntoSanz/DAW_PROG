package E06;

/**
 *
 * @author ANTO
 */
public class PROG02_Ejer06 {
            public enum Planetas {Mercurio, Venus, Tierra, Marte, Jupiter, Saturno, Urano, Neptuno, Pluton};

    public static void main(String[] args) {
        System.out.println(Planetas.Saturno);
        System.out.println(Planetas.valueOf("Jupiter"));
    }
}
