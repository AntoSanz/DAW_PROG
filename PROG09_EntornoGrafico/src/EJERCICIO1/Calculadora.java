/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package EJERCICIO1;

import EJERCICIO1.Excepciones.ExcepcionDivisionPorCero;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import static java.awt.Font.*;
import java.awt.event.ActionEvent;

/**
 *
 * @author ANTONIO SANZ PANS
 */
public class Calculadora extends JFrame {

    JLabel display;
    //Botones
    int numBotones = 17;
    JButton botones[] = new JButton[numBotones];
    String textoBotones[] = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "C", "0", ".", "+", "="};
    int xBotones[] = {15, 80, 145, 210, 15, 80, 145, 210, 15, 80, 145, 210, 15, 80, 145, 210, 15};
    int yBotones[] = {90, 90, 90, 90, 155, 155, 155, 155, 220, 220, 220, 220, 285, 285, 285, 285, 350};
    int numerosBotones[] = {13, 8, 9, 10, 4, 5, 6, 0, 1, 2};
    int[] operacionesBotones = {16, 15, 11, 7, 3};
    int anchoBoton = 50;
    int altoBoton = 50;
    //Operaciones
    boolean nuevoNumero = true;
    boolean puntoDecimal = false;
    double operando1 = 0;
    double operando2 = 0;
    double resultado = 0;
    String operacion = "";

    public Calculadora() {
        //Iniciar componentes de la calculadora y asignar eventos.
        initDisplay();
        initBotones();
        initPantalla();
        eventosNumeros();
        eventoDecimal();
        eventosOperaciones();
        eventoLimpiar();
    }

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
    }

    /**
     * Configuracion visual de la calculadora
     */
    private void initDisplay() {
        display = new JLabel("0");
        display.setBounds(15, 15, 245, 60);
        display.setOpaque(true);
        display.setBackground(Color.BLACK);
        display.setForeground(Color.WHITE);
        display.setFont(new Font("ROBOTO", BOLD, 24));
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        add(display);
    }

    /**
     * Configuración de los botones
     */
    private void initBotones() {
        for (int i = 0; i < numBotones; i++) {
            botones[i] = new JButton(textoBotones[i]);
            int size = (i == 16) ? 24 : 16;
            int ancho = (i == 16) ? 245 : anchoBoton;
            Color bgcolor = (i == 16) ? new Color(0, 167, 40) : Color.DARK_GRAY;
            Color textColor = (i == 15 || i == 12 || i == 11 || i == 7 || i == 3) ? (i == 12) ? Color.RED : Color.GREEN : Color.WHITE;
            botones[i].setBounds(xBotones[i], yBotones[i], ancho, altoBoton);
            botones[i].setFont(new Font("ROBOTO", BOLD, size));
            botones[i].setOpaque(true);
            botones[i].setFocusPainted(false);
            botones[i].setBackground(bgcolor);
            botones[i].setForeground(textColor);
            botones[i].setBorder(new LineBorder(Color.DARK_GRAY));
            add(botones[i]);
        }
    }

    private void initPantalla() {
        setLayout(null);
        setTitle("Calculadora");
        setSize(290, 455);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.BLACK);
        setVisible(true);
    }

    /**
     * Asignar funcionamiento a los botones de número
     */
    private void eventosNumeros() {
        for (int i = 0; i < 10; i++) {
            int numBoton = numerosBotones[i];
            botones[numBoton].addActionListener((ActionEvent e) -> {
                //Comprobar si es un nuevo numero o en su lugar hay ya numeros en el box
                //nuevoNumero = (display.getText() == "0") ? true : false;
                if (nuevoNumero) {
                    if (!textoBotones[numBoton].equals("0")) {
                        display.setText(textoBotones[numBoton]);
                        nuevoNumero = false;
                    }
                } else {
                    display.setText(display.getText() + textoBotones[numBoton]);
                }
            });
        }
    }

    /**
     * Funcionamiento del botón de decimales
     */
    private void eventoDecimal() {
        botones[14].addActionListener((ActionEvent e) -> {
            if (!puntoDecimal) {
                display.setText(display.getText() + textoBotones[14]);
                puntoDecimal = true;
                nuevoNumero = false;
            }
        });

    }

    /**
     * Funcionamiento para los botones de operaciones
     */
    private void eventosOperaciones() {
        for (int numBoton : operacionesBotones) {
            botones[numBoton].addActionListener((ActionEvent e) -> {
                if (operacion.equals("")) {
                    //Obtenemos el boton que queremos que
                    operacion = textoBotones[numBoton];
                    //Obtener el numero que está por pantalla como double
                    operando1 = Double.parseDouble(display.getText());
                    display.setText("0");
                    nuevoNumero = true;
                    puntoDecimal = false;
                } else {
                    operando2 = Double.parseDouble(display.getText());
                    resultado();
                }
            });
        }
    }

    /**
     * Funcionamiento del boton C
     */
    private void eventoLimpiar() {
        botones[12].addActionListener((ActionEvent e) -> {
            clearScreen();
        });
    }

    /**
     * Calculo del resultado
     */
    private void resultado() {
        try {
            switch (operacion) {
                case "+" ->
                    resultado = operando1 + operando2;
                case "-" ->
                    resultado = operando1 - operando2;
                case "*" ->
                    resultado = operando1 * operando2;
                case "/" -> {
                    DivisionPorCero(operando2, operacion);
                    resultado = operando1 / operando2;
                }
            }
            display.setText(String.valueOf(resultado));
            resetOperandos();
        } catch (ArithmeticException | ExcepcionDivisionPorCero e) {
            System.out.println("Imposible dividir por 0");
            clearScreen();
        }
    }

    /**
     * Reinicio de las variables de operaciones
     */
    private void resetOperandos() {
        operando1 = 0;
        operando2 = 0;
        operacion = "";
        nuevoNumero = true;
        puntoDecimal = false;
    }

    /**
     * Borrar pantalla y operaciones
     */
    private void clearScreen() {
        resetOperandos();
        display.setText("0");

    }

    static void DivisionPorCero(double divisor, String operador) throws ExcepcionDivisionPorCero {
        if (divisor == 0 && operador.equals("/")) {
            throw new ExcepcionDivisionPorCero("ERROR: La nota está fuera del rango (0-10)");
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
